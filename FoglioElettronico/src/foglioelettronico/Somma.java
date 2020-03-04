package foglioelettronico;

/**
 * **************************************************************
 * FORMULA DELLA CONDIZIONE SOMMA
 *
 * @author Gazi Adnan Latif
 * @version 2.
 * @brief Implementa l'interfaccia 'Valore'.
 * @brief Calcola il valore somma in base alla formula inserita.
 * @since 08/08/2017 to 08/09/2017
 * *************************************************************
 */
public class Somma implements Valore{

    private Cella[] celle;

    ///costruttore
    public Somma(String formula, Foglio foglio) {
        celle = new Cella[1 + (formula.charAt(10) - formula.charAt(7) + 1) * (formula.charAt(11) - formula.charAt(8) + 1)];
    }

    /**
     * **********************************************
     * GETVALORE
     *
     * @brief calcola la somma tra le celle indicate.
     * @return somma: stringa.
     * **********************************************
     */
    @Override
    public String getValore() {
        int somma = 0;
        for (int i = 1; i < celle.length; i++) {
            somma += Integer.parseInt(celle[i].getValore());
        }
        return "" + somma;
    }

    /**
     * ***********************************************************************
     * GENERAVALORE
     *
     * @brief verifica che tutte le celle indicate contengano valore numerici.
     * @brief assegna le celle indicate all'istanza 'celle'.
     * @param testo: stringa contenente la formula.
     * @param foglio: Foglio.
     * @return corretto: boolean.
     * ***********************************************************************
     */
    @Override
    public boolean generaValore(String testo, Foglio foglio) {
        int indice = 1;
        boolean corretto = true;
        for (int r = 0; r < (testo.charAt(11) - testo.charAt(8) + 1); r++) {
            for (int c = 0; c < (testo.charAt(10) - testo.charAt(7) + 1); c++) {
                celle[indice] = foglio.getCella((char) (testo.charAt(7) + c) + "" + (char) (testo.charAt(8) + r));
                indice += 1;
                if (!foglio.getCella((char) (testo.charAt(7) + c) + "" + (char) (testo.charAt(8) + r)).numero()) {
                    corretto = false;
                }
            }
        }
        return corretto;
    }
}
