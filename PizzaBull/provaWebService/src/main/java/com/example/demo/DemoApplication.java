package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.ResultSet;
import java.sql.SQLException;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        //SpringApplication.run(DemoApplication.class, args); //=> Avvia il web service

        DbConnection db= new DbConnection("test1");//Creo la connessione verso il database "test"

        try
        {
            ResultSet result= db.executeQuery("select * from tabella1");//Eseguo la query

            while(result.next())//Fin tanto che result contiene risultati, eseguo il codice all'interno del ciclo
            {
                System.out.println(result.getString("nome")+" "+result.getString("cognome"));//result.getString prende i valori sottoforma di stringa dei campi a e b
            }
        }
        catch (Exception e){e.printStackTrace();}
        db.closeConnection();
    }
}
