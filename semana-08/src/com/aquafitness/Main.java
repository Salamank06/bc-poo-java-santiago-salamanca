package com.aquafitness;

import com.aquafitness.modelo.*;
import com.aquafitness.servicio.ActivityManager;
import com.aquafitness.excepciones.*;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Clase Main - Programa principal con menú interactivo
 * Demuestra el uso de HashMap y ArrayList con Generics
 * 
 * @author Santiago Salamanca Narváez
 * @version 1.0 - Semana 08
 */
public class Main {
    private static ActivityManager manager = new ActivityManager();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════════════╗");
        System.out.println("║  SISTEMA DE GESTIÓN AQUA FITNESS - SEMANA 08  ║");
        System.out.println("║       Colecciones y Programación Genérica     ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
        
        // Cargar datos de prueba
        loadSampleData();
        
        // Menú principal
        int option;
        do {
            showMenu();
            option = readInt("Seleccione una opción: ");
            
            System.out.println(); // Línea en blanco
            
            switch (option) {
                case 1: addActivityOption(); break;
                case 2: searchByCodeOption(); break;
                case 3: listAllActivitiesOption(); break;
                case 4: filterByPriceOption(); break;
                case 5: filterByTypeOption(); break;
                case 6: showStatisticsOption(); break;
                case 7: removeActivityOption(); break;
                case 8: enrollParticipantOption(); break;
                case 0: 
                    System.out.println("¡Gracias por usar el sistema Aqua Fitness!");
                    System.out.println("Hasta luego.");
                    break;
                default: 
                    System.out.println("❌ Opción inválida. Intente nuevamente.");
            }
            
            if (option != 0) {
                waitForEnter();
            }
            
        } while (option != 0);
        
        scanner.close();
    }
    
    /**
     * Muestra el menú principal
     */
    private static void showMenu() {
        System.out.println("\n╔═══════════════════════════════════════════════╗");
        System.out.println("║              MENÚ PRINCIPAL                   ║");
        System.out.println("╠═══════════════════════════════════════════════╣");
        System.out.println("║  1. ➕ Agregar nueva actividad                ║");
        System.out.println("║  2. 🔍 Buscar actividad por código            ║");
        System.out.println("║  3. 📋 Listar todas las actividades           ║");
        System.out.println("║  4. 💰 Filtrar por rango de precio            ║");
        System.out.println("║  5. 🏊 Filtrar por tipo de actividad          ║");
        System.out.println("║  6. 📊 Ver estadísticas del sistema           ║");
        System.out.println("║  7. ❌ Eliminar actividad                      ║");
        System.out.println("║  8. 👤 Inscribir participante                 ║");
        System.out.println("║  0. 🚪 Salir                                  ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
    }
    
    // ========== OPCIÓN 1: AGREGAR ACTIVIDAD ==========
    
    private static void addActivityOption() {
        System.out.println("╔═══════════════════════════════════════════════╗");
        System.out.println("║          AGREGAR NUEVA ACTIVIDAD              ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
        
        System.out.println("\nTipos de actividad:");
        System.out.println("1. Clase de Natación");
        System.out.println("2. Aquaeróbicos");
        System.out.println("3. Hidroterapia");
        
        int type = readInt("Tipo de actividad: ");
        
        try {
            System.out.println("\nDatos generales:");
            String code = readString("Código: ");
            String name = readString("Nombre: ");
            String instructor = readString("Instructor: ");
            String schedule = readString("Horario: ");
            int duration = readInt("Duración (minutos): ");
            double price = readDouble("Precio por sesión: ");
            int maxParticipants = readInt("Capacidad máxima: ");
            
            AquaticActivity activity;
            
            switch (type) {
                case 1:
                    String level = readString("Nivel (Bebés/Niños/Adultos/Avanzado): ");
                    String techniques = readString("Técnicas enfocadas: ");
                    boolean certification = readBoolean("¿Incluye certificación? (s/n): ");
                    
                    activity = new SwimmingLesson(code, name, instructor, schedule,
                        duration, price, maxParticipants, level, techniques, certification);
                    break;
                    
                case 2:
                    String intensity = readString("Intensidad (Baja/Media/Alta): ");
                    String music = readString("Género musical: ");
                    boolean equipment = readBoolean("¿Requiere equipo? (s/n): ");
                    
                    activity = new AquaAerobics(code, name, instructor, schedule,
                        duration, price, maxParticipants, intensity, music, equipment);
                    break;
                    
                case 3:
                    String condition = readString("Condición médica: ");
                    String therapist = readString("Terapeuta: ");
                    boolean approval = readBoolean("¿Requiere aprobación médica? (s/n): ");
                    int sessions = readInt("Sesiones recomendadas/mes: ");
                    
                    activity = new HydroTherapy(code, name, instructor, schedule,
                        duration, price, maxParticipants, condition, therapist, 
                        approval, sessions);
                    break;
                    
                default:
                    System.out.println("❌ Tipo de actividad inválido");
                    return;
            }
            
            manager.addActivity(activity);
            System.out.println("\n✅ Actividad creada exitosamente");
            
        } catch (IllegalArgumentException e) {
            System.out.println("\n❌ Error de validación: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\n❌ Error inesperado: " + e.getMessage());
        }
    }
    
    // ========== OPCIÓN 2: BUSCAR POR CÓDIGO (DEMUESTRA HASHMAP O(1)) ==========
    
    private static void searchByCodeOption() {
        System.out.println("╔═══════════════════════════════════════════════╗");
        System.out.println("║        BUSCAR ACTIVIDAD POR CÓDIGO            ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
        
        String code = readString("\nIngrese el código de la actividad: ");
        
        // ✅ Búsqueda O(1) con HashMap
        long startTime = System.nanoTime();
        AquaticActivity activity = manager.findByCode(code);
        long endTime = System.nanoTime();
        
        if (activity != null) {
            System.out.println("\n✅ Actividad encontrada en " + 
                             (endTime - startTime) + " nanosegundos (O(1)):");
            System.out.println();
            activity.showInfo();
        } else {
            System.out.println("\n❌ No existe actividad con código: " + code);
        }
    }
    
    // ========== OPCIÓN 3: LISTAR TODAS (DEMUESTRA ARRAYLIST) ==========
    
    private static void listAllActivitiesOption() {
        System.out.println("╔═══════════════════════════════════════════════╗");
        System.out.println("║          LISTADO DE ACTIVIDADES               ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
        
        // ✅ Usa ArrayList con Generics
        List<AquaticActivity> activities = manager.getAllActivities();
        
        if (activities.isEmpty()) {
            System.out.println("\n⚠️ No hay actividades registradas");
            return;
        }
        
        System.out.println("\nTotal de actividades: " + activities.size());
        System.out.println("\n" + "=".repeat(80));
        
        // ✅ Iteración con for-each sobre List<AquaticActivity>
        for (AquaticActivity activity : activities) {
            System.out.printf("%-12s | %-30s | $%-10.2f | Cupos: %2d/%2d | %s\n",
                activity.getActivityCode(),
                activity.getActivityName(),
                activity.getPricePerSession(),
                activity.getCurrentParticipants(),
                activity.getMaxParticipants(),
                activity.isActive() ? "✓ Activa" : "✗ Inactiva"
            );
        }
        System.out.println("=".repeat(80));
    }
    
    // ========== OPCIÓN 4: FILTRAR POR PRECIO ==========
    
    private static void filterByPriceOption() {
        System.out.println("╔═══════════════════════════════════════════════╗");
        System.out.println("║       FILTRAR POR RANGO DE PRECIO             ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
        
        double minPrice = readDouble("\nPrecio mínimo: ");
        double maxPrice = readDouble("Precio máximo: ");
        
        // ✅ Método de filtrado
        List<AquaticActivity> filtered = manager.filterByPriceRange(minPrice, maxPrice);
        
        if (filtered.isEmpty()) {
            System.out.println("\n⚠️ No hay actividades en ese rango de precio");
            return;
        }
        
        System.out.println("\n✅ Se encontraron " + filtered.size() + " actividades:");
        System.out.println("\n" + "=".repeat(80));
        
        for (AquaticActivity activity : filtered) {
            System.out.printf("%-12s | %-30s | $%-10.2f | %s\n",
                activity.getActivityCode(),
                activity.getActivityName(),
                activity.getPricePerSession(),
                activity.getActivityType()
            );
        }
        System.out.println("=".repeat(80));
    }
    
    // ========== OPCIÓN 5: FILTRAR POR TIPO ==========
    
    private static void filterByTypeOption() {
        System.out.println("╔═══════════════════════════════════════════════╗");
        System.out.println("║       FILTRAR POR TIPO DE ACTIVIDAD           ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
        
        System.out.println("\nTipos disponibles:");
        System.out.println("1. SwimmingLesson");
        System.out.println("2. AquaAerobics");
        System.out.println("3. HydroTherapy");
        
        int typeChoice = readInt("\nSeleccione tipo: ");
        
        String type;
        switch (typeChoice) {
            case 1: type = "SwimmingLesson"; break;
            case 2: type = "AquaAerobics"; break;
            case 3: type = "HydroTherapy"; break;
            default:
                System.out.println("❌ Tipo inválido");
                return;
        }
        
        // ✅ Filtrado por tipo usando HashMap secundario
        List<AquaticActivity> filtered = manager.filterByType(type);
        
        if (filtered.isEmpty()) {
            System.out.println("\n⚠️ No hay actividades de tipo " + type);
            return;
        }
        
        System.out.println("\n✅ Actividades de tipo " + type + " (" + filtered.size() + "):");
        System.out.println();
        
        for (AquaticActivity activity : filtered) {
            activity.showInfo();
            System.out.println();
        }
    }
    
    // ========== OPCIÓN 6: ESTADÍSTICAS ==========
    
    private static void showStatisticsOption() {
        System.out.println("╔═══════════════════════════════════════════════╗");
        System.out.println("║          ESTADÍSTICAS DEL SISTEMA             ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
        
        // ✅ Demuestra métodos de estadísticas
        manager.showSummary();
        
        // Estadísticas adicionales
        System.out.println("\n╔═══════════════════════════════════════════════╗");
        System.out.println("║         ANÁLISIS DETALLADO                    ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
        
        // Actividades con cupos disponibles
        List<AquaticActivity> available = manager.filterByAvailability(1);
        System.out.println("\nActividades con cupos disponibles: " + available.size());
        
        // Actividades activas
        List<AquaticActivity> active = manager.filterActiveActivities();
        System.out.println("Actividades activas: " + active.size());
        
        // Conteo por tipo usando Map
        System.out.println("\n📊 Distribución por tipo:");
        Map<String, Integer> typeCount = manager.countByType();
        for (Map.Entry<String, Integer> entry : typeCount.entrySet()) {
            System.out.println("  - " + entry.getKey() + ": " + entry.getValue() + 
                             " actividades");
        }
    }
    
    // ========== OPCIÓN 7: ELIMINAR ACTIVIDAD ==========
    
    private static void removeActivityOption() {
        System.out.println("╔═══════════════════════════════════════════════╗");
        System.out.println("║           ELIMINAR ACTIVIDAD                  ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
        
        String code = readString("\nIngrese el código de la actividad a eliminar: ");
        
        // Verificar si existe
        if (!manager.exists(code)) {
            System.out.println("\n❌ No existe actividad con código: " + code);
            return;
        }
        
        // Mostrar información antes de eliminar
        AquaticActivity activity = manager.findByCode(code);
        System.out.println("\nActividad a eliminar:");
        activity.showInfo();
        
        boolean confirm = readBoolean("\n¿Confirma la eliminación? (s/n): ");
        
        if (confirm) {
            // ✅ Elimina de HashMap y ArrayList sincronizadamente
            manager.removeActivity(code);
            System.out.println("\n✅ Actividad eliminada exitosamente");
        } else {
            System.out.println("\n⚠️ Operación cancelada");
        }
    }
    
    // ========== OPCIÓN 8: INSCRIBIR PARTICIPANTE ==========
    
    private static void enrollParticipantOption() {
        System.out.println("╔═══════════════════════════════════════════════╗");
        System.out.println("║         INSCRIBIR PARTICIPANTE                ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
        
        String code = readString("\nIngrese el código de la actividad: ");
        
        try {
            // ✅ Demuestra manejo de excepciones personalizadas
            manager.enrollParticipant(code);
            System.out.println("\n✅ Inscripción exitosa");
            
        } catch (CuposAgotadosException e) {
            System.out.println("\n❌ Cupos agotados: " + e.getMessage());
        } catch (ActividadInactivaException e) {
            System.out.println("\n❌ Actividad inactiva: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("\n❌ Error: " + e.getMessage());
        }
    }
    
    // ========== DATOS DE PRUEBA ==========
    
    private static void loadSampleData() {
        System.out.println("\nCargando datos de prueba...");
        
        try {
            // 3 clases de natación
            manager.addActivity(new SwimmingLesson(
                "NAT-001", "Natación Bebés", "Ana García", 
                "Lunes y Miércoles 9:00 AM", 45, 35000, 8, 
                "Bebés", "Flotación y familiarización", true
            ));
            
            manager.addActivity(new SwimmingLesson(
                "NAT-002", "Natación Niños Principiantes", "Carlos Ruiz",
                "Martes y Jueves 3:00 PM", 60, 40000, 12,
                "Niños", "Técnica libre y espalda", false
            ));
            
            manager.addActivity(new SwimmingLesson(
                "NAT-003", "Natación Adultos Avanzado", "María López",
                "Lunes, Miércoles y Viernes 6:00 PM", 90, 55000, 10,
                "Avanzado", "Mariposa y competencia", true
            ));
            
            // 2 aquaeróbicos
            manager.addActivity(new AquaAerobics(
                "AQA-001", "Aqua Fitness Matutino", "Laura Sánchez",
                "Lunes a Viernes 7:00 AM", 60, 30000, 15,
                "Media", "Pop latino", true
            ));
            
            manager.addActivity(new AquaAerobics(
                "AQA-002", "Aqua Zumba", "Pedro Martínez",
                "Martes y Jueves 7:00 PM", 50, 28000, 20,
                "Alta", "Reggaeton", false
            ));
            
            // 2 hidroterapias
            manager.addActivity(new HydroTherapy(
                "HYD-001", "Terapia Rehabilitación Lumbar", "Dr. Juan Pérez",
                "Lunes, Miércoles y Viernes 10:00 AM", 45, 65000, 6,
                "Lesión lumbar", "Dr. Juan Pérez", true, 12
            ));
            
            manager.addActivity(new HydroTherapy(
                "HYD-002", "Terapia Post-Operatoria", "Dr. Sofia Torres",
                "Martes y Jueves 2:00 PM", 60, 70000, 4,
                "Recuperación post-quirúrgica", "Dr. Sofia Torres", true, 8
            ));
            
            // Inscribir algunos participantes
            manager.enrollParticipant("NAT-001");
            manager.enrollParticipant("NAT-001");
            manager.enrollParticipant("NAT-001");
            
            manager.enrollParticipant("AQA-001");
            manager.enrollParticipant("AQA-001");
            manager.enrollParticipant("AQA-001");
            manager.enrollParticipant("AQA-001");
            manager.enrollParticipant("AQA-001");
            
            manager.enrollParticipant("HYD-001");
            manager.enrollParticipant("HYD-001");
            
            System.out.println("✅ Datos de prueba cargados exitosamente\n");
            
        } catch (Exception e) {
            System.out.println("⚠️ Error cargando datos: " + e.getMessage());
        }
    }
    
    // ========== UTILIDADES DE ENTRADA ==========
    
    private static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
    
    private static int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("❌ Debe ingresar un número entero");
            }
        }
    }
    
    private static double readDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = Double.parseDouble(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("❌ Debe ingresar un número válido");
            }
        }
    }
    
    private static boolean readBoolean(String prompt) {
        while (true) {
            System.out.print(prompt);
            String response = scanner.nextLine().toLowerCase();
            if (response.equals("s") || response.equals("si")) {
                return true;
            } else if (response.equals("n") || response.equals("no")) {
                return false;
            } else {
                System.out.println("❌ Responda con 's' o 'n'");
            }
        }
    }
    
    private static void waitForEnter() {
        System.out.println("\nPresione ENTER para continuar...");
        scanner.nextLine();
    }
}
