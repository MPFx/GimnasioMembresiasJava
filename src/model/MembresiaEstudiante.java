package model;

import enums.TipoMembresia;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * Clase que representa una membresía especial para estudiantes.
 * Precio reducido con validación de carnet estudiantil.
 * 
 * @author ISC Israel de Jesús Mar Parada (MPFx++)
 * @version 1.0.0
 */
public class MembresiaEstudiante extends Membresia {
    
    // ==================== ATRIBUTOS ESPECÍFICOS ====================
    
    /** Nombre de la institución educativa */
    private String institucion;
    
    /** Número de carnet estudiantil */
    private String carnetEstudiante;
    
    /** Fecha de vigencia del carnet */
    private LocalDate vigenciaCarnet;
    
    /** Carrera que estudia */
    private String carrera;
    
    /** Promedio de calificaciones */
    private double promedioCalificaciones;
    
    /** Indica si es beneficiario de beca */
    private boolean tieneBeca;
    
    /** Porcentaje de descuento adicional por beca */
    private double descuentoBeca;
    
    
    // ==================== CONSTRUCTOR ====================
    
    /**
     * Constructor de la clase MembresiaEstudiante.
     * 
     * @param idMembresia         Identificador
     * @param nombreCliente       Nombre
     * @param rutCliente          RUT
     * @param emailCliente        Email
     * @param telefonoCliente     Teléfono
     * @param fechaInicio         Fecha inicio
     * @param fechaFin            Fecha fin
     * @param costoBase           Costo base
     * @param maximoVisitas       Máximo visitas
     * @param institucion         Institución
     * @param carnetEstudiante    Carnet estudiante
     * @param vigenciaCarnet      Vigencia carnet
     * @param carrera             Carrera
     * @param promedioCalificaciones Promedio
     * @param tieneBeca           Tiene beca
     * @param descuentoBeca       Descuento beca
     */
    public MembresiaEstudiante(String idMembresia, String nombreCliente, String rutCliente,
                               String emailCliente, String telefonoCliente, LocalDate fechaInicio,
                               LocalDate fechaFin, double costoBase, int maximoVisitas,
                               String institucion, String carnetEstudiante, LocalDate vigenciaCarnet,
                               String carrera, double promedioCalificaciones, boolean tieneBeca,
                               double descuentoBeca) {
        super(idMembresia, nombreCliente, rutCliente, emailCliente, telefonoCliente,
              TipoMembresia.ESTUDIANTE, fechaInicio, fechaFin, costoBase, maximoVisitas);
        this.institucion = institucion;
        this.carnetEstudiante = carnetEstudiante;
        this.vigenciaCarnet = vigenciaCarnet;
        this.carrera = carrera;
        this.promedioCalificaciones = promedioCalificaciones;
        this.tieneBeca = tieneBeca;
        this.descuentoBeca = descuentoBeca;
    }
    
    
    // ==================== MÉTODOS SOBRESCRITOS ====================
    
    /**
     * Calcula el costo mensual de la membresía de estudiante.
     * Aplica descuento por beca si corresponde.
     * 
     * @return Costo mensual
     */
    @Override
    public double calcularCostoMensual() {
        double costo = getCostoBase() * 0.6; // 40% descuento base para estudiantes
        
        if (tieneBeca) {
            costo = costo * (1 - descuentoBeca / 100);
        }
        
        if (promedioCalificaciones >= 6.0) {
            costo = costo * 0.9; // 10% adicional por buen promedio
        }
        
        return costo;
    }
    
    /**
     * Obtiene los beneficios de la membresía de estudiante.
     * 
     * @return Lista de beneficios
     */
    @Override
    public List<String> obtenerBeneficios() {
        return Arrays.asList(
            "✓ Acceso a sala de pesas",
            "✓ Horario flexible para estudiantes",
            "✓ 40% descuento en mensualidad",
            (tieneBeca ? "✓ " + descuentoBeca + "% descuento adicional por beca" : ""),
            (promedioCalificaciones >= 6.0 ? "✓ 10% descuento por excelencia académica" : ""),
            "✓ " + getMaximoVisitas() + " visitas mensuales",
            "✓ Institución: " + institucion
        );
    }
    
    /**
     * Verifica si el carnet de estudiante está vigente.
     * 
     * @return true si está vigente
     */
    public boolean carnetVigente() {
        return LocalDate.now().isBefore(vigenciaCarnet);
    }
    
    
    // ==================== GETTERS Y SETTERS ====================
    
    public String getInstitucion() { return institucion; }
    public void setInstitucion(String institucion) { this.institucion = institucion; }
    
    public String getCarnetEstudiante() { return carnetEstudiante; }
    public void setCarnetEstudiante(String carnetEstudiante) { this.carnetEstudiante = carnetEstudiante; }
    
    public LocalDate getVigenciaCarnet() { return vigenciaCarnet; }
    public void setVigenciaCarnet(LocalDate vigenciaCarnet) { this.vigenciaCarnet = vigenciaCarnet; }
    
    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }
    
    public double getPromedioCalificaciones() { return promedioCalificaciones; }
    public void setPromedioCalificaciones(double promedioCalificaciones) { this.promedioCalificaciones = promedioCalificaciones; }
    
    public boolean isTieneBeca() { return tieneBeca; }
    public void setTieneBeca(boolean tieneBeca) { this.tieneBeca = tieneBeca; }
    
    public double getDescuentoBeca() { return descuentoBeca; }
    public void setDescuentoBeca(double descuentoBeca) { this.descuentoBeca = descuentoBeca; }
}
// fin de la clase MembresiaEstudiante