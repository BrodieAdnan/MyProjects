package branomusicale;
/**
 * *********************************************************
 * NOTA
 *
 * @author Gazi Adnan Latif
 * @brief Estende elemento.
 * @brief Tipo particolare di elemento. 
 * @date 13/10/2017
 * ********************************************************
 */
public class Nota extends Elemento {

    private int valore;

    public Nota(int d, int valore) {
        this.valore = valore;
        durata = d;
    }

    @Override
    public String suona(){
        return note[valore-1] + " " + durata;
    }
}
