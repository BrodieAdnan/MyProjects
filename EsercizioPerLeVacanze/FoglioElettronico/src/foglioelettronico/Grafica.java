package foglioelettronico;

import static zuclib.GraficaSemplice.*;
/**
 * **********************************************
 * GRAFICA
 *
 * @author Gazi Adnan Latif
 * @version 2.
 * @brief Gestisce la grafica dell'applicazione.
 * @since 08/08/2017 to 08/09/2017
 * **********************************************
 */
public class Grafica {

    CellaGrafica[][] celle;
    CellaGrafica visore;
    CellaGrafica notificatore;
    private double latoL;
    private double latoH;

    ///costruttore
    public Grafica(Coppia dimensioni) {
        celle = new CellaGrafica[dimensioni.getPrimo()][dimensioni.getSecondo()];
        visore = new CellaGrafica((float) 0.05, (float) 0.925, (float) 0.95, (float) 0.975);
        notificatore = new CellaGrafica((float) 0.05, (float) 0.0075, (float) 0.95, (float) 0.0525);
        disegna();
    }

    /**
     * *************************************************
     * DISEGNA
     *
     * @brief disegna la grafica iniziale del programma.
     * *************************************************
     */
    private void disegna() {
        int altezza = celle.length;
        int larghezza = celle[0].length;
        double x = 0.00;
        double y = 0.90;
        latoH = 0.90 / altezza;
        latoL = 1.00 / larghezza;
        double sX = 0.0;
        double sY = 0.9 - latoH;
        double dX = latoL;
        double dY = 0.9;
        for (int i = 0; i < altezza; i++) {
            for (int j = 0; j < larghezza; j++) {
                celle[i][j] = new CellaGrafica((float) sX, (float) sY, (float) dX, (float) dY);
                sX += latoL;
                dX += latoL;
            }
            sX = 0.0;
            sY -= latoH;
            dX = latoL;
            dY -= latoH;
        }
        x += latoL / 2;
        y -= latoH / 2;
        setFinestra(1100, 650, "Excel");
        quadratoPieno(0.5, 0.5, 10, VERDE_SCURO);
        rettangoloPieno(0.5, 0.95, 0.9, 0.05, BIANCO);
        rettangolo(0.5, 0.95, 0.9, 0.05);
        for (int r = 0; r < altezza; r++) {
            for (int c = 0; c < larghezza; c++) {
                rettangoloPieno(x, y, latoL, latoH, (r == 0 || c == 0) ? GRIGIO : BIANCO);
                rettangolo(x, y, latoL, latoH);
                x += latoL;
            }
            x = 0.00 + latoL / 2;
            y -= latoH;
        }
        drawIndice();
        rettangoloPieno(0.5, 0.035, 0.71, 0.06, VERDE_SCURO);
        rettangoloPieno(0.5, 0.035, 0.7, 0.045, BIANCO);
        rettangolo(0.5, 0.035, 0.7, 0.045);
    }

    /**
     * ****************************************************************************
     * DRAWINDICE
     *
     * @brief scrive gli indici delle celle della prima riga e della prima colonna.
     * ****************************************************************************
     */
    private void drawIndice() {
        char lettere = 'A';
        for (int i = 1; i < celle[0].length; i++) {
            celle[0][i].scriviTesto("" + lettere);
            lettere = (char) (lettere + 1);
        }
        char numeri = '1';
        char decimali = '0';
        for (int i = 1; i < celle.length; i++) {
            if (decimali == '0') {
                celle[i][0].scriviTesto("" + numeri);
            } else {
                celle[i][0].scriviTesto(decimali + "" + numeri);
            }
            if (numeri >= '9') {
                numeri = '0';
                decimali = (char) (decimali + 1);
            } else {
                numeri = (char) (numeri + 1);
            }
        }
    }

    /**
     * ******************************************************************************
     * SELEZIONA
     *
     * @brief metodo aggiunto.
     * @brief colora di grigio la cella selezionata con il click del mouse.
     * @param coordinate: coppia contenente le coordinate delle celle da selezionare.
     * ******************************************************************************
     */
    public void seleziona(Coppia coordinate) {
        rettangoloPieno((latoL * (coordinate.getSecondo() + 1) + latoL * (coordinate.getSecondo())) / 2, (latoH * (celle.length - coordinate.getPrimo()) + latoH * (celle.length - coordinate.getPrimo() - 1)) / 2, latoL, latoH, GRIGIO_CHIARO);
        rettangolo((latoL * (coordinate.getSecondo() + 1) + latoL * (coordinate.getSecondo())) / 2, (latoH * (celle.length - coordinate.getPrimo()) + latoH * (celle.length - coordinate.getPrimo() - 1)) / 2, latoL, latoH);
    }

    /**
     * ***********************************************************************
     * SETTESTO
     *
     * @brief Passa il testo da scrivere al metodo 'scriviTesto()'.
     * @param testo: valore da scrivere sulla grafica.
     * @param coordinate: coppia che identifica la cella sulla quale scrivere.
     * ***********************************************************************
     */
    public void setTesto(String testo, Coppia coordinate) {
        if (coordinate.getPrimo() == -1 && coordinate.getSecondo() == -1) {
            rettangoloPieno(0.5, 0.95, 0.9, 0.05, BIANCO);
            rettangolo(0.5, 0.95, 0.9, 0.05);
            visore.scriviTesto(testo);
        } else if (coordinate.getPrimo() == 30 && coordinate.getSecondo() == 30) {
            rettangoloPieno(0.5, 0.035, 0.7, 0.045, BIANCO);
            rettangolo(0.5, 0.035, 0.7, 0.045);
            notificatore.scriviTesto(testo);
        } else {
            rettangoloPieno((latoL * (coordinate.getSecondo() + 1) + latoL * (coordinate.getSecondo())) / 2, (latoH * (celle.length - coordinate.getPrimo()) + latoH * (celle.length - coordinate.getPrimo() - 1)) / 2, latoL, latoH, BIANCO);
            rettangolo((latoL * (coordinate.getSecondo() + 1) + latoL * (coordinate.getSecondo())) / 2, (latoH * (celle.length - coordinate.getPrimo()) + latoH * (celle.length - coordinate.getPrimo() - 1)) / 2, latoL, latoH);
            celle[coordinate.getPrimo()][coordinate.getSecondo()].scriviTesto(testo);
        }
    }

    /**
     * ***************************************************************************************
     * GETCOORDINATEFOGLIO
     *
     * @brief restituisce le coordinate della cella premuta o del visore se il click è valido.
     * @param mouseX float.
     * @param mouseY float.
     * @return Coppia contenente gli indici delle celle.
     * ***************************************************************************************
     */
    public Coppia getCoordinateFoglio(float mouseX, float mouseY) {
        return (mouseX > 0.1 && mouseX < 0.9 && mouseY < 0.975 && mouseY > 0.925) ? new Coppia(-1, -1) : (mouseY < 0.9) ? new Coppia(celle.length - 1 - (int) (mouseY / latoH), (int) (mouseX / latoL)) : null;
    }
}
