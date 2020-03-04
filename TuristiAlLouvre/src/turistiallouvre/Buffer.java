package turistiallouvre;

public class Buffer {

    private int indice;
    private int lung;
    private Turisti[] buffer;

    public Buffer() {
        indice = 0;
        lung = 5;
        buffer = new Turisti[lung];
    }

    synchronized public void set(Turisti t) throws InterruptedException {
        while (indice == lung) {//impossibile caricare: aspetto un get.
            wait();
        }
        buffer[indice++] = t;
        System.out.println("Caricato " + t.pin + " in posizione " + indice);
        notifyAll();//buffer nuovamente libero.
    }

    synchronized public Turisti get(Turisti t) throws InterruptedException {
        while (indice == 0) {//impossibile estrarre: aspetto un set.
            wait();
        }
        for (int i = 0; i < lung; i++) {
            if (buffer[i]!=null && buffer[i].pin.equals(t.pin)) {
                Turisti appoggio = buffer[i];
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
