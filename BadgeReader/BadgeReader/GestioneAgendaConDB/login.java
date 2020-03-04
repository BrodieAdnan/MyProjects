package beans;

import static OPdatabase.SQLhelper.getAccount;
import static OPdatabase.SQLhelper.isUserRegistered;

public class login {

    protected String username, password;

    public login() {
        username = password = "";
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

    public boolean tryToLogUser() {
        return isUserRegistered(username, password);
    }

    public Account getUserAccount() {
        return getAccount(this.username, this.password);
    }
}
