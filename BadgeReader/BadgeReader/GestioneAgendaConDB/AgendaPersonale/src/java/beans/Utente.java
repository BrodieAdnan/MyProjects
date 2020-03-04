package beans;
import java.util.ArrayList;

public class Utente {

    private String username;
    private String password;
    private String nome;
    private String cognome;
    private ArrayList<Date> accessi;

    public Utente() {
        this.cognome = "";
        this.nome = "";
        this.password = "";
        this.username = "";
        this.accessi = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public ArrayList<Date> getListaAccessi() {
        return accessi;
    }

    public void addNewAccesso(String min, String h, String d, String m, String y) {
        Date newDate=new Date(y, m, d, h, min);
        accessi.add(newDate);
    }
}
