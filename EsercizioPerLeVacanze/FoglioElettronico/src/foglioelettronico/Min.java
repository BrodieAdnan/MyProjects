package foglioelettronico;

/**
 * ***************************************************************
 * FORMULA DELLA CONDIZIONE MIN
 *
 * @author Gazi Adnan Latif
 * @version 2.
 * @brief Implementa l'interfaccia 'Valore'.
 * @brief Calcola il valore minimo in base alla formula inserita.
 * @since 08/08/2017 to 08/09/2017
 * ***************************************************************
 */
public class Min implements Valore{

    private Cella[] celle;

    ///costruttore
    public Min(String formula, Foglio foglio) {
        celle = new Cella[1 + (formula.charAt(8) - formula.charAt(5) + 1) * (formula.charAt(9) - formula.charAt(6) + 1)];
    }

    /**
     * *******************************************************
     * GETVALORE
     *
     * @brief calcola il valore minimo tra le celle indicate.
     * @return max: stringa contenente il nuemro minimo.
     * *******************************************************
     */
    @Override
    public String getValore() {
        int min = Integer.parseInt(celle[1].getValore());
        for (int i = 2; i < celle.length; i++) {
            if (min > Integer.parseInt(celle[i].getValore())) {
                min = Integer.parseInt(celle[i].getValore());
            }
        }
        return "" + min;
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
        for (int r = 0; r < (testo.charAt(9) - testo.charAt(6) + 1); r++) {
            for (int c = 0; c < (testo.charAt(8) - testo.charAt(5) + 1); c++) {
                celle[indice] = foglio.getCella((char) (testo.charAt(5) + c) + "" + (char) (testo.charAt(6) + r));
                indice += 1;
                if (!foglio.getCella((char) (testo.charAt(5) + c) + "" + (char) (testo.charAt(6) + r)).numero()) {
                    corretto = false;
                }
            }
        }
        return corretto;
    }
}
