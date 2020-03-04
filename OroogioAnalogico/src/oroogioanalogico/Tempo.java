package oroogioanalogico;

import static zuclib.GraficaSemplice.*;
import static zuclib.Varie.*;

/**
 ***************************************************
 * TEMPO
 *
 * classe principale
 *
 * @author Adnan Gazi Latif
 * @brief Realizzatore di un orologio con i secondi.
 * @date 11/04/2017 **************************************************
 */
class Tempo {

    public static void main(String[] args) {
        Orologio orologio = new Orologio(); //nasce l'oggetto orologio.
        setFinestra(1024, 576, "Tempo");
        for (;;) {
            ritardo(885);
            orologio.incrementa(); //avvia l'incremento a ritardo di 1 secondo.
            orologio.visualizza();
            orologio = azzeramento(orologio);
        }
    }

    public static Orologio azzeramento(Orologio orologio) { //azzera arrivato a 24h.
        if (orologio.azzeramento()) {
            orologio = new Orologio(); //nasce un nuovo oggetto azzerato.
            return orologio; //return nuovo oggetto per sostituzione con quello vecchio.
        } else {
            return orologio;
        }
    }
}
