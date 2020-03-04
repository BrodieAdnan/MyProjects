package foglioelettronico;

import static zuclib.GraficaSemplice.*;
/**
 * **************************************************************
 * CELLA GRAFICA
 *
 * @author Gazi Adnan Latif
 * @version 2.
 * @brief Gestisce le coordinate per ogni cella.
 * @brief Scrive il valore della cella nella posizione indicata.
 * @since 08/08/2017 to 08/09/2017
 * *************************************************************
 */
public class CellaGrafica {

    private float vertsxX;
    private float vertsxY;
    private float vertdxX;
    private float vertdxY;

    ///costruttore
    public CellaGrafica(float sxX, float sxY, float dxX, float dxY) {
        vertsxX = sxX;
        vertsxY = sxY;
        vertdxX = dxX;
        vertdxY = dxY;
    }

    /**
     * ****************************************************************************
     * SCRIVITESTO
     * 
     * @brief rappresemta un testo in formato stringa sulla grifica del programmaa.
     * @param testo: valore in formato stringa.
     * ****************************************************************************
    */
    public void scriviTesto(String testo) {
        testo((double) (vertdxX - vertsxX) / 2 + vertsxX, (double) (vertdxY - vertsxY) / 2 + vertsxY, testo, 0, NERO);
    }
}
