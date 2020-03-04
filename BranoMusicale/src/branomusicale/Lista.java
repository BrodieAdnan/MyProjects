package branomusicale;
/**
 * *********************************************************
 * LISTA
 *
 * @author Gazi Adnan Latif
 * @brief Lista concatenata di elementi.
 * @date 13/10/2017
 * ********************************************************
 */
public class Lista<T> {

    private int lunghezza;
    private NodoConc<T> testa;
    private NodoConc<T> coda;

    public T nodoPos(int pos) {
        NodoConc<T> corrente = testa;
        for (; corrente != null && pos > 0; pos--, corrente = corrente.succ) ;
        return (corrente == null) ? null : corrente.info;
    }

    public boolean ricerca(T elem) {
        NodoConc<T> corrente = testa;
        for (; corrente != null && !corrente.info.equals(elem); corrente = corrente.succ);
        return (corrente != null);
    }

    private NodoConc<T> elemPrec(T elem) {
        NodoConc<T> corrente = testa;
        NodoConc<T> precedente = null;
        while (corrente != null && !corrente.info.equals(elem)) {
            corrente = corrente.succ;
            precedente = corrente;
        }
        return precedente;
    }

    public void inserimento(int pos, T elem) {
        assert pos >= 0 : "posizione negativa in inserimento";
        NodoConc<T> prec = null, corrente = testa;
        for (; corrente != null && pos >= 0; pos--, prec = corrente, corrente = corrente.succ);
        if (corrente == null) {
            aggiungi(elem);
        } else if (prec == null) {
            testa = new NodoConc(elem, testa);
        } else {
            prec.succ = new NodoConc(elem, corrente);
        }
    }

    public void aggiungi(T info) {
        NodoConc temp = new NodoConc(info, null);
        if (testa == null) {
            testa = temp;
        } else {
            coda.succ = temp;
        }
        coda = temp;
        lunghezza++;
    }

    public void cancVal(T elem) {
        NodoConc<T> precedente = elemPrec(elem);
        NodoConc<T> corrente = (precedente == null) ? testa : precedente.succ;
        if (precedente != null && corrente != null) {
            precedente.succ = corrente.succ;
            corrente = null;
        } else {
            testa = corrente.succ;
        }
        lunghezza--;
    }

    public void cancPos(int pos) {
        NodoConc<T> prec = null, corrente = testa;
        T info = null;
        for (; corrente != null && pos >= 0; pos--, prec = corrente, corrente = corrente.succ);
        if (corrente != null) {
            info = (T) corrente.info;
            if (prec == null) {
                testa = corrente.succ;
            } else {
                prec.succ = corrente.succ;
            }
            if (coda == corrente) {
                coda = prec;
            }
        }
        lunghezza--;
    }

    public int lunghezza() {
        return lunghezza;
    }
}
