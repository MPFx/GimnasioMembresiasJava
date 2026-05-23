package model;

import enums.TipoMembresia;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * Clase que representa una membresía VIP del gimnasio.
 * Beneficios exclusivos y servicios personalizados.
 * 
 * @author ISC Israel de Jesús Mar Parada (MPFx++)
 * @version 1.0.0
 */
public class MembresiaVIP extends Membresia {
    
    // ==================== ATRIBUTOS ESPECÍFICOS ====================
    
    /** Indica si incluye nutricionista */
    private boolean incluyeNutricionista;
    
    /** Sesiones con nutricionista por año */
    private int sesionesNutricionistaYear;
    
    /** Indica si incluye entrenador personal */
    private boolean incluyeEntrenadorPersonal;
    
    /** Sesiones con entrenador por mes */
    private int sesionesEntrenadorMes;
    
    /** Locker exclusivo */
    private String lockerExclusivo;
    
    /** Porcentaje de descuento general */
    private double porcentajeDescuento;
    
    /** Indica si tiene acceso a áreas VIP */
    private boolean accesoAreasVIP;
    
    /** Eventos exclusivos por año */
    private int eventosExclusivosYear;
    
    /** Tipo de acceso especial */
    private String tipoAccesoEspecial;
    
    /** Bono anual adicional */
    private double bonoAnual;
    
    
    // ==================== CONSTRUCTOR ====================
    
    /**
     * Constructor de la clase MembresiaVIP.
     * 
     * @param idMembresia                Identificador
     * @param nombreCliente              Nombre
     * @param rutCliente                 RUT
     * @param emailCliente               Email
     * @param telefonoCliente            Teléfono
     * @param fechaInicio                Fecha inicio
     * @param fechaFin                   Fecha fin
     * @param costoBase                  Costo base
     * @param maximoVisitas              Máximo visitas
     * @param incluyeNutricionista       Incluye nutricionista
     * @param sesionesNutricionistaYear  Sesiones nutricionista
     * @param incluyeEntrenadorPersonal  Incluye entrenador
     * @param sesionesEntrenadorMes      Sesiones entrenador
     * @param lockerExclusivo            Locker exclusivo
     * @param porcentajeDescuento        Descuento
     * @param accesoAreasVIP             Acceso áreas VIP
     * @param eventosExclusivosYear      Eventos exclusivos
     * @param tipoAccesoEspecial         Tipo acceso
     * @param bonoAnual                  Bono anual
     */
    public MembresiaVIP(String idMembresia, String nombreCliente, String rutCliente,
                        String emailCliente, String telefonoCliente, LocalDate fechaInicio,
                        LocalDate fechaFin, double costoBase, int maximoVisitas,
                        boolean incluyeNutricionista, int sesionesNutricionistaYear,
                        boolean incluyeEntrenadorPersonal, int sesionesEntrenadorMes,
                        String lockerExclusivo, double porcentajeDescuento,
                        boolean accesoAreasVIP, int eventosExclusivosYear,
                        String tipoAccesoEspecial, double bonoAnual) {
        super(idMembresia, nombreCliente, rutCliente, emailCliente, telefonoCliente,
              TipoMembresia.VIP, fechaInicio, fechaFin, costoBase, maximoVisitas);
        this.incluyeNutricionista = incluyeNutricionista;
        this.sesionesNutricionistaYear = sesionesNutricionistaYear;
        this.incluyeEntrenadorPersonal = incluyeEntrenadorPersonal;
        this.sesionesEntrenadorMes = sesionesEntrenadorMes;
        this.lockerExclusivo = lockerExclusivo;
        this.porcentajeDescuento = porcentajeDescuento;
        this.accesoAreasVIP = accesoAreasVIP;
        this.eventosExclusivosYear = eventosExclusivosYear;
        this.tipoAccesoEspecial = tipoAccesoEspecial;
        this.bonoAnual = bonoAnual;
    }
    
    
    // ==================== MÉTODOS SOBRESCRITOS ====================
    
    /**
     * Calcula el costo mensual de la membresía VIP.
     * 
     * @return Costo mensual
     */
    @Override
    public double calcularCostoMensual() {
        return getCostoBase() + (bonoAnual / 12);
    }
    
    /**
     * Obtiene los beneficios de la membresía VIP.
     * 
     * @return Lista de beneficios
     */
    @Override
    public List<String> obtenerBeneficios() {
        return Arrays.asList(
            "✓ Acceso ilimitado 24/7",
            (incluyeEntrenadorPersonal ? "✓ " + sesionesEntrenadorMes + " sesiones/mes con entrenador personal" : "✗ Entrenador no incluido"),
            (incluyeNutricionista ? "✓ " + sesionesNutricionistaYear + " sesiones/año con nutricionista" : "✗ Nutricionista no incluido"),
            "✓ Locker exclusivo: " + lockerExclusivo,
            "✓ " + porcentajeDescuento + "% descuento en todos los servicios",
            (accesoAreasVIP ? "✓ Acceso a Áreas VIP" : ""),
            "✓ " + eventosExclusivosYear + " eventos exclusivos al año",
            "✓ Acceso especial: " + tipoAccesoEspecial,
            "✓ Bono anual: $" + bonoAnual
        );
    }
    
    
    // ==================== GETTERS Y SETTERS ====================
    
    public boolean isIncluyeNutricionista() { return incluyeNutricionista; }
    public void setIncluyeNutricionista(boolean incluyeNutricionista) { this.incluyeNutricionista = incluyeNutricionista; }
    
    public int getSesionesNutricionistaYear() { return sesionesNutricionistaYear; }
    public void setSesionesNutricionistaYear(int sesionesNutricionistaYear) { this.sesionesNutricionistaYear = sesionesNutricionistaYear; }
    
    public boolean isIncluyeEntrenadorPersonal() { return incluyeEntrenadorPersonal; }
    public void setIncluyeEntrenadorPersonal(boolean incluyeEntrenadorPersonal) { this.incluyeEntrenadorPersonal = incluyeEntrenadorPersonal; }
    
    public int getSesionesEntrenadorMes() { return sesionesEntrenadorMes; }
    public void setSesionesEntrenadorMes(int sesionesEntrenadorMes) { this.sesionesEntrenadorMes = sesionesEntrenadorMes; }
    
    public String getLockerExclusivo() { return lockerExclusivo; }
    public void setLockerExclusivo(String lockerExclusivo) { this.lockerExclusivo = lockerExclusivo; }
    
    public double getPorcentajeDescuento() { return porcentajeDescuento; }
    public void setPorcentajeDescuento(double porcentajeDescuento) { this.porcentajeDescuento = porcentajeDescuento; }
    
    public boolean isAccesoAreasVIP() { return accesoAreasVIP; }
    public void setAccesoAreasVIP(boolean accesoAreasVIP) { this.accesoAreasVIP = accesoAreasVIP; }
    
    public int getEventosExclusivosYear() { return eventosExclusivosYear; }
    public void setEventosExclusivosYear(int eventosExclusivosYear) { this.eventosExclusivosYear = eventosExclusivosYear; }
    
    public String getTipoAccesoEspecial() { return tipoAccesoEspecial; }
    public void setTipoAccesoEspecial(String tipoAccesoEspecial) { this.tipoAccesoEspecial = tipoAccesoEspecial; }
    
    public double getBonoAnual() { return bonoAnual; }
    public void setBonoAnual(double bonoAnual) { this.bonoAnual = bonoAnual; }
}
// fin de la clase MembresiaVIP