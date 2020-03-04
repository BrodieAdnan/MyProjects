package vocabolario;

/**
 * @author Riccardo Fusaro & Adnan Gazi Latif
 * @date 28/03/2017
 * @brief Contenitore del valore della parola e della sua definizione.
 */
public class Parola {

    private String valore;
    private String definizione;

    Parola(String valore, String definizione) {
        this.valore = valore;
        this.definizione = definizione;
    }

    public String getValore() {
        return valore;
    }

    public String getDef() {
        return definizione;
    }
}
