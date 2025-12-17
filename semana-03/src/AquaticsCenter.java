import java.util.ArrayList;

/**
 * Clase gestora con encapsulación completa y validaciones
 * @author Santiago Salamanca Narváez
 * @version 2.0 - Semana 03
 */
public class AquaticsCenter {
    private String centerName;
    private String location;
    private ArrayList<SwimmingClass> swimmingClasses;
    private ArrayList<Student> students;
    private ArrayList<Pool> pools;
    private ArrayList<Instructor> instructors;

    // Constructor completo con validaciones
    public AquaticsCenter(String centerName, String location) {
        setCenterName(centerName);
        setLocation(location);
        this.swimmingClasses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.pools = new ArrayList<>();
        this.instructors = new ArrayList<>();
    }

    // Constructor sobrecargado: solo nombre
    public AquaticsCenter(String centerName) {
        this(centerName, "Ubicación por definir");
    }

    // Métodos privados de validación
    private boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty() && name.length() >= 3;
    }

    private boolean isValidLocation(String location) {
        return location != null && !location.trim().isEmpty();
    }

    // Métodos de gestión con validaciones
    public void addSwimmingClass(SwimmingClass swimmingClass) {
        if (swimmingClass == null) {
            throw new IllegalArgumentException("La clase no puede ser nula");
        }
        if (findClassByCode(swimmingClass.getClassCode()) != null) {
            throw new IllegalArgumentException("Ya existe una clase con ese código");
        }
        swimmingClasses.add(swimmingClass);
        System.out.println("✓ Clase agregada: " + swimmingClass.getClassCode());
    }

    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("El estudiante no puede ser nulo");
        }
        if (findStudentById(student.getStudentId()) != null) {
            throw new IllegalArgumentException("Ya existe un estudiante con ese ID");
        }
        students.add(student);
        System.out.println("✓ Estudiante registrado: " + student.getFullName());
    }

    public void addPool(Pool pool) {
        if (pool == null) {
            throw new IllegalArgumentException("La piscina no puede ser nula");
        }
        pools.add(pool);
        System.out.println("✓ Piscina registrada: " + pool.getPoolName());
    }

    public void addInstructor(Instructor instructor) {
        if (instructor == null) {
            throw new IllegalArgumentException("El instructor no puede ser nulo");
        }
        instructors.add(instructor);
        System.out.println("✓ Instructor registrado: " + instructor.getFullName());
    }

    public void showAllClasses() {
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║        CLASES DISPONIBLES EN " + centerName.toUpperCase() + "        ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        
        if (swimmingClasses.isEmpty()) {
            System.out.println("No hay clases registradas.");
            return;
        }

        for (int i = 0; i < swimmingClasses.size(); i++) {
            SwimmingClass sc = swimmingClasses.get(i);
            System.out.println("\n" + (i + 1) + ". " + sc.getClassSummary());
            System.out.println("   Instructor: " + sc.getInstructor().getFullName());
            System.out.println("   Piscina: " + sc.getAssignedPool().getPoolName());
            System.out.println("   Cupos disponibles: " + sc.getAvailableSpots());
            System.out.println("   Estado: " + sc.getOccupancyStatus());
        }
    }

    public void showAllStudents() {
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║              ESTUDIANTES REGISTRADOS                   ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        
        if (students.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println((i + 1) + ". " + student.getStudentSummary() + 
                             " - " + (student.hasActiveMembership() ? "ACTIVO" : "INACTIVO"));
        }
    }

    public void showStatistics() {
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║            ESTADÍSTICAS DEL CENTRO                     ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        System.out.println("Centro: " + centerName);
        System.out.println("Ubicación: " + location);
        System.out.println("─────────────────────────────────────────────────────────");
        System.out.println("Total de clases: " + swimmingClasses.size());
        System.out.println("Clases activas: " + countActiveClasses());
        System.out.println("Total de estudiantes: " + students.size());
        System.out.println("Estudiantes activos: " + countActiveStudents());
        System.out.println("Total de piscinas: " + pools.size());
        System.out.println("Total de instructores: " + instructors.size());
        System.out.println("Cupos totales disponibles: " + getTotalAvailableSpots());
        System.out.println("─────────────────────────────────────────────────────────");
    }

    // Métodos de búsqueda
    public SwimmingClass findClassByCode(String classCode) {
        for (SwimmingClass sc : swimmingClasses) {
            if (sc.getClassCode().equals(classCode)) {
                return sc;
            }
        }
        return null;
    }

    public Student findStudentById(String studentId) {
        for (Student s : students) {
            if (s.getStudentId().equals(studentId)) {
                return s;
            }
        }
        return null;
    }

    public ArrayList<SwimmingClass> getClassesByLevel(String level) {
        ArrayList<SwimmingClass> result = new ArrayList<>();
        for (SwimmingClass sc : swimmingClasses) {
            if (sc.getLevel().equalsIgnoreCase(level)) {
                result.add(sc);
            }
        }
        return result;
    }

    // Métodos de conteo
    public int countActiveClasses() {
        int count = 0;
        for (SwimmingClass sc : swimmingClasses) {
            if (sc.isActive()) {
                count++;
            }
        }
        return count;
    }

    public int countActiveStudents() {
        int count = 0;
        for (Student s : students) {
            if (s.hasActiveMembership()) {
                count++;
            }
        }
        return count;
    }

    public int getTotalAvailableSpots() {
        int total = 0;
        for (SwimmingClass sc : swimmingClasses) {
            total += sc.getAvailableSpots();
        }
        return total;
    }

    // Getters
    public String getCenterName() {
        return centerName;
    }

    public String getLocation() {
        return location;
    }

    public ArrayList<SwimmingClass> getSwimmingClasses() {
        return new ArrayList<>(swimmingClasses); // retornar copia para proteger encapsulación
    }

    public ArrayList<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public ArrayList<Pool> getPools() {
        return new ArrayList<>(pools);
    }

    public ArrayList<Instructor> getInstructors() {
        return new ArrayList<>(instructors);
    }

    // Setters con validaciones
    public void setCenterName(String centerName) {
        if (!isValidName(centerName)) {
            throw new IllegalArgumentException("Nombre de centro inválido. Debe tener al menos 3 caracteres");
        }
        this.centerName = centerName.trim();
    }

    public void setLocation(String location) {
        if (!isValidLocation(location)) {
            throw new IllegalArgumentException("Ubicación inválida. No puede estar vacía");
        }
        this.location = location.trim();
    }
}
