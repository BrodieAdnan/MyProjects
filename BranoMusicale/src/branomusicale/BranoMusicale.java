package branomusicale;
/**
 * *********************************************************
 * BRANO MUSICALE
 *
 * Classe Pricipale.
 * 
 * @author Gazi Adnan Latif
 * @brief Gestisce l'input dell'utente e crea un brano.
 * @date 13/10/2017
 * ********************************************************
 */
import java.util.*;

public class BranoMusicale {

    static Scanner t = new Scanner(System.in);
    static Elemento e;
    static Brano brano;
    static int valore;
    static int durata;
    static int[] accordo;

    public static void main(String[] args) {
        messaggioAvideo();
        aquisimentoIniziale();
        player();
        termina();
    }

    public static void messaggioAvideo() {
        System.out.println("Premi 'n' per inserire una nota, 'a' per un accordo e 'p' per una pausa...");
        System.out.println("Per terminare scrivi 'termina'...");
        System.out.println("Scrivi 'riproduci' per riprodurre, 'add' per aggiungere, 'remove' per rimouvere...");
    }

    public static void aquisimentoIniziale() {
        brano = new Brano();
        int pos = 0;
        boolean finito = false;
        while (!finito) {
            System.out.print("Inserisci : ");
            String s = t.next();
            if (s.equals("n")) {
                System.out.print("Valore : ");
                valore = t.nextInt();
                System.out.print("Durata : ");
                durata = t.nextInt();
                e = new Nota(durata, valore);
                brano.add(pos++, e);
            } else if (s.equals("a")) {
                System.out.print("Quanto è lungo l'accordo? ");
                int lung = t.nextInt();
                accordo = new int[lung];
                for (int i = 0; i < lung; i++) {
                    System.out.print("elemento " + (i + 1) + " : ");
                    accordo[i] = t.nextInt();
                }
                System.out.print("Durata : ");
                durata = t.nextInt();
                e = new Accordo(durata, accordo);
                brano.add(pos++, e);
            } else if (s.equals("p")) {
                System.out.print("Durata : ");
                durata = t.nextInt();
                e = new Pausa(durata);
                brano.add(pos++, e);
            } else if (s.equals("termina")) {
                finito = true;
            }
        }
    }

    public static void player() {
        boolean confermato = false;
        while (!confermato) {
            System.out.println("Sto aspettando un azione...");
            String s = t.next();
            boolean finito = false;
            while (!finito) {
                if (s.equals("add")) {
                    System.out.print("Inserisci cosa vuoi inserire (n, p, a) : ");
                    String v = t.next();
                    if (v.equals("n")) {
                        System.out.print("Valore : ");
                        valore = t.nextInt();
                        System.out.print("Durata : ");
                        durata = t.nextInt();
                        System.out.print("Posizione : ");
                        int pos = t.nextInt();
                        e = new Nota(durata, valore);
                        brano.add(pos, e);
                    } else if (v.equals("a")) {
                        System.out.print("Quanto è lungo l'accordo? ");
                        int lung = t.nextInt();
                        accordo = new int[lung];
                        for (int i = 0; i < lung; i++) {
                            System.out.print("elemento " + (i + 1) + " : ");
                            accordo[i] = t.nextInt();
                        }
                        System.out.print("Durata : ");
                        durata = t.nextInt();
                        System.out.println("Posizione : ");
                        int pos = t.nextInt();
                        e = new Accordo(durata, accordo);
                        brano.add(pos, e);
                    } else if (v.equals("p")) {
                        System.out.print("Durata : ");
                        durata = t.nextInt();
                        System.out.print("Posizione : ");
                        int pos = t.nextInt();
                        e = new Pausa(durata);
                        brano.add(pos, e);
                    }
                    finito = true;
                } else if (s.equals("remove")) {
                    System.out.print("Posizione : ");
                    int pos = t.nextInt();
                    brano.remove(pos);
                    finito = true;
                } else if (s.equals("riproduci")) {
                    brano.riproduci();
                    finito = true;
                } else if (s.equals("termina")) {
                    finito = true;
                    confermato = true;
                }
            }
        }
    }

    public static void termina() {
        System.out.print("Sei sicuro di valore terminare ? ");
        String termina = t.next();
        if (termina.equals("si")) {
            brano = new Brano();
            System.out.println("Terminato...");
            System.out.println("");
            aquisimentoIniziale();
        } else {
            player();
        }
    }
}
