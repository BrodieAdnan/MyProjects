package branomusicale;

/**
 * *********************************************************
 * LINKED LIST
 *
 * @author Gazi Adnan Latif
 * @brief Simula il funzionamento di una lista.
 * @brief Non viene utilizzata.
 * @date 13/10/2017 
 * *******************************************************
 */
import java.util.*;

public class LinkedList<T> {

    private ArrayList<T> lista;
    private int lunghezza;

    public LinkedList() {
        lista = new ArrayList();
        lunghezza = 0;
    }

    public void inserimento(int pos, T elem) {
        lista.add(pos, elem);
    }

    public T cancPos(int pos) {
        return lista.remove(pos);
    }

    public int lunghezza() {
        return lista.size();
    }

    public T get(int i) {
        return lista.get(i);
    }
}
