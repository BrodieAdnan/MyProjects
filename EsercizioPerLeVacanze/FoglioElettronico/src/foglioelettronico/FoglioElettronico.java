package foglioelettronico;

import static zuclib.GraficaSemplice.*;
/**
 * **************************************************************
 * FOGLIO ELETTRONICO
 *
 * Classe Principale
 *
 * @author Gazi Adnan Latif
 * @version 2.
 * @brief Classe principale dell'applicazione Execel.
 * @brief crea un foglio Excel e intercetta ogni click del mouse.
 * @since 08/08/2017 to 08/09/2017
 * **************************************************************
 */
public class FoglioElettronico {

    public static void main(String[] args) {
        Foglio foglio = new Foglio(new Coppia(26, 13));
        while (true) {
            while (!mousePremuto());
            foglio.gestoreEventi();
            foglio.visuaizza();
        }
    }
}
