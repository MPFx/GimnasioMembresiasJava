package model;

import enums.TipoMembresia;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * Clase que representa una membresía corporativa para empresas.
 * Permite múltiples empleados con tarifa especial.
 * 
 * @author ISC Israel de Jesús Mar Parada (MPFx++)
 * @version 1.0.0
 */
public class MembresiaCorporativa extends Membresia {
    
    // ==================== ATRIBUTOS ESPECÍFICOS ====================
    
    /** Nombre de la empresa */
    private String empresa;
    
    /** RUT de la empresa */
    private String rutEmpresa;
    
    /** Número de empleados afiliados */
    private int numeroEmpleados;
    
    /** Descuento adicional por volumen */
    private double descuentoVolumen;
    
    /** Contacto en la empresa */
    private String contactoEmpresa;
    
    /** Teléfono de contacto empresarial */
    private String telefonoEmpresa;
    
    /** Email de contacto empresarial */
    private String emailEmpresa;
    
    /** Plan corporativo seleccionado */
    private String planCorporativo;
    
    /** Facturación mensual total */
    private double facturacionMensual;
    
    
    // ==================== CONSTRUCTOR ====================
    
    /**
     * Constructor de la clase MembresiaCorporativa.
     * 
     * @param idMembresia        Identificador
     * @param nombreCliente      Nombre (contacto)
     * @param rutCliente         RUT
     * @param emailCliente       Email
     * @param telefonoCliente    Teléfono
     * @param fechaInicio        Fecha inicio
     * @param fechaFin           Fecha fin
     * @param costoBase          Costo base
     * @param maximoVisitas      Máximo visitas
     * @param empresa            Empresa
     * @param rutEmpresa         RUT empresa
     * @param numeroEmpleados    Número empleados
     * @param descuentoVolumen   Descuento volumen
     * @param contactoEmpresa    Contacto
     * @param telefonoEmpresa    Teléfono empresa
     * @param emailEmpresa       Email empresa
     * @param planCorporativo    Plan corporativo
     * @param facturacionMensual Facturación
     */
    public MembresiaCorporativa(String idMembresia, String nombreCliente, String rutCliente,
                                String emailCliente, String telefonoCliente, LocalDate fechaInicio,
                                LocalDate fechaFin, double costoBase, int maximoVisitas,
                                String empresa, String rutEmpresa, int numeroEmpleados,
                                double descuentoVolumen, String contactoEmpresa, String telefonoEmpresa,
                                String emailEmpresa, String planCorporativo, double facturacionMensual) {
        super(idMembresia, nombreCliente, rutCliente, emailCliente, telefonoCliente,
              TipoMembresia.CORPORATIVA, fechaInicio, fechaFin, costoBase, maximoVisitas);
        this.empresa = empresa;
        this.rutEmpresa = rutEmpresa;
        this.numeroEmpleados = numeroEmpleados;
        this.descuentoVolumen = descuentoVolumen;
        this.contactoEmpresa = contactoEmpresa;
        this.telefonoEmpresa = telefonoEmpresa;
        this.emailEmpresa = emailEmpresa;
        this.planCorporativo = planCorporativo;
        this.facturacionMensual = facturacionMensual;
    }
    
    
    // ==================== MÉTODOS SOBRESCRITOS ====================
    
    /**
     * Calcula el costo mensual de la membresía corporativa.
     * Aplica descuento por volumen de empleados.
     * 
     * @return Costo mensual
     */
    @Override
    public double calcularCostoMensual() {
        double descuento = descuentoVolumen + (numeroEmpleados * 0.5);
        descuento = Math.min(descuento, 30.0); // Máximo 30% descuento
        return getCostoBase() * (1 - descuento / 100);
    }
    
    /**
     * Obtiene los beneficios de la membresía corporativa.
     * 
     * @return Lista de beneficios
     */
    @Override
    public List<String> obtenerBeneficios() {
        return Arrays.asList(
            "✓ Empresa: " + empresa,
            "✓ " + numeroEmpleados + " empleados afiliados",
            "✓ " + descuentoVolumen + "% descuento por volumen",
            "✓ Plan: " + planCorporativo,
            "✓ Facturación mensual: $" + facturacionMensual,
            "✓ Contacto: " + contactoEmpresa,
            "✓ " + getMaximoVisitas() + " visitas por empleado/mes"
        );
    }
    
    /**
     * Calcula el costo por empleado.
     * 
     * @return Costo por empleado
     */
    public double calcularCostoPorEmpleado() {
        return calcularCostoMensual() / numeroEmpleados;
    }
    
    
    // ==================== GETTERS Y SETTERS ====================
    
    public String getEmpresa() { return empresa; }
    public void setEmpresa(String empresa) { this.empresa = empresa; }
    
    public String getRutEmpresa() { return rutEmpresa; }
    public void setRutEmpresa(String rutEmpresa) { this.rutEmpresa = rutEmpresa; }
    
    public int getNumeroEmpleados() { return numeroEmpleados; }
    public void setNumeroEmpleados(int numeroEmpleados) { this.numeroEmpleados = numeroEmpleados; }
    
    public double getDescuentoVolumen() { return descuentoVolumen; }
    public void setDescuentoVolumen(double descuentoVolumen) { this.descuentoVolumen = descuentoVolumen; }
    
    public String getContactoEmpresa() { return contactoEmpresa; }
    public void setContactoEmpresa(String contactoEmpresa) { this.contactoEmpresa = contactoEmpresa; }
    
    public String getTelefonoEmpresa() { return telefonoEmpresa; }
    public void setTelefonoEmpresa(String telefonoEmpresa) { this.telefonoEmpresa = telefonoEmpresa; }
    
    public String getEmailEmpresa() { return emailEmpresa; }
    public void setEmailEmpresa(String emailEmpresa) { this.emailEmpresa = emailEmpresa; }
    
    public String getPlanCorporativo() { return planCorporativo; }
    public void setPlanCorporativo(String planCorporativo) { this.planCorporativo = planCorporativo; }
    
    public double getFacturacionMensual() { return facturacionMensual; }
    public void setFacturacionMensual(double facturacionMensual) { this.facturacionMensual = facturacionMensual; }
}
// fin de la clase MembresiaCorporativa