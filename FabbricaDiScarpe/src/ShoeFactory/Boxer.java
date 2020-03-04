package ShoeFactory;

/**
 * Classe Boxer (consumatore)
 *
 * @author Farhan
 */
public class Boxer extends Thread {

    private Production productor;
    private Matching matcher;
    private PairBuffer pairBuffer;
    private final int pairNumber;

    /**
     * Costruttore Boxer
     *
     * @param productor
     * @param matcher
     * @param pairBuffer
     * @param pairNumber
     */
    public Boxer(Production productor, Matching matcher, PairBuffer pairBuffer, int pairNumber) {

        this.pairNumber = pairNumber;

        //tutte le referenze
        this.productor = productor;//referenza per fermare la peoduzione
        this.matcher = matcher;//referenza per fermare il matching
        this.pairBuffer = pairBuffer;//referenza al pair buffer
    }

    /**
     * Metodo Run
     */
    @Override
    public void run() {
        for (int i = 1; i <= pairNumber; i++) {
            Shoe[] pair;
            pair = pairBuffer.get();

            System.out.println("Boxer : got pair #" + i + " " + pair[0] + ", " + pair[1]);
        }//for

        productor.stopRunning();//ferma il thread produttore
        matcher.stopRunning();//ferma il thread matching
    }
}
