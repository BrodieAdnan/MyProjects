/**********************************************
 *TRATTA
 *@author Gazi Adnan Latif, Riccardo Fusaro
 *@brief Contiene informazioni di ogni Tratta.
 *@brief fornisce i dati al Gestore.
 *@date 12/05/2018
**********************************************/
function Tratta(partenza, arrivo, tempo) {
    this.partenza = partenza;
    this.arrivo = arrivo;
    this.tempo = tempo;
}

Tratta.prototype.getPartenza = function () {
    return this.partenza;
}

Tratta.prototype.getArrivo = function () {
    return this.arrivo;
}

Tratta.prototype.getTempo = function () {
    return this.tempo;
}

Tratta.prototype.setPartenza = function (newPartenza) {
    this.partenza = newPartenza;
}

Tratta.prototype.setArrivo = function (newArrivo) {
    this.arrivo = newArrivo;
}

Tratta.prototype.setTempo = function (newTempo) {
    this.tempo = newTempo;
}