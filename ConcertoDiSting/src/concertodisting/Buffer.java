package concertodisting;

public class Buffer {

    private int biglietti;
    private int indice;
    private int lung;
    private Partecipante[] buffer;

    public Buffer() {
        indice = 0;
        lung = 5;
        buffer = new Partecipante[lung];
        biglietti=200;
    }

    synchronized public void set(Partecipante t) throws InterruptedException {
        while (indice == lung) {//impossibile caricare: aspetto un get.
            wait();
        }
        if (biglietti>0) {
            buffer[indice++] = t;
        biglietti--;
        System.out.println("Caricato " + t.pin + " in posizione " + indice);
        notifyAll();//buffer nuovamente libero.
        }
    }

    synchronized public Partecipante get(Partecipante t) throws InterruptedException {
        while (indice == 0) {//impossibile estrarre: aspetto un set.
            wait();
        }
        for (int i = 0; i < lung; i++) {
            if (buffer[i]!=null && buffer[i].pin.equals(t.pin)) {
                Partecipante appoggio = buffer[i];
                indice--;
                for (int j = 0; j < lung-1; j++) {
                    if (buffer[j] == null) {
                        buffer[j] = buffer[j + 1];
                        buffer[j + 1] = null;
                    }
                }
                System.out.println("                                              Estratto " + appoggio.pin + " in posizione " + indice);
                notifyAll();
                return appoggio;
            }
        }
        return t;
    }
}
