/************************************************
 *GRAFO LISTA
 *@author Gazi Adnan Latif, Riccardo Fusaro
 *@brief GRAFO USATO. Contiene Fermate e Tratte.
 *@date 12/05/2018
 ***********************************************/
function GrafoLista(vertici) {
    this.init(vertici);
}
GrafoLista.prototype.init = function (vertici) {
    this._vertici = vertici;
    this._adiacenze = new Array(this._vertici);
    this._adiacenze.fill([]);
    this.vertici = new Array(this._vertici);
}

GrafoLista.prototype.insertInfo = function (info) {
    this.vertici.push(info);
    this._vertici += 1;
    this._adiacenze.push([]);
}

GrafoLista.prototype.getInfo = function (pos) {
    return this.vertici[pos];
}

GrafoLista.prototype.addArco = function (vert1, vert2) {
    if (this._adiacenze[this.vertici.indexOf(vert1)].indexOf(vert2) === -1) {
        this._adiacenze[this.vertici.indexOf(vert1)].push(vert2);
        this._adiacenze[this.vertici.indexOf(vert1)].push(vert2);
    }
}
GrafoLista.prototype.deleteArco = function (vert1, vert2) {
    assert.preCondizione(vert1 < this._vertici && vert2 < this._vertici, "vertici in input non validi!");//vertice inesistente.
    this._adiacenze[vert1].splice(this._adiacenze[vert1].indexOf(vert2), 1);
    this._adiacenze[vert2].splice(this._adiacenze[vert2].indexOf(vert1), 1);
}
GrafoLista.prototype.getVertici = function () {
    return this._vertici;
}
GrafoLista.prototype.getGrado = function (vert) {//numero di archi collegati a vert.
    assert.preCondizione(vert < this._vertici, "vertici in input non validi!");//vertice inesistente.
    return this._adiacenze[vert].lenght;
}

GrafoLista.prototype.rappresenta = function () {
    for (var i = 0; i < this._vertici; i++) {
        console.log("Vertice : " + this.vertici[i]);
        for (var j = 0; j < this._adiacenze[i].length; j++) {
            console.log("           " + this._adiacenze[i][j]);
        }
    }
}
//creo un grafo copia parziale del mio grafo originale / complementare del mio originale
//di supporto se creo una coppia del mio sottografo, indotto se faccio il complementare del mio sottografo tale da comporre il grafo G originale
GrafoLista.prototype.grafoIndotto = function (vertici) {//array di tutti i vertici.
    var sottoGrafo = new GrafoLista(vertici.lenght);
    for (var i = 0; i < vertici.length - 1; i++) {//scorro il sottografo
        for (var j = i; j < vertici.lenght; j++) {
            if (this._adiacenze[vertici[i]].indexOf(vertici[j]) !== -1)
                sottoGrafo.addArco(j, i);//sottografo complementare dell'originale.
            //if (this._adiacenze[vertici[i]].indexOf(vertici[j]) === -1) sottoGrafo.addArco(j, i);//sottografo copia dell'originale.
        }
    }
    return sottoGrafo;
}
//fornire lista delle adiacenze del vertice vert
GrafoLista.prototype.intorno = function (vert) {//lista con tutti gli archi collegati a vert.
    //assert.preCondizione(vert < this._vertici, "vertici in input non validi!");//vertice inesistente.
    var archi = [];//lista degli archi.
    for (var i = 0; i < this._adiacenze[this.vertici.indexOf(vert)].length; i++) {
        archi.push(this._adiacenze[this.vertici.indexOf(vert)][i]);
    }
    //return this._adiacenze[vert];//puntatore
    return archi;
}
//prendo tutti gli elementi del grafo a lista e creo un grafo a matrice uguale fatto con gli array.
//TRASFORMAZIONE DA GRAFO LISTA A GRAFO ARRAY
GrafoLista.prototype.grafoMatrice = function () {//è un grafo array.
    var grafoMatrice = new GrafoArray(this._vertici);
    for (var i = 0; i < this._vertici; i++) {//scorro grafo lista.
        for (var j = 0; j < this._adiacenze[i].length; j++) {
            grafoMatrice._adiacenze[i][this._adiacenze[i][j]] = true;
        }
    }
    return grafoMatrice;
}
GrafoLista.prototype.isConnected = function () {
    var componenteConnesso = [];//lista.
    connesso(componenteConnesso, 0);
    return componenteConnesso.lenght === this._vertici;
}
GrafoLista.prototype.connesso = function (comp, i) {
    for (var j = 0; j < this._adiacenze[i].length; j++) {
        var contenuto = this._adiacenze[i][j];
        if (presente(comp, contenuto)) {
            comp.push(contenuto);
            this._adiacenze[i].splice(this._adiacenze[i].indexOf(contenuto), 1);
            connesso(comp, this._vertici.indexOf(contenuto));
        }
    }
}
GrafoLista.prototype.presente = function (comp, contenuto) {
    for (var i = 0; i < comp.lenght; i++) {
        if (comp[i] === contenuto) {
            return true;
        }
    }
    return false;
}
GrafoLista.prototype.isComplete = function () {
    var archToHave = (this._vertici - 1) * this._vertici;
    var contArch = 0;
    for (var i = 0; i < this._vertici; i++) {
        contArch += this._adiacenze[i].length;
    }
    return archToHave === contArch;//true: complete, false: not complete
}

//INIZIO ESERCIZI DELLA VERIFICA.
GrafoLista.prototype.gradoMax = function () {//grafo array (matrice).
    var vertMax;
    var max = -1;
    for (var i = 0; i < this._vertici; i++) {//scorro il grafo.
        var contatore = 0;
        for (var j = 0; j < this._adiacenze.length; j++) {
            if (this._adiacenze[i][j]) {//conto il grado di ogni vertice.
                contatore++;
            }
        }
        if (contatore > max) {//salvo il massimo e il suo vertice.
            max = contatore;
            vertMax = this._adiacenze[i];
        }
    }
    return vertMax;
}
GrafoLista.prototype.checkPath = function (percorso) {//grafo lista. Percorso è una lista.
    var vertice = this._adiacenze[this._adiacenze.indexOf(percorso[0])];
    for (var i = 1; i < percorso.length; i++) {//scorro l'array del percorso.
        if (vertice.indexOf(percorso[i + 1]) === -1) {//non travoto il prossimo vertice.
            return false;
        } else {
            vertice = this._adiacenze[this._adiacenze.indexOf(percorso[i + 1])];//prossimo vertice da controllare se è nel percorso.
        }
    }
    return true;
}
GrafoLista.prototype.checkListForAdjacencies = function (vertici) {//grafo lista. Vertici è una lista.
    for (var i = 0; i < this._vertici; i++) {//scorro il grafo.
        for (var j = 0; j < this._adiacenze[i].length; j++) {
            //controllo se il vertice originale o se quello corrente sono presenti nella lista.
            if (vertici.indexOf(this._vertici[i]) === -1 && vertici.indexOf(this._adiacenze[i][j]) !== -1) {
                return false;
            }
        }
    }
    return true;
}
//FINE ESERCIZI DELLA VERIFICA.

//INIZIO METODI PER CONTROLLARE SE UN GRAFO è UN ALBERO.
GrafoLista.prototype.isATree = function () {
    var visitati = [];
    for (var i = 0; i < this._vertici; i++) {
        if (!grafoAlbero(visitati, this._adiacenze[i])) {
            return false;
        }
    }
    return true;
}
GrafoLista.prototype.grafoAlbero = function (visitati, lista) {
    for (var i = 0; i < lista.lenght; i++) {
        if (!control(visitati, lista[i])) {
            return false;
        }
    }
    return true;
}
GrafoLista.prototype.control = function (visitati, contenuto) {
    if (presente(visitati, contenuto)) {
        return false;
    }
    return true;
}
//FINE METODI PER CONTROLLARE SE UN GRAFO è UN ALBERO.