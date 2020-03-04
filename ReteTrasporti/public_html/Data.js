/***************************************************************
 *DATA
 *@author Gazi Adnan Latif, Riccardo Fusaro
 *@brief legge da file e salva i dati di fermate, tratte e bus.
 *@brief fornisce i dati al Gestore.
 *@date 12/05/2018
 ***************************************************************/
function Data() {
    this.fermate = [];
    this.tratte = [];
    this.bus = [];
    this.linee = [];
    this.color = ["blue", "crimson", "goldenRoad", "lightSeaGreen", "navy", "orange", "green", "red", "teal", "darkOrange", "darkBlue", "darkCyan", "darkMagenta", "darkOrchid", "darkSlateGrey", "darkGoldenRod", "hotPink", "indigo", "yellowGreen", "mediumBlue", "mediumVioletRed", "orangeRed", "peru", "seaGreen", "sienna", "steelBlue"];
    this.svg = new ExtendedSVG();
    this.obj = [];
    this.autoBus = [];
    this.grafo = new GrafoLista();
}

Data.prototype.getObj = function (i) {
    return this.obj[i];
}

Data.prototype.getGrafo = function () {
    return this.grafo;
}

Data.prototype.getAutoBus = function (i) {
    return this.autoBus[i];
}

Data.prototype.getAutoBusLength = function () {
    return this.autoBus.length;
}

Data.prototype.getFermata = function (i) {
    return this.fermate[i];
}

Data.prototype.getTratta = function (i) {
    return this.tratte[i];
}

Data.prototype.getLinea = function (i) {
    return this.linee[i];
}

Data.prototype.getBus = function (i) {
    return this.bus[i];
}

Data.prototype.getColore = function (i) {
    return this.color[i];
}

Data.prototype.getColoreLength = function () {
    return this.color.length;
}

Data.prototype.getSVG = function () {
    return this.svg;
}

Data.prototype.getFermate = function () {
    return this.fermate;
}

Data.prototype.getTratte = function () {
    return this.tratte;
}

Data.prototype.getAutobus = function () {
    return this.bus;
}
Data.prototype.getLinee = function () {
    return this.linee;
}

Data.prototype.grafoInsertInfo = function (info) {
    this.grafo.insertInfo(info);
}

Data.prototype.grafoAddArco = function (v1, v2) {
    this.grafo.addArco(v1, v2);
}

Data.prototype.grafoRappresenta = function () {
    this.grafo.rappresenta();
}

Data.prototype.caricaObj = function (b) {
    return this.obj.push(b);
}

Data.prototype.caricaAutoBus = function (b) {
    return this.autoBus.push(b);
}

Data.prototype.caricaFermata = function (json) {
    this.fermate.push(json);
}

Data.prototype.caricaLinea = function (json) {
    this.linee.push(json);
}

Data.prototype.caricaTratta = function (json) {
    this.tratte.push(json);
}

Data.prototype.caricaBus = function (json) {
    this.bus.push(json);
}

Data.prototype.converti = function () {
    for (var i = 0; i < this.fermate.length; i++) {
        this.fermate[i] = new Fermata(this.fermate[i].nome, new Coppia(this.fermate[i].x, this.fermate[i].y), this.fermate[i].codice);
    }

    for (var i = 0; i < this.tratte.length; i++) {
        this.tratte[i] = new Tratta(this.tratte[i].partenza, this.tratte[i].arrivo);
    }

    for (var i = 0; i < this.bus.length; i++) {
        this.bus[i] = new Bus(this.bus[i].nome, this.bus[i].fermate);
    }

    for (var i = 0; i < this.linee.length; i++) {
        this.linee[i] = new Linea(this.linee[i].nome, this.linee[i].fermate);
    }
}

/********************************************************************
 *CERCA
 *@brief controlla che un nome sia presente tra le femate della rete
 *@in nome della fermata da controllare.
 *@out oggetto fermata che corrisponde al nome.
 ********************************************************************/
Data.prototype.cerca = function (nomeFermata) {
    for (var i = 0; i < this.fermate.length; i++) {
        if (this.fermate[i].nome === nomeFermata) {
            return this.fermate[i];
        }
    }
    return this.fermate[0];
}

/***********************************************************************
 *CERCA FERMATA
 *@brief fornisce le coordinate di una fermata dal codice della fermata.
 *@in codice della fermata.
 *@out coordinate della fermata.
 ***********************************************************************/
Data.prototype.cercaFermata = function (codice) {
    var j = {"x": 0, "y": 0};
    for (var i = 0; i < this.fermate.length; i++) {
        if (this.fermate[i].codice === codice) {
            j.x = this.fermate[i].x;
            j.y = this.fermate[i].y;
        }
    }
    return j;
}

/******************************************************************
 *CONNESSO
 *@brief verifica che due fermata siano connesse mediante un arco.
 *@in fermate i, f
 *@out boolean true/false
 ******************************************************************/
Data.prototype.connesso = function (i, f) {
    var inizio = this.trova(i);
    var fine = this.trova(f);
    for (var j = 0; j < this.tratte.length; j++) {
        if ((this.tratte[j].partenza === inizio && this.tratte[j].arrivo === fine) || (this.tratte[j].arrivo === inizio && this.tratte[j].partenza === fine)) {
            return true;
        }
    }
    return false;
}

/****************************************
 *TEMPO
 *@brief fornisce il tempo di una tratta.
 *@in fermate i, f
 *@out numero --> tempo in secondi
 ****************************************/
Data.prototype.tempo = function (i, f) {
    var inizio = this.trova(i);
    var fine = this.trova(f);
    for (var j = 0; j < this.tratte.length; j++) {
        if ((this.tratte[j].partenza === inizio && this.tratte[j].arrivo === fine) || (this.tratte[j].arrivo === inizio && this.tratte[j].partenza === fine)) {
            return this.tratte[j].tempo;
        }
    }
}

/***********************************************
 *TROVA
 *@brief cerca il nome della fermata dal codice.
 ***********************************************/
Data.prototype.trova = function (codice) {
    for (var i = 0; i < this.fermate.length; i++) {
        if (this.fermate[i].codice === codice) {
            return this.fermate[i].nome;
        }
    }
}