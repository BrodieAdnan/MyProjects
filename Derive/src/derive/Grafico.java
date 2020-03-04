package derive;

import static zuclib.GraficaSemplice.*;

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
public class Grafico {

    private double x;
    private int primoRis;
    private double puntoPrec;

    public Grafico() {
        x = 0;
        primoRis = 0;
        puntoPrec = 0;
    }

    void disegna(double ris) {
        linea(x - 0.00001, puntoPrec, x, ris/100000, ROSSO, 0.001);
        punto(x, ris/100000);
        x += 0.00001;
        puntoPrec = ris/100000;
    }

    public void imposta() {
        double x = 0;
        double y = 0;
        quadratoPieno(0.5, 0.5, 10, BIANCO);
        linea(0, 0.5, 1, 0.5, NERO, 0.005);
        linea(0.5, 1, 0.5, 0, NERO, 0.005);
        for (int i = 0; i < 20; i++) {
            linea(x, y, 1, y, NERO, 0.0005);
            y += 0.05;
        }
        y = 0;
        for (int i = 0; i < 20; i++) {
            linea(x, y, x, 1, NERO, 0.001);
            x += 0.05;
        }
    }
}
