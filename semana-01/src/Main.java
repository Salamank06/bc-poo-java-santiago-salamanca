/**
 * Programa de demostración del sistema de gestión de Aqua Fitness
 * @author Santiago Salamanca Narváez
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║  CENTRO DE NATACIÓN AQUA FITNESS - SISTEMA DE GESTIÓN      ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝\n");

        System.out.println("--- CREACIÓN DE CLASES DE NATACIÓN ---\n");
        
        SwimmingClass class1 = new SwimmingClass("SWIM-001", "Bebés", "Instructor Pérez", 8, 150000);
        SwimmingClass class2 = new SwimmingClass("SWIM-002", "Niños Principiantes", "Instructora López", 12, 180000);
        SwimmingClass class3 = new SwimmingClass("SWIM-003", "Adolescentes Intermedio", "Instructor Gómez", 10, 200000);
        SwimmingClass class4 = new SwimmingClass("SWIM-004", "Adultos Avanzado", "Instructora Martínez", 8, 220000);

        System.out.println("--- CREACIÓN DE ESTUDIANTES ---\n");
        
        Student student1 = new Student("EST-001", "María González", 8, "maria.gonzalez@email.com");
        Student student2 = new Student("EST-002", "Carlos Rodríguez", 15, "carlos.rodriguez@email.com");
        Student student3 = new Student("EST-003", "Ana Martínez", 25, "ana.martinez@email.com");

        System.out.println("--- INFORMACIÓN DE LAS CLASES ---\n");
        
        class1.showInfo();
        System.out.println();
        class2.showInfo();
        System.out.println();
        class3.showInfo();
        System.out.println();
        class4.showInfo();
        System.out.println();

        System.out.println("--- CÁLCULO DE PRECIO TRIMESTRAL (10% descuento) ---\n");
        System.out.println("Clase " + class1.getClassCode() + " - Precio trimestral: $" + class1.calculateQuarterlyPrice());
        System.out.println("Clase " + class2.getClassCode() + " - Precio trimestral: $" + class2.calculateQuarterlyPrice());
        System.out.println();

        System.out.println("--- INFORMACIÓN DE ESTUDIANTES ---\n");
        
        student1.showStudentInfo();
        System.out.println("Categoría de edad: " + student1.getAgeCategory());
        System.out.println();
        
        student2.showStudentInfo();
        System.out.println("Categoría de edad: " + student2.getAgeCategory());
        System.out.println();
        
        student3.showStudentInfo();
        System.out.println("Categoría de edad: " + student3.getAgeCategory());
        System.out.println();

        System.out.println("--- PROCESO DE INSCRIPCIÓN ---\n");
        
        if (student1.canEnroll()) {
            student1.enrollInClass(class2.getClassCode());
            class2.enrollStudent();
        }
        System.out.println();

        if (student2.canEnroll()) {
            student2.enrollInClass(class3.getClassCode());
            class3.enrollStudent();
        }
        System.out.println();

        if (student3.canEnroll()) {
            student3.enrollInClass(class4.getClassCode());
            class4.enrollStudent();
        }
        System.out.println();

        System.out.println("--- ESTADO DESPUÉS DE INSCRIPCIONES ---\n");
        
        student1.showStudentInfo();
        System.out.println();
        
        class2.showInfo();
        System.out.println("Cupos disponibles: " + class2.getAvailableSpots());
        System.out.println("¿Está llena?: " + (class2.isFull() ? "Sí" : "No"));
        System.out.println();

        System.out.println("--- MODIFICACIÓN DE PRECIO Y ESTADO ---\n");
        
        System.out.println("Actualizando precio de " + class1.getClassCode() + "...");
        class1.setMonthlyPrice(160000);
        class1.showInfo();
        System.out.println();

        System.out.println("Desactivando " + class4.getClassCode() + "...");
        class4.setActive(false);
        class4.showInfo();
        System.out.println();

        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║              FIN DE LA DEMOSTRACIÓN                        ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
    }
}

