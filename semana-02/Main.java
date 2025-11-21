public class Main {
    public static void main(String[] args) {
        System.out.println("=== WEEK 02: AQUA FITNESS OOP EXPANDED ===\n");

        // --- 1. CREATE OBJECTS ---
        Instructor instrLopez = new Instructor("E-001", "Lopez Instructor", 2000000.0, 6);
        Instructor instrGomez = new Instructor("E-002", "Gomez Instructor", 1800000.0, 3);

        Student studentSantiago = new Student(101, "Santiago Salamanca", "3001234567", "Intermediate");
        Student studentAna = new Student(102, "Ana Lucía Marín", "3109876543", "Beginner");

        SwimClass intermediate = new SwimClass("INT-003", "Adult Intermediate", instrLopez, 10, 150000.0);
        SwimClass advanced = new SwimClass("ADV-004", "Adult Advanced", instrGomez, 2, 250000.0);

        // --- 2. USE ARRAYLIST (MANAGER CLASS) ---
        AquaticsCenter center = new AquaticsCenter("AQUA FITNESS Main");
        center.addClass(intermediate);
        center.addClass(advanced);

        // --- 3. CREATE RELATIONSHIPS & USE ARRAYLIST IN SWIMCLASS ---
        System.out.println("--- ENROLLMENT TEST ---");
        intermediate.enrollStudent(studentSantiago);
        advanced.enrollStudent(studentAna);

        // Register Payments (New Class 2)
        Payment paymentSantiago = new Payment("PAGO-101", studentSantiago, 150000.0);
        Payment paymentAna = new Payment("PAGO-102", studentAna, 250000.0);

        // Use ArrayList in Manager Class
        center.registerPayment(paymentSantiago);
        center.registerPayment(paymentAna);

        // --- 4. DISPLAY RESULTS ---
        System.out.println("\n========================================");
        center.displayClassesWithCapacity();

        System.out.println("\nInstructor Details for INT-003: " + intermediate.getInstructorDetails());

        center.displayPaymentHistory();

        System.out.println("Total classes managed by the center: " + center.countClasses());
        System.out.println("========================================\n");
    }
}