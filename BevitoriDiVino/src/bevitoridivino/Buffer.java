package bevitoridivino;

public class Buffer {

    private int vino;
    private Bevitore[] buffer;
    private int indice;
    private int lung;

    public Buffer() {
        lung = 3;
        buffer = new Bevitore[lung];
        vino = 100;
        indice = 0;
    }

    synchronized public void set(Bevitore n) throws InterruptedException {
        while (indice == lung) {//già presenti 3 bevitori.
            wait();
        }
        if (vino > 0) {
            buffer[indice++] = n;
            vino--;
            System.out.println("Caricato " + n.pin + " nella posizione " + (indice - 1));
            notifyAll();
        }
    }

    synchronized public Bevitore get(Bevitore n) throws InterruptedException {
        while (indice == 0) {//impossibile eseguire l'estrazione: nessun bevitore da togliere.
            wait();
        }
        for (int i = 0; i < lung; i++) {
            if (buffer[i]!=null && buffer[i].pin.equals(n.pin)) {
                Bevitore appoggio = buffer[i];
                System.out.println("                                          Estratto " + n.pin + " nella posizione " + indice);
                indice--;
                for (int j = 0; j < lung-1; j++) {
                    if (buffer[j] == null) {
                        buffer[j] = buffer[j + 1];
                        buffer[j + 1] = null;
                    }
                }
                notifyAll();
                return appoggio;
            }
        }
        return n;
    }
}
