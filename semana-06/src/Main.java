/**
 * Programa principal - Semana 06: Abstracción e Interfaces
 * @author Santiago Salamanca Narváez
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("AQUA FITNESS - SEMANA 06");
        System.out.println("Abstracción e Interfaces\n");

        // Array polimórfico
        AquaticActivity[] activities = new AquaticActivity[3];

        activities[0] = new SwimmingLesson(
            "SWIM-101", "Natación Bebés", "Instructor Pérez",
            "Lunes y Miércoles 9:00-10:00", 60, 25000, 8,
            "Bebés", "Familiarización", false
        );

        activities[1] = new AquaAerobics(
            "AERO-101", "Aquaeróbicos", "Coach Gómez",
            "Lunes, Miércoles y Viernes 7:00-8:00", 60, 22000, 20,
            "Alta", "Electrónica", true
        );

        activities[2] = new HydroTherapy(
            "HYDRO-101", "Rehabilitación", "Dr. Torres",
            "Lunes a Viernes 14:00-15:00", 60, 50000, 4,
            "Hernia discal", "Dra. Rodríguez", true, 12
        );

        System.out.println("=== POLIMORFISMO ===\n");
        for (AquaticActivity act : activities) {
            System.out.println(act.getActivityCode() + ": " + act.getActivityType());
            System.out.println("Precio mensual: $" + act.calculateMonthlyPrice());
            System.out.println("---");
        }

        System.out.println("\n=== INTERFACES ===\n");
        
        // Reservable
        Reservable r1 = (SwimmingLesson) activities[0];
        r1.realizarReserva("María González", "2025-01-15", 2);
        
        // Evaluable
        Evaluable e1 = (SwimmingLesson) activities[0];
        e1.agregarCalificacion(5, "Excelente", "Ana");
        System.out.println("Calificación: " + e1.obtenerPromedioCalificaciones());
        
        // Cancelable
        Cancelable c1 = (AquaAerobics) activities[1];
        System.out.println("Política: " + c1.obtenerPoliticaCancelacion());
        
        System.out.println("\n✓ Demostración completada");
    }
}
