package controlador;

import modelo.Suscripcion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SuscripcionDAO {

    
    private static final String SQL_SELECT = "SELECT id_suscripcion, id_cliente, id_plan, fecha_inicio, fecha_fin, estado FROM suscripcion";
    private static final String SQL_INSERT = "INSERT INTO suscripcion (id_cliente, id_plan, fecha_inicio, fecha_fin, estado) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE suscripcion SET id_cliente=?, id_plan=?, fecha_inicio=?, fecha_fin=?, estado=? WHERE id_suscripcion=?";
    private static final String SQL_DELETE = "DELETE FROM suscripcion WHERE id_suscripcion=?";

    public List<Suscripcion> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Suscripcion> suscripciones = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Suscripcion suscripcion = new Suscripcion();
               
                
                suscripcion.setIdSuscripcion(rs.getInt("id_suscripcion"));
                suscripcion.setIdCliente(rs.getInt("id_cliente"));
                suscripcion.setIdPlan(rs.getInt("id_plan"));
                suscripcion.setFechaInicio(rs.getDate("fecha_inicio"));
                suscripcion.setFechaFin(rs.getDate("fecha_fin"));
                suscripcion.setEstado(rs.getString("estado"));
                
                suscripciones.add(suscripcion);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar suscripciones:");
            e.printStackTrace();
        } finally {
            // Cierre de recursos (usando los métodos de Conexion.java)
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn); 
        }
        return suscripciones;
    }

     
    public int insertar(Suscripcion suscripcion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0; 

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            
            
            stmt.setInt(1, suscripcion.getIdCliente());
            stmt.setInt(2, suscripcion.getIdPlan());
            stmt.setDate(3, suscripcion.getFechaInicio());
            stmt.setDate(4, suscripcion.getFechaFin());
            stmt.setString(5, suscripcion.getEstado());
            
            
            registros = stmt.executeUpdate(); 
            
        } catch (SQLException e) {
            System.err.println("Error al insertar suscripción:");
            e.printStackTrace();
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return registros;
    }

   
     
    public int actualizar(Suscripcion suscripcion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

            // 1. Parámetros de actualización (valores nuevos)
            stmt.setInt(1, suscripcion.getIdCliente());
            stmt.setInt(2, suscripcion.getIdPlan());
            stmt.setDate(3, suscripcion.getFechaInicio());
            stmt.setDate(4, suscripcion.getFechaFin());
            stmt.setString(5, suscripcion.getEstado());
            
            
            stmt.setInt(6, suscripcion.getIdSuscripcion()); 

            
            registros = stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al actualizar suscripción:");
            e.printStackTrace();
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return registros;
    }

  
     
    public int eliminar(int idSuscripcion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            
            stmt.setInt(1, idSuscripcion);

           
            registros = stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al eliminar suscripción:");
            e.printStackTrace();
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return registros;
    }
}