package com.aquafitness.modelo;

import com.aquafitness.interfaces.Reservable;
import com.aquafitness.interfaces.Evaluable;
import java.util.ArrayList;

/**
 * Clase SwimmingLesson - Lección de natación
 * Implementa Reservable y Evaluable
 * @author Santiago Salamanca Narváez
 * @version 2.0 - Semana 06
 */
public class SwimmingLesson extends AquaticActivity implements Reservable, Evaluable {
    private String level;
    private String techniquesFocus;
    private boolean includesCertification;
    
    private ArrayList<String> reservas = new ArrayList<>();
    private ArrayList<Integer> calificaciones = new ArrayList<>();
    private int contadorReservas = 1000;
    
    public SwimmingLesson(String activityCode, String activityName, String instructorName,
                         String schedule, int durationMinutes, double pricePerSession,
                         int maxParticipants, String level, String techniquesFocus,
                         boolean includesCertification) {
        super(activityCode, activityName, instructorName, schedule, durationMinutes,
              pricePerSession, maxParticipants);
        this.level = level;
        this.techniquesFocus = techniquesFocus;
        this.includesCertification = includesCertification;
    }
    
    @Override
    public double calculateMonthlyPrice() {
        double basePrice = pricePerSession * 3 * 4;
        if (level.equals("Bebés")) return basePrice * 1.2;
        if (level.equals("Adultos")) return basePrice * 0.9;
        return basePrice;
    }
    
    @Override
    public String getActivityType() {
        return "Clase de Natación - " + level;
    }
    
    @Override
    public void showInfo() {
        System.out.println("=== CLASE DE NATACIÓN ===");
        System.out.println("Código: " + activityCode);
        System.out.println("Nivel: " + level);
        System.out.println("Precio mensual: $" + calculateMonthlyPrice());
    }
    
    // Implementación de Reservable
    @Override
    public boolean verificarDisponibilidad(String fecha) {
        return getAvailableSpots() > 0;
    }
    
    @Override
    public String realizarReserva(String nombreCliente, String fecha, int numeroCupos) {
        String codigo = activityCode + "-R" + (contadorReservas++);
        reservas.add(codigo);
        for (int i = 0; i < numeroCupos; i++) enrollParticipant();
        return codigo;
    }
    
    @Override
    public boolean cancelarReserva(String codigoReserva) {
        return reservas.remove(codigoReserva);
    }
    
    @Override
    public int obtenerNumeroReservas() {
        return reservas.size();
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
    
    public String getLevel() { return level; }
}

