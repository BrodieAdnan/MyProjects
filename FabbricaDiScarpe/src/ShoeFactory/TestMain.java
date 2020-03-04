/**
 * Questo programma simula una fabbrica di scarpe
 *
 * @author Frahan Latif Gazi classe 4^IA
 * @version 1.1
 * @date 12-11-2016
 */
package ShoeFactory;

import java.util.Scanner;

/**
 * Questa e' la classe main nella quale vengono creati tutti i thread e viene
 * rischiesta all'utente il numero di paia
 *
 * @author Farhan
 */
public class TestMain {

    public static void main(String[] args) {

        Scanner t = new Scanner(System.in);//creazione oggetto scanner
        System.out.println("How many pairs of shoe do you want?");
        int pairs = t.nextInt();//numero di paia

        Buffer b = new Buffer();//creazione buffer per contenere le singole scarpe
        PairBuffer pb = new PairBuffer();//creazione buffer per contenere le coppie di scarpe

        ///creazione threads
        Production p = new Production(b, 1);//creazione produttore n.1

        Matching m = new Matching(b, pb);//crazione matcher

        Boxer box = new Boxer(p, m, pb, pairs);//creazione boxer

        //partenza dei thread(vengono mandati in runnig)
        p.start();
        m.start();
        box.start();
    }

}
