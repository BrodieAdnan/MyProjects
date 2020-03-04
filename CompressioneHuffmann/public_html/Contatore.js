function Contatore (){
    this.cont = 0;
}

Contatore.prototype.piupiu = function (){
    this.cont++;
}

Contatore.prototype.getCont = function (){
    return this.cont;
}