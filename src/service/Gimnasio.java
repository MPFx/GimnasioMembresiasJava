package service;

import model.Membresia;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa el gimnasio como negocio.
 * Gestiona clientes, entrenadores y membresías.
 * 
 * @author ISC Israel de Jesús Mar Parada (MPFx++)
 * @version 1.0.0
 */
public class Gimnasio {
    
    // ==================== ATRIBUTOS ====================
    
    /** Nombre del gimnasio */
    private String nombre;
    
    /** Dirección del gimnasio */
    private String direccion;
    
    /** Teléfono de contacto */
    private String telefono;
    
    /** Horario de atención */
    private String horarioAtencion;
    
    /** Capacidad máxima de clientes */
    private int capacidadMaxima;
    
    /** Lista de clientes del gimnasio */
    private List<Cliente> clientes;
    
    /** Lista de entrenadores del gimnasio */
    private List<Entrenador> entrenadores;
    
    /** Lista de membresías activas */
    private List<Membresia> membresiasActivas;
    
    /** Ingresos mensuales del gimnasio */
    private double ingresosMensuales;
    
    /** Total de visitas registradas */
    private int visitasTotales;
    
    /** Costo de mantenimiento mensual */
    private double mantenimientoMensual;
    
    
    // ==================== CONSTRUCTOR ====================
    
    /**
     * Constructor de la clase Gimnasio.
     * 
     * @param nombre             Nombre del gimnasio
     * @param direccion          Dirección
     * @param telefono           Teléfono
     * @param horarioAtencion    Horario de atención
     * @param capacidadMaxima    Capacidad máxima
     * @param mantenimientoMensual Costo de mantenimiento
     */
    public Gimnasio(String nombre, String direccion, String telefono,
                    String horarioAtencion, int capacidadMaxima, double mantenimientoMensual) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.horarioAtencion = horarioAtencion;
        this.capacidadMaxima = capacidadMaxima;
        this.mantenimientoMensual = mantenimientoMensual;
        this.clientes = new ArrayList<>();
        this.entrenadores = new ArrayList<>();
        this.membresiasActivas = new ArrayList<>();
        this.ingresosMensuales = 0;
        this.visitasTotales = 0;
    }
    
    
    // ==================== MÉTODOS ====================
    
    /**
     * Registra un nuevo cliente en el gimnasio.
     * 
     * @param c Cliente a registrar
     */
    public void registrarCliente(Cliente c) {
        if (clientes.size() < capacidadMaxima) {
            clientes.add(c);
            System.out.println("Cliente " + c.getNombre() + " registrado exitosamente");
        } else {
            System.out.println("No hay cupos disponibles");
        }
    }
    
    /**
     * Contrata un nuevo entrenador.
     * 
     * @param e Entrenador a contratar
     */
    public void contratarEntrenador(Entrenador e) {
        entrenadores.add(e);
        System.out.println("Entrenador " + e.getNombre() + " contratado");
    }
    
    /**
     * Activa una membresía para un cliente.
     * 
     * @param m Membresía a activar
     */
    public void activarMembresia(Membresia m) {
        membresiasActivas.add(m);
        ingresosMensuales += m.calcularCostoMensual();
        System.out.println("Membresía activada para " + m.getNombreCliente());
    }
    
    /**
     * Obtiene la cantidad de clientes activos.
     * 
     * @return Número de clientes activos
     */
    public int getClientesActivos() {
        int activos = 0;
        for (Cliente c : clientes) {
            if (c.getMembresia() != null && c.getMembresia().isActiva()) {
                activos++;
            }
        }
        return activos;
    }
    
    /**
     * Calcula los ingresos mensuales del gimnasio.
     * 
     * @return Ingresos mensuales
     */
    public double getIngresosMensuales() {
        double total = 0;
        for (Membresia m : membresiasActivas) {
            if (m.isActiva()) {
                total += m.calcularCostoMensual();
            }
        }
        return total;
    }
    
    /**
     * Calcula los gastos mensuales del gimnasio.
     * 
     * @return Gastos mensuales
     */
    public double getGastosMensuales() {
        double gastos = mantenimientoMensual;
        // Gastos de entrenadores (simplificado)
        gastos += entrenadores.size() * 500000;
        return gastos;
    }
    
    /**
     * Calcula la utilidad mensual del gimnasio.
     * 
     * @return Utilidad mensual
     */
    public double getUtilidadMensual() {
        return getIngresosMensuales() - getGastosMensuales();
    }
    
    /**
     * Obtiene los clientes con membresías morosas.
     * 
     * @return Lista de clientes morosos
     */
    public List<Cliente> getClientesMorosos() {
        List<Cliente> morosos = new ArrayList<>();
        for (Cliente c : clientes) {
            if (c.getMembresia() != null && 
                c.getMembresia().getEstadoPago() == enums.EstadoPago.ATRASADO) {
                morosos.add(c);
            }
        }
        return morosos;
    }
    
    /**
     * Registra una visita al gimnasio.
     * 
     * @return true si la visita fue exitosa
     */
    public boolean registrarVisita(Cliente c) {
        if (c.registrarVisita()) {
            visitasTotales++;
            return true;
        }
        return false;
    }
    
    /**
     * Muestra el resumen del gimnasio.
     */
    public void mostrarResumen() {
        System.out.println("\n=== GIMNASIO " + nombre.toUpperCase() + " ===");
        System.out.println("Dirección: " + direccion);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Horario: " + horarioAtencion);
        System.out.println("Clientes totales: " + clientes.size());
        System.out.println("Clientes activos: " + getClientesActivos());
        System.out.println("Entrenadores: " + entrenadores.size());
        System.out.println("Membresías activas: " + membresiasActivas.size());
        System.out.printf("Ingresos mensuales: $%,.0f\n", getIngresosMensuales());
        System.out.printf("Gastos mensuales: $%,.0f\n", getGastosMensuales());
        System.out.printf("Utilidad mensual: $%,.0f\n", getUtilidadMensual());
        System.out.println("Visitas totales: " + visitasTotales);
    }
    
    
    // ==================== GETTERS Y SETTERS ====================
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    
    public String getHorarioAtencion() { return horarioAtencion; }
    public void setHorarioAtencion(String horarioAtencion) { this.horarioAtencion = horarioAtencion; }
    
    public int getCapacidadMaxima() { return capacidadMaxima; }
    public void setCapacidadMaxima(int capacidadMaxima) { this.capacidadMaxima = capacidadMaxima; }
    
    public List<Cliente> getClientes() { return clientes; }
    public List<Entrenador> getEntrenadores() { return entrenadores; }
    
    public int getVisitasTotales() { return visitasTotales; }
    public void setVisitasTotales(int visitasTotales) { this.visitasTotales = visitasTotales; }
    
    public double getMantenimientoMensual() { return mantenimientoMensual; }
    public void setMantenimientoMensual(double mantenimientoMensual) { this.mantenimientoMensual = mantenimientoMensual; }
}
// fin de la clase Gimnasio