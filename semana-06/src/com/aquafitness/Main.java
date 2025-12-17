package com.aquafitness;

import com.aquafitness.modelo.*;
import com.aquafitness.interfaces.*;

/**
 * Programa principal - Semana 06: Abstracción e Interfaces
 * @author Santiago Salamanca Narváez
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║     AQUA FITNESS - SEMANA 06: ABSTRACCIÓN E INTERFACES       ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝\n");

        // Crear actividades
        AquaticActivity[] activities = new AquaticActivity[3];

        activities[0] = new SwimmingLesson(
            "SWIM-101", "Natación Bebés", "Instructor Pérez",
            "Lunes y Miércoles 9:00-10:00", 60, 25000, 8,
            "Bebés", "Familiarización", false
        );

        activities[1] = new AquaAerobics(
            "AERO-101", "Aquaeróbicos Intenso", "Coach Gómez",
            "Lunes, Miércoles y Viernes 7:00-8:00", 60, 22000, 20,
            "Alta", "Electrónica", true
        );

        activities[2] = new HydroTherapy(
            "HYDRO-101", "Rehabilitación Lumbar", "Dr. Torres",
            "Lunes a Viernes 14:00-15:00", 60, 50000, 4,
            "Hernia discal", "Dra. Rodríguez", true, 12
        );

        System.out.println("═══════════════════════════════════════════════════════════════");
        System.out.println("  POLIMORFISMO CON CLASE ABSTRACTA");
        System.out.println("═══════════════════════════════════════════════════════════════\n");

        for (AquaticActivity activity : activities) {
            System.out.println("Código: " + activity.getActivityCode());
            System.out.println("Tipo: " + activity.getActivityType());
            System.out.println("Precio mensual: $" + activity.calculateMonthlyPrice());
            System.out.println("───────────────────────────────────────");
        }

        System.out.println("\n═══════════════════════════════════════════════════════════════");
        System.out.println("  INTERFACES - RESERVABLE");
        System.out.println("═══════════════════════════════════════════════════════════════\n");

        Reservable reservable1 = (SwimmingLesson) activities[0];
        if (reservable1.verificarDisponibilidad("2025-01-15")) {
            String codigo = reservable1.realizarReserva("María González", "2025-01-15", 2);
            System.out.println("Reserva creada: " + codigo);
        }

        System.out.println("\n═══════════════════════════════════════════════════════════════");
        System.out.println("  INTERFACES - EVALUABLE");
        System.out.println("═══════════════════════════════════════════════════════════════\n");

        Evaluable evaluable1 = (SwimmingLesson) activities[0];
        evaluable1.agregarCalificacion(5, "Excelente", "Ana Pérez");
        evaluable1.agregarCalificacion(5, "Muy bueno", "Laura Martínez");
        evaluable1.agregarCalificacion(4, "Bueno", "Pedro Sánchez");
        
        System.out.println("Calificaciones: " + evaluable1.obtenerNumeroEvaluaciones());
        System.out.println("Promedio: " + evaluable1.obtenerPromedioCalificaciones() + " ⭐");
        System.out.println("Calificación alta: " + (evaluable1.tieneCalificacionAlta() ? "Sí" : "No"));

        System.out.println("\n═══════════════════════════════════════════════════════════════");
        System.out.println("  INTERFACES - CANCELABLE");
        System.out.println("═══════════════════════════════════════════════════════════════\n");

        Cancelable cancelable = (AquaAerobics) activities[1];
        System.out.println("Política: " + cancelable.obtenerPoliticaCancelacion());
        
        double reembolso = cancelable.calcularReembolso(10, 240000);
        System.out.println("Reembolso con 10 días anticipación: $" + reembolso);

        System.out.println("\n═══════════════════════════════════════════════════════════════");
        System.out.println("  MÚLTIPLE IMPLEMENTACIÓN (HydroTherapy)");
        System.out.println("═══════════════════════════════════════════════════════════════\n");

        HydroTherapy therapy = (HydroTherapy) activities[2];
        
        System.out.println("→ Como Reservable:");
        String codigoTerapia = therapy.realizarReserva("Elena Martínez", "2025-02-01", 1);
        System.out.println("  Reserva: " + codigoTerapia);
        
        System.out.println("\n→ Como Evaluable:");
        therapy.agregarCalificacion(5, "Excelente tratamiento", "Elena");
        System.out.println("  Calificación: " + therapy.obtenerPromedioCalificaciones() + " ⭐");
        
        System.out.println("\n→ Como Cancelable:");
        System.out.println("  Política: " + therapy.obtenerPoliticaCancelacion());

        System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║               DEMOSTRACIÓN COMPLETADA                        ║");
        System.out.println("║  ✓ Clase abstracta con métodos abstractos y concretos       ║");
        System.out.println("║  ✓ 3 Interfaces: Reservable, Evaluable, Cancelable          ║");
        System.out.println("║  ✓ Múltiple implementación en HydroTherapy                  ║");
        System.out.println("║  ✓ Estructura de paquetes: com.aquafitness.*                ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
    }
}

