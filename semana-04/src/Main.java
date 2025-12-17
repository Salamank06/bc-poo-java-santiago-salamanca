/**
 * Programa principal - Semana 04: Herencia
 * Demuestra herencia, polimorfismo y arrays polimórficos
 * @author Santiago Salamanca Narváez
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║        AQUA FITNESS - SEMANA 04: HERENCIA                    ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝\n");

        System.out.println("=== DEMOSTRACIÓN 1: CREACIÓN DE OBJETOS CON HERENCIA ===\n");

        // Crear objetos de las subclases
        SwimmingLesson lesson1 = new SwimmingLesson(
            "SWIM-101", "Natación Bebés", "Instructor Pérez",
            "Lunes y Miércoles 9:00-10:00", 60, 25000, 8,
            "Bebés", "Familiarización con el agua", false
        );

        SwimmingLesson lesson2 = new SwimmingLesson(
            "SWIM-201", "Natación Avanzada", "Instructora López",
            "Martes y Jueves 18:00-19:30", 90, 30000, 12,
            "Adultos", "Crol y Espalda", true
        );

        AquaAerobics aerobics1 = new AquaAerobics(
            "AERO-101", "Aquaeróbicos Dinámicos", "Coach Gómez",
            "Lunes, Miércoles y Viernes 7:00-8:00", 60, 22000, 20,
            "Alta", "Electrónica", true
        );

        AquaAerobics aerobics2 = new AquaAerobics(
            "AERO-102", "Aquaeróbicos Suaves", "Coach Martínez",
            "Martes y Jueves 10:00-11:00", 60, 20000, 15,
            "Baja", "Música Latina", false
        );

        HydroTherapy therapy1 = new HydroTherapy(
            "HYDRO-101", "Rehabilitación Post-Lesión", "Dr. Torres",
            "Lunes a Viernes 14:00-15:00", 60, 50000, 4,
            "Rehabilitación", "Dra. Rodríguez", true, 12
        );

        HydroTherapy therapy2 = new HydroTherapy(
            "HYDRO-102", "Terapia Antiestrés", "Terapeuta Silva",
            "Sábados 11:00-12:00", 60, 40000, 6,
            "Estrés", "Lic. Silva", false, 8
        );

        System.out.println("✓ 6 actividades creadas usando herencia\n");

        System.out.println("=== DEMOSTRACIÓN 2: ARRAYS POLIMÓRFICOS ===\n");

        // Array polimórfico: referencia de tipo padre, objetos de tipo hijo
        AquaticActivity[] activities = new AquaticActivity[6];
        activities[0] = lesson1;
        activities[1] = lesson2;
        activities[2] = aerobics1;
        activities[3] = aerobics2;
        activities[4] = therapy1;
        activities[5] = therapy2;

        System.out.println("Array polimórfico creado con 6 actividades diferentes\n");

        System.out.println("=== DEMOSTRACIÓN 3: POLIMORFISMO EN ACCIÓN ===\n");

        // Polimorfismo: mismo bucle, diferentes comportamientos
        for (int i = 0; i < activities.length; i++) {
            System.out.println("─────── Actividad " + (i + 1) + " ───────");
            activities[i].showInfo(); // Llama al método sobrescrito de cada subclase
            System.out.println("Tipo: " + activities[i].getActivityType());
            System.out.println("Precio mensual: $" + activities[i].calculateMonthlyPrice());
            System.out.println();
        }

        System.out.println("=== DEMOSTRACIÓN 4: INSCRIPCIÓN DE PARTICIPANTES ===\n");

        // Inscribir participantes en diferentes actividades
        lesson1.enrollParticipant();
        lesson1.enrollParticipant();
        lesson1.enrollParticipant();

        aerobics1.enrollParticipant();
        aerobics1.enrollParticipant();
        aerobics1.enrollParticipant();
        aerobics1.enrollParticipant();
        aerobics1.enrollParticipant();

        therapy1.enrollParticipant(); // Requiere aprobación médica
        therapy1.enrollParticipant();

        System.out.println();

        System.out.println("=== DEMOSTRACIÓN 5: MÉTODOS ESPECÍFICOS DE SUBCLASES ===\n");

        System.out.println("--- SwimmingLesson: Métodos específicos ---");
        lesson2.evaluateProgress();
        System.out.println("Estado: " + lesson2.getSkillLevel());

        System.out.println("\n--- AquaAerobics: Métodos específicos ---");
        aerobics1.warmUp();
        System.out.println("Beneficios: " + aerobics1.getHealthBenefits());
        aerobics1.coolDown();

        System.out.println("\n--- HydroTherapy: Métodos específicos ---");
        therapy1.assessPatient();
        therapy1.generateTherapyPlan();
        System.out.println("Objetivos: " + therapy1.getTherapyGoals());
        System.out.println("Costo tratamiento completo: $" + therapy1.calculateTreatmentCost());

        System.out.println("\n=== DEMOSTRACIÓN 6: USO DE instanceof ===\n");

        // Verificar tipos en tiempo de ejecución
        for (int i = 0; i < activities.length; i++) {
            AquaticActivity activity = activities[i];
            
            if (activity instanceof SwimmingLesson) {
                SwimmingLesson lesson = (SwimmingLesson) activity; // Casting
                System.out.println(activity.getActivityCode() + " es una Clase de Natación - Nivel: " + lesson.getLevel());
            } else if (activity instanceof AquaAerobics) {
                AquaAerobics aerobics = (AquaAerobics) activity;
                System.out.println(activity.getActivityCode() + " es Aquaeróbicos - Intensidad: " + aerobics.getIntensityLevel());
            } else if (activity instanceof HydroTherapy) {
                HydroTherapy therapy = (HydroTherapy) activity;
                System.out.println(activity.getActivityCode() + " es Hidroterapia - Condición: " + therapy.getMedicalCondition());
            }
        }

        System.out.println("\n=== DEMOSTRACIÓN 7: GESTOR CON POLIMORFISMO ===\n");

        // Usar clase gestora con array polimórfico
        ActivityManager manager = new ActivityManager("Aqua Fitness", 10);
        
        manager.addActivity(lesson1);
        manager.addActivity(lesson2);
        manager.addActivity(aerobics1);
        manager.addActivity(aerobics2);
        manager.addActivity(therapy1);
        manager.addActivity(therapy2);

        manager.showStatistics();

        System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║               DEMOSTRACIÓN COMPLETADA                        ║");
        System.out.println("║                                                              ║");
        System.out.println("║  ✓ Clase padre AquaticActivity con atributos protected      ║");
        System.out.println("║  ✓ 3 Subclases con extends                                   ║");
        System.out.println("║  ✓ super() usado en todos los constructores                  ║");
        System.out.println("║  ✓ @Override en métodos sobrescritos                         ║");
        System.out.println("║  ✓ Arrays polimórficos implementados                         ║");
        System.out.println("║  ✓ instanceof para verificación de tipos                     ║");
        System.out.println("║  ✓ Casting seguro demostrado                                 ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
    }
}
