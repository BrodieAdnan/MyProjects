package branomusicale;
/**
 * *********************************************************
 * PAUSA
 *
 * @author Gazi Adnan Latif
 * @brief Estende elemento.
 * @brief Tipo particolare di elemento. 
 * @date 13/10/2017
 * ********************************************************
 */
public class Pausa extends Elemento {

    public Pausa(int d) {
        durata = d;
    }

    @Override
    public String suona() {
        return "pausa " + durata;
    }
}
