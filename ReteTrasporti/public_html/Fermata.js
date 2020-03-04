/**********************************************
 *FERMATA
 *@author Gazi Adnan Latif, Riccardo Fusaro
 *@brief Contiene informazioni di ogni fermata.
 *@date 12/05/2018
**********************************************/
function Fermata(n, c, p) {
    this.nome = n;
    this.codice = c;
    this.coordinate = p;
}

Fermata.prototype.getNome = function () {
    return this.name;
}

Fermata.prototype.getX = function () {
    return this.codice.getX();
}

Fermata.prototype.getY = function () {
    return this.codice.getY();
}

Fermata.prototype.getCodice = function () {
    return this.codice;
}

Fermata.prototype.getCoordinate = function () {//return Coppia
    return this.coordinate;
}

Fermata.prototype.setName = function (newName) {
    this.name = newName;
}

Fermata.prototype.setCodice = function (newCodice) {
    this.codice = newCodice;
}

Fermata.prototype.setCoordinateX = function (newX) {
    this.coordinate.setX(newX);
}

Fermata.prototype.setCoordinateY = function (newY) {
    this.coordinate.setY(newY);
}