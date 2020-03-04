package beans;

import static OPdatabase.SQLhelper.isUsernameFree;
import static OPdatabase.SQLhelper.registerAccount;

public class registration {

    protected String nome, cognome, username, password;

    public registration() {
        nome = cognome = username = password = "";
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

    public boolean isUsernameValid() {
        return isUsernameFree(username);
    }

    public void registerUser() {
        registerAccount(username, password, nome, cognome);
    }
}
