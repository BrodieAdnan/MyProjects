package vocabolario;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Dizionario {

    ArrayLogico[] contenuto;
    Scanner t;

    public Dizionario() throws Exception {
        contenuto = new ArrayLogico[16];
        for (int i = 0; i < 16; i++) {
            contenuto[i] = new ArrayLogico();
        }
    }

    public void INIT(String file) throws Exception {
        try {
            t = new Scanner(new FileReader(file));
        } catch (Exception e) {
            throw new FileNotFoundException("File non trovato");
        }
        while (t.hasNext()) {
            String p = t.nextLine();
            String d = t.nextLine();
            Parola a = new Parola(p, d);
            contenuto[p.length() - 1].add(a);
        }
    }

    public String getDefinizione(String parolaCercata) throws Exception {
        int lung = parolaCercata.length();
        ArrayLogico a = contenuto[lung];
        for (int i = 0; i < a.length; i++) {
            Parola temp = a[i];
            if (temp.getValore().equals(parolaCercata)) {
                return temp.getDef();
            }
        }
        throw new Exception("Parola non trovata nel dizionario!");
    }
}
