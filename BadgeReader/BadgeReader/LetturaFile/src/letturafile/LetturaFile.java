package letturafile;

import static SQLHelper.DBOP.insertAccesso;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LetturaFile {

    public static void main(String[] args) throws IOException, InterruptedException {
        FileReader f;
        f = new FileReader("F:\\Scuola\\4IB\\Sistemi&Reti\\BadgeReader\\Accessi.txt");

        BufferedReader b;
        b = new BufferedReader(f);

        String s;
        int id = 0;

        ArrayList<Integer> idPersona = new ArrayList<>();
        ArrayList<String> data = new ArrayList<>();

        while (true) {
            s = b.readLine();
            if (s == null) {
                break;
            }
            if (id % 2 == 0) {
                idPersona.add(Integer.parseInt(s));
            } else {
                data.add(s);
            }
            id++;
        }

        prova(idPersona, data);
    }

    public static void prova(ArrayList<Integer> idPersona, ArrayList<String> data) {
        insertAccesso(idPersona.get(idPersona.size() - 1), data.get(idPersona.size() - 1));
    }
}
