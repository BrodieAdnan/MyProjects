function GrafoArray(vertici) {
    this.init(vertici);
}
GrafoArray.prototype.init = function (vertici) {
    this._vertici = vertici;
    this._adiacenze = new Array(this._vertici);
    for (var i = 0; i < this._vertici; i++) {
        this._adiacenze[i] = new Array(this._vertici);
        this._adiacenze[i].fill(false);
    }
}
GrafoArray.prototype.addArco = function (vert1, vert2) {
    assert.preCondizione(vert1 < this._vertici && vert2 < this._vertici, "vertici in input non validi!");//vertice inesistente.
    this._adiacenze[vert1][vert2] = true;
    this._adiacenze[vert2][vert1] = true;
}
GrafoArray.prototype.deleteArco = function (vert1, vert2) {
    assert.preCondizione(vert1 < this._vertici && vert2 < this._vertici, "vertici in input non validi!");//vertice inesistente.
    this._adiacenze[vert1][vert2] = false;
    this._adiacenze[vert2][vert1] = false;
}
GrafoArray.prototype.getVertici = function () {
    return this._vertici;
}
GrafoArray.prototype.getGrado = function (vertice) {//numero di archi collegati ad un vertice.
    assert.preCondizione(vertice < this._vertici, "vertici in input non validi!");//vertice inesistente.
    var cont = 0;
    for (var i = 0; i < this._vertici[vertice].length; i++) {
        if (this._adiacenze[vertice][i])
            cont++;
    }
    return cont;
}
GrafoArray.prototype.grafoIndotto = function (vertici) {//vertici: array con i vertici.
    var sottoGrafo = new GrafoArray(vertici.length);
    for (var i = 0; i < vertici.length - 1; i++) {
        for (var j = 0; j < vertici.length; j++) {
            if (!this._adiacenze[vertici[i]][vertici[j]])
                sottoGrafo.addArco(j, i);//aggiunge tutti gli archi complementari al sottografo.
            //if (this._adiacenze[vertici[i]][vertici[j]]) sottoGrafo.addArco(j, i);//aggiunge tutti gli archi già presenti nell'originale.
        }
    }
    return sottoGrafo;
}
GrafoArray.prototype.intorno = function (vertice) {//lista con tutti gli archi collegati al vertice.
    assert.preCondizione(vertice < this._vertici, "vertici in input non validi!");//vertice inesistente.
    var archi = [];//lista.
    for (var i = 0; i < this._adiacenze[vertice].length; i++) {
        if (this._adiacenze[vertice][i])
            archi.push(this._adiacenze[vertice][i]);
    }
    return archi;
}
GrafoArray.prototype.isComplete = function () {
    var archToHave = (this._vertici - 1) * this._vertici;
    var contArch = 0;
    for (var i = 0; i < this._vertici.lenght; i++) {
        for (var j = 0; j < this._adiacenze[i].length; j++) {
            if (this._adiacenze[i][this._adiacenze[j]])
                contArch++;
        }
    }
    return contArch === archToHave;//true: complete, false: not complete.
}