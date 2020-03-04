/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoasta;

/**
 * Classe utilizzata per definire gli articoli venduti all' asta
 *
 * @author Farhan
 */
public class ArticoloAsta {

    /*Arttibuti*/
    /**
     * Dichiarazione attributi (privati)
     */
    private int id;
    private String name, foto, proprietario;
    private double prezzo;

    /*Costruttore*/
    /**
     * Costruttore utilizzato per inizializzare gli attributi
     *
     * @param id numero di identificazione dell' atricolo
     * @param name nome del articolo
     * @param prezzo prezzo del articolo
     * @param foto nome e formato del immagine (es. esempio.jgp)
     * @param proprietario nome del proprietrio del articolo
     */
    ArticoloAsta(int id, String name, double prezzo, String foto, String proprietario) {
        this.id = id;
        this.name = name;
        this.prezzo = prezzo;
        this.foto = foto;
        this.proprietario = proprietario;
    }

    /*Metodi*/
    /**
     * Metodo che restituisce il numero di indentificazione del articolo
     *
     * @return id
     */
    protected int getId() {
        return id;
    }

    /**
     * Metodo che restituisce il nome del articolo
     *
     * @return name
     */
    protected String getName() {
        return name;
    }

    /**
     * Metodo che restituisce il prezzo del articolo
     *
     * @return prezzo
     */
    protected double getPrezzo() {
        return prezzo;
    }

    /**
     * Metodo che restituisce il nome della foto del articolo
     *
     * @return foto
     */
    protected String getFotoName() {
        return foto;
    }

    /**
     * Metodo che restituisce il nome del proprietario del articolo
     *
     * @return proprietario
     */
    protected String getOwner() {
        return proprietario;
    }

    /**
     * Metodo toString restituisce tutti gli atributi con il loro nome in una
     * stringa
     *
     * @return String
     */
    @Override
    public String toString() {
        return "ArticoloAsta{" + "id=" + id + ", name=" + name + ", foto=" + foto
                + ", proprietario=" + proprietario + ", prezzo=" + prezzo + '}';
    }
}
