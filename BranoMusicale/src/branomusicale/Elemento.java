package branomusicale;
/**
 * *********************************************************
 * ELEMENTO
 *
 * @author Gazi Adnan Latif
 * @brief Classe astretta estesa.
 * @date 13/10/2017
 * ********************************************************
 */
public abstract class Elemento {

    static final String[] note = new String[]{"DO", "DO#", "RE", "RE#", "MI", "FA", "FA#", "SOLb", "LA", "LA#", "SIb", "SI"};
    int durata=12;

    public abstract String suona();
}
