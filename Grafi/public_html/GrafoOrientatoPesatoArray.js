function Arco(peso) {
    this._peso = peso;
}

Arco.prototype.getPeso = function () {
    return this._peso;
}

function GrafoOrientatoPesatoArray(vertici) {
    this.init(vertici);
}

GrafoOrientatoPesatoArray.prototype.init = function (vertici) {
    this._vertici = vertici;
    this._adiacenze = new Array(this._vertici);
    for (var i = 0; i < this._vertici; i++) {
        this._adiacenze[i] = new Array(this._vertici);
        this._adiacenze[i].fill(null);
    }
}

GrafoOrientatoPesatoArray.prototype.addArco = function (vert1, vert2, peso) {
    assert.preCondizione(vert1 < this._vertici && vert2 < this._vertici, "vertici in input non validi!");//vertice inesistente.
    this._adiacenze[vert1][vert2] = new Arco(peso);
}

GrafoOrientatoPesatoArray.prototype.deleteArco = function (vert1, vert2) {
    assert.preCondizione(vert1 < this._vertici && vert2 < this._vertici, "vertici in input non validi!");//vertice inesistente.
    this._adiacenze[vert1][vert2] = null;
}

GrafoOrientatoPesatoArray.prototype.getPeso = function (vertice1, vertice2) {
    assert.preCondizione(vertice1 < this._vertici && vertice2 < this._vertici, "vertici in input non validi!");//vertice inesistente.
    return this._adiacenze[vertice1][vertice2].getPeso();
}

GrafoOrientatoPesatoArray.prototype.getPesoMax = function (vertice) {
    assert.preCondizione(vertice < this._vertici, "vertici in input non validi!");//vertice inesistente.
    var maxPeso = 0;
    for (var i = 0; i < this._adiacenze[vertice].length; i++) {
        maxPeso = Math.max(maxPeso, this._adiacenze[vertice][i]);
    }
    return maxPeso;
}

GrafoOrientatoPesatoArray.prototype.getPesoTotale = function (vertice) {
    assert.preCondizione(vertice < this._vertici, "vertici in input non validi!");//vertice inesistente.
    var pesoTotale = 0;
    for (var i = 0; i < this._adiacenze[vertice].length; i++) {
        pesoTotale += this._adiacenze[vertice][i];
    }
    return pesoTotale;
}

GrafoOrientatoPesatoArray.prototype = new GrafoOrientatoArray();
GrafoOrientatoPesatoArray.constructor = GrafoOrientatoPesatoArray;