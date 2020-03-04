package quadrati_cerchi;

import java.awt.Color;
import java.util.*;
import static zuclib.GraficaSemplice.*;
import static zuclib.Varie.ritardo;

/**
 * @author adnan.gazi
 */
public class Quadrati_cerchi {

    public static void main(String[] args) {
        setFinestra(900, 900, "salve");
        Scanner input = new Scanner(System.in);
        double lato = 0.99;
        System.out.println("inserisci il numero : ");
        int n = 1; //2 * input.nextInt();
        double x = 0.5;
        double y = 0.5;
        for (;;) {
            Color color = coloreACaso();
            n = 1;
            quadratoPieno(0.5, 0.5, 5, color);
            for (; n < 8; n++) {
                quadratoPieno(0.5, 0.5, 5, color);
                ricorsione1(lato, n, x, y);
                ritardo(300);
            }
            ritardo(300);
        }
    }

    public static void ricorsione1(double lato, int n, double x, double y) {
        if (n >= 0) {
            Color color = coloreACaso();
            quadratoPieno(x, y, lato, color);
            quadrato(x, y, lato);
            ricorsione2(lato / 4, n - 1, x - lato / 4, y + lato / 4);
            ricorsione2(lato / 4, n - 1, x + lato / 4, y + lato / 4);
            ricorsione2(lato / 4, n - 1, x + lato / 4, y - lato / 4);
            ricorsione2(lato / 4, n - 1, x - lato / 4, y - lato / 4);
        }
    }

    public static void ricorsione2(double lato, int n, double x, double y) {
        if (n >= 0) {
            Color color = coloreACaso();
            cerchioPieno(x, y, lato, color);
            cerchio(x, y, lato);
            ricorsione1((lato * 7) / 5, n - 1, x, y);
        }
    }
}
