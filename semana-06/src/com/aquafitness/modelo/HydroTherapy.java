package com.aquafitness.modelo;

import com.aquafitness.interfaces.Reservable;
import com.aquafitness.interfaces.Evaluable;
import com.aquafitness.interfaces.Cancelable;
import java.util.ArrayList;

/**
 * Clase HydroTherapy - Hidroterapia
 * Implementa las 3 interfaces (múltiple implementación completa)
 * @author Santiago Salamanca Narváez
 * @version 2.0 - Semana 06
 */
public class HydroTherapy extends AquaticActivity implements Reservable, Evaluable, Cancelable {
    private String medicalCondition;
    private String therapistName;
    private boolean requiresMedicalApproval;
    private int sessionsRecommended;
    
    private ArrayList<String> reservas = new ArrayList<>();
    private ArrayList<Integer> calificaciones = new ArrayList<>();
    private int contadorReservas = 5000;
    
    public HydroTherapy(String activityCode, String activityName, String instructorName,
                       String schedule, int durationMinutes, double pricePerSession,
                       int maxParticipants, String medicalCondition, String therapistName,
                       boolean requiresMedicalApproval, int sessionsRecommended) {
        super(activityCode, activityName, instructorName, schedule, durationMinutes,
              pricePerSession, maxParticipants);
        this.medicalCondition = medicalCondition;
        this.therapistName = therapistName;
        this.requiresMedicalApproval = requiresMedicalApproval;
        this.sessionsRecommended = sessionsRecommended;
    }
    
    @Override
    public double calculateMonthlyPrice() {
        return pricePerSession * sessionsRecommended * 1.5;
    }
    
    @Override
    public String getActivityType() {
        return "Hidroterapia - " + medicalCondition;
    }
    
    @Override
    public void showInfo() {
        System.out.println("=== HIDROTERAPIA ===");
        System.out.println("Código: " + activityCode);
        System.out.println("Condición: " + medicalCondition);
        System.out.println("Precio mensual: $" + calculateMonthlyPrice());
    }
    
    // Implementación de Reservable
    @Override
    public boolean verificarDisponibilidad(String fecha) {
        return getAvailableSpots() > 0;
    }
    
    @Override
    public String realizarReserva(String nombreCliente, String fecha, int numeroCupos) {
        String codigo = activityCode + "-H" + (contadorReservas++);
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
        return obtenerPromedioCalificaciones() >= 4.5;
    }
    
    // Implementación de Cancelable
    @Override
    public boolean cancelarInscripcion(String nombreParticipante, String motivo) {
        return withdrawParticipant();
    }
    
    @Override
    public double calcularReembolso(int diasAnticipacion, double montoTotal) {
        if (diasAnticipacion >= 14) return montoTotal;
        if (diasAnticipacion >= 7) return montoTotal * 0.70;
        if (diasAnticipacion >= 3) return montoTotal * 0.40;
        return 0;
    }
    
    @Override
    public boolean esCancelable(int diasAnticipacion) {
        return true;
    }
    
    @Override
    public String obtenerPoliticaCancelacion() {
        return "≥14 días: 100% | 7-13 días: 70% | 3-6 días: 40% | <3 días: 0%";
    }
    
    public String getMedicalCondition() { return medicalCondition; }
}


