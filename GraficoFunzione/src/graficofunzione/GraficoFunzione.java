package graficofunzione;

import static java.lang.Double.POSITIVE_INFINITY;
import java.util.Scanner;
import static zuclib.GraficaSemplice.*;
import zuclib.Tartaruga;

/**
 * @author gazi.farhan
 */
public class GraficoFunzione {

    public static double XMIN, XMAX;

    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        System.out.print("Definisci il valore minimo dell' ascissa : ");
        XMIN = t.nextDouble();
        System.out.print("Definisci il valore massimo dell' ascissa : ");
        XMAX = t.nextDouble();
        pianoCartesiano();
    }

    public static double funSin(double x) {
        double y = POSITIVE_INFINITY;
        y = Math.tan(x)*0.3;
        System.out.println(y);
        return y;
    }

    public static void pianoCartesiano() {
        Tartaruga tar = new Tartaruga();
        setFinestra(720, 720, "Grafico funzione");
        testoSinistra(0.2, 0.02, "Indica con un click il centro del grafico.");
        while (mousePremuto());
        while (!mousePremuto());
        double centroX = mouseX();
        double centroY = mouseY();
        pulisci();
        linea(centroX, -1, centroX, 1);
        linea(-1, centroY, 1, centroY);
        for (double x = XMIN; x < XMAX; x += 0.001) {
            punto((x / 10.0) + centroX, (funSin(x) / 10.0) + centroY);
        }
    }

}
