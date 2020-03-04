package derive;

import java.util.*;
import static zuclib.GraficaSemplice.*;
import static zuclib.Varie.*;

/**
 * ********************************************
 * DERIVE
 *
 * classe principale.
 *
 * @author Gazi adnan Latif
 * @brief illustra il grafico di una equazione.
 * @date 02/05/2017 *******************************************
 */
public class Derive {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        setFinestra(600, 600, "Derive");
        Grafico g = new Grafico();
        g.imposta();
        for (double x = 0; x < 1; x += 0.001) {
            punto((x / 10.0) + 0.5, (x / 10.0) + 0.5);
        }
    }

    public static double aquisisciEquazione(int x) {
        double X = x * x / 2 - 3 * x;
        System.out.println(X);
        return X;
    }
}
