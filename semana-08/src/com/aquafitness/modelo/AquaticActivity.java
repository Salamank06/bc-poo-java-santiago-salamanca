package com.aquafitness.modelo;

import com.aquafitness.excepciones.CuposAgotadosException;
import com.aquafitness.excepciones.ActividadInactivaException;

/**
 * Clase abstracta AquaticActivity - Representa una actividad acuática genérica
 * Define el comportamiento común y abstracto para todas las actividades
 * 
 * @author Santiago Salamanca Narváez
 * @version 3.0 - Semana 08 (Con colecciones)
 */
public abstract class AquaticActivity {
    // Atributos protegidos
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
     * Constructor con validaciones
     * @param activityCode Código único de la actividad
     * @param activityName Nombre de la actividad
     * @param instructorName Nombre del instructor
     * @param schedule Horario
     * @param durationMinutes Duración en minutos
     * @param pricePerSession Precio por sesión
     * @param maxParticipants Capacidad máxima
     * @throws IllegalArgumentException si algún parámetro es inválido
     */
    public AquaticActivity(String activityCode, String activityName, String instructorName,
                          String schedule, int durationMinutes, double pricePerSession,
                          int maxParticipants) {
        // Validaciones
        if (activityCode == null || activityCode.trim().isEmpty()) {
            throw new IllegalArgumentException("El código de actividad no puede estar vacío");
        }
        if (activityName == null || activityName.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de actividad no puede estar vacío");
        }
        if (durationMinutes <= 0) {
            throw new IllegalArgumentException("La duración debe ser mayor a 0 minutos");
        }
        if (pricePerSession < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        if (maxParticipants <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor a 0");
        }
        
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
    
    /**
     * Inscribe un participante con validaciones
     * @throws CuposAgotadosException si no hay cupos disponibles
     * @throws ActividadInactivaException si la actividad está inactiva
     */
    public void enrollParticipant() throws CuposAgotadosException, ActividadInactivaException {
        if (!isActive) {
            throw new ActividadInactivaException(
                "La actividad " + activityCode + " está inactiva y no acepta inscripciones"
            );
        }
        
        if (currentParticipants >= maxParticipants) {
            throw new CuposAgotadosException(
                "La actividad " + activityCode + " está llena. Cupos: " + 
                currentParticipants + "/" + maxParticipants
            );
        }
        
        currentParticipants++;
        System.out.println("✓ Participante inscrito en " + activityCode + 
                         " (" + currentParticipants + "/" + maxParticipants + ")");
    }
    
    /**
     * Da de baja a un participante
     * @return true si la baja fue exitosa
     */
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
    
    /**
     * Obtiene el número de cupos disponibles
     * @return Cupos disponibles
     */
    public int getAvailableSpots() {
        return maxParticipants - currentParticipants;
    }
    
    /**
     * Verifica si la actividad está llena
     * @return true si no hay cupos
     */
    public boolean isFull() {
        return currentParticipants >= maxParticipants;
    }
    
    /**
     * Activa o desactiva la actividad
     * @param active Estado deseado
     */
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
    
    // Setters con validaciones
    public void setInstructorName(String instructorName) {
        if (instructorName == null || instructorName.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del instructor no puede estar vacío");
        }
        this.instructorName = instructorName;
    }
    
    public void setSchedule(String schedule) {
        if (schedule == null || schedule.trim().isEmpty()) {
            throw new IllegalArgumentException("El horario no puede estar vacío");
        }
        this.schedule = schedule;
    }
    
    public void setPricePerSession(double pricePerSession) {
        if (pricePerSession < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.pricePerSession = pricePerSession;
    }
}
