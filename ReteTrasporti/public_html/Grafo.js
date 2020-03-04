/*******************************************
 *GRAFO
 *@author Gazi Adnan Latif, Riccardo Fusaro
 *@brief GRAFO NON USATO.
 *@date 12/05/2018
 ******************************************/
function Grafo(vertici) {
    this.init(vertici);
}

Grafo.prototype.init = function (vertici) {
    this._vertici = vertici;
    this._infoVertici = [];
    this._adiacenze = new Array(vertici);
    this._adiacenze.fill([]);
}

Grafo.prototype.insertInfo = function (info) {
    this._infoVertici.push(info);
    this._vertici++;
    this._adiacenze.push([]);
}

Grafo.prototype.setInfo = function (info, pos) {
    this._infoVertici[pos] = info;
}

Grafo.prototype.addArco = function (v1, v2) {
    var pos1 = this._infoVertici.indexOf(v1);
    var pos2 = this._infoVertici.indexOf(v2);
    this._adiacenze[pos1].push(v2);
    this._adiacenze[pos2].push(v1);
}

Grafo.prototype.deleteArco = function (v1, v2) {
    var pos1 = this._infoVertici.indexOf(v1);
    var pos2 = this._infoVertici.indexOf(v2);
    this._adiacenze[pos1].splice(pos2, 1);
    this._adiacenze[pos2].splice(pos1, 1);
}

Grafo.prototype.getCoordinate = function (pos) {
    return this._infoVertici[pos];
}

Grafo.prototype.getLength = function () {
    return this._infoVertici.length;
}