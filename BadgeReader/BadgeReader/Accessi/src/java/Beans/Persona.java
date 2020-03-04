/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Adnan
 */
public class Persona {

    String username;
    int idPersona;

    public Persona() {
    }

    public Persona(String username, int idPersona) {
        this.username = username;
        this.idPersona = idPersona;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public String toString() {
        return "Persona{" + "username=" + username + ", idPersona=" + idPersona + '}';
    }

}
