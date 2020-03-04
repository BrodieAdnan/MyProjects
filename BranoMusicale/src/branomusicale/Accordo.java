package branomusicale;
/**
 * *********************************************************
 * ACCORDO
 *
 * @author Gazi Adnan Latif
 * @brief Estende elemento.
 * @brief Tipo particolare di elemento. 
 * @date 13/10/2017
 * ********************************************************
 */
public class Accordo extends Elemento {

    private int[] valoreNote;

    public Accordo(int d, int[] valore) {
        valoreNote = valore;
        durata=d;
    }

    @Override
    public String suona() {
        String ris = "";
        for (int i = 0; i < valoreNote.length; i++) {
            ris+=note[valoreNote[i]-1]+" x "+durata+" ";
        }
        return ris;
    }

}
