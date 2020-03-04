package OPdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLhelper {

    //var to get the connection
    final static String SQLITE_JDBC = "org.sqlite.JDBC";
    final static String DRIVE = "jdbc:sqlite:";
    final static String DB_PATH = "F:\\Scuola\\4IB\\Sistemi&Reti\\BadgeReader\\GestioneAgendaConDB\\";//cambiare link per accedere al database.
    final static String DB = "AccessiUtentiDB.db";

    //connection status
    static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName(SQLITE_JDBC);
                conn = DriverManager.getConnection(DRIVE + DB_PATH + DB);
            } catch (ClassNotFoundException clsNtFndEx) {
                Logger.getLogger(SQLhelper.class.getName()).log(Level.SEVERE, null, clsNtFndEx);
            } catch (SQLException slqEx) {
                Logger.getLogger(SQLhelper.class.getName()).log(Level.SEVERE, null, slqEx);

            }
        }
        return conn;
    }

    public static void closeConnection() throws SQLException {
        try {
            conn.close();
            conn = null;
        } catch (SQLException slqEx) {
            Logger.getLogger(SQLhelper.class.getName()).log(Level.SEVERE, null, slqEx);
        }
    }
}
