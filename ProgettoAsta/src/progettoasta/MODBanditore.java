/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoasta;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.Observer;

/**
 * Classe Modello Banditore
 *
 * @author Farhan
 */
public class MODBanditore extends Observable implements Observer {

    /*Attributi*/
    /**
     * Dichiarazione di tutti gli attributi (private)
     */
    private FRMBanditore fb;
    private ArrayList<MODAstante> listAstnt;
    private CntDwnTimer time;
    private OPdatabase db;
    private ArticoloAsta art;

    /*Costruttore*/
    /**
     * Costruttore che crea il frame del banditore ed inizializza gli attributi
     */
    MODBanditore() {
        fb = new FRMBanditore(this);
        this.addObserver(fb);
        fb.setLocation(0, 0);

        listAstnt = new ArrayList<>();

        time = new CntDwnTimer();
        time.addObserver(fb);

        db = new OPdatabase();
        nxtArt();//viene caricato il primo articolo
    }

    /*Metodi*/
    /**
     * Metodo per aggiungere un nuovo astante
     *
     * @param ma (MODAstante)
     */
    void addAstante(MODAstante ma) {
        ma.addObserver(this);//per ossrvare gli astanti

        listAstnt.add(ma);//astante aggiunto alla lista 

        ma.addTimer(time);//passa la reference del timer

        refresh(listAstnt);//per far vedere la lista dei patecipanti

        updateAstanti();
    }

    /**
     * Metodo per iniziare il count down
     *
     * @param min
     * @param sec
     */
    void startCDT(int min, int sec) {
        time.startCountDown(min, sec);
    }

    /**
     * Metodo per fermare il count down
     */
    void stopCDT() {
        time.stopCountDown();
    }

    /**
     * Metodo per vedere lo stato del timer
     *
     * @return boolean
     */
    boolean isCntDwnFinished() {
        return time.isCntDwnFinished();
    }

    /**
     * Metodo per caricare il prossimo articolo
     */
    void nxtArt() {
        art = db.selectElement();
        refresh(art);
        updateAstanti();
    }

    /**
     * Metodo per informare agli astanti il nuovo articolo in atsa
     */
    void updateAstanti() {
        for (int i = 0; i < listAstnt.size(); i++) {
            listAstnt.get(i).setArticolo(art);
        }
    }

    /**
     * Metodo che salva il vincitore nel database
     */
    void confermaVincitore() {
        int id = art.getId();
        String name = listAstnt.get(0).getNome();
        double prezzo = listAstnt.get(0).getOfferta();
        db.updateElement(id, name, prezzo);
        listAstnt.get(0).preleva();
    }

    /**
     * Metodo per chiudere e riapire la connessione con il database: in modo da
     * salvare le modifiche
     *
     * @throws SQLException
     */
    void aggiornaAsta() throws SQLException {
        db.closeAllConection();
        db.getConnection();
        nxtArt();
    }

    /**
     * Metodo utilizzato per aggiornare le viste sul oggetto Timer
     */
    public void refresh(Object o) {
        this.setChanged();
        notifyObservers(o);
    }

    /**
     * Metodo update del Observer(il banditore e' osservatore degli astanti)
     *
     * @param o (Observable): MODAstante
     * @param arg (null)
     */
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof MODAstante && arg == null) {
            try {
                Collections.sort(listAstnt);
                refresh(listAstnt);
                informeFirst();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
        }
    }

    /**
     * Metodo per informare il primo astante a tutti gli altri astanti
     */
    private void informeFirst() {
        int lung = listAstnt.size();
        MODAstante first = listAstnt.get(0);
        for (int i = 0; i < lung; i++) {
            listAstnt.get(i).setFirstAstnt(first);
        }
    }

}
