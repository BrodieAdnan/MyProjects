/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoasta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Classe utilizzata per svolgere le operazioni con il database
 *
 * @author Farhan
 */
public class OPdatabase {

    /*Attributi*/
    /**
     * Dichiarazione attributi (privati)
     */
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private final String DBname = "MAGAZZINO.db";//nome DataBase
    private final String TABname = "ARTICOLI ";//nome tabella

    /*Costruttore*/
    /**
     * Costruttore utilizzato per inizializzare gli attributi ed ottenere la
     * prima connessione con il database
     */
    OPdatabase() {
        conn = null;
        stmt = null;
        rs = null;
        getConnection();
    }

    /*Metodi*/
    /**
     * Metodo per ottenere la connessione con il database
     */
    protected void getConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:" + DBname);
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM " + TABname + ";");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    /**
     * Metodo per inserire gli articoli nel database. N.B. il metodo non e'
     * stato utilizzato nel progarmma(pensato per un eventuale update)
     *
     * @param a ogetto ArticoloAsta
     */
    protected void insertElement(ArticoloAsta a) {
        try {
            /*L' oggetto ArticoloAsta viene suddiviso e messo in variabili*/
            int nElem = a.getId();
            String titolo = a.getName();
            double prezzo = a.getPrezzo();
            String percFoto = a.getFotoName();
            String proprietario = a.getOwner();
            String sql = "INSERT INTO " + TABname + "(ID,TITOLO,PREZZO,PROPRIETARIO,FOTO)"
                    + "VALUES (" + nElem + ", '" + titolo + "', " + prezzo + ", '" + proprietario + "', '" + percFoto + "');";
            stmt.executeUpdate(sql);
            conn.commit();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    /**
     * Metodo per visitare la tabella del database
     *
     * @return a oggetto ArticoloAsta
     */
    protected ArticoloAsta selectElement() {
        ArticoloAsta a = null;
        try {
            boolean go = rs.next();//prossimo elemento
            if (go) {
                int id = rs.getInt("id");
                String name = rs.getString("titolo");
                double prezzo = rs.getInt("prezzo");
                String foto = rs.getString("foto");
                String proprietario = rs.getString("proprietario");
                a = new ArticoloAsta(id, name, prezzo, foto, proprietario);
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return a;
    }

    /**
     * Metodo per aggiornare la tabella mettendo il nuovo proprietario e valore
     * di un determinato oggetto
     *
     * @param id numero di identificazione del oggetto
     * @param name nome del nuovo proprietario
     * @param prezzo nuovo prezzo del oggetto
     */
    protected void updateElement(int id, String name, double prezzo) {
        try {
            String sql = "UPDATE " + TABname + "set PROPRIETARIO = '" + name + "' where ID=" + id + ";";
            stmt.executeUpdate(sql);
            conn.commit();
            sql = "UPDATE " + TABname + "set PREZZO = " + prezzo + " where ID=" + id + ";";
            stmt.executeUpdate(sql);
            conn.commit();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    /**
     * Metodo per chiudere tutte le connessioni con il database
     *
     * @throws SQLException
     */
    protected void closeAllConection() throws SQLException {
        try {
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
