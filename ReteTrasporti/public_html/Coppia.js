/****************************************************************
 *COPPIA
 *@author Gazi Adnan Latif, Riccardo Fusaro
 *@brief legge da file e salva i dati di fermate, tratte e bus.
 *@brief fornisce i dati al Gestore.
 *@date 12/05/2018
 ***************************************************************/
function Coppia(x, y) {
    this.x = x;
    this.y = y;
}

Coppia.prototype.getX = function () {
    return this.x;
}
Coppia.prototype.getY = function () {
    return this.y;
}

Coppia.prototype.setX = function (newX) {
    this.x = newX;
}

Coppia.prototype.setY = function (newY) {
    this.y = newY;
}