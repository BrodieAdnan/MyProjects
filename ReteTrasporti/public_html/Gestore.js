/*****************************************************************************
 *GESTORE
 *@author Gazi Adnan Latif, Riccardo Fusaro
 *@brief Crea la rete e fa partire le animazioni del movimento degli autobus.
 *@brief LEGGE DA FILE.
 *@date 12/05/2018
 ****************************************************************************/
function Gestore() {
    document.getElementById("data").addEventListener("change", this.selectFile.bind(this));
}

Gestore.prototype.selectFile = function () {
    this.reader(document.getElementById("data").files[0]);
}

Gestore.prototype.reader = function (data) {
    var reader = new FileReader();

    reader.onload = function (ev) {

        this.data = new Data();
        
        this.read = function () {
            var linee = this.result.split('\n');
            for (var i = 0; i < linee.length - 1; i++) {
                var jSon = JSON.parse(linee[i].substring(1, linee[i].length));
                if (linee[i].charAt(0) === "F") {//fermate
                    this.data.caricaFermata(jSon);
                    //this.fermate.push(jSon);
                } else if (linee[i].charAt(0) === "T") {//tratte
                    this.data.caricaTratta(jSon);
                    //this.tratte.push(jSon);
                } else if (linee[i].charAt(0) === "B") {//autobus
                    this.data.caricaBus(jSon);
                    //this.bus.push(jSon);
                } else if (linee[i].charAt(0) === "L") {//linee degli autobus
                    this.data.caricaLinea(jSon);
                    //this.linee.push(jSon);
                }
            }
        }

        this.disegnaTratte = function () {
            for (var i = 0; i < this.data.getTratte().length; i++) {
                var percorso = "M " + this.data.cerca(this.data.getTratta(i).partenza).x + " " + this.data.cerca(this.data.getTratta(i).partenza).y + " q " + 0 + " " + 0 + " " + (this.data.cerca(this.data.getTratta(i).arrivo).x - this.data.cerca(this.data.getTratta(i).partenza).x) + " " + (this.data.cerca(this.data.getTratta(i).arrivo).y - this.data.cerca(this.data.getTratta(i).partenza).y);
                this.data.getSVG().createShape("path", {"d": percorso, "fill": "grey", "stroke": "grey", "stroke-width": 3});
            }
        }

        this.disegnaLinee = function () {
            for (var i = 0; i < this.data.getLinee().length; i++) {
                this.data.getSVG().busName(this.data.cercaFermata(this.data.getLinea(i).fermate[0]).x + 0, this.data.cercaFermata(this.data.getLinea(i).fermate[0]).y + 60, this.data.getLinea(i).nome, this.data.getLinea(i).colore);
                for (var j = 0; j < this.data.getLinea(i).fermate.length; j++) {
                    var inizio = this.data.getLinea(i).fermate[j];
                    var posInizio = this.data.cercaFermata(inizio);
                    for (var k = 0; k < this.data.getLinea(i).fermate.length; k++) {
                        var fine = this.data.getLinea(i).fermate[k];
                        var posFine = this.data.cercaFermata(fine);
                        if (this.data.connesso(inizio, fine)) {
                            var colore = this.data.getLinea(i).colore;
                            this.data.getSVG().createShape("path", {"d": "M " + posInizio.x + " " + posInizio.y + " " + posFine.x + " " + " " + posFine.y, "fill": "none", "stroke": colore, "stroke-width": 3});
                        }
                    }
                }
            }
        }

        this.disegnaFermate = function () {
            for (var i = 0; i < this.data.getFermate().length; i++) {
                this.data.getSVG().vertGraph("circle", {"cx": this.data.getFermata(i).x, "cy": this.data.getFermata(i).y, "r": 5, "fill": "black", "stroke": "black", "stroke-width": 2}, this.data.getFermata(i).nome, this.data.getFermata(i).codice);
            }
        }

        this.disegnaBus = function () {
            for (var j = 0; j < this.data.getAutobus().length; j++) {
                var colore = this.data.getColore(Math.round(Math.random() * this.data.getColoreLength()));
                var partenzaX = this.data.cercaFermata(this.data.getBus(j).fermate[0]).x;
                var partenzaY = this.data.cercaFermata(this.data.getBus(j).fermate[0]).y;
                var b = this.data.getSVG().bus(partenzaX, partenzaY, colore);
                var busName = this.data.getSVG().busName(partenzaX, partenzaY, this.data.getBus(j).nome, colore);
                //orario di partenza casuale
                var tempoAtt = Math.round(Math.random() * 10);
                var percorso, tempo, inizioX, inizioY, fineX, fineY;

                for (var i = 0; i < this.data.getBus(j).fermate.length - 1; i++) {
                    tempo = Math.round(Math.random() * 2) + 1;//this.data.tempo(i, j);
                    inizioX = this.data.cercaFermata(this.data.getBus(j).fermate[i]).x;
                    inizioY = this.data.cercaFermata(this.data.getBus(j).fermate[i]).y;
                    fineX = this.data.cercaFermata(this.data.getBus(j).fermate[i + 1]).x;
                    fineY = this.data.cercaFermata(this.data.getBus(j).fermate[i + 1]).y;
                    if (i === 0) {
                        percorso = "M " + 0 + " " + 0 + " L " + (fineX - partenzaX) + " " + (fineY - partenzaY);
                    } else {
                        percorso = "M " + (inizioX - partenzaX) + " " + (inizioY - partenzaY) + " L " + (fineX - partenzaX) + " " + (fineY - partenzaY);
                    }
                    this.data.caricaObj(b);
                    this.data.caricaObj(busName);
                    this.data.caricaAutoBus(this.data.getSVG().addAnimateMotion(percorso, tempo, tempoAtt));
                    this.data.caricaAutoBus(this.data.getSVG().addAnimateMotion(percorso, tempo, tempoAtt));
                    tempoAtt += tempo + 0.5;//ad ogni fermata attende mezzo secondo.
                }
            }
        }

        this.start = function () {
            for (var i = 0; i < this.data.getAutoBusLength(); i++) {
                this.data.getSVG().startAnimation(this.data.getObj(i), this.data.getAutoBus(i));
            }
        }

        this.formaGrafo = function () {
            //inserimento dei vertici
            for (var i = 0; i < this.data.getFermate().length; i++) {
                this.data.grafoInsertInfo(this.data.getFermata(i).nome);
            }
            //inserimento degli archi
            for (var i = 0; i < this.data.getTratte().length; i++) {
                var inizio = this.data.getTratta(i).partenza;
                for (var j = 0; j < this.data.getTratte().length; j++) {
                    var fine = this.data.getTratta(j).arrivo;
                    if (this.data.getTratta(j).partenza === inizio) {
                        this.data.grafoAddArco(inizio, fine);
                    }
                }
            }
            this.data.grafoRappresenta();
            this.data.getSVG().disegnaGrafo(this.data.getGrafo());
        }

        this.read();
        
        this.disegnaTratte();
        this.disegnaLinee();
        this.disegnaFermate();
        this.disegnaBus();
        this.start();
        
        this.formaGrafo();
    }
    reader.readAsText(data);
}