package com.aquafitness.servicio;

import com.aquafitness.modelo.AquaticActivity;
import com.aquafitness.excepciones.ReservaInvalidaException;
import com.aquafitness.excepciones.CuposAgotadosException;
import com.aquafitness.excepciones.ActividadInactivaException;

import java.util.ArrayList;

/**
 * Gestor de actividades acuáticas
 * Maneja la lógica de negocio y validaciones
 * 
 * @author Santiago Salamanca Narváez
 * @version 2.0 - Semana 07
 */
public class ActivityManager {
    private ArrayList<AquaticActivity> activities;
    private String centerName;
    
    /**
     * Constructor
     * @param centerName Nombre del centro
     * @throws IllegalArgumentException si el nombre es vacío
     */
    public ActivityManager(String centerName) {
        if (centerName == null || centerName.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del centro no puede estar vacío");
        }
        this.centerName = centerName;
        this.activities = new ArrayList<>();
    }
    
    /**
     * Agrega una actividad con validaciones
     * @param activity Actividad a agregar
     * @throws IllegalArgumentException si la actividad es null o el código ya existe
     */
    public void addActivity(AquaticActivity activity) {
        if (activity == null) {
            throw new IllegalArgumentException("La actividad no puede ser null");
        }
        
        // Verificar que no exista una actividad con el mismo código
        for (AquaticActivity act : activities) {
            if (act.getActivityCode().equals(activity.getActivityCode())) {
                throw new IllegalArgumentException(
                    "Ya existe una actividad con el código: " + activity.getActivityCode()
                );
            }
        }
        
        activities.add(activity);
        System.out.println("✓ Actividad agregada: " + activity.getActivityCode() + 
                         " - " + activity.getActivityName());
    }
    
    /**
     * Busca una actividad por código
     * @param code Código de la actividad
     * @return La actividad encontrada
     * @throws IllegalArgumentException si el código es inválido
     * @throws ReservaInvalidaException si no se encuentra la actividad
     */
    public AquaticActivity findActivityByCode(String code) throws ReservaInvalidaException {
        if (code == null || code.trim().isEmpty()) {
            throw new IllegalArgumentException("El código no puede estar vacío");
        }
        
        for (AquaticActivity activity : activities) {
            if (activity.getActivityCode().equals(code)) {
                return activity;
            }
        }
        
        throw new ReservaInvalidaException(
            "No se encontró ninguna actividad con el código: " + code
        );
    }
    
    /**
     * Procesa una inscripción con manejo completo de excepciones
     * @param activityCode Código de la actividad
     * @param participantName Nombre del participante
     * @throws ReservaInvalidaException si la actividad no existe
     * @throws CuposAgotadosException si no hay cupos
     * @throws ActividadInactivaException si la actividad está inactiva
     */
    public void processEnrollment(String activityCode, String participantName) 
            throws ReservaInvalidaException, CuposAgotadosException, ActividadInactivaException {
        
        // Validar nombre del participante
        if (participantName == null || participantName.trim().isEmpty()) {
            throw new ReservaInvalidaException("El nombre del participante no puede estar vacío");
        }
        
        // Buscar actividad
        AquaticActivity activity = findActivityByCode(activityCode);
        
        // Intentar inscribir
        System.out.println("\n→ Procesando inscripción de " + participantName + 
                         " en " + activityCode + "...");
        activity.enrollParticipant();
        System.out.println("✓ Inscripción exitosa para " + participantName);
    }
    
    /**
     * Inscripción con validación de cupos
     * @param activityCode Código de actividad
     * @param numberOfParticipants Número de participantes a inscribir
     * @throws ReservaInvalidaException si la reserva es inválida
     * @throws CuposAgotadosException si no hay suficientes cupos
     * @throws ActividadInactivaException si la actividad está inactiva
     */
    public void processGroupEnrollment(String activityCode, int numberOfParticipants)
            throws ReservaInvalidaException, CuposAgotadosException, ActividadInactivaException {
        
        // Validar número de participantes
        if (numberOfParticipants <= 0) {
            throw new ReservaInvalidaException(
                "El número de participantes debe ser mayor a 0"
            );
        }
        
        // Buscar actividad
        AquaticActivity activity = findActivityByCode(activityCode);
        
        // Verificar disponibilidad total
        if (activity.getAvailableSpots() < numberOfParticipants) {
            throw new CuposAgotadosException(
                "No hay suficientes cupos. Disponibles: " + activity.getAvailableSpots() + 
                ", Solicitados: " + numberOfParticipants
            );
        }
        
        // Inscribir grupo
        System.out.println("\n→ Procesando inscripción grupal de " + numberOfParticipants + 
                         " personas en " + activityCode + "...");
        
        for (int i = 0; i < numberOfParticipants; i++) {
            activity.enrollParticipant();
        }
        
        System.out.println("✓ Inscripción grupal exitosa");
    }
    
    /**
     * Muestra todas las actividades
     */
    public void showAllActivities() {
        System.out.println("\n╔══════════════════════════════════════════════════════════╗");
        System.out.println("║     " + centerName.toUpperCase() + " - ACTIVIDADES");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        
        if (activities.isEmpty()) {
            System.out.println("No hay actividades registradas");
            return;
        }
        
        for (AquaticActivity activity : activities) {
            System.out.println("\n→ " + activity.getActivityCode() + ": " + 
                             activity.getActivityName());
            System.out.println("  Tipo: " + activity.getActivityType());
            System.out.println("  Cupos: " + activity.getCurrentParticipants() + "/" + 
                             activity.getMaxParticipants());
            System.out.println("  Precio mensual: $" + activity.calculateMonthlyPrice());
            System.out.println("  Estado: " + (activity.isActive() ? "✓ Activa" : "✗ Inactiva"));
        }
    }
    
    /**
     * Calcula los ingresos totales
     * @return Ingresos mensuales totales
     */
    public double calculateTotalRevenue() {
        double total = 0;
        for (AquaticActivity activity : activities) {
            total += activity.calculateMonthlyPrice() * activity.getCurrentParticipants();
        }
        return total;
    }
    
    /**
     * Genera reporte estadístico
     */
    public void generateReport() {
        System.out.println("\n╔══════════════════════════════════════════════════════════╗");
        System.out.println("║          REPORTE ESTADÍSTICO - " + centerName);
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        
        int totalActivities = activities.size();
        int activeActivities = 0;
        int totalParticipants = 0;
        int totalCapacity = 0;
        
        for (AquaticActivity activity : activities) {
            if (activity.isActive()) {
                activeActivities++;
            }
            totalParticipants += activity.getCurrentParticipants();
            totalCapacity += activity.getMaxParticipants();
        }
        
        double occupancyRate = totalCapacity > 0 ? 
            (totalParticipants * 100.0 / totalCapacity) : 0;
        
        System.out.println("Total de actividades: " + totalActivities);
        System.out.println("Actividades activas: " + activeActivities);
        System.out.println("Total de participantes: " + totalParticipants);
        System.out.println("Capacidad total: " + totalCapacity);
        System.out.println("Tasa de ocupación: " + String.format("%.1f%%", occupancyRate));
        System.out.println("Ingresos mensuales: $" + calculateTotalRevenue());
    }
    
    // Getters
    public String getCenterName() {
        return centerName;
    }
    
    public int getActivityCount() {
        return activities.size();
    }
    
    public ArrayList<AquaticActivity> getActivities() {
        return new ArrayList<>(activities); // Copia defensiva
    }
}


