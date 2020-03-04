package oroogioanalogico;

/**
 *******************************************
 * CIFRAFINALE
 *
 * @author Adnan Gazi Latif
 * @brief Tipo usato dalle decine della ore.
 * @date 11/04/2017
 *******************************************
 */
class CifraFinale {

    private Incrementatore incremento;

    CifraFinale(int limite) {
        incremento = new Incrementatore(limite);
    }

    void incrementa() { //richiamo incremento di Incrementatore.
        incremento.incrementa();
    }

    int getValore() { //restituisce il valore da Incrementatore.
        return incremento.getValore();
    }
}
