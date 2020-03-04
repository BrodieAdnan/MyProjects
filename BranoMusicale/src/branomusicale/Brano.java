package branomusicale;
/**
 * *********************************************************
 * BRANO
 *
 * @author Gazi Adnan Latif
 * @brief Definisce il funzionamento di una lista.
 * @brief Forma una lista di elemti.
 * @date 13/10/2017
 * ********************************************************
 */
public class Brano {

    Lista<Elemento> elementi;

    public Brano() {
        elementi = new Lista();
    }

    public boolean add(int pos, Elemento elem) {
        elementi.inserimento(pos, elem);
        return true;
    }

    public boolean remove(int pos) {
        elementi.cancPos(pos);
        return true;
    }

    public void riproduci() {
        for (int i = 0; i < elementi.lunghezza(); i++) {
            System.out.println(elementi.nodoPos(i).suona());
        }
    }
}
