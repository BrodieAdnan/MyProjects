Grafo.prototype.Dijkstra = function (start, end) {
    var cammino = [this._vertInfo.indexOf(end) - this._vertInfo.indexOf(start)];
    for (var i = this._vertInfo.indexOf(start); i < this._vertInfo.indexOf(end); i++) {
        cammino.push(this._vertInfo[i]);
    }
    var predecessori = [this._vertInfo.indexOf(end) - this._vertInfo.indexOf(start)];
    predecessori.fill(-1);
    var pesi = [this._vertInfo.indexOf(end) - this._vertInfo.indexOf(start)];
    pesi.fill(Number.POSITIVE_INFINITY);
    pesi[0] = 0;
    var visitati = [];

    for (var i = 0; i < this._vertici; i++) {
        var vert = cammino[i];
        var intorno = this.intorno(vert);
        for (var j = 0; j < this._vertici; j++) {
            if (intorno[j].valore && !this.presente(this._vertInfo[j]) && pesi[j] > intorno[j].peso + pesi[i]) {
                predecessori[j] = vert;
                pesi[j] = this._adiacenze[i][j].peso + pesi[i];
            }
        }
        visitati.push(this._vertInfo[i]);
    }
    return this.componiCamminoFinale(cammino, [], predecessori, predecessori[predecessori.length - 1]);
}

Grafo.prototype.componiCamminoFinale = function (c, f, p, e) {
    var elem = p[c.indexOf(e)];
    if (elem !== -1) {
        this.componiCamminoFinale(c, f, p, elem);
    }
    return f.push(e);
}
