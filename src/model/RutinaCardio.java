package model;

import enums.NivelRutina;
import java.util.Arrays;
import java.util.List;

/**
 * Clase que representa una rutina de ejercicio cardiovascular.
 * 
 * @author ISC Israel de Jesús Mar Parada (MPFx++)
 * @version 1.0.0
 */
public class RutinaCardio extends RutinaEjercicio {
    
    // ==================== ATRIBUTOS ESPECÍFICOS ====================
    
    /** Frecuencia cardíaca objetivo (ppm) */
    private int frecuenciaCardiacaObjetivo;
    
    /** Indica si incluye calentamiento */
    private boolean incluyeCalentamiento;
    
    /** Indica si incluye enfriamiento */
    private boolean incluyeEnfriamiento;
    
    /** Lista de ejercicios cardio */
    private List<String> ejerciciosCardio;
    
    /** Tipo de cardio (Continua, Intervalos, HIIT) */
    private String tipoCardio;
    
    /** Número de intervalos (si aplica) */
    private int intervalos;
    
    /** Tiempo de descanso entre intervalos (segundos) */
    private int tiempoDescanso;
    
    /** Distancia estimada recorrida (km) */
    private double distanciaEstimada;
    
    
    // ==================== CONSTRUCTOR ====================
    
    /**
     * Constructor de la clase RutinaCardio.
     * 
     * @param nombreRutina              Nombre
     * @param descripcion               Descripción
     * @param nivel                     Nivel
     * @param duracionMinutos           Duración
     * @param caloriasEstimadas         Calorías
     * @param intensidad                Intensidad
     * @param dificultad                Dificultad
     * @param frecuenciaCardiacaObjetivo Frecuencia cardíaca
     * @param incluyeCalentamiento      Incluye calentamiento
     * @param incluyeEnfriamiento       Incluye enfriamiento
     * @param ejerciciosCardio          Ejercicios
     * @param tipoCardio                Tipo cardio
     * @param intervalos                Intervalos
     * @param tiempoDescanso            Tiempo descanso
     * @param distanciaEstimada         Distancia estimada
     */
    public RutinaCardio(String nombreRutina, String descripcion, NivelRutina nivel,
                        int duracionMinutos, int caloriasEstimadas, String intensidad,
                        int dificultad, int frecuenciaCardiacaObjetivo, boolean incluyeCalentamiento,
                        boolean incluyeEnfriamiento, List<String> ejerciciosCardio, String tipoCardio,
                        int intervalos, int tiempoDescanso, double distanciaEstimada) {
        super(nombreRutina, descripcion, nivel, duracionMinutos, caloriasEstimadas, intensidad, dificultad);
        this.frecuenciaCardiacaObjetivo = frecuenciaCardiacaObjetivo;
        this.incluyeCalentamiento = incluyeCalentamiento;
        this.incluyeEnfriamiento = incluyeEnfriamiento;
        this.ejerciciosCardio = ejerciciosCardio;
        this.tipoCardio = tipoCardio;
        this.intervalos = intervalos;
        this.tiempoDescanso = tiempoDescanso;
        this.distanciaEstimada = distanciaEstimada;
    }
    
    
    // ==================== MÉTODOS SOBRESCRITOS ====================
    
    /**
     * Obtiene la lista de ejercicios de cardio.
     * 
     * @return Lista de ejercicios
     */
    @Override
    public List<String> getEjercicios() {
        return ejerciciosCardio;
    }
    
    /**
     * Obtiene recomendaciones para la rutina de cardio.
     * 
     * @return Recomendaciones
     */
    @Override
    public String getRecomendaciones() {
        return "🎯 Mantén tu frecuencia cardíaca entre " + frecuenciaCardiacaObjetivo + 
               " ppm\n💧 Hidrátate cada 15 minutos\n" +
               (incluyeCalentamiento ? "✅ Calentamiento incluido (5 min)\n" : "⚠️ Realiza calentamiento antes de empezar\n") +
               (incluyeEnfriamiento ? "✅ Enfriamiento incluido (5 min)\n" : "⚠️ Realiza enfriamiento al terminar\n") +
               "🏃 Tipo: " + tipoCardio + "\n" +
               (intervalos > 0 ? "🔄 " + intervalos + " intervalos con " + tiempoDescanso + "s de descanso\n" : "") +
               "📏 Distancia estimada: " + distanciaEstimada + " km";
    }
    
    
    // ==================== GETTERS Y SETTERS ====================
    
    public int getFrecuenciaCardiacaObjetivo() { return frecuenciaCardiacaObjetivo; }
    public void setFrecuenciaCardiacaObjetivo(int frecuenciaCardiacaObjetivo) { this.frecuenciaCardiacaObjetivo = frecuenciaCardiacaObjetivo; }
    
    public boolean isIncluyeCalentamiento() { return incluyeCalentamiento; }
    public void setIncluyeCalentamiento(boolean incluyeCalentamiento) { this.incluyeCalentamiento = incluyeCalentamiento; }
    
    public boolean isIncluyeEnfriamiento() { return incluyeEnfriamiento; }
    public void setIncluyeEnfriamiento(boolean incluyeEnfriamiento) { this.incluyeEnfriamiento = incluyeEnfriamiento; }
    
    public List<String> getEjerciciosCardio() { return ejerciciosCardio; }
    public void setEjerciciosCardio(List<String> ejerciciosCardio) { this.ejerciciosCardio = ejerciciosCardio; }
    
    public String getTipoCardio() { return tipoCardio; }
    public void setTipoCardio(String tipoCardio) { this.tipoCardio = tipoCardio; }
    
    public int getIntervalos() { return intervalos; }
    public void setIntervalos(int intervalos) { this.intervalos = intervalos; }
    
    public int getTiempoDescanso() { return tiempoDescanso; }
    public void setTiempoDescanso(int tiempoDescanso) { this.tiempoDescanso = tiempoDescanso; }
    
    public double getDistanciaEstimada() { return distanciaEstimada; }
    public void setDistanciaEstimada(double distanciaEstimada) { this.distanciaEstimada = distanciaEstimada; }
}
// fin de la clase RutinaCardio