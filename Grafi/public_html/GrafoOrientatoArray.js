function GrafoOrientatoArray(vertici) {
    this.init(vertici);
}

GrafoOrientatoArray.prototype.addArco = function (vert1, vert2) {
    assert.preCondizione(vert1 < this._vertici && vert2 < this._vertici, "vertici in input non validi!");//vertice inesistente.
    this._adiacenze[vert1][vert2] = true;
}

GrafoOrientatoArray.prototype.deleteArco = function (vert1, vert2) {
    assert.preCondizione(vert1 < this._vertici && vert2 < this._vertici, "vertici in input non validi!");//vertice inesistente.
    this._adiacenze[vert1][vert2] = false;
}

GrafoOrientatoArray.prototype.getGrado = function (vertice) {
    return this.getGradoEntrante(vertice) + this.getGradoUscente(vertice);
}

GrafoOrientatoArray.prototype.getGradoEntrante = function (vertice) {
    assert.preCondizione(vertice < this._vertici, "vertici in input non validi!");//vertice inesistente.
    var cont = 0;
    for (var i = 0; i < this._vertici; i++) {
        for (var j = 0; j < this._adiacenze[i].length; j++) {
            if (this._adiacenze[i][j] === vertice)
                cont++;
        }
    }
    return cont;
}

GrafoOrientatoArray.prototype.getGradoUscente = function (vertice) {
    assert.preCondizione(vertice < this._vertici, "vertici in input non validi!");//vertice inesistente.
    var cont = 0;
    for (var i = 0; i < this._vertici[vertice].length; i++) {
        if (this._adiacenze[vertice][i])
            cont++;
    }
    return cont;
}

GrafoOrientatoArray.prototype = new GrafoArray();
GrafoOrientatoArray.constructor = GrafoOrientatoArray;