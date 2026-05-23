package service;

import model.RutinaEjercicio;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un entrenador del gimnasio.
 * 
 * @author ISC Israel de Jesús Mar Parada (MPFx++)
 * @version 1.0.0
 */
public class Entrenador {
    
    // ==================== ATRIBUTOS ====================
    
    /** Nombre del entrenador */
    private String nombre;
    
    /** ID del entrenador */
    private String idEntrenador;
    
    /** Especialidad del entrenador */
    private String especialidad;
    
    /** Certificaciones del entrenador */
    private List<String> certificaciones;
    
    /** Años de experiencia */
    private int anosExperiencia;
    
    /** Teléfono de contacto */
    private String telefono;
    
    /** Correo electrónico */
    private String email;
    
    /** Clientes asignados al entrenador */
    private List<Cliente> clientesAsignados;
    
    /** Horario disponible */
    private String horarioDisponible;
    
    /** Máximo de clientes por entrenador */
    private int maximoClientes;
    
    
    // ==================== CONSTRUCTOR ====================
    
    /**
     * Constructor de la clase Entrenador.
     * 
     * @param nombre          Nombre
     * @param idEntrenador    ID
     * @param especialidad    Especialidad
     * @param anosExperiencia Años experiencia
     * @param telefono        Teléfono
     * @param email           Email
     * @param maximoClientes  Máximo clientes
     */
    public Entrenador(String nombre, String idEntrenador, String especialidad,
                      int anosExperiencia, String telefono, String email, int maximoClientes) {
        this.nombre = nombre;
        this.idEntrenador = idEntrenador;
        this.especialidad = especialidad;
        this.anosExperiencia = anosExperiencia;
        this.telefono = telefono;
        this.email = email;
        this.maximoClientes = maximoClientes;
        this.certificaciones = new ArrayList<>();
        this.clientesAsignados = new ArrayList<>();
        this.horarioDisponible = "Lun-Vie 08:00-18:00";
    }
    
    
    // ==================== MÉTODOS ====================
    
    /**
     * Asigna un cliente al entrenador.
     * 
     * @param c Cliente a asignar
     */
    public void asignarCliente(Cliente c) {
        if (clientesAsignados.size() < maximoClientes) {
            clientesAsignados.add(c);
            System.out.println(c.getNombre() + " asignado a entrenador " + nombre);
        } else {
            System.out.println("El entrenador " + nombre + " ya tiene máximo de clientes");
        }
    }
    
    /**
     * Remueve un cliente del entrenador.
     * 
     * @param c Cliente a remover
     */
    public void removerCliente(Cliente c) {
        if (clientesAsignados.remove(c)) {
            System.out.println(c.getNombre() + " removido del entrenador " + nombre);
        }
    }
    
    /**
     * Crea una rutina para un cliente.
     * 
     * @param c      Cliente
     * @param rutina Rutina a asignar
     */
    public void crearRutina(Cliente c, RutinaEjercicio rutina) {
        if (clientesAsignados.contains(c)) {
            c.asignarRutina(rutina);
            System.out.println(nombre + " ha creado la rutina '" + rutina.getNombreRutina() + 
                             "' para " + c.getNombre());
        }
    }
    
    /**
     * Evalúa el progreso de un cliente.
     * 
     * @param c Cliente a evaluar
     */
    public void evaluarProgreso(Cliente c) {
        if (clientesAsignados.contains(c)) {
            System.out.println("\n--- EVALUACIÓN DE PROGRESO ---");
            System.out.println("Cliente: " + c.getNombre());
            System.out.println("Peso actual: " + c.getPesoActual() + " kg");
            System.out.println("IMC: " + String.format("%.2f", c.calcularIMC()));
            System.out.println("Rutinas completadas: " + c.getRutinasAsignadas().size());
            System.out.println("Visitas este mes: " + c.getVisitasMes());
        }
    }
    
    /**
     * Agrega una certificación al entrenador.
     * 
     * @param certificacion Certificación a agregar
     */
    public void agregarCertificacion(String certificacion) {
        certificaciones.add(certificacion);
        System.out.println("Certificación '" + certificacion + "' agregada a " + nombre);
    }
    
    
    // ==================== GETTERS Y SETTERS ====================
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getIdEntrenador() { return idEntrenador; }
    public void setIdEntrenador(String idEntrenador) { this.idEntrenador = idEntrenador; }
    
    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
    
    public List<String> getCertificaciones() { return certificaciones; }
    
    public int getAnosExperiencia() { return anosExperiencia; }
    public void setAnosExperiencia(int anosExperiencia) { this.anosExperiencia = anosExperiencia; }
    
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public List<Cliente> getClientesAsignados() { return clientesAsignados; }
    
    public String getHorarioDisponible() { return horarioDisponible; }
    public void setHorarioDisponible(String horarioDisponible) { this.horarioDisponible = horarioDisponible; }
    
    public int getMaximoClientes() { return maximoClientes; }
    public void setMaximoClientes(int maximoClientes) { this.maximoClientes = maximoClientes; }
}
// fin de la clase Entrenador