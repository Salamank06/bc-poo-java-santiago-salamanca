public class Main {
    public static void main(String[] args) {
        System.out.println("=== CENTRO DE NATACIÓN AQUA FITNESS - DEMO POO ===\n");
        
        // 1. CREAR OBJETOS
        
        ClaseNatacion bebe = new ClaseNatacion("BAB-001", "Bebés", "Instructora López", 3, 150000.0);
        ClaseNatacion avanzado = new ClaseNatacion("AVZ-002", "Adultos Avanzado", "Instructor Gómez", 8, 120000.0);
        
        Estudiante estSantiago = new Estudiante(101, "Santiago Salamanca", "3001234567", "Intermedio");
        Estudiante estAna = new Estudiante(102, "Ana Lucía Marín", "3109876543", "Principiante");
        
        // 2. DEMOSTRACIÓN DE FUNCIONALIDADES
        
        System.out.println("--- PRUEBA CLASE: BAB-001 (BEBÉS) ---");
        bebe.mostrarDetalles(); 
        
        System.out.println("\nIntentando inscribir a " + estSantiago.getNombreCompleto() + "...");
        if (bebe.inscribirEstudiante()) { 
             System.out.println("Inscripción exitosa. Procesando pago...");
             estSantiago.realizarPago(150000.0); 
        }
        bebe.mostrarDetalles();
        
        System.out.println("\n--- PRUEBA CLASE AVZ-002 (AVANZADO) ---");
        avanzado.mostrarDetalles();
        
        System.out.println("Instructor asignado (Getter): " + avanzado.getInstructor());
        
        System.out.printf("Ingreso máximo potencial actual: $%.2f%n", avanzado.calcularIngresoMaximo());
        
        avanzado.setEsActiva(false); 
        avanzado.mostrarDetalles();
        
        System.out.println("\n--- PRUEBA ESTUDIANTE: ANA LUCÍA ---");
        estAna.mostrarPerfil(); 
        estAna.realizarPago(120000.0); 
    }
}
