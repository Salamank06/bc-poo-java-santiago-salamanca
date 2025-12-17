/**
 * Programa principal - Semana 02: Clases, Objetos y ArrayList
 * Demuestra relaciones entre objetos y uso de colecciones
 * @author Santiago Salamanca Narváez
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║     CENTRO DE NATACIÓN AQUA FITNESS - SISTEMA COMPLETO      ║");
        System.out.println("║                    SEMANA 02                                 ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝\n");

        // Crear el centro acuático (clase gestora con ArrayList)
        AquaticsCenter aquaFitness = new AquaticsCenter("Aqua Fitness", "Bogotá - Salitre");
        
        System.out.println("=== PASO 1: REGISTRAR PISCINAS ===\n");
        Pool pool1 = new Pool("P001", "Piscina Semi-Olímpica", "Competencia", 50, 27.0);
        Pool pool2 = new Pool("P002", "Piscina Recreativa", "Recreación", 30, 29.0);
        
        aquaFitness.addPool(pool1);
        aquaFitness.addPool(pool2);
        
        System.out.println("\n=== PASO 2: REGISTRAR INSTRUCTORES ===\n");
        Instructor instructor1 = new Instructor("I001", "Carlos Pérez", "FEDECOL Nivel 3", 8, "Natación Infantil");
        Instructor instructor2 = new Instructor("I002", "Laura López", "ASFA Avanzado", 12, "Natación Deportiva");
        Instructor instructor3 = new Instructor("I003", "Miguel Gómez", "FEDECOL Nivel 2", 5, "Aquaeróbicos");
        
        aquaFitness.addInstructor(instructor1);
        aquaFitness.addInstructor(instructor2);
        aquaFitness.addInstructor(instructor3);
        
        System.out.println("\n=== PASO 3: CREAR HORARIOS ===\n");
        Schedule schedule1 = new Schedule("Lunes y Miércoles", "08:00", "09:00");
        Schedule schedule2 = new Schedule("Martes y Jueves", "10:00", "11:30");
        Schedule schedule3 = new Schedule("Viernes", "15:00", "16:00");
        Schedule schedule4 = new Schedule("Sábado", "09:00", "10:30");
        
        System.out.println("✓ Horario 1: " + schedule1.getScheduleSummary() + " (" + schedule1.getDurationMinutes() + " min)");
        System.out.println("✓ Horario 2: " + schedule2.getScheduleSummary() + " (" + schedule2.getDurationMinutes() + " min)");
        System.out.println("✓ Horario 3: " + schedule3.getScheduleSummary() + " (" + schedule3.getDurationMinutes() + " min)");
        System.out.println("✓ Horario 4: " + schedule4.getScheduleSummary() + " (" + schedule4.getDurationMinutes() + " min)");
        
        System.out.println("\n=== PASO 4: CREAR CLASES DE NATACIÓN (CON RELACIONES) ===\n");
        
        SwimmingClass class1 = new SwimmingClass("SWIM-101", "Bebés", instructor1, pool2, schedule1, 8, 150000);
        SwimmingClass class2 = new SwimmingClass("SWIM-102", "Niños Principiantes", instructor1, pool2, schedule2, 12, 180000);
        SwimmingClass class3 = new SwimmingClass("SWIM-201", "Adolescentes Intermedio", instructor2, pool1, schedule3, 10, 200000);
        SwimmingClass class4 = new SwimmingClass("SWIM-301", "Adultos Avanzado", instructor2, pool1, schedule4, 8, 220000);
        
        aquaFitness.addSwimmingClass(class1);
        aquaFitness.addSwimmingClass(class2);
        aquaFitness.addSwimmingClass(class3);
        aquaFitness.addSwimmingClass(class4);
        
        System.out.println("\n=== PASO 5: REGISTRAR ESTUDIANTES ===\n");
        
        Student student1 = new Student("EST-001", "María González", 8, "maria.gonzalez@email.com", "3101234567");
        Student student2 = new Student("EST-002", "Carlos Rodríguez", 15, "carlos.rodriguez@email.com", "3109876543");
        Student student3 = new Student("EST-003", "Ana Martínez", 25, "ana.martinez@email.com", "3205551234");
        Student student4 = new Student("EST-004", "Pedro Ramírez", 10, "pedro.ramirez@email.com", "3157778899");
        Student student5 = new Student("EST-005", "Sofía Torres", 28, "sofia.torres@email.com", "3186665544");
        
        aquaFitness.addStudent(student1);
        aquaFitness.addStudent(student2);
        aquaFitness.addStudent(student3);
        aquaFitness.addStudent(student4);
        aquaFitness.addStudent(student5);
        
        System.out.println("\n=== PASO 6: INSCRIBIR ESTUDIANTES EN CLASES ===\n");
        
        student1.activateMembership();
        class2.enrollStudent();
        
        student2.activateMembership();
        class3.enrollStudent();
        
        student3.activateMembership();
        class4.enrollStudent();
        
        student4.activateMembership();
        class2.enrollStudent();
        
        student5.activateMembership();
        class4.enrollStudent();
        
        System.out.println("\n=== PASO 7: MOSTRAR INFORMACIÓN DETALLADA DE UNA CLASE ===\n");
        class2.showFullInfo();
        
        System.out.println("\n=== PASO 8: MOSTRAR INFORMACIÓN DE PISCINA Y HORARIO ===\n");
        pool1.showPoolInfo();
        System.out.println();
        schedule2.showScheduleInfo();
        
        System.out.println("\n=== PASO 9: USAR MÉTODOS DE LA CLASE GESTORA (ArrayList) ===\n");
        aquaFitness.showStatistics();
        
        aquaFitness.showAllClasses();
        
        aquaFitness.showAllStudents();
        
        System.out.println("\n=== PASO 10: BÚSQUEDAS Y FILTROS ===\n");
        
        System.out.println("Buscando clase SWIM-102...");
        SwimmingClass foundClass = aquaFitness.findClassByCode("SWIM-102");
        if (foundClass != null) {
            System.out.println("✓ Encontrada: " + foundClass.getClassSummary());
        }
        
        System.out.println("\nClases activas: " + aquaFitness.countActiveClasses());
        
        System.out.println("\n=== PASO 11: DEMOSTRAR MÉTODOS DE NEGOCIO ===\n");
        
        System.out.println("¿La piscina recreativa puede acomodar 25 personas? " + pool2.canAccommodate(25));
        System.out.println("¿La clase SWIM-102 está llena? " + class2.isFull());
        System.out.println("¿El horario del viernes es en la mañana? " + schedule3.isInMorning());
        System.out.println("Precio trimestral de SWIM-301: $" + class4.calculateQuarterlyPrice());
        
        System.out.println("\n=== PASO 12: INFORMACIÓN DE INSTRUCTOR ===\n");
        instructor2.showInstructorInfo();
        System.out.println("¿Es instructor experimentado? " + instructor2.isExperienced());
        
        System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║               DEMOSTRACIÓN COMPLETADA                        ║");
        System.out.println("║                                                              ║");
        System.out.println("║  ✓ 2 Piscinas registradas                                    ║");
        System.out.println("║  ✓ 3 Instructores registrados                                ║");
        System.out.println("║  ✓ 4 Horarios creados                                        ║");
        System.out.println("║  ✓ 4 Clases con relaciones (Pool, Instructor, Schedule)     ║");
        System.out.println("║  ✓ 5 Estudiantes registrados                                 ║");
        System.out.println("║  ✓ ArrayList implementado en AquaticsCenter                  ║");
        System.out.println("║  ✓ Relaciones entre objetos demostradas                      ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
    }
}


