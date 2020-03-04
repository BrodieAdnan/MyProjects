package ilbardelristorante;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Barista extends Thread {

    private Bar monitor;

    public Barista(Bar monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                sleep((long) (Math.random() * 1000)); //attesa fino a 1 secondi.
                monitor.open(false);//stato off.
                sleep((long) (Math.random() * 1000)); //attesa fino a 1 secondi.
                monitor.open(true);//stato on.
            } catch (InterruptedException ex) {
                Logger.getLogger(Barista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
