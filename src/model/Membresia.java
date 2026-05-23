package model;

import enums.TipoMembresia;
import enums.EstadoPago;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * Clase abstracta que representa una membresía genérica del gimnasio.
 * Contiene los atributos y métodos comunes a todos los tipos de membresías.
 * 
 * @author ISC Israel de Jesús Mar Parada (MPFx++)
 * @version 1.0.0
 */
public abstract class Membresia {
    
    // ==================== ATRIBUTOS ====================
    
    /** Identificador único de la membresía */
    private String idMembresia;
    
    /** Nombre del cliente */
    private String nombreCliente;
    
    /** RUT del cliente */
    private String rutCliente;
    
    /** Correo electrónico del cliente */
    private String emailCliente;
    
    /** Teléfono del cliente */
    private String telefonoCliente;
    
    /** Tipo de membresía */
    private TipoMembresia tipo;
    
    /** Fecha de inicio de la membresía */
    private LocalDate fechaInicio;
    
    /** Fecha de término de la membresía */
    private LocalDate fechaFin;
    
    /** Costo base de la membresía */
    private double costoBase;
    
    /** Indica si la membresía está activa */
    private boolean activa;
    
    /** Estado de pago */
    private EstadoPago estadoPago;
    
    /** Visitas realizadas en el mes */
    private int visitasRealizadas;
    
    /** Máximo de visitas permitidas por mes */
    private int maximoVisitas;
    
    
    // ==================== CONSTRUCTOR ====================
    
    /**
     * Constructor de la clase Membresia.
     * 
     * @param idMembresia    Identificador único
     * @param nombreCliente  Nombre del cliente
     * @param rutCliente     RUT del cliente
     * @param emailCliente   Correo electrónico
     * @param telefonoCliente Teléfono
     * @param tipo           Tipo de membresía
     * @param fechaInicio    Fecha de inicio
     * @param fechaFin       Fecha de término
     * @param costoBase      Costo base
     * @param maximoVisitas  Máximo de visitas mensuales
     */
    public Membresia(String idMembresia, String nombreCliente, String rutCliente,
                     String emailCliente, String telefonoCliente, TipoMembresia tipo,
                     LocalDate fechaInicio, LocalDate fechaFin, double costoBase,
                     int maximoVisitas) {
        this.idMembresia = idMembresia;
        this.nombreCliente = nombreCliente;
        this.rutCliente = rutCliente;
        this.emailCliente = emailCliente;
        this.telefonoCliente = telefonoCliente;
        this.tipo = tipo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costoBase = costoBase;
        this.maximoVisitas = maximoVisitas;
        this.activa = true;
        this.estadoPago = EstadoPago.AL_DIA;
        this.visitasRealizadas = 0;
    }
    
    
    // ==================== MÉTODOS ABSTRACTOS ====================
    
    /**
     * Calcula el costo mensual de la membresía.
     * 
     * @return Costo mensual
     */
    public abstract double calcularCostoMensual();
    
    /**
     * Obtiene la lista de beneficios de la membresía.
     * 
     * @return Lista de beneficios
     */
    public abstract List<String> obtenerBeneficios();
    
    
    // ==================== MÉTODOS CONCRETOS ====================
    
    /**
     * Registra una visita del cliente.
     * 
     * @return true si puede ingresar
     */
    public boolean registrarVisita() {
        if (!activa || estadoPago != EstadoPago.AL_DIA) {
            return false;
        }
        
        if (visitasRealizadas < maximoVisitas) {
            visitasRealizadas++;
            return true;
        }
        return false;
    }
    
    /**
     * Renueva la membresía por un período adicional.
     */
    public void renovar() {
        if (activa) {
            fechaInicio = LocalDate.now();
            fechaFin = fechaInicio.plusMonths(1);
            visitasRealizadas = 0;
            estadoPago = EstadoPago.AL_DIA;
            System.out.println("Membresía renovada hasta " + fechaFin);
        }
    }
    
    /**
     * Cancela la membresía.
     */
    public void cancelar() {
        this.activa = false;
        System.out.println("Membresía cancelada para " + nombreCliente);
    }
    
    /**
     * Registra el pago de la membresía.
     */
    public void pagarMensualidad() {
        this.estadoPago = EstadoPago.AL_DIA;
        System.out.println("Mensualidad pagada para " + nombreCliente);
    }
    
    /**
     * Verifica si el cliente puede ingresar al gimnasio.
     * 
     * @return true si puede ingresar
     */
    public boolean puedeIngresar() {
        return activa && estadoPago == EstadoPago.AL_DIA && 
               visitasRealizadas < maximoVisitas;
    }
    
    /**
     * Obtiene los días restantes de la membresía.
     * 
     * @return Días restantes
     */
    public long getDiasRestantes() {
        return ChronoUnit.DAYS.between(LocalDate.now(), fechaFin);
    }
    
    
    // ==================== GETTERS Y SETTERS ====================
    
    public String getIdMembresia() { return idMembresia; }
    public void setIdMembresia(String idMembresia) { this.idMembresia = idMembresia; }
    
    public String getNombreCliente() { return nombreCliente; }
    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }
    
    public String getRutCliente() { return rutCliente; }
    public void setRutCliente(String rutCliente) { this.rutCliente = rutCliente; }
    
    public String getEmailCliente() { return emailCliente; }
    public void setEmailCliente(String emailCliente) { this.emailCliente = emailCliente; }
    
    public String getTelefonoCliente() { return telefonoCliente; }
    public void setTelefonoCliente(String telefonoCliente) { this.telefonoCliente = telefonoCliente; }
    
    public TipoMembresia getTipo() { return tipo; }
    
    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
    
    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }
    
    public double getCostoBase() { return costoBase; }
    public void setCostoBase(double costoBase) { this.costoBase = costoBase; }
    
    public boolean isActiva() { return activa; }
    public void setActiva(boolean activa) { this.activa = activa; }
    
    public EstadoPago getEstadoPago() { return estadoPago; }
    public void setEstadoPago(EstadoPago estadoPago) { this.estadoPago = estadoPago; }
    
    public int getVisitasRealizadas() { return visitasRealizadas; }
    public void setVisitasRealizadas(int visitasRealizadas) { this.visitasRealizadas = visitasRealizadas; }
    
    public int getMaximoVisitas() { return maximoVisitas; }
    public void setMaximoVisitas(int maximoVisitas) { this.maximoVisitas = maximoVisitas; }
}
// fin de la clase Membresia