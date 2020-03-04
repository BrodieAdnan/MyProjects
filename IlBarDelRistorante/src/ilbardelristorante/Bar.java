package ilbardelristorante;

//BUFFER MONITOR
public class Bar {

    private boolean priOsp;
    private boolean priLoc;
    private int presenza;
    private int indice;
    private Tifoso[] buffer;
    private int NMAX;
    private boolean state;

    public Bar(int NMAX) {
        this.NMAX = NMAX;
        priOsp = false;
        priLoc = false;
        presenza = 0;
        indice = 0;
        buffer = new Tifoso[this.NMAX];
        state = true;
    }

    synchronized public void set(Tifoso t) throws InterruptedException {
        while (indice == NMAX) {
            wait();
        }
        if (state && priorità(t)) {
            buffer[indice++] = t;
            System.out.println(indice);
        } else if (t.pin.equals("Ospite")) {
            priOsp = true;
        } else {
            priLoc = true;
        }
        notifyAll();
    }

    synchronized public Tifoso get(int pos) throws InterruptedException {
        while (indice == 0) {
            wait();
        }
        notifyAll();
        indice--;
        for (int j = pos; j < NMAX - 1; j++) {
            if (buffer[j] == null) {
                buffer[j] = buffer[j + 1];
                buffer[j + 1] = null;
            }
        }
        return buffer[pos];
    }

    public boolean state() {//false=vuoto, true=non vuoto.
        return (indice < NMAX) ? false : true;
    }

    public void open(boolean toDo) {//cambia lo stato di apertura o chiusura.
        state = toDo;
    }

    private boolean priorità(Tifoso t) {
        if ((indice >= NMAX - 1) && (((!searchFor("Ospite") && t.pin.equals("Ospite")) || (!searchFor("Locale") && t.pin.equals("Locale"))) || (t.pin.equals("Ospite")) || (!priOsp))) {//ultimo posto libero nel bar: controllo per vedere se ci sono sia ospiti che locali.
            return true;
        }
        return false;
    }

    private boolean searchFor(String tifoso) {
        for (int i = 0; i < indice; i++) {
            if (buffer[i].pin.equals(tifoso)) {
                return true;
            }
        }
        return false;
    }
}
