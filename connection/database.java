package connection;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class database {
  private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
  private static final String URL = "jdbc:mysql://localhost:3306/trabalho";
  private static final String USER = "root";
  private static final String PASS = "Casa2523";
  public static final String BLUE = "\u001B[34m";
  public static final String RED = "\u001B[31m";


  public static Connection getConnection() {
    try {
        Class.forName(DRIVER);
        System.out.println("Conectado a " + URL);
        return DriverManager.getConnection(URL, USER, PASS);
    } catch (ClassNotFoundException | SQLException ex) {
        throw new RuntimeException(RED + "Erro na conexão: ", ex);
    }
}

public static void closeConnection(Connection con) {
    try {
        if (con != null) {
            con.close();
        }
    } catch (SQLException ex) {
        Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
    }
}

public static void closeConnection(Connection con, PreparedStatement stmt) {

    closeConnection(con);

    try {

        if (stmt != null) {
            stmt.close();
        }

    } catch (SQLException ex) {
        Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
    }
}

public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {

    closeConnection(con, stmt);

    try {

        if (rs != null) {
            rs.close();
        }

    } catch (SQLException ex) {
        Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
    }
}

}