import java.util.ArrayList;

/**
 * Programa principal - Semana 05: Polimorfismo
 * Demuestra sobrecarga, sobrescritura y polimorfismo dinámico
 * @author Santiago Salamanca Narváez
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║     AQUA FITNESS - SEMANA 05: POLIMORFISMO                   ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝\n");

        // ===================================================================
        // DEMOSTRACIÓN 1: SOBRESCRITURA DE MÉTODOS (@Override)
        // ===================================================================
        System.out.println("═══════════════════════════════════════════════════════════════");
        System.out.println("  DEMOSTRACIÓN 1: SOBRESCRITURA DE MÉTODOS (@Override)");
        System.out.println("═══════════════════════════════════════════════════════════════\n");

        SwimmingLesson lesson1 = new SwimmingLesson(
            "SWIM-101", "Natación Bebés", "Instructor Pérez",
            "Lunes y Miércoles 9:00-10:00", 60, 25000, 8,
            "Bebés", "Familiarización", false
        );

        AquaAerobics aerobics1 = new AquaAerobics(
            "AERO-101", "Aquaeróbicos Intenso", "Coach Gómez",
            "Lunes, Miércoles y Viernes 7:00-8:00", 60, 22000, 20,
            "Alta", "Electrónica", true
        );

        HydroTherapy therapy1 = new HydroTherapy(
            "HYDRO-101", "Rehabilitación", "Dr. Torres",
            "Lunes a Viernes 14:00-15:00", 60, 50000, 4,
            "Rehabilitación", "Dra. Rodríguez", true, 12
        );

        System.out.println("→ Método calculateMonthlyPrice() sobrescrito en cada subclase:\n");
        System.out.println("SwimmingLesson (Bebés +20%): $" + lesson1.calculateMonthlyPrice());
        System.out.println("AquaAerobics (Equipo +20k): $" + aerobics1.calculateMonthlyPrice());
        System.out.println("HydroTherapy (Servicio médico +50%): $" + therapy1.calculateMonthlyPrice());

        System.out.println("\n→ Método getActivityType() sobrescrito en cada subclase:\n");
        System.out.println("SwimmingLesson: " + lesson1.getActivityType());
        System.out.println("AquaAerobics: " + aerobics1.getActivityType());
        System.out.println("HydroTherapy: " + therapy1.getActivityType());

        // ===================================================================
        // DEMOSTRACIÓN 2: SOBRECARGA DE MÉTODOS (OVERLOADING)
        // ===================================================================
        System.out.println("\n═══════════════════════════════════════════════════════════════");
        System.out.println("  DEMOSTRACIÓN 2: SOBRECARGA DE MÉTODOS (OVERLOADING)");
        System.out.println("═══════════════════════════════════════════════════════════════\n");

        ActivityCatalog catalog = new ActivityCatalog("Catálogo Aqua Fitness");

        // Agregar más actividades
        SwimmingLesson lesson2 = new SwimmingLesson(
            "SWIM-201", "Natación Adultos", "Instructora López",
            "Martes y Jueves 18:00-19:00", 60, 30000, 12,
            "Adultos", "Crol y Espalda", true
        );

        AquaAerobics aerobics2 = new AquaAerobics(
            "AERO-102", "Aquaeróbicos Suaves", "Coach Martínez",
            "Martes y Jueves 10:00-11:00", 60, 20000, 15,
            "Baja", "Latina", false
        );

        HydroTherapy therapy2 = new HydroTherapy(
            "HYDRO-102", "Antiestrés", "Lic. Silva",
            "Sábados 11:00-12:00", 60, 40000, 6,
            "Estrés", "Lic. Silva", false, 8
        );

        // Agregar al catálogo
        catalog.addActivity(lesson1);
        catalog.addActivity(lesson2);
        catalog.addActivity(aerobics1);
        catalog.addActivity(aerobics2);
        catalog.addActivity(therapy1);
        catalog.addActivity(therapy2);

        System.out.println("\n→ Método searchActivity() SOBRECARGADO (4 versiones):\n");

        // Sobrecarga 1: buscar por código (String)
        System.out.println("1. Búsqueda por código:");
        AquaticActivity found1 = catalog.searchActivity("SWIM-101");
        if (found1 != null) {
            System.out.println("   Encontrada: " + found1.getActivityName());
        }

        // Sobrecarga 2: buscar por instructor (String, String)
        System.out.println("\n2. Búsqueda por instructor:");
        ArrayList<AquaticActivity> found2 = catalog.searchActivity("instructor", "Coach Gómez");
        System.out.println("   Encontradas: " + found2.size() + " actividad(es)");

        // Sobrecarga 3: buscar por rango de precio (double, double)
        System.out.println("\n3. Búsqueda por rango de precio:");
        ArrayList<AquaticActivity> found3 = catalog.searchActivity(20000.0, 30000.0);
        System.out.println("   Encontradas: " + found3.size() + " actividad(es)");

        // Sobrecarga 4: buscar por duración (int)
        System.out.println("\n4. Búsqueda por duración:");
        ArrayList<AquaticActivity> found4 = catalog.searchActivity(60);
        System.out.println("   Encontradas: " + found4.size() + " actividad(es)");

        // ===================================================================
        // DEMOSTRACIÓN 3: POLIMORFISMO CON ARRAYLIST
        // ===================================================================
        System.out.println("\n═══════════════════════════════════════════════════════════════");
        System.out.println("  DEMOSTRACIÓN 3: POLIMORFISMO CON ARRAYLIST");
        System.out.println("═══════════════════════════════════════════════════════════════\n");

        // ArrayList polimórfico: tipo padre almacena objetos de tipo hijo
        ArrayList<AquaticActivity> activities = new ArrayList<>();
        activities.add(lesson1);
        activities.add(lesson2);
        activities.add(aerobics1);
        activities.add(aerobics2);
        activities.add(therapy1);
        activities.add(therapy2);

        System.out.println("→ ArrayList polimórfico creado: ArrayList<AquaticActivity>");
        System.out.println("  Contiene " + activities.size() + " actividades de diferentes tipos\n");

        // Inscribir algunos participantes
        lesson1.enrollParticipant();
        lesson1.enrollParticipant();
        lesson1.enrollParticipant();
        aerobics1.enrollParticipant();
        aerobics1.enrollParticipant();
        aerobics1.enrollParticipant();
        aerobics1.enrollParticipant();
        aerobics1.enrollParticipant();
        therapy1.enrollParticipant();
        therapy1.enrollParticipant();

        System.out.println("\n→ Iterando sobre ArrayList polimórfico:");
        System.out.println("  (Dynamic Binding: cada objeto llama a sus propios métodos)\n");

        for (AquaticActivity activity : activities) {
            System.out.println("──────────────────────────────────────");
            System.out.println("Código: " + activity.getActivityCode());
            System.out.println("Tipo: " + activity.getActivityType()); // Polimorfismo
            System.out.println("Precio mensual: $" + activity.calculateMonthlyPrice()); // Polimorfismo
            System.out.println("Tipo real: " + activity.getClass().getSimpleName());
        }

        // ===================================================================
        // DEMOSTRACIÓN 4: MÉTODOS POLIMÓRFICOS
        // ===================================================================
        System.out.println("\n═══════════════════════════════════════════════════════════════");
        System.out.println("  DEMOSTRACIÓN 4: MÉTODOS POLIMÓRFICOS");
        System.out.println("═══════════════════════════════════════════════════════════════");

        System.out.println("\n→ Método processActivity() acepta cualquier AquaticActivity:");
        catalog.processActivity(lesson2); // Funciona con SwimmingLesson
        catalog.processActivity(aerobics2); // Funciona con AquaAerobics

        System.out.println("\n→ Método processAllActivities() procesa todas:");
        catalog.processAllActivities();

        // ===================================================================
        // DEMOSTRACIÓN 5: DYNAMIC BINDING (ENLACE DINÁMICO)
        // ===================================================================
        System.out.println("\n═══════════════════════════════════════════════════════════════");
        System.out.println("  DEMOSTRACIÓN 5: DYNAMIC BINDING (ENLACE DINÁMICO)");
        System.out.println("═══════════════════════════════════════════════════════════════\n");

        System.out.println("→ Referencia de tipo padre, objetos de tipo hijo:\n");

        // Mismo tipo de referencia, diferentes tipos de objetos
        AquaticActivity activity1 = lesson1; // SwimmingLesson
        AquaticActivity activity2 = aerobics1; // AquaAerobics
        AquaticActivity activity3 = therapy1; // HydroTherapy

        System.out.println("activity1.getActivityType() → " + activity1.getActivityType());
        System.out.println("  (Tipo de referencia: AquaticActivity, Tipo real: " + 
                          activity1.getClass().getSimpleName() + ")");

        System.out.println("\nactivity2.getActivityType() → " + activity2.getActivityType());
        System.out.println("  (Tipo de referencia: AquaticActivity, Tipo real: " + 
                          activity2.getClass().getSimpleName() + ")");

        System.out.println("\nactivity3.getActivityType() → " + activity3.getActivityType());
        System.out.println("  (Tipo de referencia: AquaticActivity, Tipo real: " + 
                          activity3.getClass().getSimpleName() + ")");

        System.out.println("\n✓ Dynamic Binding: el método llamado se decide en tiempo de ejecución");
        System.out.println("  basándose en el tipo REAL del objeto, no en el tipo de la referencia.");

        // ===================================================================
        // DEMOSTRACIÓN 6: instanceof y CASTING
        // ===================================================================
        System.out.println("\n═══════════════════════════════════════════════════════════════");
        System.out.println("  DEMOSTRACIÓN 6: instanceof y CASTING");
        System.out.println("═══════════════════════════════════════════════════════════════\n");

        System.out.println("→ Usando instanceof para identificar tipos específicos:\n");

        for (AquaticActivity activity : activities) {
            if (activity instanceof SwimmingLesson) {
                SwimmingLesson lesson = (SwimmingLesson) activity; // Casting
                System.out.println("✓ " + activity.getActivityCode() + " es SwimmingLesson");
                System.out.println("  Nivel: " + lesson.getLevel());
                System.out.println("  Técnicas: " + lesson.getTechniquesFocus());
            } else if (activity instanceof AquaAerobics) {
                AquaAerobics aerobics = (AquaAerobics) activity;
                System.out.println("✓ " + activity.getActivityCode() + " es AquaAerobics");
                System.out.println("  Intensidad: " + aerobics.getIntensityLevel());
                System.out.println("  Calorías: " + aerobics.getCaloriesBurned() + " kcal");
            } else if (activity instanceof HydroTherapy) {
                HydroTherapy therapy = (HydroTherapy) activity;
                System.out.println("✓ " + activity.getActivityCode() + " es HydroTherapy");
                System.out.println("  Condición: " + therapy.getMedicalCondition());
                System.out.println("  Sesiones: " + therapy.getSessionsRecommended());
            }
            System.out.println();
        }

        // ===================================================================
        // DEMOSTRACIÓN 7: REPORTE Y ESTADÍSTICAS
        // ===================================================================
        System.out.println("═══════════════════════════════════════════════════════════════");
        System.out.println("  DEMOSTRACIÓN 7: REPORTE Y ESTADÍSTICAS");
        System.out.println("═══════════════════════════════════════════════════════════════");

        catalog.generateReport();
        catalog.showAvailableActivities();

        System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║               DEMOSTRACIÓN COMPLETADA                        ║");
        System.out.println("║                                                              ║");
        System.out.println("║  ✓ Sobrecarga: 4 versiones de searchActivity()              ║");
        System.out.println("║  ✓ Sobrescritura: 3 métodos @Override por subclase          ║");
        System.out.println("║  ✓ Polimorfismo: ArrayList<AquaticActivity>                 ║");
        System.out.println("║  ✓ Dynamic Binding: métodos resueltos en runtime            ║");
        System.out.println("║  ✓ Métodos polimórficos: aceptan clase padre                ║");
        System.out.println("║  ✓ instanceof y casting demostrados                          ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
    }
}
