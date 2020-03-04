package bevitoridivino;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Bevitore extends Thread{
    private Buffer buffer;
    public String pin;
    public Bevitore(Buffer buffer, String pin){
        this.buffer=buffer;
        this.pin=pin;
    }
    @Override
    public void run(){
        try {
            sleep((long) (Math.random()*1000));//attesa fino a un secondo.
            buffer.set(this);
            sleep(20);//per bere neccessita di 10 millisecondi.
            buffer.get(this);
        } catch (InterruptedException ex) {
            Logger.getLogger(Bevitore.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
