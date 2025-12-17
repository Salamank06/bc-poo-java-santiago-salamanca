import java.util.ArrayList;

/**
 * Programa principal - Semana 03: Encapsulación y Validaciones
 * @author Santiago Salamanca Narváez
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║     AQUA FITNESS - SEMANA 03: ENCAPSULACIÓN Y VALIDACIONES  ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝\n");

        // Crear centro con constructor
        AquaticsCenter aquaFitness = new AquaticsCenter("Aqua Fitness", "Bogotá - Salitre");
        
        System.out.println("=== DEMOSTRACIÓN 1: SOBRECARGA DE CONSTRUCTORES ===\n");
        
        // Student con 3 constructores sobrecargados
        Student student1 = new Student("EST-001", "María González", 8, "maria@gmail.com", "3101234567");
        System.out.println("✓ Constructor completo: " + student1.getStudentSummary());
        
        Student student2 = new Student("EST-002", "Carlos Rodríguez", 15, "carlos@gmail.com");
        System.out.println("✓ Constructor sin teléfono: " + student2.getStudentSummary());
        
        Student student3 = new Student("EST-003", "Ana Martínez", 25);
        System.out.println("✓ Constructor mínimo: " + student3.getStudentSummary() + " - Email: " + student3.getEmail());
        
        // Instructor con 3 constructores sobrecargados
        System.out.println();
        Instructor instructor1 = new Instructor("I001", "Carlos Pérez", "FEDECOL Nivel 3", 8, "Natación Infantil");
        System.out.println("✓ Constructor completo: " + instructor1.getInstructorSummary());
        
        Instructor instructor2 = new Instructor("I002", "Laura López", "ASFA Avanzado", 12);
        System.out.println("✓ Constructor sin especialización: " + instructor2.getInstructorSummary());
        
        Instructor instructor3 = new Instructor("I003", "Miguel Gómez", "FEDECOL Nivel 2");
        System.out.println("✓ Constructor nuevo instructor: " + instructor3.getInstructorSummary() + " - " + instructor3.getExperienceLevel());
        
        // Pool con 3 constructores sobrecargados
        System.out.println();
        Pool pool1 = new Pool("P001", "Piscina Semi-Olímpica", "Competencia", 50, 27.0);
        System.out.println("✓ Constructor completo: " + pool1.getPoolSummary());
        
        Pool pool2 = new Pool("P002", "Piscina Recreativa", "Recreación", 30);
        System.out.println("✓ Constructor con temp por defecto: " + pool2.getPoolSummary() + " - " + pool2.getTemperature() + "°C");
        
        Pool pool3 = new Pool("P003", "Piscina Terapéutica", "Hidroterapia");
        System.out.println("✓ Constructor mínimo: " + pool3.getPoolSummary() + " - Cap: " + pool3.getMaxCapacity());
        
        // Schedule con 3 constructores sobrecargados
        System.out.println();
        Schedule schedule1 = new Schedule("Lunes y Miércoles", "08:00", "09:00");
        System.out.println("✓ Constructor completo: " + schedule1.getScheduleSummary());
        
        Schedule schedule2 = new Schedule("Martes y Jueves", "10:00");
        System.out.println("✓ Constructor 1 hora por defecto: " + schedule2.getScheduleSummary());
        
        Schedule schedule3 = new Schedule("Viernes", "15:00", 90);
        System.out.println("✓ Constructor con duración: " + schedule3.getScheduleSummary() + " (" + schedule3.getFormattedDuration() + ")");
        
        System.out.println("\n=== DEMOSTRACIÓN 2: VALIDACIONES EN SETTERS ===\n");
        
        try {
            Student invalidStudent = new Student("INVALID", "Test", 10);
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Validación ID estudiante: " + e.getMessage());
        }
        
        try {
            student1.setAge(150);
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Validación edad: " + e.getMessage());
        }
        
        try {
            student1.setEmail("correo-invalido");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Validación email: " + e.getMessage());
        }
        
        try {
            pool1.setTemperature(50.0);
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Validación temperatura: " + e.getMessage());
        }
        
        try {
            SwimmingClass invalidClass = new SwimmingClass("INVALID", "Bebés", instructor1, pool1, schedule1);
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Validación código clase: " + e.getMessage());
        }
        
        System.out.println("\n=== DEMOSTRACIÓN 3: MÉTODOS PRIVADOS Y AUXILIARES ===\n");
        
        // Los métodos privados se usan internamente para validaciones
        System.out.println("Estudiante 1 - Categoría de edad: " + student1.getAgeCategory());
        System.out.println("Piscina 1 - Estado temperatura: " + pool1.getTemperatureStatus());
        System.out.println("Horario 1 - Turno: " + schedule1.getShift());
        System.out.println("Instructor 1 - Nivel experiencia: " + instructor1.getExperienceLevel());
        
        System.out.println("\n=== DEMOSTRACIÓN 4: SISTEMA COMPLETO CON VALIDACIONES ===\n");
        
        // Agregar al centro
        aquaFitness.addPool(pool1);
        aquaFitness.addPool(pool2);
        aquaFitness.addInstructor(instructor1);
        aquaFitness.addInstructor(instructor2);
        aquaFitness.addStudent(student1);
        aquaFitness.addStudent(student2);
        aquaFitness.addStudent(student3);
        
        System.out.println();
        
        // Crear clases con constructores sobrecargados
        SwimmingClass class1 = new SwimmingClass("SWIM-101", "Bebés", instructor1, pool2, schedule1, 8, 150000);
        SwimmingClass class2 = new SwimmingClass("SWIM-102", "Niños Principiantes", instructor1, pool2, schedule2, 180000);
        SwimmingClass class3 = new SwimmingClass("SWIM-201", "Adolescentes Intermedio", instructor2, pool1, schedule3);
        
        aquaFitness.addSwimmingClass(class1);
        aquaFitness.addSwimmingClass(class2);
        aquaFitness.addSwimmingClass(class3);
        
        System.out.println("\n=== DEMOSTRACIÓN 5: ENCAPSULACIÓN EN ACCIÓN ===\n");
        
        // Activar membresías
        student1.activateMembership();
        student2.activateMembership();
        
        // Inscribir estudiantes
        class1.enrollStudent();
        class2.enrollStudent();
        class2.enrollStudent();
        
        // Mostrar información detallada (acceso controlado mediante getters)
        System.out.println();
        class2.showFullInfo();
        
        System.out.println("\n=== DEMOSTRACIÓN 6: MODIFICACIONES CON VALIDACIONES ===\n");
        
        // Modificar precio con validación
        System.out.println("Precio original clase 1: $" + class1.getMonthlyPrice());
        class1.setMonthlyPrice(160000);
        System.out.println("Precio nuevo clase 1: $" + class1.getMonthlyPrice());
        
        // Ajustar temperatura con validación
        System.out.println("\nTemperatura original pool1: " + pool1.getTemperature() + "°C");
        pool1.adjustTemperature(1.5);
        pool1.adjustTemperature(-2.0);
        
        // Modificar estado
        System.out.println();
        class3.setActive(false);
        
        System.out.println("\n=== DEMOSTRACIÓN 7: GETTERS PROTEGIENDO ENCAPSULACIÓN ===\n");
        
        // Los getters de colecciones retornan copias para proteger la encapsulación
        ArrayList<SwimmingClass> classesCopy = aquaFitness.getSwimmingClasses();
        System.out.println("✓ Número de clases obtenidas: " + classesCopy.size());
        System.out.println("✓ Las colecciones retornan copias para proteger datos internos");
        
        aquaFitness.showStatistics();
        
        System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║               DEMOSTRACIÓN COMPLETADA                        ║");
        System.out.println("║                                                              ║");
        System.out.println("║  ✓ Encapsulación completa (todos los atributos private)     ║");
        System.out.println("║  ✓ Sobrecarga de constructores (2-3 por clase)              ║");
        System.out.println("║  ✓ Validaciones en constructores y setters                  ║");
        System.out.println("║  ✓ Métodos privados de validación                           ║");
        System.out.println("║  ✓ IllegalArgumentException para errores                    ║");
        System.out.println("║  ✓ Getters retornando copias (protección)                   ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
    }
}
