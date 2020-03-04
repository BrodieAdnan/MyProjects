package foglioelettronico;

import static zuclib.GraficaSemplice.*;
/**
 * ***************************************************************
 * FOGLIO
 *
 * @author Gazi Adnan Latif
 * @version 2.
 * @brief Intercetta e gestisce il testo inserito dalla tastiera.
 * @since 08/08/2017 to 08/09/2017
 * **************************************************************
 */
public class Foglio {

    private Cella[][] celle;
    private Grafica grafica;
    private Coppia cellaCorrente;
    private String[][] formule;
    private String[][] valori;
    private String t;

    ///costruttore
    public Foglio(Coppia dimensioni) {
        celle = new Cella[dimensioni.getPrimo()][dimensioni.getSecondo()];
        valori = new String[dimensioni.getPrimo()][dimensioni.getSecondo()];
        formule = new String[dimensioni.getPrimo()][dimensioni.getSecondo()];
        grafica = new Grafica(dimensioni);
        cellaCorrente = new Coppia(1, 1);
        t = " ";
        inizializza();
    }

    /**
     * *****************************************************************************************
     * INIZIALIZZA
     *
     * @brief inizializza tutte le celle della matrice che forma il foglio fornendo gli inidici.
     * *****************************************************************************************
     */
    private void inizializza() {
        for (int r = 0; r < celle.length; r++) {
            for (int c = 0; c < celle[0].length; c++) {
                celle[r][c] = new Cella((char) (c + 64) + "" + r, this);
            }
        }
    }

    /**
     * ******************************************************************************************
     * GESTOREEVENTI
     *
     * @brief salva il testo scritto dalla tastiera e assegna il valore della formula alla cella.
     * ******************************************************************************************
     */
    public void gestoreEventi() {
        cellaCorrente = grafica.getCoordinateFoglio((float) mouseX(), (float) mouseY());
        grafica.setTesto("Hai selezionato la cella: " + celle[cellaCorrente.getPrimo()][cellaCorrente.getSecondo()].getIndice(), new Coppia(30, 30));
        grafica.seleziona(cellaCorrente);
        while (mousePremuto());
        while (!tastoPremuto());
        while (!premutoTasto('\n')) {
            if (tastoPremuto()) {
                t += tasto();
                grafica.setTesto(celle[cellaCorrente.getPrimo()][cellaCorrente.getSecondo()].getValore() + " >>> " + t, new Coppia(-1, -1));
            }
        }
        celle[cellaCorrente.getPrimo()][cellaCorrente.getSecondo()].setFormula(t.substring(1, t.length()));
        celle[cellaCorrente.getPrimo()][cellaCorrente.getSecondo()].setContenuto();
        t = "";
    }

    /**
     * ******************************************************************************
     * VISUALIZZA
     *
     * @brief stampa il contenuto di ogni cella che è diversa dall'evento precedente.
     * ******************************************************************************
     */
    public void visuaizza() {
        if (!celle[cellaCorrente.getPrimo()][cellaCorrente.getSecondo()].getValore().equals(valori[cellaCorrente.getPrimo()][cellaCorrente.getSecondo()]) || !celle[cellaCorrente.getPrimo()][cellaCorrente.getSecondo()].getFormula().equals(formule[cellaCorrente.getPrimo()][cellaCorrente.getSecondo()])) {
            if (!celle[cellaCorrente.getPrimo()][cellaCorrente.getSecondo()].getValore().equals("%errore%")) {
                valori[cellaCorrente.getPrimo()][cellaCorrente.getSecondo()] = celle[cellaCorrente.getPrimo()][cellaCorrente.getSecondo()].getValore();
                formule[cellaCorrente.getPrimo()][cellaCorrente.getSecondo()] = celle[cellaCorrente.getPrimo()][cellaCorrente.getSecondo()].getFormula();
                grafica.setTesto(celle[cellaCorrente.getPrimo()][cellaCorrente.getSecondo()].getValore(), cellaCorrente);
            } else {
                grafica.setTesto("ERRORE: Hai scritto male la formula!", new Coppia(30, 30));
            }
        } else {
            grafica.setTesto("ERRORE: Il testo è uguale a quello precedente!", new Coppia(30, 30));
        }
    }

    /**
     * ************************************************************************************
     * GETCELLA
     *
     * @brief conversione da formato excel a formato numerico delle coordinate della cella.
     * @param indice: stringa di coordinate della cella in formato A1...
     * @return Cella in formato nuemerico.
     * ************************************************************************************
     */
    public Cella getCella(String indice) {
        return celle[(indice.charAt(1) - 48)][(indice.charAt(0) - 64)];
    }
}
