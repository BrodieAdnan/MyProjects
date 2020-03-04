package foglioelettronico;

/**
 * *********************************************************
 * CELLA
 *
 * @author Gazi Adnan Latif
 * @version 2.
 * @brief Forma una matrice che definisce il foglio.
 * @brief Contiene il testo inserito e analizza le formule.
 * @since 08/08/2017 to 08/09/2017
 * ********************************************************
 */
public class Cella {

    private String indice;
    private String formula;
    private String valore;
    private Foglio f;
    private Valore contenuto;

    ///costruttore
    public Cella(String indice, Foglio f) {
        this.indice = indice;
        formula = "";
        valore = "";
        this.f = f;
    }

    /**
     * ************************************************
     * SETFORMULA
     *
     * @param formula: stringa.
     * @brief assegna all'istanza il parametro formula.
     * ************************************************
     */
    public void setFormula(String formula) {
        this.formula = formula;
    }

    /**
     * ***************************************
     * SETCONTENUTO
     *
     * @brief imposta il valore della formula.
     * ***************************************
     */
    public void setContenuto() {
        if (!scrittoCorretto()) {
            valore = formula;
        } else {
            analizzaFormula();
        }
    }

    /**
     * ***************************************************
     * SCRITTTOCORRETTO
     *
     * @brief distingue le formule dai numeri e dai testi.
     * @return boolean.
     * ***************************************************
     */
    private boolean scrittoCorretto() {
        return (formula.charAt(0) == '=' && formula.charAt(formula.length() - 1) == ';') ? true : false;
    }

    /**
     * ********************************************************************
     * ANALIZZAFORMULA
     *
     * @brief distingue il tipo di formula.
     * @brief utilizza gli oggetti dell'intefaccia per assegnare il valore.
     * ********************************************************************
     */
    private void analizzaFormula() {
        if (formula.substring(1, 3).equals("se")) {
            contenuto=new Se(formula, f);
            valore=contenuto.getValore();
        } else if (formula.substring(1, 4).equals("max")) {
            contenuto = new Max(formula, f);
            if (contenuto.generaValore(formula, f)) {
                valore = contenuto.getValore();
            } else {
                valore="%errore%";
            }
        } else if (formula.substring(1, 4).equals("min")) {
            contenuto = new Min(formula, f);
            if (contenuto.generaValore(formula, f)) {
                valore = contenuto.getValore();
            } else {
                valore="%errore%";
            }
        } else if (formula.substring(1, 6).equals("somma")) {
            contenuto = new Somma(formula, f);
            if (contenuto.generaValore(formula, f)) {
                valore = contenuto.getValore();
            } else {
                valore="%errore%";
            }
        }
    }

    /**
     * ***************************************************************
     * NUMERO
     *
     * @brief verifica che il valore della cella sia di tipo numerico.
     * @return numero: boolean.
     * ***************************************************************
     */
    public boolean numero() {
        boolean numero = false;
        try {
            Integer.parseInt(valore);
            numero = true;
        } catch (Exception e) {
        }
        return numero;
    }

    /**
     * ***************
     * GETVALORE
     *
     * @return valore.
     * ***************
     */
    public String getValore() {
        return valore;
    }

    /**
     * ****************
     * GETFORMULA
     *
     * @return formula.
     * ****************
     */
    public String getFormula() {
        return formula;
    }

    /**
     * ***************
     * GETINDICE
     *
     * @return indice.
     * ***************
     */
    public String getIndice() {
        return indice;
    }
}
