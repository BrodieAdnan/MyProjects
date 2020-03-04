package oroogioanalogico;

import static zuclib.GraficaSemplice.*;

/**
 ********************************************************************
 * OROLOGIO
 *
 * @author Adnan Gazi Latif
 * @brief Tipo contenente gli altri oggetti: gestisce le altre cifre.
 * @date 11/04/2017
 * *******************************************************************
 */
class Orologio {

    private CifraFinale decineO; //nasce l'oggetto decineO.
    private Cifra unitaO; //nasce l'oggetto unitaO.
    private Cifra decineM; //nasce l'oggetto decineM.
    private Cifra unitaM; //nasce l'oggetto unitaM.
    private Cifra decineS; //nasce l'oggetto decineS.
    private Cifra unitaS; //nasce l'oggetto unitaS.
    private int[] con;
    private double[] appoggio;
    private Digit d;

    Orologio() {
        decineO = new CifraFinale(3); //limite imposto a 3.
        unitaO = new Cifra(10, decineO); //limite imposto a 10.
        decineM = new Cifra(6, unitaO); //limite imposto a 6.
        unitaM = new Cifra(10, decineM); //limite imposto a 10.
        decineS = new Cifra(6, unitaM); //limite imposto a 6.
        unitaS = new Cifra(10, decineS); //limite imposto a 10.
        con = new int[]{0, 0, 0, 0, 0, 0};
        appoggio = new double[]{0.1, 0.21, 0.38, 0.49, 0.66, 0.77};
    }

    void incrementa() { //richiamo incremento di Cifra.
        ///modificare quà.
        unitaS.incrementa();
        con[0] = decineO.getValore();
        con[1] = unitaO.getValore();
        con[2] = decineM.getValore();
        con[3] = unitaM.getValore();
        con[4] = decineS.getValore();
        con[5] = unitaS.getValore();
    }

    void visualizza() {
        String ore = "" + decineS.getValore() + unitaS.getValore();
        int ora=Integer.parseInt(ore);
        ora /= 10;
        ora++;
            disegnaImmagineRidimensionata(0.5, 0.5, "G:\\TRIENNIO\\3IB\\Informatica\\Java\\NetBeans\\LavoroACasa\\Tempo\\src\\tempo\\" + ora + ".jpg", 0, 1.024, 1.024);
        for (int i = 0; i < 6; i++) {
            d = new Digit(0.2, appoggio[i]);
            d.disegnaNumero(con[i]);
        }
    }

    boolean azzeramento() { //controllo decine e minuti ore prima di azzerare.
        if (decineO.getValore() == 2 && unitaO.getValore() == 4) {
            return true;
        } else {
            return false;
        }
    }
}
