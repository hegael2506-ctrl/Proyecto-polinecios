package modelo;

import java.sql.Date; 

public class Suscripcion {
    
    
    private int idSuscripcion;
    private int idCliente;
    private int idPlan;
    private Date fechaInicio;
    private Date fechaFin;
    private String estado;
    
    
    public Suscripcion() {}

    
    public Suscripcion(int idSuscripcion, int idCliente, int idPlan, Date fechaInicio, Date fechaFin, String estado) {
        this.idSuscripcion = idSuscripcion;
        this.idCliente = idCliente;
        this.idPlan = idPlan;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }
    
    
    public Suscripcion(int idCliente, int idPlan, Date fechaInicio, Date fechaFin, String estado) {
        this(0, idCliente, idPlan, fechaInicio, fechaFin, estado);
    }
    
    

    public int getIdSuscripcion() { return idSuscripcion; }
    public void setIdSuscripcion(int idSuscripcion) { this.idSuscripcion = idSuscripcion; }

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    public int getIdPlan() { return idPlan; }
    public void setIdPlan(int idPlan) { this.idPlan = idPlan; }

    public Date getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(Date fechaInicio) { this.fechaInicio = fechaInicio; }

    public Date getFechaFin() { return fechaFin; }
    public void setFechaFin(Date fechaFin) { this.fechaFin = fechaFin; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    
    @Override
    public String toString() {
        return "Suscripcion{" + "id=" + idSuscripcion + ", cliente=" + idCliente + ", estado=" + estado + '}';
    }
}