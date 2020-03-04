package oroogioanalogico;

/**
****************************************************
*INCREMENTATORE
 * @author Adnan Gazi Latif
 * @brief Incrementa ogni secondo la cifra ricevuta.
 * @date 11/04/2017
 ***************************************************
 */
class Incrementatore {

    private int limite;
    private int nAttuale;

    Incrementatore(int limite) {
        this.limite = limite;
        nAttuale = 0;
    }

    void incrementa() { //incremento di 1 al valore della cifra.
        nAttuale = (nAttuale + 1) % limite; //toglie la prima cifra all'incremento.
    }

    int getValore() { //restitusce il valore incrementato.
        return nAttuale;
    }
    
}
