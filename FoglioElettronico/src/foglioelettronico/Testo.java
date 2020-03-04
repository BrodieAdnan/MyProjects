package foglioelettronico;

/**
 * ********************************************************************
 * FORMULA DELLA CONDIZIONE TESTO
 *
 * @author Gazi Adnan Latif
 * @version 2.
 * @brief Implementa l'interfaccia 'Valore'.
 * @brief Calcola il valore non nuemrico in base alla formula inserita.
 * @since 08/08/2017 to 08/09/2017
 * ********************************************************************
 */
public class Testo implements Valore{

    private String valore;

    ///costruttore
    public Testo(String testo) {
        valore = testo;
    }

    /**
     * *************************************************************
     * GETVALORE
     *
     * @brief restituisce il valore non numerico in formato stringa.
     * @return valore: stringa.
     * *************************************************************
     */
    @Override
    public String getValore() {
        return valore;
    }

    /**
     * ********************************************
     * GENERAVALORE
     *
     * @param testo: stringa contenente la formula.
     * @param foglio: Foglio.
     * @brief metodo non usato.
     * @return boolean.
     * ********************************************
     */
    @Override
    public boolean generaValore(String testo, Foglio foglio) {
        return true;
    }
}
