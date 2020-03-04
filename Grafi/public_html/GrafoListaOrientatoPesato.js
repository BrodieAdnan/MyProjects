function Grafo(vertici) {//numero di vertici
    this.init(vertici);
}

Grafo.prototype.init = function (vertici) {
    var i = 0;
    this.vertici = vertici;
    this._vertici = new Array(this.vertici);
    this._vertici.fill("Vertice Numero " + i++);
    this.adiacenze = new Array(vertici);
    this.adiacenze.fill([]);//fill di liste
}

Grafo.prototype.setInfo = function (vert, info) {
    assert.preCondizione(this._vertici.indexOf(vert), "Vertice in input non esistente!");
    this._vertici[vert] = info;
}

Grafo.prototype.getInfo = function (vert) {
    assert.preCondizione(this._vertici.indexOf(vert), "Vertice in input non esistente!");
    return this._vertici[vert];
}

Grafo.prototype.addArco = function (v1, v2) {
    assert.preCondizione(v1 < this.vertici && v2 < this.vertici, "vertici in input non validi!");
    assert.preCondizione(this.adiacenze[v1].indexOf(v2) !== -1, "esiste già un arco!");
    this.adiacenze[v1].push({"valore": v2, "peso": 0});
    this.adiacenze[v2].push({"valore": v1, "peso": 0});
}

Grafo.prototype.deleteArco = function (v1, v2) {
    assert.preCondizione(v1 < this.vertici && v2 < this.vertici, "vertici in input non validi!");
    assert.preCondizione(this.adiacenze[v1].indexOf(v2) === -1, "non esiste un arco!");
    this.adiacenze[v1].splice(this.adiacenze[v1].indexof(v2), 1);
    this.adiacenze[v2].splice(this.adiacenze[v1].indexof(v1), 1);
}

Grafo.prototype.getVertici = function () {
    return this.vertici;
}

Grafo.prototype.getGradoEntrante = function (vert) {
    assert.preCondizione(this._vertInfo.indexOf(vert), "Il vertice non esiste!");
    var archi = 0;
    for (var i = 0; i < this._vertici; i++) {
        if (this._adiacenze[this._vertInfo.indexOf(vert)]) {
            archi++;
        }
    }
}

Grafo.prototype.getGradoUscente = function (vert) {
    assert.preCondizione(this._vertInfo.indexOf(vert), "Il vertice non esiste!");
    var archi=0;
    for (var i = 0; i < this._vertici; i++) {
        for (var j = 0; j < this._vertici; j++) {
            if (this._vertInfo.indexOf(vert) !== i && this._adiacenze[this._vertInfo.indexOf(vert)]) {
                archi++;
            }
        }
    }
    return archi;
}

Grafo.prototype.getGradoTotale = function (vert) {
    assert.preCondizione(this._vertInfo.indexOf(vert), "Il vertice non esiste!");
	return this.getGradoEntrante(vert) + this.getGradoUscente(vert);
}

//creare una copia parziale in un sotto grafo dato una sequenza di vertici
Grafo.prototype.indotto = function (vertici) {
    var sottoGrafo = new Grafo(vertici.length);
    for (var i = 0; i < vertici.length; i++) {
        for (var j = 0; j < vertici.length; j++) {
            if (this.adiacenze[vertici[i]].indexOf(vertici[j]) !== -1) {//this.adiacenze[this._vertice.indexOf(vertici[i])].indexOf(vertici[j]) !== -1
                sottoGrafo.addArco(vertici[i], vertici[j]);
            }
        }
    }
    return sottoGrafo;
}

//fornire la lista delle adiacenze del vertice vert per copia
Grafo.prototype.intorno = function (vert) {
    assert.preCondizione(vert < this.vertici, "vertice non esistente!");
    var intorno = [];
    for (var i = 0; i < this.adiacenze[this._vertici.indexOf(vertici)].length; i++) {
        intorno.push(this.adiacenze[this._vertici.indexOf(vertici)][i]);
    }
    return intorno;
}

//trasformare un grafo lista in un grafo matrice
Grafo.prototype.grafoMatrice = function () {
    var grafoMatrice = new Grafo(this.vertici);//grafo array.
    for (var i = 0; i < this.vertici; i++) {
        for (var j = 0; j < this.adiacenze[i].length; j++) {
           grafoMatrice.adiacenze[i][this._vertici.indexOf(this.adiacenze[i][j])] = true;
        }
    }
    return grafoMatrice;
}

Grafo.prototype.completo = function () {
    var archToHave = this.vertici * (this.vertici - 1);
    var archHad = 0;
    for (var i = 0; i < this.vertici; i++) {
        archHad += this.adiacenze[i].length;
    }
    return archHad === archToHave;
}

Grafo.prototype.connesso = function () {
    var componenteConnesso = [];//vertici visitati
    this._adiacenze = new Array(this.vertici);
    this._adiacenze.fill([]);
    for (var i = 0; i < this.vertici; i++) {
        for (var j = 0; j < this.adiacenze[i].length; j++) {
            this._adiacenze[i].push(this.adiacenze[i][j]);
        }
    }
    componenteConnesso.push(this._adiacenze[0]);
    this.isConnected(componenteConnesso, 0);
    return componenteConnesso.length === this.vertici;
}

Grafo.prototype.isConnected = function (comp, i) {
    for (var j = 0; j < this._adiacenze[i].length; j++) {
        if (this.presente(this._adiacenze[i][j], comp)) {
            comp.push(this._adiacenze[i][j]);
            this.isConnected(comp, this._adiacenze[i].indexOf(this._adiacenze[i][j]));
        }
    }
}

Grafo.prototype.presente = function (vert, comp) {
    var presente = false;
    for (var i = 0; i < comp.length; i++) {
        if (comp[i] === vert) {
            presente = true;
        }
    }
    return presente;
}

Grafo.prototype.vertGradoMax = function () {
    var maxGrado = 0;
    var vert;
    for (var i = 0; i < this.vertici; i++) {
        if (this.adiacenze[i].length > maxGrado) {
            maxGrado = this.adiacenze[i].length;
            vert = this.adiacenze[i];
        }
    }
    return vert;
}

//controllare che la sequenza 'vertici' sia un percorso
Grafo.prototype.percorso = function (vertici) {//vertici è una lista.
    var percorso = true;
    for (var i = 0; i < vertici.length - 1 && percorso; i++) {
        percorso = this.checkPath(vertici[i], vertici[i + 1]);
    }
    return percorso;
}

Grafo.prototype.checkPath = function (vert1, vert2) {
    assert.preCondizione(vert1 < this.vertici && vert2 < this.vertici, "vertici in input errati!");
    return this.adiacenze[this._vertici.indexOf(vert1)].indexOf(vert2) !== -1;//presente
}

//controllare se una dei due vertici di ogni arco appartiene alla lista 'vertici'.
Grafo.prototype.checkListForAdjacencies = function (vertici) {//vertici è una lista
    for (var i = 0; i < this.vertici; i++) {
        for (var j = 0; j < this.adiacenze[i].length; j++) {
            if (vertici.indexOf(this._vertici[i]) === -1 && vertici.indexOf(this.adiacenze[i][j]) === -1) {
                return false;
            }
        }
    }
    return true;
}

//un grafo è un albero quando i vertici visitati si ripetono una sola volta
Grafo.prototype.isATree = function () {
    var visitato = [];
    visitati.push(this._vertici[0]);
    for (var i = 0; i < this.vertici; i++) {
        for (var j = 0; j < this.adiacenze[i].length; j++) {
            if (presente(this.adiacenze[i][j], visitato)) {//non è un albero
                return false;
            } else {
                visitato.push(this.adiacenze[i][j]);
            }
        }
    }
    return true;
}

Grafo.prototype.Dijkstra = function (start, end) {//cammino minimo tra 'start' e 'end'.
    var cammino = [end - start];//tutti i vetici tra i due vertici di partenza e arrivo.
    for (var i = start; i < end; i++) {
        cammino.push(this._vertici[i]);
    }
    var predecessori = [end - start];//lista parallela.
    predecessori.fill(-1);
    var pesi = [end - start];//lista parallela.
    pesi.fill(Number.POSITIVE_INFINITY);
    pesi[0] = 0;//peso primo vertice.
    var visitati = [];//lista parallela.
    var camminoFinale = [];//contiene i vertici del cammino minimo tra i due vertici.

    for (var i = 0; i < cammino.length; i++) {
        var vertice = cammino[i];
        var intorno = this.intorno(vertice);
        if (!this.presente(vertice, visitati)) {
            for (var j = 0; j < intorno.length; j++) {
                var adiacenza = intorno[j];
                if (pesi[cammino.indexOf(adiacenza) > pesi[cammino.indexOf(vertice)] + this.adiacenze[start + i][j].peso]) {
                    pesi[cammino.indexOf(adiacenza)] = pesi[cammino.indexOf(vertice)] + this.adiacenze[start + i][j].peso;
                    predecessori[cammino.indexOf(adiacenza)] = vertice;
                }
            }
            visitati.push(vertice);
        }
    }
    return componiCamminoFinale(cammino, camminoFinale, predecessori, predecessori[predecessori.length - 1]);//ultimo elemento.
}

Grafo.prototype.componiCamminoFinale = function (c, f, pre, elem) {
    var elemento = pre[c.indexOf(elem)];
    if (elemento !== -1) {
        this.componiCamminoFinale(c, f, pre, elemento);
    }
    return f.push(elem);
}