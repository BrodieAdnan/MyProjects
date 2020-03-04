package turistiallouvre;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Turisti extends Thread{
    private Buffer buffer;
    public String pin;
    public Turisti(Buffer b, String pin){
        buffer=b;
        this.pin=pin;
    }
    @Override
    public void run(){
        try {
            sleep((long) (Math.random()*1000));//attesa fino ad un secondo.
            buffer.set(this);
            sleep((long) (Math.random()*1000));//attesa di 5 secondi.
            buffer.get(this);
        } catch (InterruptedException ex) {
            Logger.getLogger(Turisti.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
