package service;

import model.Membresia;
import model.RutinaEjercicio;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un cliente del gimnasio.
 * 
 * @author ISC Israel de Jesús Mar Parada (MPFx++)
 * @version 1.0.0
 */
public class Cliente {
    
    // ==================== ATRIBUTOS ====================
    
    /** Nombre del cliente */
    private String nombre;
    
    /** ID del cliente */
    private String idCliente;
    
    /** RUT del cliente */
    private String rut;
    
    /** Correo electrónico */
    private String email;
    
    /** Teléfono de contacto */
    private String telefono;
    
    /** Membresía del cliente */
    private Membresia membresia;
    
    /** Rutinas asignadas al cliente */
    private List<RutinaEjercicio> rutinasAsignadas;
    
    /** Historial de visitas */
    private List<String> historialVisitas;
    
    /** Peso actual en kg */
    private double pesoActual;
    
    /** Estatura en metros */
    private double estatura;
    
    /** Edad del cliente */
    private int edad;
    
    /** Objetivos de entrenamiento */
    private String objetivosEntrenamiento;
    
    
    // ==================== CONSTRUCTOR ====================
    
    /**
     * Constructor de la clase Cliente.
     * 
     * @param nombre       Nombre
     * @param idCliente    ID
     * @param rut          RUT
     * @param email        Email
     * @param telefono     Teléfono
     * @param pesoActual   Peso actual
     * @param estatura     Estatura
     * @param edad         Edad
     * @param objetivosEntrenamiento Objetivos
     */
    public Cliente(String nombre, String idCliente, String rut, String email,
                   String telefono, double pesoActual, double estatura, int edad,
                   String objetivosEntrenamiento) {
        this.nombre = nombre;
        this.idCliente = idCliente;
        this.rut = rut;
        this.email = email;
        this.telefono = telefono;
        this.pesoActual = pesoActual;
        this.estatura = estatura;
        this.edad = edad;
        this.objetivosEntrenamiento = objetivosEntrenamiento;
        this.rutinasAsignadas = new ArrayList<>();
        this.historialVisitas = new ArrayList<>();
    }
    
    
    // ==================== MÉTODOS ====================
    
    /**
     * Registra una visita del cliente al gimnasio.
     * 
     * @return true si puede ingresar
     */
    public boolean registrarVisita() {
        if (membresia != null && membresia.puedeIngresar()) {
            boolean ingreso = membresia.registrarVisita();
            if (ingreso) {
                historialVisitas.add(java.time.LocalDate.now().toString());
                System.out.println(nombre + " ha ingresado al gimnasio");
            }
            return ingreso;
        }
        System.out.println(nombre + " no puede ingresar (membresía inválida)");
        return false;
    }
    
    /**
     * Asigna una rutina al cliente.
     * 
     * @param r Rutina a asignar
     */
    public void asignarRutina(RutinaEjercicio r) {
        rutinasAsignadas.add(r);
        System.out.println("Rutina '" + r.getNombreRutina() + "' asignada a " + nombre);
    }
    
    /**
     * Completa una rutina asignada.
     * 
     * @param r Rutina completada
     */
    public void completarRutina(RutinaEjercicio r) {
        if (rutinasAsignadas.contains(r)) {
            r.ejecutar();
            System.out.println(nombre + " ha completado la rutina");
        }
    }
    
    /**
     * Obtiene el número de visitas en el mes actual.
     * 
     * @return Número de visitas
     */
    public int getVisitasMes() {
        String mesActual = java.time.LocalDate.now().getMonth().toString();
        int contador = 0;
        for (String visita : historialVisitas) {
            if (visita.contains(mesActual.substring(0, 3))) {
                contador++;
            }
        }
        return contador;
    }
    
    /**
     * Verifica si el cliente puede ingresar al gimnasio.
     * 
     * @return true si puede ingresar
     */
    public boolean puedeIngresar() {
        return membresia != null && membresia.puedeIngresar();
    }
    
    /**
     * Calcula el índice de masa corporal (IMC).
     * 
     * @return IMC
     */
    public double calcularIMC() {
        if (estatura <= 0) return 0;
        return pesoActual / (estatura * estatura);
    }
    
    
    // ==================== GETTERS Y SETTERS ====================
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getIdCliente() { return idCliente; }
    public void setIdCliente(String idCliente) { this.idCliente = idCliente; }
    
    public String getRut() { return rut; }
    public void setRut(String rut) { this.rut = rut; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    
    public Membresia getMembresia() { return membresia; }
    public void setMembresia(Membresia membresia) { this.membresia = membresia; }
    
    public List<RutinaEjercicio> getRutinasAsignadas() { return rutinasAsignadas; }
    
    public List<String> getHistorialVisitas() { return historialVisitas; }
    
    public double getPesoActual() { return pesoActual; }
    public void setPesoActual(double pesoActual) { this.pesoActual = pesoActual; }
    
    public double getEstatura() { return estatura; }
    public void setEstatura(double estatura) { this.estatura = estatura; }
    
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    
    public String getObjetivosEntrenamiento() { return objetivosEntrenamiento; }
    public void setObjetivosEntrenamiento(String objetivosEntrenamiento) { this.objetivosEntrenamiento = objetivosEntrenamiento; }
}
// fin de la clase Cliente