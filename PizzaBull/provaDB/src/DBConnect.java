import java.sql.*;

public class DBConnect {
    private Connection connection;
    private Statement statement;
    private ResultSet result;

    public DBConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "");
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println("Errore nel costruttore di DBConnect: " + e);
        }
    }

    public void getData() {
        try {
            String query = "Select * from tabella1";
            result = statement.executeQuery(query);
            System.out.println("Contenuti della tabella:");
            while (result.next()) {
                String ID = result.getString("ID");
                String name = result.getString("nome");
                String cognome = result.getString("cognome");
                System.out.println("ID: " + ID + "   Nome: " + name + "   Cognome: " + cognome);
            }
        } catch (Exception e) {
            System.out.println("Errore nel getData: " + e);
        }
    }
}
