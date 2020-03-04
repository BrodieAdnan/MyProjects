package ShoeFactory;

/**
 * Questa classe definisce il buffer delle singloe scarpe
 *
 * @author Farhan
 */
public class Buffer {

    //attributi privati
    private final int N;//lunghezza buffer
    private int p, count;//indice put e contatore scarpe
    private Shoe vettS[];//buffer

    /**
     * costruttore Buffer
     *
     */
    public Buffer() {

        N = 10;
        p = count = 0;
        vettS = new Shoe[this.N];
    }

    /**
     * Metodo get con indice
     *
     * @param index del buffer
     * @return Shoe
     */
    //non necessita di essere synchronized
    public Shoe get(int index) {

        return vettS[index];
    }

    /**
     * metodo per mettere dentro gli elementi
     *
     * @param scarpa
     */
    public synchronized void put(Shoe scarpa) {

        while (isFull()) {//quando il buffer e' pieno aspetta
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        vettS[p] = scarpa;//mette dentro la scarpa
        p++;//avanza l'indice
        count++;//incremento contatore
        notifyAll();
    }

    /**
     * metedo che indica se il buffer e' pieno
     *
     * @return true/false
     */
    public boolean isFull() {
        return p == (N - 1);
    }

    /**
     * metodo che svuota il buffer
     *
     */
    public synchronized void freeBuffer() {
        p = 0;
        count = 0;
        notifyAll();
    }

    /**
     * metodo per ottenere il numero degli elementi
     *
     * @return int numero elemeni
     */
    public int getElementNumb() {
        return count;//solo per sicurezza
    }

}
