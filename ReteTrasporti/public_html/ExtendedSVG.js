/****************************************************************************
 *EXTEDED SVG
 *@author Gazi Adnan Latif, Riccardo Fusaro
 *@brief AGGIUNGE FUNZIONI SPEZIFICHE PER RAPPRESENTARE LE RETI DI TRASPORTO.
 *@brief DERIVATO DALLA CLASSE SVG.
 *@date 12/05/2018
 ****************************************************************************/
function ExtendedSVG() {
    this.init();
}

//derivazione da SVG
ExtendedSVG.prototype = new SVG();
ExtendedSVG.constructor = ExtendedSVG;

ExtendedSVG.prototype.addAnimateMotion = function (percorso, durata, begin) {
    var a = document.createElementNS(this.svgNS, "animateMotion");
    a.setAttribute("path", percorso);
    a.setAttribute("dur", durata + "s");
    a.setAttribute("fill", "freeze");
    a.setAttribute("begin", begin + "s");
    return a;
}

ExtendedSVG.prototype.startAnimation = function (obj, a) {
    obj.appendChild(a);
}

ExtendedSVG.prototype.bus = function (partenzaX, partenzaY, colore) {
    return this.createShape("circle", {"cx": partenzaX, "cy": partenzaY, "r": 5, "fill": "white", "stroke": colore, "stroke-width": 2});
}

ExtendedSVG.prototype.busName = function (partenzaX, partenzaY, contenuto, colore) {
    return this.createShape("text", {"x": partenzaX - 20, "y": partenzaY - 15, "contenuto": contenuto, "fill": colore, "stroke": colore, "stroke-width": 0.5});
}

ExtendedSVG.prototype.vertGraph = function (tipo, attributi, nomeFermata, codiceFermata) {
    this.createShape(tipo, attributi);
    this.createShape("text", {"x": attributi.cx + 6, "y": attributi.cy - 6, "contenuto": nomeFermata, "fill": "red", "stroke": "red", "stroke-width": 0.5, transform: "rotate(0 " + attributi.cx + ", " + attributi.cy + ")"});
    this.createShape("text", {"x": attributi.cx + 6, "y": attributi.cy + 6, "contenuto": codiceFermata, "fill": "blue", "stroke": "blue", "stroke-width": 0.5, transform: "rotate(0 " + attributi.cx + ", " + attributi.cy + ")"});
}

ExtendedSVG.prototype.disegnaGrafo = function (grafo) {
    //disegna i vertici
    for (var i = 0; i < grafo._vertici; i++) {
        this.vertGraph("circle", {"cx": grafo.getCoordinate(i).getX(), "cy": grafo.getCoordinate(i).getY(), "r": 20, "fill": grafo.getColore(i), "stroke": "none", "stroke-width": 1}, i);
    }
    //disegna gli archi
    for (var i = 0; i < grafo.vertici; i++) {
        for (var j = 0; j < grafo.adiacenze[i].length; j++) {
            this.createShape("line", {"x1": grafo.getCoordinate(i).getX(), "x2": grafo.getCoordinate(grafo.adiacenze[i][j]).getX(), "y1": grafo.getCoordinate(i).getY(), "y2": grafo.getCoordinate(grafo.adiacenze[i][j]).getY(), "fill": "black", "stroke": "black", "stroke-width": 0.5});
        }
    }
}