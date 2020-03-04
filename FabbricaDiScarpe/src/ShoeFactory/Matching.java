package ShoeFactory;

/**
 * Questa classe ha il compito di trovare il paio di scarpe
 *
 * @author Farhan
 */
public class Matching extends Thread {

    private Buffer buffer;//reference buffer singolo
    private PairBuffer pairBuffer;//refernce buffer paio
    private Shoe a, b;
    private boolean stopThread;

    /**
     * Costrutore Matcher
     *
     * @param buffer
     * @param pairBuffer
     */
    public Matching(Buffer buffer, PairBuffer pairBuffer) {
        this.buffer = buffer;//reference
        this.pairBuffer = pairBuffer;//reference
        stopThread = false;
    }

    /**
     * metodo run mandato in esecuzione dal main
     */
    @Override
    public void run() {

        while (!stopThread) {//finchè stopthread e' false
            if (buffer.isFull()) {//comincia il confronto solo se il buffer e' pieno
                System.out.println("Matcher : is now working...");
                int nElem = buffer.getElementNumb();

                for (int i = 0; i < nElem; i++) {
                    a = buffer.get(i);

                    for (int j = i + 1; j < nElem; j++) {
                        b = buffer.get(j);

                        if (a.getColor().equals(b.getColor())
                                && (!a.getFootType().equals(b.getFootType()))) {
                            System.out.println("Matcher : found a pair !\n"
                                    + "Matcher : put " + a + ", " + b);
                            pairBuffer.put(new Shoe[]{a, b});
                        }
                    }
                }
                buffer.freeBuffer();//libera il buffer in modo che il produttore possa continuare la produzione

            } else {//se il buffer non e' pieno allora aspetta
                try {
                    sleep((long) (Math.random() * 100));
                } catch (InterruptedException e) {
                }
            }
        }
    }

    /**
     * metodo che permette di mettere true al stopThread per terminare il
     * running
     */
    public void stopRunning() {
        stopThread = true;
    }

}
