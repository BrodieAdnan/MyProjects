package ShoeFactory;

/**
 * Questa classe serve per creare le "Shoe" (scarpe)
 *
 * @author Farhan
 */
public class Production extends Thread {

    //attributi privati
    //array di stringhe che contengono le caratteristiche delle scarpe
    private final String footType[] = {"LEFT", "RIGHT"};//tipo di piede
    private final String colors[]
            = {"BLACK", "BLUE", "RED", "YELLOW",
                "ORANGE", "GREEN", "WHITE"};//colore

    private Buffer singleShoeBuffer;
    private int pin, colorsLength, footTypeLength;
    private boolean stopThread;

    /**
     * Costruttore Producer
     *
     * @param singleShoeBuffer
     * @param pin
     */
    public Production(Buffer singleShoeBuffer, int pin) {

        this.singleShoeBuffer = singleShoeBuffer;//reference al buffer delle scarpe singole 
        this.pin = pin;//numero di identificazione

        colorsLength = colors.length;//luchezza array colori
        footTypeLength = footType.length;//lunghezza array tipo piede

        stopThread = false;//variabile che matirne vivo il running
    }

    /**
     * metodo run che viene avviato con il start fatto nel main
     *
     */
    @Override
    public void run() {

        while (!stopThread) {//finchè stopThread è falso continua

            String shoeColor = colors[(int) (Math.random() * colorsLength)];//decide casualmente il colore
            String foot = footType[(int) (Math.random() * footTypeLength)];//decide casualmente il tipo
            Shoe s = new Shoe(shoeColor, foot);//crea una nuova scarpa

            singleShoeBuffer.put(s);//mette la nuova scarpa nel buffer
            System.out.println("Producer #" + pin + " put : " + s);

            try {
                sleep((long) (Math.random() * 100));
            } catch (InterruptedException e) {
            }
        }//while
    }//run

    /**
     * metodo che permette di mettere true al stopThread per terminare il
     * running
     *
     */
    public void stopRunning() {
        stopThread = true;
    }

}
