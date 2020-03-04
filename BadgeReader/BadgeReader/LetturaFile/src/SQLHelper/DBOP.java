package SQLHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBOP {

    //var to get the connection
    final static String SQLITE_JDBC = "org.sqlite.JDBC";
    final static String DRIVE = "jdbc:sqlite:";
    final static String DB_PATH = "F:\\Scuola\\4IB\\Sistemi&Reti\\BadgeReader\\Accessi\\";//cambiare link per accedere al database.
    final static String DB = "AccessiUtentiDB.db";

    //connection status
    static Connection conn = null;
    
    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName(SQLITE_JDBC);
                conn = DriverManager.getConnection(DRIVE + DB_PATH + DB);
            } catch (ClassNotFoundException clsNtFndEx) {
                Logger.getLogger(DBOP.class.getName()).log(Level.SEVERE, null, clsNtFndEx);
            } catch (SQLException slqEx) {
                Logger.getLogger(DBOP.class.getName()).log(Level.SEVERE, null, slqEx);
                
            }
        }
        return conn;
    }
    
    public static void closeConnection() throws SQLException {
        try {
            conn.close();
            conn = null;
        } catch (SQLException slqEx) {
            Logger.getLogger(DBOP.class.getName()).log(Level.SEVERE, null, slqEx);
        }
    }
    
    public static void insertAccesso(int idPersona, String dataOra) {
        try {
            Connection con = getConnection();
            PreparedStatement reg = con.prepareStatement("INSERT INTO ACCESSO(dataOra,idPersona) VALUES(?,?)");
            reg.setString(1, dataOra);
            reg.setInt(2, idPersona);
            reg.executeUpdate();
            reg.close();
        } catch (SQLException sqlEx) {
            Logger.getLogger(DBOP.class.getName()).log(Level.SEVERE, null, sqlEx);
        }
    }

//    static void listaTutto() throws Exception {
//        System.out.println("AGENDA COMPLETA: ");
//        String sql = "SELECT * FROM PERSONA";
//        PreparedStatement stm = conn.prepareStatement(sql);
//        ResultSet rs = stm.executeQuery();
//        while (rs.next()) {
//            int idPers = rs.getInt("IDPersona");
//            System.out.println(rs.getString("Cognome Nome") + " ABITANTE IN: " + rs.getString("indirizzo"));
//            String telefSQL = "SELECT * FROM TELEFONO WHERE IDPersona = ?";
//            PreparedStatement stmTel = conn.prepareStatement(telefSQL);
//            stmTel.setInt(1, idPers);
//            ResultSet rsTel = stmTel.executeQuery();
//            while (rsTel.next()) {
//                System.out.println("      " + rsTel.getString("Telefono") + "  " + rsTel.getString("Tipo"));
//            }
//        }
//
//    }
    public static void main(String[] args) throws SQLException {
        
    }
}
