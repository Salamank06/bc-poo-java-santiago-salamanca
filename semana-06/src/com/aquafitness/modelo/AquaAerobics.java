package com.aquafitness.modelo;

import com.aquafitness.interfaces.Evaluable;
import com.aquafitness.interfaces.Cancelable;
import java.util.ArrayList;

/**
 * Clase AquaAerobics - Aquaeróbicos
 * Implementa Evaluable y Cancelable
 * @author Santiago Salamanca Narváez
 * @version 2.0 - Semana 06
 */
public class AquaAerobics extends AquaticActivity implements Evaluable, Cancelable {
    private String intensityLevel;
    private String musicGenre;
    private boolean requiresEquipment;
    
    private ArrayList<Integer> calificaciones = new ArrayList<>();
    
    public AquaAerobics(String activityCode, String activityName, String instructorName,
                       String schedule, int durationMinutes, double pricePerSession,
                       int maxParticipants, String intensityLevel, String musicGenre,
                       boolean requiresEquipment) {
        super(activityCode, activityName, instructorName, schedule, durationMinutes,
              pricePerSession, maxParticipants);
        this.intensityLevel = intensityLevel;
        this.musicGenre = musicGenre;
        this.requiresEquipment = requiresEquipment;
    }
    
    @Override
    public double calculateMonthlyPrice() {
        double basePrice = pricePerSession * 3 * 4;
        return requiresEquipment ? basePrice + 20000 : basePrice;
    }
    
    @Override
    public String getActivityType() {
        return "Aquaeróbicos - " + intensityLevel;
    }
    
    @Override
    public void showInfo() {
        System.out.println("=== AQUAERÓBICOS ===");
        System.out.println("Código: " + activityCode);
        System.out.println("Intensidad: " + intensityLevel);
        System.out.println("Precio mensual: $" + calculateMonthlyPrice());
    }
    
    // Implementación de Evaluable
    @Override
    public void agregarCalificacion(int estrellas, String comentario, String nombreParticipante) {
        calificaciones.add(estrellas);
    }
    
    @Override
    public double obtenerPromedioCalificaciones() {
        if (calificaciones.isEmpty()) return 0.0;
        return calificaciones.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }
    
    @Override
    public int obtenerNumeroEvaluaciones() {
        return calificaciones.size();
    }
    
    @Override
    public boolean tieneCalificacionAlta() {
        return obtenerPromedioCalificaciones() >= 4.0;
    }
    
    // Implementación de Cancelable
    @Override
    public boolean cancelarInscripcion(String nombreParticipante, String motivo) {
        return withdrawParticipant();
    }
    
    @Override
    public double calcularReembolso(int diasAnticipacion, double montoTotal) {
        if (diasAnticipacion >= 7) return montoTotal;
        if (diasAnticipacion >= 3) return montoTotal * 0.5;
        if (diasAnticipacion >= 1) return montoTotal * 0.25;
        return 0;
    }
    
    @Override
    public boolean esCancelable(int diasAnticipacion) {
        return true;
    }
    
    @Override
    public String obtenerPoliticaCancelacion() {
        return "≥7 días: 100% | 3-6 días: 50% | 1-2 días: 25% | <1 día: 0%";
    }
    
    public String getIntensityLevel() { return intensityLevel; }
}

