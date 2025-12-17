package com.aquafitness.modelo;

import com.aquafitness.excepciones.CuposAgotadosException;
import com.aquafitness.excepciones.ActividadInactivaException;

/**
 * Clase SwimmingLesson - Lección de natación
 * @author Santiago Salamanca Narváez
 * @version 2.0 - Semana 07
 */
public class SwimmingLesson extends AquaticActivity {
    private String level; // Bebés, Niños, Adultos, Avanzado
    private String techniquesFocus;
    private boolean includesCertification;
    
    /**
     * Constructor con validaciones
     * @throws IllegalArgumentException si el nivel o técnicas son inválidos
     */
    public SwimmingLesson(String activityCode, String activityName, String instructorName,
                         String schedule, int durationMinutes, double pricePerSession,
                         int maxParticipants, String level, String techniquesFocus,
                         boolean includesCertification) {
        super(activityCode, activityName, instructorName, schedule, durationMinutes,
              pricePerSession, maxParticipants);
        
        // Validaciones específicas
        if (level == null || level.trim().isEmpty()) {
            throw new IllegalArgumentException("El nivel no puede estar vacío");
        }
        if (!isValidLevel(level)) {
            throw new IllegalArgumentException(
                "Nivel inválido. Debe ser: Bebés, Niños, Adultos o Avanzado"
            );
        }
        
        this.level = level;
        this.techniquesFocus = techniquesFocus;
        this.includesCertification = includesCertification;
    }
    
    /**
     * Valida que el nivel sea uno de los permitidos
     */
    private boolean isValidLevel(String level) {
        return level.equals("Bebés") || level.equals("Niños") || 
               level.equals("Adultos") || level.equals("Avanzado");
    }
    
    @Override
    public double calculateMonthlyPrice() {
        double basePrice = pricePerSession * 3 * 4; // 3 sesiones/semana * 4 semanas
        
        if (level.equals("Bebés")) {
            return basePrice * 1.2; // 20% más por cuidado especial
        } else if (level.equals("Adultos")) {
            return basePrice * 0.9; // 10% descuento
        }
        return basePrice;
    }
    
    @Override
    public String getActivityType() {
        return "Clase de Natación - " + level;
    }
    
    @Override
    public void showInfo() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║     CLASE DE NATACIÓN                  ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Código: " + activityCode);
        System.out.println("Nombre: " + activityName);
        System.out.println("Nivel: " + level);
        System.out.println("Instructor: " + instructorName);
        System.out.println("Horario: " + schedule);
        System.out.println("Duración: " + durationMinutes + " minutos");
        System.out.println("Técnicas: " + techniquesFocus);
        System.out.println("Certificación: " + (includesCertification ? "Sí" : "No"));
        System.out.println("Precio/sesión: $" + pricePerSession);
        System.out.println("Precio mensual: $" + calculateMonthlyPrice());
        System.out.println("Cupos: " + currentParticipants + "/" + maxParticipants);
        System.out.println("Estado: " + (isActive ? "Activa" : "Inactiva"));
    }
    
    // Getters
    public String getLevel() { return level; }
    public String getTechniquesFocus() { return techniquesFocus; }
    public boolean includesCertification() { return includesCertification; }
}
