import java.util.ArrayList;

/**
 * Clase gestora del centro acuático (usa ArrayList)
 * @author Santiago Salamanca Narváez
 * @version 1.0
 */
public class AquaticsCenter {
    private String centerName;
    private String location;
    private ArrayList<SwimmingClass> swimmingClasses;
    private ArrayList<Student> students;
    private ArrayList<Pool> pools;
    private ArrayList<Instructor> instructors;

    public AquaticsCenter(String centerName, String location) {
        this.centerName = centerName;
        this.location = location;
        this.swimmingClasses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.pools = new ArrayList<>();
        this.instructors = new ArrayList<>();
    }

    public void addSwimmingClass(SwimmingClass swimmingClass) {
        swimmingClasses.add(swimmingClass);
        System.out.println("✓ Clase agregada: " + swimmingClass.getClassCode());
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("✓ Estudiante registrado: " + student.getFullName());
    }

    public void addPool(Pool pool) {
        pools.add(pool);
        System.out.println("✓ Piscina registrada: " + pool.getPoolName());
    }

    public void addInstructor(Instructor instructor) {
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
            System.out.println((i + 1) + ". " + student.getStudentSummary());
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
        System.out.println("Total de estudiantes: " + students.size());
        System.out.println("Total de piscinas: " + pools.size());
        System.out.println("Total de instructores: " + instructors.size());
        System.out.println("Cupos totales disponibles: " + getTotalAvailableSpots());
        System.out.println("─────────────────────────────────────────────────────────");
    }

    public int getTotalAvailableSpots() {
        int total = 0;
        for (SwimmingClass sc : swimmingClasses) {
            total += sc.getAvailableSpots();
        }
        return total;
    }

    public SwimmingClass findClassByCode(String classCode) {
        for (SwimmingClass sc : swimmingClasses) {
            if (sc.getClassCode().equals(classCode)) {
                return sc;
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

    public int countActiveClasses() {
        int count = 0;
        for (SwimmingClass sc : swimmingClasses) {
            if (sc.isActive()) {
                count++;
            }
        }
        return count;
    }

    public String getCenterName() {
        return centerName;
    }

    public String getLocation() {
        return location;
    }

    public ArrayList<SwimmingClass> getSwimmingClasses() {
        return swimmingClasses;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Pool> getPools() {
        return pools;
    }

    public ArrayList<Instructor> getInstructors() {
        return instructors;
    }
}


