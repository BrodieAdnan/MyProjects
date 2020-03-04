function GrafoOrientatoLista(vertici) {
    this.init(vertici);
}

GrafoOrientatoLista.prototype.addArco = function (vert1, vert2) {
    assert.preCondizione(vert1 < this._vertici && vert2 < this._vertici, "vertici in input non validi!");//vertice inesistente.
    this._adiacenze[vert1].push(vert2);
}

GrafoOrientatoLista.prototype.deleteArco = function (vert1, vert2) {
    assert.preCondizione(vert1 < this._vertici && vert2 < this._vertici, "vertici in input non validi!");//vertice inesistente.
    this._adiacenze[vert1].splice(this._adiacenze[vert1].indexOf(vert2), 1);
}

GrafoOrientatoLista.prototype.getGrado = function (vertice) {
    return this.getGradoEntrante(vertice) + this.getGradoUscente(vertice);
}

GrafoOrientatoLista.prototype.getGradoEntrante = function (vertice) {
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

GrafoOrientatoLista.prototype.getGradoUscente = function (vertice) {
    assert.preCondizione(vertice < this._vertici, "vertici in input non validi!");//vertice inesistente.
    return this._adiacenze[vertice].lenght;
}

GrafoOrientatoLista.prototype = new GrafoLista();
GrafoOrientatoLista.constructor = GrafoOrientatoLista;