/*******************************************
 *BUS
 *@author Gazi Adnan Latif, Riccardo Fusaro
 *@brief Contiene informazioni di ogni Bus.
 *@date 12/05/2018
*******************************************/
function Bus(n, f) {
    this.name = n;
    this.fermate = f;
}

Bus.prototype.getName = function () {
    return this.name;
}

Bus.prototype.getFermate = function () {
    return this.fermate;
}

Bus.prototype.getBus = function (i) {
    return this.fermate[i];
}

Bus.prototype.setName = function (newName) {
    this.name = newName;
}

Bus.prototype.setBus = function (bus, i) {
    this.fermate[i] = bus;
}

Bus.prototype.setFermate = function (newFermate) {
    this.fermate = newFermate;
}