package model;

import enums.TipoMembresia;
import enums.EstadoPago;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * Clase que representa una membresía básica del gimnasio.
 * Acceso limitado a sala de pesas y horario restringido.
 * 
 * @author ISC Israel de Jesús Mar Parada (MPFx++)
 * @version 1.0.0
 */
public class MembresiaBasica extends Membresia {
    
    // ==================== ATRIBUTOS ESPECÍFICOS ====================
    
    /** Límite de días por semana */
    private int limiteDiasSemana;
    
    /** Indica si incluye acceso a la app */
    private boolean incluyeApp;
    
    /** Horario de acceso */
    private String horarioAcceso;
    
    /** Costo de mantenimiento mensual */
    private double costoMantenimiento;
    
    /** Meses de contrato mínimo */
    private int mesesContrato;
    
    
    // ==================== CONSTRUCTOR ====================
    
    /**
     * Constructor de la clase MembresiaBasica.
     * 
     * @param idMembresia      Identificador
     * @param nombreCliente    Nombre
     * @param rutCliente       RUT
     * @param emailCliente     Email
     * @param telefonoCliente  Teléfono
     * @param fechaInicio      Fecha inicio
     * @param fechaFin         Fecha fin
     * @param costoBase        Costo base
     * @param maximoVisitas    Máximo visitas
     * @param limiteDiasSemana Límite días por semana
     * @param incluyeApp       Incluye app
     * @param horarioAcceso    Horario acceso
     * @param costoMantenimiento Costo mantenimiento
     * @param mesesContrato    Meses contrato
     */
    public MembresiaBasica(String idMembresia, String nombreCliente, String rutCliente,
                           String emailCliente, String telefonoCliente, LocalDate fechaInicio,
                           LocalDate fechaFin, double costoBase, int maximoVisitas,
                           int limiteDiasSemana, boolean incluyeApp, String horarioAcceso,
                           double costoMantenimiento, int mesesContrato) {
        super(idMembresia, nombreCliente, rutCliente, emailCliente, telefonoCliente,
              TipoMembresia.BASICA, fechaInicio, fechaFin, costoBase, maximoVisitas);
        this.limiteDiasSemana = limiteDiasSemana;
        this.incluyeApp = incluyeApp;
        this.horarioAcceso = horarioAcceso;
        this.costoMantenimiento = costoMantenimiento;
        this.mesesContrato = mesesContrato;
    }
    
    
    // ==================== MÉTODOS SOBRESCRITOS ====================
    
    /**
     * Calcula el costo mensual de la membresía básica.
     * 
     * @return Costo mensual
     */
    @Override
    public double calcularCostoMensual() {
        return getCostoBase() + costoMantenimiento;
    }
    
    /**
     * Obtiene los beneficios de la membresía básica.
     * 
     * @return Lista de beneficios
     */
    @Override
    public List<String> obtenerBeneficios() {
        return Arrays.asList(
            "✓ Acceso a sala de pesas",
            "✓ Horario: " + horarioAcceso,
            (incluyeApp ? "✓ Acceso a app móvil" : "✗ App no incluida"),
            "✓ " + limiteDiasSemana + " días por semana",
            "✓ " + getMaximoVisitas() + " visitas mensuales"
        );
    }
    
    
    // ==================== GETTERS Y SETTERS ====================
    
    public int getLimiteDiasSemana() { return limiteDiasSemana; }
    public void setLimiteDiasSemana(int limiteDiasSemana) { this.limiteDiasSemana = limiteDiasSemana; }
    
    public boolean isIncluyeApp() { return incluyeApp; }
    public void setIncluyeApp(boolean incluyeApp) { this.incluyeApp = incluyeApp; }
    
    public String getHorarioAcceso() { return horarioAcceso; }
    public void setHorarioAcceso(String horarioAcceso) { this.horarioAcceso = horarioAcceso; }
    
    public double getCostoMantenimiento() { return costoMantenimiento; }
    public void setCostoMantenimiento(double costoMantenimiento) { this.costoMantenimiento = costoMantenimiento; }
    
    public int getMesesContrato() { return mesesContrato; }
    public void setMesesContrato(int mesesContrato) { this.mesesContrato = mesesContrato; }
}
// fin de la clase MembresiaBasica