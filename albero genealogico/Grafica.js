function Grafica() {
    var puls = document.getElementById("mostra");
    var nome = document.getElementById("insert");
    var tabella = document.getElementById("tabella");

    function creaTabella(tabella, righe, colonne){
        for (var r= 0; r < righe; r++){
            var riga = tabella.insertRow(r);
            for (var c= 0; c < colonne; c++){
                riga.insertCell(c);
            }
        }
    }

    this.scrivi = function (valore, r, c) {
        tabella.rows[r].cells[c].innerHTML = valore;
    };

    this.initArea = function () {
        var righe = tabella.rows.length;
        for (var r = 0; r < righe; r++) {
            var colonne = tabella.rows[r].length;
            for (var c = 0; c < colonne; c++) {
                tabella.rows[r].cells[c].innerHTML = "&nbsp;";
            }
        }
    };

    this.callBack = function (f) {
        puls.addEventListener("click", function () {
            f(nome.value);
        });
    };
    creaTabella(tabella, 7, 3)
}