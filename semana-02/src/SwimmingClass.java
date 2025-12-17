/**
 * Clase que representa una clase de natación (con relaciones)
 * @author Santiago Salamanca Narváez
 * @version 1.0
 */
public class SwimmingClass {
    private String classCode;
    private String level;
    private Instructor instructor;
    private Pool assignedPool;
    private Schedule schedule;
    private int capacity;
    private int enrolledStudents;
    private double monthlyPrice;
    private boolean isActive;

    public SwimmingClass(String classCode, String level, Instructor instructor, 
                        Pool assignedPool, Schedule schedule, int capacity, double monthlyPrice) {
        this.classCode = classCode;
        this.level = level;
        this.instructor = instructor;
        this.assignedPool = assignedPool;
        this.schedule = schedule;
        this.capacity = capacity;
        this.enrolledStudents = 0;
        this.monthlyPrice = monthlyPrice;
        this.isActive = true;
    }

    public void showFullInfo() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║      CLASE DE NATACIÓN - DETALLE      ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Código: " + classCode);
        System.out.println("Nivel: " + level);
        System.out.println("Instructor: " + instructor.getFullName());
        System.out.println("Piscina: " + assignedPool.getPoolName());
        System.out.println("Horario: " + schedule.getScheduleSummary());
        System.out.println("Cupos: " + enrolledStudents + "/" + capacity);
        System.out.println("Precio mensual: $" + monthlyPrice);
        System.out.println("Estado: " + (isActive ? "ACTIVA" : "INACTIVA"));
        System.out.println("Duración: " + schedule.getDurationMinutes() + " minutos");
    }

    public String getClassSummary() {
        return classCode + " - " + level + " | " + schedule.getScheduleSummary();
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

    public int getAvailableSpots() {
        return capacity - enrolledStudents;
    }

    public double calculateQuarterlyPrice() {
        final double QUARTERLY_DISCOUNT = 0.10;
        double totalPrice = monthlyPrice * 3;
        return totalPrice - (totalPrice * QUARTERLY_DISCOUNT);
    }

    public String getClassCode() {
        return classCode;
    }

    public String getLevel() {
        return level;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public Pool getAssignedPool() {
        return assignedPool;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public double getMonthlyPrice() {
        return monthlyPrice;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public void setMonthlyPrice(double monthlyPrice) {
        if (monthlyPrice > 0) {
            this.monthlyPrice = monthlyPrice;
        }
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
}


