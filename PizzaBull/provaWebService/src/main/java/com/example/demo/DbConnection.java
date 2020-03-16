package com.example.demo;

import java.sql.*;

/*
* @brief Classe per la gestione delle connessioni al database
*/
public class DbConnection {
    private Connection connection;
    private Statement statement;

    /*
    * @brief Costruttore per connettersi a un determinato database
    * @param dbName => String, nome del database al quale connettersi
    */
    public DbConnection(String dbName)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName, "root", "");//connessione al db test

            statement= connection.createStatement();//oggetto per eseguire le query
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /*
    * @brief Costruttore per connettersi al dbms, senza selezionare un particolare database
    */
    public DbConnection()
    {
        this("");
    }

    /*
    * @brief Metodo per eseguire una query per richiedere dati al database. Funziona solo con comandi SELECT
    * @param query => String, query da eseguire
    * @return ResultSet, oggetto che contiene i risultati della query
    */
    public ResultSet executeQuery(String query) throws SQLException
    {
        return statement.executeQuery(query);
    }

    /*
    * @brief  Metodo per eseguire una query per manipolare i dati del database. Funziona con tutti i comandi tranne SELECT
    * @param query => String, query da eseguire
    */
    public void executeUpdate(String query)
    {
        try
        {
            statement.executeUpdate(query);
        }
        catch (SQLException e) {e.printStackTrace();}
    }

    /*
     * @brief  Metodo per chiudere la connessione
     */
    public void closeConnection()
    {
        try
        {
            connection.close();
        }
        catch (SQLException e) {e.printStackTrace();}
    }
}