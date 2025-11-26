package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
   
    private static final String URL = "jdbc:mysql://localhost:3306/suscripciones?serverTimezone=UTC"; 
    private static final String USUARIO = "root";   
    private static final String CONTRASENA = "root";

 
    public static Connection getConnection() {
        Connection conexion = null;
        try {
          
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            // System.out.println("Conexión establecida."); // Línea para pruebas
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos:");
            e.printStackTrace();
        }
        return conexion;
    }
    

    public static void close(ResultSet rs) {
        try {
            if (rs != null) rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void close(Statement stmt) {
        try {
            if (stmt != null) stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void close(Connection conn) {
        try {
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}