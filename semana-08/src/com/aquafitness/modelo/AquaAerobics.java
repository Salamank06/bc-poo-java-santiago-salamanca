package com.aquafitness.modelo;

import com.aquafitness.excepciones.CuposAgotadosException;
import com.aquafitness.excepciones.ActividadInactivaException;

/**
 * Clase AquaAerobics - Clase de aquaeróbicos
 * @author Santiago Salamanca Narváez
 * @version 3.0 - Semana 08
 */
public class AquaAerobics extends AquaticActivity {
    private String intensityLevel; // Baja, Media, Alta
    private String musicGenre;
    private boolean requiresEquipment;
    
    /**
     * Constructor con validaciones
     */
    public AquaAerobics(String activityCode, String activityName, String instructorName,
                       String schedule, int durationMinutes, double pricePerSession,
                       int maxParticipants, String intensityLevel, String musicGenre,
                       boolean requiresEquipment) {
        super(activityCode, activityName, instructorName, schedule, durationMinutes,
              pricePerSession, maxParticipants);
        
        // Validaciones
        if (intensityLevel == null || intensityLevel.trim().isEmpty()) {
            throw new IllegalArgumentException("La intensidad no puede estar vacía");
        }
        if (!isValidIntensity(intensityLevel)) {
            throw new IllegalArgumentException(
                "Intensidad inválida. Debe ser: Baja, Media o Alta"
            );
        }
        
        this.intensityLevel = intensityLevel;
        this.musicGenre = musicGenre;
        this.requiresEquipment = requiresEquipment;
    }
    
    private boolean isValidIntensity(String intensity) {
        return intensity.equals("Baja") || intensity.equals("Media") || intensity.equals("Alta");
    }
    
    @Override
    public double calculateMonthlyPrice() {
        double basePrice = pricePerSession * 3 * 4;
        if (requiresEquipment) {
            return basePrice + 20000; // Cargo por equipo
        }
        return basePrice;
    }
    
    @Override
    public String getActivityType() {
        return "Aquaeróbicos - Intensidad " + intensityLevel;
    }
    
    @Override
    public void showInfo() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║     AQUAERÓBICOS                       ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Código: " + activityCode);
        System.out.println("Nombre: " + activityName);
        System.out.println("Intensidad: " + intensityLevel);
        System.out.println("Instructor: " + instructorName);
        System.out.println("Horario: " + schedule);
        System.out.println("Duración: " + durationMinutes + " minutos");
        System.out.println("Música: " + musicGenre);
        System.out.println("Requiere equipo: " + (requiresEquipment ? "Sí" : "No"));
        System.out.println("Precio/sesión: $" + pricePerSession);
        System.out.println("Precio mensual: $" + calculateMonthlyPrice());
        System.out.println("Cupos: " + currentParticipants + "/" + maxParticipants);
        System.out.println("Estado: " + (isActive ? "Activa" : "Inactiva"));
    }
    
    // Getters
    public String getIntensityLevel() { return intensityLevel; }
    public String getMusicGenre() { return musicGenre; }
    public boolean requiresEquipment() { return requiresEquipment; }
}
