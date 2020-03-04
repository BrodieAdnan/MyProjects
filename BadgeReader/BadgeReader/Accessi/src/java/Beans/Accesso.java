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
public class Accesso {

    String data;
    int idAcceso;
    int idPersona;

    public Accesso() {
    }

    public Accesso(String data, int idAcceso, int idPersona) {
        this.data = data;
        this.idAcceso = idAcceso;
        this.idPersona = idPersona;
    }



    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdAcceso() {
        return idAcceso;
    }

    public void setIdAcceso(int idAcceso) {
        this.idAcceso = idAcceso;
    }

    @Override
    public String toString() {
        return "Accesso{" + "data=" + data + ", idAcceso=" + idAcceso + ", idPersona=" + idPersona + '}';
    }
    


}
