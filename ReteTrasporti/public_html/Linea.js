/********************************************************
 *LINEA
 *@author Gazi Adnan Latif, Riccardo Fusaro
 *@brief Contiene informazioni di ogni linea di autobus.
 *@date 12/05/2018
********************************************************/
function Linea (n, f, c){
    this.name = n;
    this.fermate = f;
    this.colore = c;
}

Linea.prototype.getName=function(){
    return this.name;
}

Linea.prototype.getColore=function(){
    return this.colore;
}

Linea.prototype.setColore=function(newColore){
    this.colore = newColore;
}

Linea.prototype.getFermate=function(pos){
    return this.fermate[pos];
}

Linea.prototype.setName=function(newName){
    this.name = newName;
}

Linea.prototype.setFermate=function(newFermata, pos){
    this.fermate[pos] = newFermata;
}