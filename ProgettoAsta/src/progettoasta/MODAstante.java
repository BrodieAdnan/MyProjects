/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoasta;

import java.util.Observable;

/**
 * Classe modello Astante: contiene tutti gli attributi e metodi necessari all'
 * astante
 *
 * @author Farhan
 */
public class MODAstante extends Observable implements Comparable<MODAstante> {

    /*Attributi*/
    /**
     * Dichiarazione attributi (privati)
     */
    private FRMAstante fa;
    private CntDwnTimer time;
    private final int id;
    private final String nome;
    private double budget, offerta;

    /*Costruttore*/
    /**
     * Costruttore utilizzato per inizializzare gli attributi e creare la vista
     * sul modello (frame FRMAstante)
     */
    MODAstante(int id, String nome, double budget) {
        fa = new FRMAstante(this);//Frame astante
        this.addObserver(fa);//fa viene aggiunto agli osservatori
        fa.setLocation(50, 300);

        this.id = id;

        this.nome = nome;
        refresh(this.nome);//manda il nome alla vista

        this.budget = budget;//manda il budget alla vista 
        refresh(this.budget);

        offerta = 0;
    }

    /*Metodi*/
    /**
     * Metodo che retituisce il numero di identificazione del astante
     */
    int getId() {
        return id;
    }

    /**
     * Metodo che retituisce l'offerta corrente del astante
     */
    double getOfferta() {
        return offerta;
    }

    /**
     * Metodo che retituisce il nnome del astante
     */
    String getNome() {
        return nome;
    }

    /**
     * Metodo che imposta l'offerta del astante e lo segnala al Banditore
     */
    void setOfferta(double offerta) {
        this.offerta = offerta;
        refresh(null);///SOLO ED UNICA ECCEZIONE PER IL BANDITORE
    }

    /**
     * Metodo che restituisce il budget del astante
     *
     * @return budget (double)
     */
    double getBudget() {
        return budget;
    }

    /**
     * Metodo che imposta il timer al astante
     *
     * @param timer
     */
    void addTimer(CntDwnTimer timer) {
        this.time = timer;
        time.addObserver(fa);//il frame del astante viene aggiunto agli osservatori del Timer
    }

    /**
     * Metodo che indica lo stato del Timer(attivo/terminato)
     *
     * @return boolean
     */
    boolean isCntDwnFinished() {
        return time.isCntDwnFinished();
    }

    /**
     * Metodo che indica l'astate con la maggiore offerta
     *
     * @param first (MODAstante)
     */
    void setFirstAstnt(MODAstante first) {
        MODAstante temp = first;
        refresh(temp);
    }

    /**
     * Metodo che indica l'articolo corrente in asta
     *
     * @param art
     */
    void setArticolo(ArticoloAsta art) {
        ArticoloAsta temp = art;
        refresh(temp);
    }

    /**
     * Metodo che simula il prelevamento dei soldi dal badget
     */
    void preleva() {
        this.budget -= this.offerta;
        refresh(this.budget);

        this.offerta = 0;
    }

    /**
     * Metodo utilizzato per aggiornare le viste sull Astante
     */
    private void refresh(Object o) { //aggiorna le viste
        this.setChanged();
        notifyObservers(o);
    }

    /**
     * Metodo toString restituisce tutti gli atributi con il loro nome in una
     * stringa
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Nome = " + nome + ", offerta = " + offerta + " €";
    }

    /**
     * Metodo compearTo utilizzato per ordinare gli astanti secondo la loro
     * offerta
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(MODAstante o) {
        double thisOff = this.getOfferta();
        double otherOff = o.getOfferta();
        return thisOff > otherOff ? -1 : (thisOff < otherOff ? 1 : 0);
    }

}
