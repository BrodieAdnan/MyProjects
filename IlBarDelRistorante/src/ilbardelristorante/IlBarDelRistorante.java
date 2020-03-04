package ilbardelristorante;

public class IlBarDelRistorante {

    public static void main(String[] args) throws InterruptedException {
        Bar bar = new Bar(10);
        GeneratoreTifosi gen = new GeneratoreTifosi(bar);
        Barista barista = new Barista(bar);
        gen.start();
        barista.start();
        gen.join();
        barista.join();
        System.out.println("Termine thread main");
    }
}
