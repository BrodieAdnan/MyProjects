//grafo lista orientato non pesato
Grafo.prototype.insVertice = function (vert) {
    this._vertici++;
    var vertInfo = new Array(this._vertici);
    for (var i = 0; i < this._vertici - 1; i++) {
        vertInfo[i] = this._vertInfo[i];
    }
    vertInfo[vertInfo.length - 1] = vert;
    this._vertInfo = vertInfo;
    var adiacenze = new Array(this._vertici);
    adiacenze.fill([]);
    for (var i = 0; i < this._vertici - 1; i++) {
        for (var j = 0; j < this._adiacenze[i].length; j++) {
            adiacenze[i].push(this._adiacenze[i][j]);
        }
    }
    this._adiacenze = adiacenze;
}

Grafo.prototype.isAdiacente = function (vert1, vert2) {
    assert.preCondizione(this._vertInfo.indexOf(vert2) && this._vertInfo.indexOf(vert1), "Vertici in input non esistenti!");
    return this._adiacenze[this._vertInfo.indexOf(vert2)].indexOf(vert1) !== -1;
}

Grafo.prototype.invertiArchi = function () {
    var newGrafo = new Grafo(this._vertici);
    for (var i = 0; i < this._vertici; i++) {//copio le info dei vertici
        newGrafo.vertInfo[i] = this._vertInfo[i];
    }
    for (var i = 0; i < this._vertici; i++) {
        for (var j = 0; j < this._adiacenze[i].length; j++) {
//newGrafo.addArco(this._adiacenze[i][j], this._vertInfo[i]);
            newGrafo[this._vertInfo.indexOf(this._adiacenze[i][j])].push(this._vertInfo[i]);
        }
    }
    return newGrafo;
}

Grafo.prototype.cammino = function (percorso) {
    var stillPercorso = true;
    for (var i = 0; i < percorso.length && stillPercorso; i++) {
        percorso = this.checkPath(percorso[i], percorso[i + 1]);
    }
    return stillPercorso;
}

Grafo.prototype.checkPath = function (vert1, vert2) {
    assert.preCondizione(this._vertInfo.indexOf(vert1) && this._vertInfo.indexOf(vert2), "Vertici in input non esistenti!");
    return this._adiacenze[this._vertInfo.indexOf(vert1)].indexOf(vert2) !== -1; //esiste.
}

//grafo array non orientato non pesato
Grafo.prototype.elimArchVertGradMax = function () {
    var vertMax = this.gradoMax();
    var indice = this._vertInfo.indexOf(vertMax);
    var archi = [];
    for (var i = 0; i < this._vertici; i++) {
        if (this._adiacenze[indice][i]) {
            archi.push(this._vertInfo[i]);
        }
    }

    for (var i = 0; i < this._vertici; i++) {
        for (var j = 0; j < this._vertici; j++) {
            if (this._adiacenze[this._vertInfo.indexOf(archi[i])][this._vertInfo.indexOf(archi[j])]) {
                this._adiacenze[archi[i]][archi[j]] = false;
            }
        }
    }
}

//grafo lista orientato non pesato
Grafo.prototype.togliAdiacenti = function (vert) {
    assert.preCondizione(vert < this._vertici, "Vertice in input non esistente!");
    for (var i = 0; i < this._adiacenze[this._vertInfo.indexOf(vert)].length; i++) {
        this.deleteArco(vert, this._adiacenze[this._vertInfo.indexOf(vert)][i]);
    }
}

//da grafo matrice a grafo lista.
Grafo.prototype.grafoLista = function () {
    var g = new Grafo(this._vertici); //grafo lista.
    for (var i = 0; i < this._vertici; i++) {
        g._vertInfo[i] = this._vertInfo[i]; //copio vertici.
        for (var j = 0; j < this._vertici; j++) {
            if (this._adiacenze[i][j]) {
                g.addArco(this._vertInfo[i], this._vertInfo[j]); //copio adiacenze.
            }
        }
    }
    return g;
}

//grafo array orientato non pesato.
Grafo.prototype.pozzoSorgente = function () {
    var pozzo = [];
    var sorgente = [];
    for (var i = 0; i < this._vertici; i++) {
        if (this.getGradoEntrante(this._vertInfo[i]) === 0 && this.getGradoUscente(this._vertInfo[i]) > 0) {
            sorgente.push(this._vertInfo[i]);
        } else if (this.getGradoEntrante(this._vertInfo[i]) > 0 && this.getGradoUscente(this._vertInfo[i]) === 0) {
            pozzo.push(this._vertInfo[i]);
        }
    }
    return {"pozzo": pozzo, "sorgente": sorgente};
}

//grafo lista non orientato non pesato.
Grafo.prototype.popolaGrafo = function (lista) {
    var grafo = new Grafo(lista.length);
    for (var i = 0; i < lista.length; i++) {
        for (var j = 0; j < lista.length; j++) {
            for (var z = 0; z < lista.length; z++) {
                if (z !== i && lista[z].indexOf(lista[i][j]) !== -1) {
                    grafo.addArco(grafo._vertInfo[i], grafo._vertInfo[z]);
                }
            }
        }
    }
    return grafo;
}

//grafo array orientato non pesato :: restituire grafo lista orientato non pesato.
Grafo.prototype.estractVert = function (vert) {
    assert.preCondizione(vert < this._vertici, "Vertice in input inesistente!");
    var predecessori = this.getGradoEntrante(vert);
    var newGrafo = new Grafo(this._vertici); //grafo lista.
    for (var i = 0; i < this._vertici; i++) {
        for (var j = 0; j < this._vertici; j++) {
            if (i !== this._vertInfo.indexOf(vert) && this._adiacenze[i][j]) {
                newGrafo.addArco(this._vertInfo[i], this._vertInfo[j]);
            }
        }
    }
    if (predecessori === 1) {
        var pre = this.getPredecessore(vert);
        var intorno = newGrafo.intorno(vert);
        newGrafo._adiacenze[newGrafo._vertInfo.indexOf(pre)].splice(newGrafo._adiacenze[newGrafo._vertInfo.indexOf(pre)].indexOf(vert), 1);
        for (var i = 0; i < intorno.length; i++) {
            newGrafo._adiacenze[newGrafo._vertInfo.indexOf(pre)].push(intorno[i]);
        }
    } else {// > 1
        newGrafo = null;
    }
    return newGrafo;
}