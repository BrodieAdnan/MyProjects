package foglioelettronico;

/**
 * ***************************************************************
 * FORMULA DELLA CONDIZIONE NUMERO
 *
 * @author Gazi Adnan Latif
 * @version 2.
 * @brief Implementa l'interfaccia 'Valore'.
 * @brief oggetto non usato.
 * @since 08/08/2017 to 08/09/2017
 * ***************************************************************
 */
public class Numero implements Valore{

    private String valore;

    ///costruttore
    public Numero(String numero) {
        valore = numero;
    }

    /**
     * *********************************************************
     * GETVALORE
     *
     * @brief restituisce il valore numerico in formato stringa.
     * @return valore: stringa.
     * *********************************************************
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
