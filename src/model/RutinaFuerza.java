package model;

import enums.NivelRutina;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una rutina de ejercicio de fuerza.
 * 
 * @author ISC Israel de Jesús Mar Parada (MPFx++)
 * @version 1.0.0
 */
public class RutinaFuerza extends RutinaEjercicio {
    
    // ==================== ATRIBUTOS ESPECÍFICOS ====================
    
    /** Número de series por ejercicio */
    private int seriesPorEjercicio;
    
    /** Número de repeticiones por serie */
    private int repeticionesPorSerie;
    
    /** Peso recomendado en kg */
    private double pesoRecomendado;
    
    /** Grupos musculares trabajados */
    private List<String> gruposMusculares;
    
    /** Tipo de equipamiento necesario */
    private String tipoEquipamiento;
    
    /** Tiempo de descanso entre series (segundos) */
    private int tiempoDescansoEntreSeries;
    
    /** Indica si incluye peso corporal */
    private boolean incluyePesoCorporal;
    
    /** Progresión semanal de peso (kg) */
    private double progresionSemanal;
    
    /** Número de ejercicios por grupo muscular */
    private int ejerciciosPorGrupo;
    
    
    // ==================== CONSTRUCTOR ====================
    
    /**
     * Constructor de la clase RutinaFuerza.
     * 
     * @param nombreRutina              Nombre
     * @param descripcion               Descripción
     * @param nivel                     Nivel
     * @param duracionMinutos           Duración
     * @param caloriasEstimadas         Calorías
     * @param intensidad                Intensidad
     * @param dificultad                Dificultad
     * @param seriesPorEjercicio        Series
     * @param repeticionesPorSerie      Repeticiones
     * @param pesoRecomendado           Peso recomendado
     * @param gruposMusculares          Grupos musculares
     * @param tipoEquipamiento          Equipamiento
     * @param tiempoDescansoEntreSeries Descanso
     * @param incluyePesoCorporal       Peso corporal
     * @param progresionSemanal         Progresión
     * @param ejerciciosPorGrupo        Ejercicios por grupo
     */
    public RutinaFuerza(String nombreRutina, String descripcion, NivelRutina nivel,
                        int duracionMinutos, int caloriasEstimadas, String intensidad,
                        int dificultad, int seriesPorEjercicio, int repeticionesPorSerie,
                        double pesoRecomendado, List<String> gruposMusculares, String tipoEquipamiento,
                        int tiempoDescansoEntreSeries, boolean incluyePesoCorporal,
                        double progresionSemanal, int ejerciciosPorGrupo) {
        super(nombreRutina, descripcion, nivel, duracionMinutos, caloriasEstimadas, intensidad, dificultad);
        this.seriesPorEjercicio = seriesPorEjercicio;
        this.repeticionesPorSerie = repeticionesPorSerie;
        this.pesoRecomendado = pesoRecomendado;
        this.gruposMusculares = gruposMusculares;
        this.tipoEquipamiento = tipoEquipamiento;
        this.tiempoDescansoEntreSeries = tiempoDescansoEntreSeries;
        this.incluyePesoCorporal = incluyePesoCorporal;
        this.progresionSemanal = progresionSemanal;
        this.ejerciciosPorGrupo = ejerciciosPorGrupo;
    }
    
    
    // ==================== MÉTODOS SOBRESCRITOS ====================
    
    /**
     * Obtiene la lista de ejercicios de fuerza.
     * 
     * @return Lista de ejercicios
     */
    @Override
    public List<String> getEjercicios() {
        List<String> ejercicios = new ArrayList<>();
        for (String grupo : gruposMusculares) {
            for (int i = 1; i <= ejerciciosPorGrupo; i++) {
                ejercicios.add(grupo + " - Ejercicio " + i + ": " + seriesPorEjercicio + 
                              "x" + repeticionesPorSerie + " (" + pesoRecomendado + " kg)");
            }
        }
        return ejercicios;
    }
    
    /**
     * Obtiene recomendaciones para la rutina de fuerza.
     * 
     * @return Recomendaciones
     */
    @Override
    public String getRecomendaciones() {
        return "🏋️ Series: " + seriesPorEjercicio + " | Repeticiones: " + repeticionesPorSerie +
               "\n💪 Peso recomendado: " + pesoRecomendado + " kg" +
               "\n⏱️ Descanso entre series: " + tiempoDescansoEntreSeries + " segundos" +
               "\n🎯 Grupos musculares: " + String.join(", ", gruposMusculares) +
               "\n🛠️ Equipamiento: " + tipoEquipamiento +
               (incluyePesoCorporal ? "\n✅ Incluye ejercicios con peso corporal" : "") +
               "\n📈 Progresión semanal: +" + progresionSemanal + " kg";
    }
    
    
    // ==================== GETTERS Y SETTERS ====================
    
    public int getSeriesPorEjercicio() { return seriesPorEjercicio; }
    public void setSeriesPorEjercicio(int seriesPorEjercicio) { this.seriesPorEjercicio = seriesPorEjercicio; }
    
    public int getRepeticionesPorSerie() { return repeticionesPorSerie; }
    public void setRepeticionesPorSerie(int repeticionesPorSerie) { this.repeticionesPorSerie = repeticionesPorSerie; }
    
    public double getPesoRecomendado() { return pesoRecomendado; }
    public void setPesoRecomendado(double pesoRecomendado) { this.pesoRecomendado = pesoRecomendado; }
    
    public List<String> getGruposMusculares() { return gruposMusculares; }
    public void setGruposMusculares(List<String> gruposMusculares) { this.gruposMusculares = gruposMusculares; }
    
    public String getTipoEquipamiento() { return tipoEquipamiento; }
    public void setTipoEquipamiento(String tipoEquipamiento) { this.tipoEquipamiento = tipoEquipamiento; }
    
    public int getTiempoDescansoEntreSeries() { return tiempoDescansoEntreSeries; }
    public void setTiempoDescansoEntreSeries(int tiempoDescansoEntreSeries) { this.tiempoDescansoEntreSeries = tiempoDescansoEntreSeries; }
    
    public boolean isIncluyePesoCorporal() { return incluyePesoCorporal; }
    public void setIncluyePesoCorporal(boolean incluyePesoCorporal) { this.incluyePesoCorporal = incluyePesoCorporal; }
    
    public double getProgresionSemanal() { return progresionSemanal; }
    public void setProgresionSemanal(double progresionSemanal) { this.progresionSemanal = progresionSemanal; }
    
    public int getEjerciciosPorGrupo() { return ejerciciosPorGrupo; }
    public void setEjerciciosPorGrupo(int ejerciciosPorGrupo) { this.ejerciciosPorGrupo = ejerciciosPorGrupo; }
}
// fin de la clase RutinaFuerza