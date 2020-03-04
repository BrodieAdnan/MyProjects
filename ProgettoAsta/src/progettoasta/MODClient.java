/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoasta;


/**
 * Classe modello Client
 *
 * @author Farhan
 */
public class MODClient {

    /*Attributi*/
    private FRMClient c;
    private MODBanditore mb;
    private MODAstante ma;
    private int nAst;

    /**
     * Costruttore
     */
    MODClient() {
        c = new FRMClient(this);
        c.setLocation(900, 100);
        mb = new MODBanditore();
        nAst = 0;
    }

    /**
     * Metodo per creare un nuovo astante
     *
     * @param nome (String)
     * @param budget (double)
     */
    void creaAstante(String nome, double budget) {
        nAst++;
        ma = new MODAstante(nAst, nome, budget);
        mb.addAstante(ma);
    }

}
