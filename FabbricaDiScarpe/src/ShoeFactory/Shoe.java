package ShoeFactory;

/**
 * Quseta calsse serve per definire l' oggetto Shoe (scarpa)
 *
 * @author Farhan
 */
public class Shoe {

    //attributi privati per definire il colore e il piede (Stringhe)
    private String foot, color;

    /**
     * costruttore nella quale vengono indicati il colore e il piede dal
     * produttore
     *
     * @param color
     * @param foot
     */
    public Shoe(String color, String foot) {
        this.color = color;
        this.foot = foot;
    }

    /**
     * metodo per ottenere il colore della scrapa
     *
     * @return Strng shoe color
     */
    public String getColor() {
        return color;
    }

    /**
     * metodo per ottenere il piede della scarpa(destro o sinistro)
     *
     * @return String foot type
     */
    public String getFootType() {
        return foot;
    }

    /**
     * metodo toStirng che per ottenere la "rappresentazione testuale" dell'
     * oggeto
     *
     * @return String shoe
     */
    @Override
    public String toString() {
        return "Shoe {color: " + color + ", foot type: " + foot + "}";
    }

}
