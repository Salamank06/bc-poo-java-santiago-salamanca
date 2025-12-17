package com.aquafitness.modelo;

import java.util.ArrayList;

/**
 * Clase abstracta AquaticActivity - Representa una actividad acuática genérica
 * Define el comportamiento común y abstracto para todas las actividades del centro
 * @author Santiago Salamanca Narváez
 * @version 2.0 - Semana 06 (Con paquetes)
 */
public abstract class AquaticActivity {
    // Atributos protegidos (compartidos con subclases)
    protected String activityCode;
    protected String activityName;
    protected String instructorName;
    protected String schedule;
    protected int durationMinutes;
    protected double pricePerSession;
    protected int maxParticipants;
    protected int currentParticipants;
    protected boolean isActive;
    
    /**
     * Constructor de la clase abstracta
     */
    public AquaticActivity(String activityCode, String activityName, String instructorName,
                          String schedule, int durationMinutes, double pricePerSession,
                          int maxParticipants) {
        this.activityCode = activityCode;
        this.activityName = activityName;
        this.instructorName = instructorName;
        this.schedule = schedule;
        this.durationMinutes = durationMinutes;
        this.pricePerSession = pricePerSession;
        this.maxParticipants = maxParticipants;
        this.currentParticipants = 0;
        this.isActive = true;
    }
    
    // Métodos abstractos
    public abstract double calculateMonthlyPrice();
    public abstract String getActivityType();
    public abstract void showInfo();
    
    // Métodos concretos
    public boolean enrollParticipant() {
        if (currentParticipants < maxParticipants) {
            currentParticipants++;
            System.out.println("✓ Participante inscrito en " + activityCode);
            return true;
        } else {
            System.out.println("✗ Sin cupos disponibles en " + activityCode);
            return false;
        }
    }
    
    public boolean withdrawParticipant() {
        if (currentParticipants > 0) {
            currentParticipants--;
            System.out.println("✓ Participante dado de baja de " + activityCode);
            return true;
        } else {
            System.out.println("✗ No hay participantes inscritos en " + activityCode);
            return false;
        }
    }
    
    public int getAvailableSpots() {
        return maxParticipants - currentParticipants;
    }
    
    public boolean isFull() {
        return currentParticipants >= maxParticipants;
    }
    
    public void setActive(boolean active) {
        this.isActive = active;
        System.out.println(activityCode + " " + (active ? "activada" : "desactivada"));
    }
    
    // Getters
    public String getActivityCode() { return activityCode; }
    public String getActivityName() { return activityName; }
    public String getInstructorName() { return instructorName; }
    public String getSchedule() { return schedule; }
    public int getDurationMinutes() { return durationMinutes; }
    public double getPricePerSession() { return pricePerSession; }
    public int getMaxParticipants() { return maxParticipants; }
    public int getCurrentParticipants() { return currentParticipants; }
    public boolean isActive() { return isActive; }
    
    // Setters
    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }
    
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
    
    public void setPricePerSession(double pricePerSession) {
        if (pricePerSession > 0) {
            this.pricePerSession = pricePerSession;
        }
    }
}


