/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoasta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.Timer;

/**
 * Classe che definisce l' oggetto Timer Utilizzato dal Banditore e gli Astanti
 *
 * @author Farhan
 */
public class CntDwnTimer extends Observable {

    /*Attributi*/
    /**
     * Dichiarazione attributi (privati)
     */
    private Timer timer;
    private int[] time;
    private final int MIN;
    private final int SEC;

    /*Costruttore*/
    /**
     * Costruttore utilizzato per inizializzare gli attributi
     */
    CntDwnTimer() {
        time = new int[2];//array contenete i minuti e i secondi
        MIN = 0;//posizione minutu nel array
        SEC = 1;//posizione secondi nel array
    }

    /*Metodi*/
    /**
     * Metodo utilizzato per inizire il countdown da un determinato tempo
     *
     * @param min minuti
     * @param sec secondi
     */
    public void startCountDown(int min, int sec) {
        this.time[MIN] = min;//min viene messo dentro l'array 
        this.time[SEC] = sec;//sec viene messo dentro l'array
        timer = new Timer(1000, (ActionListener) new TimerListener());//viene creato un oggetto Timer
        timer.setRepeats(true);
        timer.start();//partenza Timer
        refresh();//vengono aggiornate le viste sul Timer
    }

    /**
     * Metodo che ferma il Timer
     */
    public void stopCountDown() {
        /*MIN e SEC vanno a 0*/
        time[MIN] = 0;
        time[SEC] = 0;
        refresh();//vengono aggiornate le viste
        timer.stop();//stop Timer
    }

    /**
     * Metodo per indicare lo stato del Timer (attivo/finito)
     *
     * @return boolean true/false
     */
    public boolean isCntDwnFinished() {
        return time[SEC] == 0 && time[MIN] == 0;
    }

    /**
     * Classe TimerListener implementa il ActionListener del Timer : ad ogni
     * secondo si verifica un evento, il quale viene catturato dalla clasee
     * TimerListener che cambia lo stato dell'array contenente i minuto e i
     * secondi.
     */
    private class TimerListener implements ActionListener {

        /**
         * Metodo actionPerformed che cattura l'evento e
         *
         * @param e ActionEvent
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (time[MIN] == 0 && (time[SEC] == 1 || time[SEC] == 0)) {//fine countdown
                time[SEC] = 0;
                refresh();//vengono aggiornate le viste
                timer.stop();//viene fermato il Timer
            } else if (time[SEC] > 0) {//se i secondi sono maggiori di 0
                time[SEC] -= 1;//decremento
            } else if (time[SEC] == 0) {//se i socondi sono 0 allora decremento i minuti
                time[SEC] = 59;
                time[MIN] -= 1;//decremento
            }
            refresh();//vengono aggiornate le viste
        }
    }

    /**
     * Metodo utilizzato per aggiornare le viste sul oggetto Timer
     */
    public void refresh() {
        this.setChanged();
        notifyObservers(time);//viene passato gli osservatori l'array contenente i MIN e i SEC
    }
}
