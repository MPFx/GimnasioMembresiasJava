package model;

import enums.TipoMembresia;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * Clase que representa una membresía premium del gimnasio.
 * Acceso a todas las áreas y clases grupales.
 * 
 * @author ISC Israel de Jesús Mar Parada (MPFx++)
 * @version 1.0.0
 */
public class MembresiaPremium extends Membresia {
    
    // ==================== ATRIBUTOS ESPECÍFICOS ====================
    
    /** Indica si incluye clases grupales */
    private boolean incluyeClasesGrupales;
    
    /** Máximo de clases por semana */
    private int maximoClasesSemana;
    
    /** Indica si incluye acceso a piscina */
    private boolean incluyeAccesoPiscina;
    
    /** Tipo de clases preferidas */
    private String tipoClasesPreferidas;
    
    /** Descuento en merchandising (%) */
    private double descuentoMerchandising;
    
    /** Indica si incluye estacionamiento */
    private boolean incluyeEstacionamiento;
    
    /** Número de invitados por mes */
    private int invitadosMensuales;
    
    /** Adicional por familiar */
    private double adicionalFamiliar;
    
    /** Máximo de familiares incluidos */
    private int maximoFamiliares;
    
    
    // ==================== CONSTRUCTOR ====================
    
    /**
     * Constructor de la clase MembresiaPremium.
     * 
     * @param idMembresia            Identificador
     * @param nombreCliente          Nombre
     * @param rutCliente             RUT
     * @param emailCliente           Email
     * @param telefonoCliente        Teléfono
     * @param fechaInicio            Fecha inicio
     * @param fechaFin               Fecha fin
     * @param costoBase              Costo base
     * @param maximoVisitas          Máximo visitas
     * @param incluyeClasesGrupales  Incluye clases
     * @param maximoClasesSemana     Máximo clases semana
     * @param incluyeAccesoPiscina   Incluye piscina
     * @param tipoClasesPreferidas   Tipo clases
     * @param descuentoMerchandising Descuento
     * @param incluyeEstacionamiento Incluye estacionamiento
     * @param invitadosMensuales     Invitados
     * @param adicionalFamiliar      Adicional familiar
     * @param maximoFamiliares       Máximo familiares
     */
    public MembresiaPremium(String idMembresia, String nombreCliente, String rutCliente,
                            String emailCliente, String telefonoCliente, LocalDate fechaInicio,
                            LocalDate fechaFin, double costoBase, int maximoVisitas,
                            boolean incluyeClasesGrupales, int maximoClasesSemana,
                            boolean incluyeAccesoPiscina, String tipoClasesPreferidas,
                            double descuentoMerchandising, boolean incluyeEstacionamiento,
                            int invitadosMensuales, double adicionalFamiliar, int maximoFamiliares) {
        super(idMembresia, nombreCliente, rutCliente, emailCliente, telefonoCliente,
              TipoMembresia.PREMIUM, fechaInicio, fechaFin, costoBase, maximoVisitas);
        this.incluyeClasesGrupales = incluyeClasesGrupales;
        this.maximoClasesSemana = maximoClasesSemana;
        this.incluyeAccesoPiscina = incluyeAccesoPiscina;
        this.tipoClasesPreferidas = tipoClasesPreferidas;
        this.descuentoMerchandising = descuentoMerchandising;
        this.incluyeEstacionamiento = incluyeEstacionamiento;
        this.invitadosMensuales = invitadosMensuales;
        this.adicionalFamiliar = adicionalFamiliar;
        this.maximoFamiliares = maximoFamiliares;
    }
    
    
    // ==================== MÉTODOS SOBRESCRITOS ====================
    
    /**
     * Calcula el costo mensual de la membresía premium.
     * 
     * @return Costo mensual
     */
    @Override
    public double calcularCostoMensual() {
        return getCostoBase();
    }
    
    /**
     * Obtiene los beneficios de la membresía premium.
     * 
     * @return Lista de beneficios
     */
    @Override
    public List<String> obtenerBeneficios() {
        return Arrays.asList(
            "✓ Acceso a sala de pesas y cardio",
            (incluyeClasesGrupales ? "✓ " + maximoClasesSemana + " clases grupales/semana" : "✗ Clases no incluidas"),
            (incluyeAccesoPiscina ? "✓ Acceso a piscina" : "✗ Piscina no incluida"),
            "✓ " + getMaximoVisitas() + " visitas mensuales",
            (incluyeEstacionamiento ? "✓ Estacionamiento gratuito" : "✗ Estacionamiento no incluido"),
            "✓ " + descuentoMerchandising + "% descuento en tienda",
            "✓ " + invitadosMensuales + " invitados por mes",
            (maximoFamiliares > 0 ? "✓ Hasta " + maximoFamiliares + " familiares (+$" + adicionalFamiliar + " c/u)" : "")
        );
    }
    
    
    // ==================== GETTERS Y SETTERS ====================
    
    public boolean isIncluyeClasesGrupales() { return incluyeClasesGrupales; }
    public void setIncluyeClasesGrupales(boolean incluyeClasesGrupales) { this.incluyeClasesGrupales = incluyeClasesGrupales; }
    
    public int getMaximoClasesSemana() { return maximoClasesSemana; }
    public void setMaximoClasesSemana(int maximoClasesSemana) { this.maximoClasesSemana = maximoClasesSemana; }
    
    public boolean isIncluyeAccesoPiscina() { return incluyeAccesoPiscina; }
    public void setIncluyeAccesoPiscina(boolean incluyeAccesoPiscina) { this.incluyeAccesoPiscina = incluyeAccesoPiscina; }
    
    public String getTipoClasesPreferidas() { return tipoClasesPreferidas; }
    public void setTipoClasesPreferidas(String tipoClasesPreferidas) { this.tipoClasesPreferidas = tipoClasesPreferidas; }
    
    public double getDescuentoMerchandising() { return descuentoMerchandising; }
    public void setDescuentoMerchandising(double descuentoMerchandising) { this.descuentoMerchandising = descuentoMerchandising; }
    
    public boolean isIncluyeEstacionamiento() { return incluyeEstacionamiento; }
    public void setIncluyeEstacionamiento(boolean incluyeEstacionamiento) { this.incluyeEstacionamiento = incluyeEstacionamiento; }
    
    public int getInvitadosMensuales() { return invitadosMensuales; }
    public void setInvitadosMensuales(int invitadosMensuales) { this.invitadosMensuales = invitadosMensuales; }
    
    public double getAdicionalFamiliar() { return adicionalFamiliar; }
    public void setAdicionalFamiliar(double adicionalFamiliar) { this.adicionalFamiliar = adicionalFamiliar; }
    
    public int getMaximoFamiliares() { return maximoFamiliares; }
    public void setMaximoFamiliares(int maximoFamiliares) { this.maximoFamiliares = maximoFamiliares; }
}
// fin de la clase MembresiaPremium