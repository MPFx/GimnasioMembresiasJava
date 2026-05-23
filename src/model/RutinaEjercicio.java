package model;

import enums.NivelRutina;
import java.util.List;

/**
 * Clase abstracta que representa una rutina de ejercicio genérica.
 * Contiene atributos y métodos comunes a todas las rutinas.
 * 
 * @author ISC Israel de Jesús Mar Parada (MPFx++)
 * @version 1.0.0
 */
public abstract class RutinaEjercicio {
    
    // ==================== ATRIBUTOS ====================
    
    /** Nombre de la rutina */
    private String nombreRutina;
    
    /** Descripción de la rutina */
    private String descripcion;
    
    /** Nivel de dificultad */
    private NivelRutina nivel;
    
    /** Duración en minutos */
    private int duracionMinutos;
    
    /** Calorías estimadas a quemar */
    private int caloriasEstimadas;
    
    /** Intensidad (Baja, Media, Alta) */
    private String intensidad;
    
    /** Dificultad numérica (1-10) */
    private int dificultad;
    
    /** Puntuación media de usuarios */
    private double puntuacionMedia;
    
    /** Número de veces realizada */
    private int vecesRealizada;
    
    
    // ==================== CONSTRUCTOR ====================
    
    /**
     * Constructor de la clase RutinaEjercicio.
     * 
     * @param nombreRutina     Nombre de la rutina
     * @param descripcion      Descripción
     * @param nivel            Nivel
     * @param duracionMinutos  Duración
     * @param caloriasEstimadas Calorías estimadas
     * @param intensidad       Intensidad
     * @param dificultad       Dificultad (1-10)
     */
    public RutinaEjercicio(String nombreRutina, String descripcion, NivelRutina nivel,
                           int duracionMinutos, int caloriasEstimadas, String intensidad,
                           int dificultad) {
        this.nombreRutina = nombreRutina;
        this.descripcion = descripcion;
        this.nivel = nivel;
        this.duracionMinutos = duracionMinutos;
        this.caloriasEstimadas = caloriasEstimadas;
        this.intensidad = intensidad;
        this.dificultad = dificultad;
        this.puntuacionMedia = 0;
        this.vecesRealizada = 0;
    }
    
    
    // ==================== MÉTODOS ABSTRACTOS ====================
    
    /**
     * Obtiene la lista de ejercicios específicos de la rutina.
     * 
     * @return Lista de ejercicios
     */
    public abstract List<String> getEjercicios();
    
    /**
     * Obtiene recomendaciones específicas para la rutina.
     * 
     * @return Recomendaciones
     */
    public abstract String getRecomendaciones();
    
    
    // ==================== MÉTODOS CONCRETOS ====================
    
    /**
     * Ejecuta la rutina.
     */
    public void ejecutar() {
        System.out.println("\n--- EJECUTANDO RUTINA: " + nombreRutina + " ---");
        System.out.println("Duración: " + duracionMinutos + " minutos");
        System.out.println("Intensidad: " + intensidad);
        System.out.println("Ejercicios:");
        for (String ejercicio : getEjercicios()) {
            System.out.println("  - " + ejercicio);
        }
        registrarRealizacion();
    }
    
    /**
     * Registra una realización de la rutina.
     */
    public void registrarRealizacion() {
        vecesRealizada++;
        System.out.println("Rutina completada! (Total realizaciones: " + vecesRealizada + ")");
    }
    
    /**
     * Actualiza la puntuación media de la rutina.
     * 
     * @param puntuacion Nueva puntuación (1-5)
     */
    public void actualizarPuntuacion(double puntuacion) {
        if (vecesRealizada > 0) {
            puntuacionMedia = (puntuacionMedia * (vecesRealizada - 1) + puntuacion) / vecesRealizada;
        } else {
            puntuacionMedia = puntuacion;
        }
        System.out.println("Nueva puntuación media: " + puntuacionMedia + "★");
    }
    
    
    // ==================== GETTERS Y SETTERS ====================
    
    public String getNombreRutina() { return nombreRutina; }
    public void setNombreRutina(String nombreRutina) { this.nombreRutina = nombreRutina; }
    
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    
    public NivelRutina getNivel() { return nivel; }
    public void setNivel(NivelRutina nivel) { this.nivel = nivel; }
    
    public int getDuracionMinutos() { return duracionMinutos; }
    public void setDuracionMinutos(int duracionMinutos) { this.duracionMinutos = duracionMinutos; }
    
    public int getCaloriasEstimadas() { return caloriasEstimadas; }
    public void setCaloriasEstimadas(int caloriasEstimadas) { this.caloriasEstimadas = caloriasEstimadas; }
    
    public String getIntensidad() { return intensidad; }
    public void setIntensidad(String intensidad) { this.intensidad = intensidad; }
    
    public int getDificultad() { return dificultad; }
    public void setDificultad(int dificultad) { this.dificultad = dificultad; }
    
    public double getPuntuacionMedia() { return puntuacionMedia; }
    
    public int getVecesRealizada() { return vecesRealizada; }
}
// fin de la clase RutinaEjercicio