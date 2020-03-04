package branomusicale;
/**
 * *********************************************************
 * NODO CONCATENATO
 *
 * @author Gazi Adnan Latif
 * @brief Utilizzata dalla classe lista.
 * @date 13/10/2017
 * ********************************************************
 */
public class NodoConc<T> {

    public T info;
    public NodoConc succ;

    public NodoConc() {
        info = null;
        succ = null;
    }

    public NodoConc(T i) {
        info = i;
        succ = null;
    }

    public NodoConc(T i, NodoConc s) {
        succ = s;
        info = i;
    }
}
