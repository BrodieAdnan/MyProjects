package concertodisting;

//SIMULA INGRESSO E USCITA DAL CONCERTO DI N PARTECIPANTI.
public class ConcertoDiSting {

    public static void main(String[] args) {
        Buffer buffer=new Buffer();
        for (int i = 0; i < 200; i++) {//50 turisti per entrare al museo.
            new Partecipante(buffer, "Partecipante n."+i).start();
            //t.join();
        }
    }
    
}