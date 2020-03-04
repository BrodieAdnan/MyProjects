package bevitoridivino;

public class BevitoriDiVino {

    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        for (int i = 0; i < 20; i++) {
            new Bevitore(buffer, "Bevitore n." + i).start();
        }
    }
}
