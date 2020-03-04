package ilbardelristorante;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Tifoso extends Thread {

    public String pin;
    private Bar monitor;
    private int tempoTrascorrimento;
    public int pos;

    public Tifoso(Bar monitor, String pin, int temp) {
        this.monitor = monitor;
        this.pin = pin;
        tempoTrascorrimento = temp;
    }

    @Override
    public void run() {
        try {
            monitor.set(this);
            //System.out.println("Tifoso " + pin + " inserito in posizione " + pos);
            sleep(tempoTrascorrimento);
            monitor.get(pos);
        } catch (InterruptedException ex) {
            Logger.getLogger(Tifoso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
