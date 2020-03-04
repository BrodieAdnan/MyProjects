package foglioelettronico;

/**
 * ********************************************************************
 * FORMULA DELLA CONDIZIONE SE
 *
 * @author Gazi Adnan Latif
 * @version 2.
 * @brief Implementa l'interfaccia 'Valore'.
 * @brief Calcola il valore condizionale in base alla formula inserita.
 * @since 08/08/2017 to 08/09/2017
 * ********************************************************************
 */
public class Se implements Valore{

    private Cella valoreVero;
    private Cella valoreFalso;
    private Cella primoOperando;
    private Cella secondoOperando;
    private String operatore;

    ///costruttore
    public Se(String formula, Foglio foglio) {
        operatore = formula.substring(6, formula.length() - 10);
        primoOperando = foglio.getCella(formula.substring(4, 6));
        secondoOperando = foglio.getCella(formula.substring(formula.length()-10, formula.length()-8));
        valoreVero = foglio.getCella(formula.substring(formula.length()-7, formula.length()-5));
        valoreFalso = foglio.getCella(formula.substring(formula.length()-4, formula.length()-2));
    }

    /**
     * ************************************************************
     * GETVALORE
     *
     * @brief calcola il valore condizionale tra le celle indicate.
     * @return se: stringa contenente il valore vero o falso.
     * ************************************************************
     */
    @Override
    public String getValore() {
        String se = "";
        if (primoOperando.numero() && secondoOperando.numero() && valoreVero.numero() && valoreFalso.numero()) {
            int segno = 6;
            String[] operatori = new String[]{"<", "=", ">", ">=", "<=", "<>"};
            for (int i = 0; i < 6; i++) {
                if (operatori[i].equals(operatore)) {
                    segno = i;
                }
            }
            System.out.println(segno);
            switch (segno) {
                case 0:
                    se = (Integer.parseInt(primoOperando.getValore()) < Integer.parseInt(secondoOperando.getValore())) ? valoreVero.getValore() : valoreFalso.getValore();
                    break;
                case 1:
                    se = (Integer.parseInt(primoOperando.getValore()) == Integer.parseInt(secondoOperando.getValore())) ? valoreVero.getValore() : valoreFalso.getValore();
                    break;
                case 2:
                    se = (Integer.parseInt(primoOperando.getValore()) > Integer.parseInt(secondoOperando.getValore())) ? valoreVero.getValore() : valoreFalso.getValore();
                    break;
                case 3:
                    se = (Integer.parseInt(primoOperando.getValore()) >= Integer.parseInt(secondoOperando.getValore())) ? valoreVero.getValore() : valoreFalso.getValore();
                    break;
                case 4:
                    se = (Integer.parseInt(primoOperando.getValore()) >= Integer.parseInt(secondoOperando.getValore())) ? valoreVero.getValore() : valoreFalso.getValore();
                    break;
                case 5:
                    se = (Integer.parseInt(primoOperando.getValore()) != Integer.parseInt(secondoOperando.getValore())) ? valoreVero.getValore() : valoreFalso.getValore();
                    break;
            }
        } else {
            se = "%errore%";
        }
        return se;
    }

    /**
     * ********************************************
     * GENERAVALORE
     *
     * @param testo: stringa contenente la formula.
     * @param foglio: Foglio.
     * @brief metodo non usato.
     * @return boolean.
     * ********************************************
     */
    @Override
    public boolean generaValore(String testo, Foglio foglio) {
        return true;
    }
}
