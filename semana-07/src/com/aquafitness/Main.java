package com.aquafitness;

import com.aquafitness.modelo.AquaticActivity;
import com.aquafitness.modelo.SwimmingLesson;
import com.aquafitness.modelo.AquaAerobics;
import com.aquafitness.modelo.HydroTherapy;
import com.aquafitness.servicio.ActivityManager;
import com.aquafitness.excepciones.ReservaInvalidaException;
import com.aquafitness.excepciones.CuposAgotadosException;
import com.aquafitness.excepciones.ActividadInactivaException;

/**
 * Programa principal - Semana 07: Paquetes y Excepciones
 * Demuestra manejo completo de excepciones personalizadas
 * 
 * @author Santiago Salamanca Narváez
 * @version 1.0 - Semana 07
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║     AQUA FITNESS - SEMANA 07: PAQUETES Y EXCEPCIONES        ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝\n");

        // Crear gestor
        ActivityManager manager = null;
        
        try {
            manager = new ActivityManager("Centro Acuático Aqua Fitness");
            System.out.println("✓ Gestor de actividades creado");
        } catch (IllegalArgumentException e) {
            System.err.println("❌ Error al crear gestor: " + e.getMessage());
            return;
        }

        // ===================================================================
        // CASO 1: OPERACIÓN EXITOSA ✅
        // ===================================================================
        System.out.println("\n═══════════════════════════════════════════════════════════════");
        System.out.println("  CASO 1: INSCRIPCIÓN EXITOSA");
        System.out.println("═══════════════════════════════════════════════════════════════");
        
        try {
            SwimmingLesson lesson1 = new SwimmingLesson(
                "SWIM-101", "Natación Bebés", "Instructor Pérez",
                "Lunes y Miércoles 9:00-10:00", 60, 25000, 8,
                "Bebés", "Familiarización con el agua", false
            );
            
            manager.addActivity(lesson1);
            manager.processEnrollment("SWIM-101", "María González");
            manager.processEnrollment("SWIM-101", "Pedro Ramírez");
            
            System.out.println("\n✓ Caso 1 completado exitosamente");
            
        } catch (ReservaInvalidaException e) {
            System.err.println("❌ Error de reserva: " + e.getMessage());
        } catch (CuposAgotadosException e) {
            System.err.println("❌ Sin cupos: " + e.getMessage());
        } catch (ActividadInactivaException e) {
            System.err.println("❌ Actividad inactiva: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("❌ Datos inválidos: " + e.getMessage());
        }

        // ===================================================================
        // CASO 2: VALIDACIÓN CON IllegalArgumentException ❌
        // ===================================================================
        System.out.println("\n═══════════════════════════════════════════════════════════════");
        System.out.println("  CASO 2: VALIDACIÓN DE DATOS INVÁLIDOS");
        System.out.println("═══════════════════════════════════════════════════════════════");
        
        System.out.println("\n→ Intentando crear actividad con duración negativa...");
        try {
            SwimmingLesson invalidLesson = new SwimmingLesson(
                "SWIM-999", "Clase Inválida", "Instructor Test",
                "Horario cualquiera", -30, 10000, 10,  // ❌ Duración negativa
                "Adultos", "Ninguna", false
            );
            
            System.out.println("✓ Actividad creada (no debería llegar aquí)");
            
        } catch (IllegalArgumentException e) {
            System.err.println("❌ Validación correcta: " + e.getMessage());
            System.out.println("✓ La validación funcionó como esperado");
        }

        // ===================================================================
        // CASO 3: EXCEPCIÓN PERSONALIZADA - ReservaInvalidaException ❌
        // ===================================================================
        System.out.println("\n═══════════════════════════════════════════════════════════════");
        System.out.println("  CASO 3: ACTIVIDAD NO ENCONTRADA (ReservaInvalidaException)");
        System.out.println("═══════════════════════════════════════════════════════════════");
        
        System.out.println("\n→ Intentando inscribir en actividad inexistente...");
        try {
            manager.processEnrollment("SWIM-999", "Juan Pérez");
            
        } catch (ReservaInvalidaException e) {
            System.err.println("❌ Reserva inválida: " + e.getMessage());
            System.out.println("✓ Excepción ReservaInvalidaException capturada correctamente");
        } catch (CuposAgotadosException | ActividadInactivaException e) {
            System.err.println("❌ Otro error: " + e.getMessage());
        }

        // ===================================================================
        // CASO 4: EXCEPCIÓN PERSONALIZADA - CuposAgotadosException ❌
        // ===================================================================
        System.out.println("\n═══════════════════════════════════════════════════════════════");
        System.out.println("  CASO 4: SIN CUPOS DISPONIBLES (CuposAgotadosException)");
        System.out.println("═══════════════════════════════════════════════════════════════");
        
        try {
            // Crear actividad con solo 2 cupos
            AquaAerobics aerobics = new AquaAerobics(
                "AERO-101", "Aquaeróbicos", "Coach López",
                "Martes y Jueves 7:00-8:00", 60, 20000, 2,  // Solo 2 cupos
                "Alta", "Electrónica", true
            );
            
            manager.addActivity(aerobics);
            
            // Intentar inscribir 5 personas (más de los cupos disponibles)
            System.out.println("\n→ Intentando inscripción grupal de 5 personas en actividad con 2 cupos...");
            manager.processGroupEnrollment("AERO-101", 5);
            
        } catch (CuposAgotadosException e) {
            System.err.println("❌ Sin cupos suficientes: " + e.getMessage());
            System.out.println("✓ Excepción CuposAgotadosException capturada correctamente");
        } catch (ReservaInvalidaException | ActividadInactivaException e) {
            System.err.println("❌ Otro error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("❌ Datos inválidos: " + e.getMessage());
        }

        // ===================================================================
        // CASO 5: EXCEPCIÓN PERSONALIZADA - ActividadInactivaException ❌
        // ===================================================================
        System.out.println("\n═══════════════════════════════════════════════════════════════");
        System.out.println("  CASO 5: ACTIVIDAD INACTIVA (ActividadInactivaException)");
        System.out.println("═══════════════════════════════════════════════════════════════");
        
        try {
            HydroTherapy therapy = new HydroTherapy(
                "HYDRO-101", "Rehabilitación", "Dr. Torres",
                "Lunes a Viernes 14:00-15:00", 60, 50000, 4,
                "Hernia discal", "Dra. Rodríguez", true, 12
            );
            
            manager.addActivity(therapy);
            
            // Desactivar la actividad
            System.out.println("\n→ Desactivando hidroterapia...");
            therapy.setActive(false);
            
            // Intentar inscribir en actividad inactiva
            System.out.println("→ Intentando inscribir en actividad inactiva...");
            manager.processEnrollment("HYDRO-101", "Ana Martínez");
            
        } catch (ActividadInactivaException e) {
            System.err.println("❌ Actividad inactiva: " + e.getMessage());
            System.out.println("✓ Excepción ActividadInactivaException capturada correctamente");
        } catch (ReservaInvalidaException | CuposAgotadosException e) {
            System.err.println("❌ Otro error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("❌ Datos inválidos: " + e.getMessage());
        }

        // ===================================================================
        // CASO 6: RECUPERACIÓN DESPUÉS DE ERROR ✅
        // ===================================================================
        System.out.println("\n═══════════════════════════════════════════════════════════════");
        System.out.println("  CASO 6: RECUPERACIÓN DESPUÉS DE ERROR");
        System.out.println("═══════════════════════════════════════════════════════════════");
        
        System.out.println("\n→ Reactivando hidroterapia e intentando nueva inscripción...");
        try {
            AquaticActivity therapy = manager.findActivityByCode("HYDRO-101");
            therapy.setActive(true);  // Reactivar
            
            manager.processEnrollment("HYDRO-101", "Ana Martínez");
            System.out.println("✓ Recuperación exitosa: la actividad fue reactivada y la inscripción completada");
            
        } catch (ReservaInvalidaException | CuposAgotadosException | ActividadInactivaException e) {
            System.err.println("❌ Error: " + e.getMessage());
        }

        // ===================================================================
        // DEMOSTRACIÓN DE FINALLY
        // ===================================================================
        System.out.println("\n═══════════════════════════════════════════════════════════════");
        System.out.println("  DEMOSTRACIÓN DE FINALLY");
        System.out.println("═══════════════════════════════════════════════════════════════");
        
        System.out.println("\n→ Simulando operación con recurso que debe limpiarse...");
        
        ActivityManager tempManager = null;
        boolean operationSuccess = false;
        
        try {
            tempManager = new ActivityManager("Centro Temporal");
            System.out.println("→ Recurso temporal creado");
            
            // Simular operación que puede fallar
            SwimmingLesson tempLesson = new SwimmingLesson(
                "TEMP-001", "Clase Temporal", "Instructor Temporal",
                "Temporal", 60, 10000, 5,
                "Adultos", "Temporal", false
            );
            
            tempManager.addActivity(tempLesson);
            operationSuccess = true;
            System.out.println("→ Operación completada");
            
        } catch (IllegalArgumentException e) {
            System.err.println("❌ Error en operación: " + e.getMessage());
            operationSuccess = false;
        } finally {
            // Este bloque SIEMPRE se ejecuta
            System.out.println("\n→ Bloque FINALLY ejecutándose (siempre se ejecuta)");
            
            if (tempManager != null) {
                System.out.println("→ Limpiando recurso temporal...");
                tempManager = null;  // Simular limpieza
                System.out.println("✓ Recurso limpiado");
            }
            
            if (operationSuccess) {
                System.out.println("✓ Estado: Operación exitosa");
            } else {
                System.out.println("✗ Estado: Operación falló");
            }
        }

        // ===================================================================
        // REPORTE FINAL
        // ===================================================================
        System.out.println("\n═══════════════════════════════════════════════════════════════");
        System.out.println("  REPORTE FINAL");
        System.out.println("═══════════════════════════════════════════════════════════════");
        
        manager.showAllActivities();
        manager.generateReport();

        System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║               DEMOSTRACIÓN COMPLETADA                        ║");
        System.out.println("║                                                              ║");
        System.out.println("║  ✓ Caso 1: Inscripción exitosa                              ║");
        System.out.println("║  ✓ Caso 2: Validación IllegalArgumentException              ║");
        System.out.println("║  ✓ Caso 3: ReservaInvalidaException                         ║");
        System.out.println("║  ✓ Caso 4: CuposAgotadosException                           ║");
        System.out.println("║  ✓ Caso 5: ActividadInactivaException                       ║");
        System.out.println("║  ✓ Caso 6: Recuperación después de error                    ║");
        System.out.println("║  ✓ Finally: Demostración de limpieza                        ║");
        System.out.println("║                                                              ║");
        System.out.println("║  Semana 07: Paquetes y Excepciones ✅                        ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
    }
}
