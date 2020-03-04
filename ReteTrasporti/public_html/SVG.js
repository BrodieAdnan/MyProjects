/*********************************************************
 *SVG
 *@author Gazi Adnan Latif, Riccardo Fusaro
 *@brief crea componenti grafiche usando la libreria SVG.
 *@date 12/05/2018
 ********************************************************/
function SVG() {
    this.init();
}

SVG.prototype.init = function () {
    this.svgNS = "http://www.w3.org/2000/svg";
    this.svg = document.getElementById("svg");
}

SVG.prototype.createShape = function (tipo, attributi) {
    var elemento = document.createElementNS(this.svgNS, tipo);
    for (var att in attributi) {//array associativo
        elemento.setAttribute(att, attributi[att]);
    }
    elemento.appendChild(document.createTextNode(attributi.contenuto));
    this.svg.appendChild(elemento);
    return elemento;
}