package concertodisting;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Partecipante extends Thread{
    private Buffer buffer;
    public String pin;
    public Partecipante(Buffer b, String pin){
        buffer=b;
        this.pin=pin;
    }
    @Override
    public void run(){
        try {
            sleep((long) (Math.random()*1000));//attesa fino ad un secondo.
            buffer.set(this);
            sleep((long) (Math.random()*100));//attesa di 5 secondi.
            buffer.get(this);
        } catch (InterruptedException ex) {
            Logger.getLogger(Partecipante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
