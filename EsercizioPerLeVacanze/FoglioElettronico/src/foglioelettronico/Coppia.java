package foglioelettronico;
/**
 * *********************************************************
 * COPPIA
 *
 * @author Gazi Adnan Latif
 * @version 2.
 * @brief Contiene gli indici riga e colonna di ogni cella.
 * @since 08/08/2017 to 08/09/2017
 * ********************************************************
 */
public class Coppia {

    private int primo;
    private int secondo;

    ///costruttore
    public Coppia(int primo, int secondo) {
        this.primo = primo;
        this.secondo = secondo;
    }
    
    /**
     * ***************
     * GETPRIMO
     *
     * @return primo.
     * **************
     */
    public int getPrimo() {
        return primo;
    }

    /**
     * *****************
     * GETSECONDO
     *
     * @return secondo.
     * *****************
     */
    public int getSecondo() {
        return secondo;
    }
}
