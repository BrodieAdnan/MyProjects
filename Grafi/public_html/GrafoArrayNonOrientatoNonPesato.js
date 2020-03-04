function Grafo(vertici) {//vertici: numero di vertici.
    this.init(vertici);
}

Grafo.prototype.init = function (vertici) {
    this._vertici = vertici;
    this._vertInfo = new Array(this._vertici);
    this._adiacenze = new Array(this._vertici);
    this._adiacenze.fill(new Array(this._vertici));
}

Grafo.prototype.addArco = function (v1, v2) {
    assert.preCondizione(this._vertInfo.indexOf(v1) && this._vertInfo.indexOf(v2), "I vertici in input non esistono!");
    assert.preCondizione(this._adiacenze[this._vertInfo.indexOf(v1)][this._vertInfo.indexOf(v2)], "Esiste già un arco!");
    this._adiacenze[this._vertInfo.indexOf(v1)][this._vertInfo.indexOf(v2)] = true;
    this._adiacenze[this._vertInfo.indexOf(v2)][this._vertInfo.indexOf(v1)] = true;
}

Grafo.prototype.deleteArco = function (v1, v2) {
    assert.preCondizione(this._vertInfo.indexOf(v1) && this._vertInfo.indexOf(v2), "I vertici in input non esistono!");
    assert.preCondizione(!this._adiacenze[this._vertInfo.indexOf(v1)][this._vertInfo.indexOf(v2)], "Non esiste un arco!");
    this._adiacenze[this._vertInfo.indexOf(v1)][this._vertInfo.indexOf(v2)] = true;
}

Grafo.prototype.getGrado = function (vert) {
    assert.preCondizione(this._vertInfo.indexOf(vert), "Il vertice non esiste!");
    var archi = 0;
    for (var i = 0; i < this._vertici; i++) {
        if (this._adiacenze[this._vertInfo.indexOf(vert)]) {
            archi++;
        }
    }
}

Grafo.prototype.grafoIndotto = function (vertici) {//vertici: lista.
    var sottoGrafo = new Grafo(vertici.length);
    for (var i = 0; i < vertici.length; i++) {
        for (var j = 0; j < vertici.length; j++) {
            if (this._adiacenze[this._vertInfo.indexOf(vertici[i])][this._vertInfo.indexOf(vertici[j])]) {
                sottoGrafo.addArco(vertici[i], vertici[j]);
            }
        }
    }
    return sottoGrafo;
}

Grafo.prototype.intorno = function (vert) {
    assert.preCondizione(this._vertInfo.indexOf(vert), "Il vertice non esiste!");
    var archi = new Array(this._vertici);
    for (var i = 0; i < this._vertici; i++) {
        archi[i] = this._adiacenze[vert][i];
    }
    return archi;
}

Grafo.prototype.completo = function () {
    var archToHave = this.vertici * (this.vertici - 1);
    var archHad = 0;
    for (var i = 0; i < this._vertici; i++) {
        archHad += this.getGrado(this._vertInfo[i]);
    }
    return archHad === archToHave;
}

Grafo.prototype.connesso = function () {
    var componenteConnessa = [];
    componenteConnessa.push(this._vertInfo[0]);
    return this.isConnected(componenteConnessa, 0).length === this._vertici;
}

Grafo.prototype.isConnected = function (comp, i) {
    for (var j = 0; j < this._vertici; j++) {
        if (this._adiacenze[i][j] && !this.presente(this._vertInfo[j], comp)) {
            comp.push(this._vertInfo[j]);
            this.isConnected(comp, j);
        }
    }
    return comp;
}

Grafo.prototype.presente = function (vert, comp) {
    assert.preCondizione(this._vertInfo.indexOf(vert), "Il vertice non esiste!");
    return comp.indexOf(vert) !== -1;
}

Grafo.prototype.gradoMax = function () {
    var maxGrad = 0;
    var vert;
    for (var i = 0; i < this._vertici; i++) {
        var grado = this.getGrado(this._vertInfo[i]);
        if (grado > maxGrado) {
            maxGrado = grado;
            vert = this._vertInfo[i];
        }
    }
    return vert;
}

Grafo.prototype.percorso = function (vertici) {
    var percorso = false;
    for (var i = 0; i < vertici.length - 1; i++) {
        percorso = this.checkPath(vertici[i], vertici[i + 1]);
    }
}

Grafo.prototype.checkPath = function (vert1, vert2) {
    assert.preCondizione(this._vertInfo.indexOf(vert1) && this._vertInfo.indexOf(vert2), "Il vertice non esiste!");
    return this._adiacenze[vert1][vert2];
}

Grafo.prototype.isATree = function () {
    var visitati = [];
    for (var i = 0; i < this._vertici; i++) {
        for (var j = 0; j < this._vertici; j++) {
            if (this._adiacenze[i][j]) {
                if (this.presente(this._vertInfo[j])) {
                    return false;
                } else {
                    visitati.push(this._vertInfo[j]);
                }
            }
        }
    }
    return true;
}

