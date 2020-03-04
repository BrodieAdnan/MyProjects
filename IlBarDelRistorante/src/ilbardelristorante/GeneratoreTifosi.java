package ilbardelristorante;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GeneratoreTifosi extends Thread {

    private Bar monitor;

    public GeneratoreTifosi(Bar monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Tifoso nuovo = new Tifoso(monitor, generate(), (int) Math.random() * 1000);
            nuovo.start();
            try {
                sleep((long) (Math.random() * 100));
            } catch (InterruptedException ex) {
                Logger.getLogger(GeneratoreTifosi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private String generate() {
        int toGenerate = (int) (Math.random() * 2);
        if (toGenerate == 0) {
            return "Locale";
        } else {
            return "Ospite";
        }
    }
}
