package ShoeFactory;

/**
 * Classe che definisce il buffer del paio di scarpe
 *
 * @author Farhan
 */
public class PairBuffer {

    private final int N;//lunghezza buffer
    private int g, p;//indici get e put
    private Shoe vettS[][];//buffer matrice perche' le scarpe sono due

    /**
     * costruttore Pair buffer
     *
     */
    public PairBuffer() {
        N = 10;
        g = p = 0;
        vettS = new Shoe[this.N][2];
    }

    /**
     * Metodo per ottenere il paio di scapre
     *
     * @return un array di scarpe
     */
    public synchronized Shoe[] get() {
        while (g == p) {//vuoto
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        notifyAll();

        Shoe[] x = new Shoe[2];

        x[0] = vettS[g][0];
        x[1] = vettS[g][1];

        g = (g + 1) % N;
        return x;
    }//get

    /**
     * Metodo void per metter il paio di scarpe
     *
     * @param shoe
     */
    public synchronized void put(Shoe[] shoe) {
        while ((p + 1) % N == g) {//pieno
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        vettS[p][0] = shoe[0];
        vettS[p][1] = shoe[1];

        p = (p + 1) % N;
        notifyAll();
    }//put
}
