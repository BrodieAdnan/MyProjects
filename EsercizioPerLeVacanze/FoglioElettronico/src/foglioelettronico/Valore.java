package foglioelettronico;

/**
 * *******************************************************************
 * INTERFACCIA VALORE
 *
 * @author Gazi Adnan Latif
 * @version 2.
 * @brief Racchiude tutte i metodi degli oggetti che la implementano.
 * @since 08/08/2017 to 08/09/2017
 * ******************************************************************
 */
public interface Valore {
    
    /**
     * ****************************************************************
     * GETVALORE
     *
     * @brief restituisce il valore in formato della formula calcolata.
     * ****************************************************************
     */
    public String getValore();
    
    /**
     * ************************************************************
     * GENERAVALORE
     *
     * @param testo: stringa contenente la formula.
     * @param foglio: Foglio.
     * @brief assegna le istanze alle celle indicate dalla formula.
     * @return boolean.
     * ************************************************************
     */
    public boolean generaValore(String testo, Foglio foglio);
}
