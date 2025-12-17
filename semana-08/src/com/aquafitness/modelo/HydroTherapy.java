package com.aquafitness.modelo;

import com.aquafitness.excepciones.CuposAgotadosException;
import com.aquafitness.excepciones.ActividadInactivaException;

/**
 * Clase HydroTherapy - Hidroterapia especializada
 * @author Santiago Salamanca Narváez
 * @version 3.0 - Semana 08
 */
public class HydroTherapy extends AquaticActivity {
    private String medicalCondition;
    private String therapistName;
    private boolean requiresMedicalApproval;
    private int sessionsRecommended;
    
    /**
     * Constructor con validaciones
     */
    public HydroTherapy(String activityCode, String activityName, String instructorName,
                       String schedule, int durationMinutes, double pricePerSession,
                       int maxParticipants, String medicalCondition, String therapistName,
                       boolean requiresMedicalApproval, int sessionsRecommended) {
        super(activityCode, activityName, instructorName, schedule, durationMinutes,
              pricePerSession, maxParticipants);
        
        // Validaciones
        if (medicalCondition == null || medicalCondition.trim().isEmpty()) {
            throw new IllegalArgumentException("La condición médica no puede estar vacía");
        }
        if (sessionsRecommended <= 0) {
            throw new IllegalArgumentException("Las sesiones recomendadas deben ser mayor a 0");
        }
        
        this.medicalCondition = medicalCondition;
        this.therapistName = therapistName;
        this.requiresMedicalApproval = requiresMedicalApproval;
        this.sessionsRecommended = sessionsRecommended;
    }
    
    @Override
    public void enrollParticipant() throws CuposAgotadosException, ActividadInactivaException {
        if (requiresMedicalApproval) {
            System.out.println("⚠️ Inscripción requiere aprobación médica previa");
        }
        super.enrollParticipant();
    }
    
    @Override
    public double calculateMonthlyPrice() {
        double basePrice = pricePerSession * sessionsRecommended;
        return basePrice * 1.5; // Servicio médico especializado
    }
    
    @Override
    public String getActivityType() {
        return "Hidroterapia - " + medicalCondition;
    }
    
    @Override
    public void showInfo() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║     HIDROTERAPIA                       ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Código: " + activityCode);
        System.out.println("Nombre: " + activityName);
        System.out.println("Condición: " + medicalCondition);
        System.out.println("Terapeuta: " + therapistName);
        System.out.println("Horario: " + schedule);
        System.out.println("Duración: " + durationMinutes + " minutos");
        System.out.println("Sesiones/mes: " + sessionsRecommended);
        System.out.println("Aprobación médica: " + (requiresMedicalApproval ? "Requerida" : "No requerida"));
        System.out.println("Precio/sesión: $" + pricePerSession);
        System.out.println("Precio mensual: $" + calculateMonthlyPrice());
        System.out.println("Cupos: " + currentParticipants + "/" + maxParticipants);
        System.out.println("Estado: " + (isActive ? "Activa" : "Inactiva"));
    }
    
    // Getters
    public String getMedicalCondition() { return medicalCondition; }
    public String getTherapistName() { return therapistName; }
    public boolean requiresMedicalApproval() { return requiresMedicalApproval; }
    public int getSessionsRecommended() { return sessionsRecommended; }
}
