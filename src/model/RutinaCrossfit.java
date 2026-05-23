package model;

import enums.NivelRutina;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una rutina de CrossFit (WOD - Workout of the Day).
 * 
 * @author ISC Israel de Jesús Mar Parada (MPFx++)
 * @version 1.0.0
 */
public class RutinaCrossfit extends RutinaEjercicio {
    
    // ==================== ATRIBUTOS ESPECÍFICOS ====================
    
    /** Tipo de WOD (AMRAP, EMOM, For Time, etc.) */
    private String tipoWOD;
    
    /** Indica si incluye equipo especial */
    private boolean incluyeEquipoEspecial;
    
    /** Materiales necesarios para la rutina */
    private List<String> materialesNecesarios;
    
    /** Número de rondas del WOD */
    private int rondas;
    
    /** Tiempo límite para completar (minutos) */
    private int tiempoLímite;
    
    /** Indica si incluye pesas */
    private boolean incluyePesas;
    
    /** Nivel de dificultad del WOD */
    private String nivelDificultadWOD;
    
    /** Calorías objetivo (para cardio WODs) */
    private int caloriasObjetivo;
    
    /** Peso máximo recomendado */
    private double pesoMaximoRecomendado;
    
    /** Estilo de entrenamiento */
    private String estiloEntrenamiento;
    
    
    // ==================== CONSTRUCTOR ====================
    
    /**
     * Constructor de la clase RutinaCrossfit.
     * 
     * @param nombreRutina              Nombre
     * @param descripcion               Descripción
     * @param nivel                     Nivel
     * @param duracionMinutos           Duración
     * @param caloriasEstimadas         Calorías
     * @param intensidad                Intensidad
     * @param dificultad                Dificultad
     * @param tipoWOD                   Tipo WOD
     * @param incluyeEquipoEspecial     Equipo especial
     * @param materialesNecesarios      Materiales
     * @param rondas                    Rondas
     * @param tiempoLímite              Tiempo límite
     * @param incluyePesas              Incluye pesas
     * @param nivelDificultadWOD        Nivel dificultad
     * @param caloriasObjetivo          Calorías objetivo
     * @param pesoMaximoRecomendado     Peso máximo
     * @param estiloEntrenamiento       Estilo entrenamiento
     */
    public RutinaCrossfit(String nombreRutina, String descripcion, NivelRutina nivel,
                          int duracionMinutos, int caloriasEstimadas, String intensidad,
                          int dificultad, String tipoWOD, boolean incluyeEquipoEspecial,
                          List<String> materialesNecesarios, int rondas, int tiempoLímite,
                          boolean incluyePesas, String nivelDificultadWOD, int caloriasObjetivo,
                          double pesoMaximoRecomendado, String estiloEntrenamiento) {
        super(nombreRutina, descripcion, nivel, duracionMinutos, caloriasEstimadas, intensidad, dificultad);
        this.tipoWOD = tipoWOD;
        this.incluyeEquipoEspecial = incluyeEquipoEspecial;
        this.materialesNecesarios = materialesNecesarios;
        this.rondas = rondas;
        this.tiempoLímite = tiempoLímite;
        this.incluyePesas = incluyePesas;
        this.nivelDificultadWOD = nivelDificultadWOD;
        this.caloriasObjetivo = caloriasObjetivo;
        this.pesoMaximoRecomendado = pesoMaximoRecomendado;
        this.estiloEntrenamiento = estiloEntrenamiento;
    }
    
    
    // ==================== MÉTODOS SOBRESCRITOS ====================
    
    /**
     * Obtiene la lista de ejercicios del WOD.
     * 
     * @return Lista de ejercicios
     */
    @Override
    public List<String> getEjercicios() {
        List<String> ejercicios = new ArrayList<>();
        ejercicios.add("Tipo de WOD: " + tipoWOD);
        for (int i = 1; i <= rondas; i++) {
            ejercicios.add("Ronda " + i + ": " + descripcionEjercicios());
        }
        return ejercicios;
    }
    
    /**
     * Obtiene recomendaciones para la rutina de CrossFit.
     * 
     * @return Recomendaciones
     */
    @Override
    public String getRecomendaciones() {
        StringBuilder rec = new StringBuilder();
        rec.append("🏋️ WOD: ").append(tipoWOD).append("\n");
        rec.append("⏱️ Tiempo límite: ").append(tiempoLímite).append(" minutos\n");
        rec.append("🔄 Rondas: ").append(rondas).append("\n");
        rec.append("🎯 ").append(rondas).append(" rondas para completar\n");
        rec.append("🏋️‍♂️ Estilo: ").append(estiloEntrenamiento).append("\n");
        rec.append("📊 Nivel: ").append(nivelDificultadWOD).append("\n");
        if (caloriasObjetivo > 0) {
            rec.append("🔥 Calorías objetivo: ").append(caloriasObjetivo).append("\n");
        }
        if (pesoMaximoRecomendado > 0) {
            rec.append("🏋️ Peso máximo recomendado: ").append(pesoMaximoRecomendado).append(" kg\n");
        }
        rec.append("🛠️ Materiales: ").append(String.join(", ", materialesNecesarios));
        return rec.toString();
    }
    
    private String descripcionEjercicios() {
        return "Ejercicios del WOD (detalles específicos de CrossFit)";
    }
    
    
    // ==================== GETTERS Y SETTERS ====================
    
    public String getTipoWOD() { return tipoWOD; }
    public void setTipoWOD(String tipoWOD) { this.tipoWOD = tipoWOD; }
    
    public boolean isIncluyeEquipoEspecial() { return incluyeEquipoEspecial; }
    public void setIncluyeEquipoEspecial(boolean incluyeEquipoEspecial) { this.incluyeEquipoEspecial = incluyeEquipoEspecial; }
    
    public List<String> getMaterialesNecesarios() { return materialesNecesarios; }
    public void setMaterialesNecesarios(List<String> materialesNecesarios) { this.materialesNecesarios = materialesNecesarios; }
    
    public int getRondas() { return rondas; }
    public void setRondas(int rondas) { this.rondas = rondas; }
    
    public int getTiempoLímite() { return tiempoLímite; }
    public void setTiempoLímite(int tiempoLímite) { this.tiempoLímite = tiempoLímite; }
    
    public boolean isIncluyePesas() { return incluyePesas; }
    public void setIncluyePesas(boolean incluyePesas) { this.incluyePesas = incluyePesas; }
    
    public String getNivelDificultadWOD() { return nivelDificultadWOD; }
    public void setNivelDificultadWOD(String nivelDificultadWOD) { this.nivelDificultadWOD = nivelDificultadWOD; }
    
    public int getCaloriasObjetivo() { return caloriasObjetivo; }
    public void setCaloriasObjetivo(int caloriasObjetivo) { this.caloriasObjetivo = caloriasObjetivo; }
    
    public double getPesoMaximoRecomendado() { return pesoMaximoRecomendado; }
    public void setPesoMaximoRecomendado(double pesoMaximoRecomendado) { this.pesoMaximoRecomendado = pesoMaximoRecomendado; }
    
    public String getEstiloEntrenamiento() { return estiloEntrenamiento; }
    public void setEstiloEntrenamiento(String estiloEntrenamiento) { this.estiloEntrenamiento = estiloEntrenamiento; }
}
// fin de la clase RutinaCrossfit