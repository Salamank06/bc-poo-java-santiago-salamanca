/**
 * Clase SwimmingClass con encapsulación completa y validaciones
 * @author Santiago Salamanca Narváez
 * @version 2.0 - Semana 03
 */
public class SwimmingClass {
    private static final double MIN_PRICE = 50000;
    private static final double MAX_PRICE = 500000;
    private static final int MIN_CAPACITY = 1;
    private static final int MAX_CAPACITY = 30;

    private String classCode;
    private String level;
    private Instructor instructor;
    private Pool assignedPool;
    private Schedule schedule;
    private int capacity;
    private int enrolledStudents;
    private double monthlyPrice;
    private boolean isActive;

    // Constructor completo con validaciones
    public SwimmingClass(String classCode, String level, Instructor instructor, 
                        Pool assignedPool, Schedule schedule, int capacity, double monthlyPrice) {
        setClassCode(classCode);
        setLevel(level);
        setInstructor(instructor);
        setAssignedPool(assignedPool);
        setSchedule(schedule);
        setCapacity(capacity);
        setMonthlyPrice(monthlyPrice);
        this.enrolledStudents = 0;
        this.isActive = true;
    }

    // Constructor sobrecargado: capacidad por defecto (10 personas)
    public SwimmingClass(String classCode, String level, Instructor instructor, 
                        Pool assignedPool, Schedule schedule, double monthlyPrice) {
        this(classCode, level, instructor, assignedPool, schedule, 10, monthlyPrice);
    }

    // Constructor sobrecargado: capacidad y precio por defecto
    public SwimmingClass(String classCode, String level, Instructor instructor, 
                        Pool assignedPool, Schedule schedule) {
        this(classCode, level, instructor, assignedPool, schedule, 10, 180000);
    }

    // Métodos privados de validación
    private boolean isValidClassCode(String code) {
        return code != null && code.matches("SWIM-\\d{3}");
    }

    private boolean isValidLevel(String level) {
        String[] validLevels = {"Bebés", "Niños", "Niños Principiantes", 
                               "Adolescentes", "Adolescentes Intermedio", 
                               "Adultos", "Adultos Avanzado", "Competencia"};
        for (String valid : validLevels) {
            if (valid.equalsIgnoreCase(level)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidCapacity(int capacity) {
        return capacity >= MIN_CAPACITY && capacity <= MAX_CAPACITY;
    }

    private boolean isValidPrice(double price) {
        return price >= MIN_PRICE && price <= MAX_PRICE;
    }

    // Métodos públicos
    public void showFullInfo() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║      CLASE DE NATACIÓN - DETALLE      ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Código: " + classCode);
        System.out.println("Nivel: " + level);
        System.out.println("Instructor: " + instructor.getFullName() + " (" + instructor.getExperienceLevel() + ")");
        System.out.println("Piscina: " + assignedPool.getPoolName());
        System.out.println("Horario: " + schedule.getScheduleSummary());
        System.out.println("Cupos: " + enrolledStudents + "/" + capacity);
        System.out.println("Disponibles: " + getAvailableSpots());
        System.out.println("Precio mensual: $" + monthlyPrice);
        System.out.println("Estado: " + (isActive ? "ACTIVA" : "INACTIVA"));
    }

    public String getClassSummary() {
        return classCode + " - " + level + " | " + schedule.getScheduleSummary();
    }

    public boolean enrollStudent() {
        if (!canEnrollMore()) {
            System.out.println("✗ No se puede inscribir. Clase llena o inactiva");
            return false;
        }
        enrolledStudents++;
        System.out.println("✓ Estudiante inscrito en " + classCode);
        return true;
    }

    public boolean unenrollStudent() {
        if (enrolledStudents > 0) {
            enrolledStudents--;
            System.out.println("✓ Estudiante dado de baja de " + classCode);
            return true;
        }
        return false;
    }

    public boolean canEnrollMore() {
        return enrolledStudents < capacity && isActive;
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

    public double calculateAnnualPrice() {
        final double ANNUAL_DISCOUNT = 0.15;
        double totalPrice = monthlyPrice * 12;
        return totalPrice - (totalPrice * ANNUAL_DISCOUNT);
    }

    public String getOccupancyStatus() {
        double occupancyRate = (double) enrolledStudents / capacity * 100;
        if (occupancyRate >= 90) {
            return "Casi llena (" + String.format("%.0f", occupancyRate) + "%)";
        } else if (occupancyRate >= 50) {
            return "Media ocupación (" + String.format("%.0f", occupancyRate) + "%)";
        } else {
            return "Baja ocupación (" + String.format("%.0f", occupancyRate) + "%)";
        }
    }

    // Getters
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

    // Setters con validaciones
    public void setClassCode(String classCode) {
        if (!isValidClassCode(classCode)) {
            throw new IllegalArgumentException("Código de clase inválido. Debe tener formato SWIM-XXX");
        }
        this.classCode = classCode;
    }

    public void setLevel(String level) {
        if (!isValidLevel(level)) {
            throw new IllegalArgumentException("Nivel inválido. Debe ser un nivel válido del centro");
        }
        this.level = level;
    }

    public void setInstructor(Instructor instructor) {
        if (instructor == null) {
            throw new IllegalArgumentException("El instructor no puede ser nulo");
        }
        this.instructor = instructor;
    }

    public void setAssignedPool(Pool assignedPool) {
        if (assignedPool == null) {
            throw new IllegalArgumentException("La piscina no puede ser nula");
        }
        this.assignedPool = assignedPool;
    }

    public void setSchedule(Schedule schedule) {
        if (schedule == null) {
            throw new IllegalArgumentException("El horario no puede ser nulo");
        }
        this.schedule = schedule;
    }

    public void setCapacity(int capacity) {
        if (!isValidCapacity(capacity)) {
            throw new IllegalArgumentException("Capacidad inválida. Debe estar entre " + MIN_CAPACITY + " y " + MAX_CAPACITY);
        }
        if (capacity < enrolledStudents) {
            throw new IllegalArgumentException("No se puede reducir la capacidad por debajo del número de estudiantes inscritos");
        }
        this.capacity = capacity;
    }

    public void setMonthlyPrice(double monthlyPrice) {
        if (!isValidPrice(monthlyPrice)) {
            throw new IllegalArgumentException("Precio inválido. Debe estar entre $" + MIN_PRICE + " y $" + MAX_PRICE);
        }
        this.monthlyPrice = monthlyPrice;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
        System.out.println("✓ Clase " + classCode + " " + (isActive ? "activada" : "desactivada"));
    }
}

