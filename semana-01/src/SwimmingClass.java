/**
 * Clase que representa una clase de natación en Aqua Fitness
 * @author Santiago Salamanca Narváez
 * @version 1.0
 */
public class SwimmingClass {
    private String classCode;
    private String level;
    private String instructor;
    private int capacity;
    private int enrolledStudents;
    private double monthlyPrice;
    private boolean isActive;

    public SwimmingClass(String classCode, String level, String instructor, int capacity, double monthlyPrice) {
        this.classCode = classCode;
        this.level = level;
        this.instructor = instructor;
        this.capacity = capacity;
        this.enrolledStudents = 0;
        this.monthlyPrice = monthlyPrice;
        this.isActive = true;
    }

    public void showInfo() {
        System.out.println("=== CLASE DE NATACIÓN ===");
        System.out.println("Código: " + classCode);
        System.out.println("Nivel: " + level);
        System.out.println("Instructor: " + instructor);
        System.out.println("Capacidad: " + enrolledStudents + "/" + capacity + " estudiantes");
        System.out.println("Precio mensual: $" + monthlyPrice);
        System.out.println("Estado: " + (isActive ? "ACTIVA" : "INACTIVA"));
    }

    public double calculateQuarterlyPrice() {
        final int MONTHS_PER_QUARTER = 3;
        final double DISCOUNT = 0.10;
        double totalPrice = monthlyPrice * MONTHS_PER_QUARTER;
        return totalPrice - (totalPrice * DISCOUNT);
    }

    public boolean enrollStudent() {
        if (enrolledStudents < capacity && isActive) {
            enrolledStudents++;
            return true;
        }
        return false;
    }

    public boolean isFull() {
        return enrolledStudents >= capacity;
    }

    public String getClassCode() {
        return classCode;
    }

    public String getLevel() {
        return level;
    }

    public int getAvailableSpots() {
        return capacity - enrolledStudents;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setMonthlyPrice(double monthlyPrice) {
        if (monthlyPrice > 0) {
            this.monthlyPrice = monthlyPrice;
        }
    }
}

