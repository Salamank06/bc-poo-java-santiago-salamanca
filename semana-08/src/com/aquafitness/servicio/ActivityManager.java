package com.aquafitness.servicio;

import com.aquafitness.modelo.AquaticActivity;
import com.aquafitness.modelo.SwimmingLesson;
import com.aquafitness.modelo.AquaAerobics;
import com.aquafitness.modelo.HydroTherapy;
import com.aquafitness.excepciones.CuposAgotadosException;
import com.aquafitness.excepciones.ActividadInactivaException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ActivityManager - Gestor de actividades acuáticas con colecciones
 * 
 * Ejercicios Semana 08:
 * - Ejercicio 1: ArrayList con Generics (NO arrays)
 * - Ejercicio 2: HashMap para búsqueda O(1)
 * - Ejercicio 3: Filtrado y estadísticas
 * 
 * @author Santiago Salamanca Narváez
 * @version 1.0 - Semana 08
 */
public class ActivityManager {
    
    // ========== EJERCICIO 1 y 2: Colecciones con Generics ==========
    
    /**
     * HashMap para búsqueda rápida O(1) por código de actividad
     */
    private Map<String, AquaticActivity> activitiesByCode;
    
    /**
     * ArrayList para mantener historial ordenado de actividades
     */
    private List<AquaticActivity> activitiesCatalog;
    
    /**
     * HashMap para agrupar actividades por tipo
     */
    private Map<String, List<AquaticActivity>> activitiesByType;
    
    /**
     * Constructor - Inicializa las colecciones vacías
     */
    public ActivityManager() {
        this.activitiesByCode = new HashMap<>();
        this.activitiesCatalog = new ArrayList<>();
        this.activitiesByType = new HashMap<>();
    }
    
    // ========== OPERACIONES CRUD CON VALIDACIÓN ==========
    
    /**
     * Agrega una nueva actividad con validación de duplicados
     * @param activity Actividad a agregar
     * @throws IllegalArgumentException si el código ya existe
     */
    public void addActivity(AquaticActivity activity) {
        if (activity == null) {
            throw new IllegalArgumentException("La actividad no puede ser null");
        }
        
        String code = activity.getActivityCode();
        
        // ✅ Validar duplicados con containsKey() - Ejercicio 2
        if (activitiesByCode.containsKey(code)) {
            throw new IllegalArgumentException(
                "Ya existe una actividad con código: " + code
            );
        }
        
        // Agregar a HashMap para búsqueda rápida
        activitiesByCode.put(code, activity);
        
        // Agregar a ArrayList para historial
        activitiesCatalog.add(activity);
        
        // Agrupar por tipo
        String type = getSimpleType(activity);
        if (!activitiesByType.containsKey(type)) {
            activitiesByType.put(type, new ArrayList<>());
        }
        activitiesByType.get(type).add(activity);
        
        System.out.println("✓ Actividad agregada: " + code);
    }
    
    /**
     * Busca una actividad por código - O(1) con HashMap
     * @param code Código de la actividad
     * @return La actividad o null si no existe
     */
    public AquaticActivity findByCode(String code) {
        return activitiesByCode.get(code); // ✅ Búsqueda O(1)
    }
    
    /**
     * Verifica si existe una actividad con el código dado
     * @param code Código a verificar
     * @return true si existe
     */
    public boolean exists(String code) {
        return activitiesByCode.containsKey(code);
    }
    
    /**
     * Elimina una actividad por código
     * @param code Código de la actividad a eliminar
     * @return La actividad eliminada o null si no existía
     */
    public AquaticActivity removeActivity(String code) {
        AquaticActivity activity = activitiesByCode.remove(code);
        
        if (activity != null) {
            // Sincronizar: eliminar de ArrayList
            activitiesCatalog.remove(activity);
            
            // Sincronizar: eliminar de agrupación por tipo
            String type = getSimpleType(activity);
            List<AquaticActivity> typeList = activitiesByType.get(type);
            if (typeList != null) {
                typeList.remove(activity);
            }
            
            System.out.println("✓ Actividad eliminada: " + code);
        } else {
            System.out.println("✗ No existe actividad con código: " + code);
        }
        
        return activity;
    }
    
    /**
     * Obtiene el número total de actividades
     * @return Cantidad de actividades
     */
    public int getCount() {
        return activitiesCatalog.size();
    }
    
    /**
     * Lista todas las actividades del catálogo
     * @return Lista de todas las actividades
     */
    public List<AquaticActivity> getAllActivities() {
        return new ArrayList<>(activitiesCatalog); // Copia defensiva
    }
    
    // ========== EJERCICIO 3: FILTRADO ==========
    
    /**
     * Filtra actividades por rango de precio
     * @param minPrice Precio mínimo
     * @param maxPrice Precio máximo
     * @return Lista de actividades en el rango
     */
    public List<AquaticActivity> filterByPriceRange(double minPrice, double maxPrice) {
        List<AquaticActivity> result = new ArrayList<>();
        
        for (AquaticActivity activity : activitiesCatalog) {
            double price = activity.getPricePerSession();
            if (price >= minPrice && price <= maxPrice) {
                result.add(activity);
            }
        }
        
        return result;
    }
    
    /**
     * Filtra actividades por tipo
     * @param type Tipo de actividad ("SwimmingLesson", "AquaAerobics", "HydroTherapy")
     * @return Lista de actividades del tipo especificado
     */
    public List<AquaticActivity> filterByType(String type) {
        return activitiesByType.getOrDefault(type, new ArrayList<>());
    }
    
    /**
     * Filtra actividades con cupos disponibles
     * @param minSpots Cupos mínimos requeridos
     * @return Lista de actividades con cupos suficientes
     */
    public List<AquaticActivity> filterByAvailability(int minSpots) {
        List<AquaticActivity> result = new ArrayList<>();
        
        for (AquaticActivity activity : activitiesCatalog) {
            if (activity.getAvailableSpots() >= minSpots) {
                result.add(activity);
            }
        }
        
        return result;
    }
    
    /**
     * Filtra actividades activas
     * @return Lista de actividades activas
     */
    public List<AquaticActivity> filterActiveActivities() {
        List<AquaticActivity> result = new ArrayList<>();
        
        for (AquaticActivity activity : activitiesCatalog) {
            if (activity.isActive()) {
                result.add(activity);
            }
        }
        
        return result;
    }
    
    // ========== EJERCICIO 3: ESTADÍSTICAS ==========
    
    /**
     * Calcula el total de ingresos mensuales de todas las actividades
     * @return Total de ingresos mensuales
     */
    public double calculateTotalMonthlyRevenue() {
        double total = 0;
        
        for (AquaticActivity activity : activitiesCatalog) {
            total += activity.calculateMonthlyPrice() * activity.getCurrentParticipants();
        }
        
        return total;
    }
    
    /**
     * Calcula el promedio de precio por sesión
     * @return Promedio de precios
     */
    public double calculateAveragePricePerSession() {
        if (activitiesCatalog.isEmpty()) {
            return 0;
        }
        
        double total = 0;
        for (AquaticActivity activity : activitiesCatalog) {
            total += activity.getPricePerSession();
        }
        
        return total / activitiesCatalog.size();
    }
    
    /**
     * Encuentra la actividad más cara (por sesión)
     * @return La actividad más cara o null si no hay actividades
     */
    public AquaticActivity findMostExpensiveActivity() {
        if (activitiesCatalog.isEmpty()) {
            return null;
        }
        
        AquaticActivity mostExpensive = activitiesCatalog.get(0);
        
        for (AquaticActivity activity : activitiesCatalog) {
            if (activity.getPricePerSession() > mostExpensive.getPricePerSession()) {
                mostExpensive = activity;
            }
        }
        
        return mostExpensive;
    }
    
    /**
     * Encuentra la actividad más económica (por sesión)
     * @return La actividad más económica o null si no hay actividades
     */
    public AquaticActivity findCheapestActivity() {
        if (activitiesCatalog.isEmpty()) {
            return null;
        }
        
        AquaticActivity cheapest = activitiesCatalog.get(0);
        
        for (AquaticActivity activity : activitiesCatalog) {
            if (activity.getPricePerSession() < cheapest.getPricePerSession()) {
                cheapest = activity;
            }
        }
        
        return cheapest;
    }
    
    /**
     * Cuenta actividades por categoría/tipo
     * @return Map con el conteo de cada tipo
     */
    public Map<String, Integer> countByType() {
        Map<String, Integer> count = new HashMap<>();
        
        for (AquaticActivity activity : activitiesCatalog) {
            String type = getSimpleType(activity);
            count.put(type, count.getOrDefault(type, 0) + 1);
        }
        
        return count;
    }
    
    /**
     * Calcula el total de participantes inscritos
     * @return Total de participantes
     */
    public int getTotalParticipants() {
        int total = 0;
        
        for (AquaticActivity activity : activitiesCatalog) {
            total += activity.getCurrentParticipants();
        }
        
        return total;
    }
    
    /**
     * Calcula el porcentaje de ocupación promedio
     * @return Porcentaje de ocupación (0-100)
     */
    public double getAverageOccupancy() {
        if (activitiesCatalog.isEmpty()) {
            return 0;
        }
        
        double totalOccupancy = 0;
        
        for (AquaticActivity activity : activitiesCatalog) {
            if (activity.getMaxParticipants() > 0) {
                double occupancy = (activity.getCurrentParticipants() * 100.0) / 
                                 activity.getMaxParticipants();
                totalOccupancy += occupancy;
            }
        }
        
        return totalOccupancy / activitiesCatalog.size();
    }
    
    // ========== MÉTODOS AUXILIARES ==========
    
    /**
     * Obtiene el tipo simple de una actividad (nombre de la clase)
     */
    private String getSimpleType(AquaticActivity activity) {
        if (activity instanceof SwimmingLesson) {
            return "SwimmingLesson";
        } else if (activity instanceof AquaAerobics) {
            return "AquaAerobics";
        } else if (activity instanceof HydroTherapy) {
            return "HydroTherapy";
        }
        return "Unknown";
    }
    
    /**
     * Inscribe un participante en una actividad
     * @param code Código de la actividad
     * @throws IllegalArgumentException si no existe la actividad
     * @throws CuposAgotadosException si no hay cupos
     * @throws ActividadInactivaException si está inactiva
     */
    public void enrollParticipant(String code) 
            throws CuposAgotadosException, ActividadInactivaException {
        AquaticActivity activity = findByCode(code);
        
        if (activity == null) {
            throw new IllegalArgumentException("No existe actividad con código: " + code);
        }
        
        activity.enrollParticipant();
    }
    
    /**
     * Muestra un resumen completo del sistema
     */
    public void showSummary() {
        System.out.println("\n╔═══════════════════════════════════════════════╗");
        System.out.println("║     RESUMEN DEL SISTEMA AQUA FITNESS          ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
        System.out.println("Total de actividades: " + getCount());
        System.out.println("Total de participantes: " + getTotalParticipants());
        System.out.println("Ocupación promedio: " + String.format("%.1f%%", getAverageOccupancy()));
        System.out.println("Precio promedio/sesión: $" + 
                         String.format("%.2f", calculateAveragePricePerSession()));
        System.out.println("Ingresos mensuales: $" + 
                         String.format("%.2f", calculateTotalMonthlyRevenue()));
        
        System.out.println("\nActividades por tipo:");
        Map<String, Integer> typeCount = countByType();
        for (Map.Entry<String, Integer> entry : typeCount.entrySet()) {
            System.out.println("  - " + entry.getKey() + ": " + entry.getValue());
        }
        
        AquaticActivity mostExpensive = findMostExpensiveActivity();
        if (mostExpensive != null) {
            System.out.println("\nActividad más cara: " + mostExpensive.getActivityCode() + 
                             " ($" + mostExpensive.getPricePerSession() + ")");
        }
        
        AquaticActivity cheapest = findCheapestActivity();
        if (cheapest != null) {
            System.out.println("Actividad más económica: " + cheapest.getActivityCode() + 
                             " ($" + cheapest.getPricePerSession() + ")");
        }
    }
}

