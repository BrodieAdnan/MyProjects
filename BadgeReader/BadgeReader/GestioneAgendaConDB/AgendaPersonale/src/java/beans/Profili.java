package beans;

import java.util.ArrayList;

public class Profili {

    private ArrayList<Utente> profili;

    public Profili() {
        profili = new ArrayList<>();
    }

    public Utente getUtente(String n) {
        for (int i = 0; i < profili.size(); i++) {
            if (profili.get(i).getNome().equals(n)) {
                return profili.get(i);
            }
        }
        return new Utente();
    }

    public void addUtente(Utente u) {
        profili.add(u);
    }
}
