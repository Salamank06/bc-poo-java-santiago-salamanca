/**
 * Clase que representa un estudiante del centro de natación
 * @author Santiago Salamanca Narváez
 * @version 1.0
 */
public class Student {
    private String studentId;
    private String fullName;
    private int age;
    private String email;
    private String enrolledClass;
    private boolean hasActiveMembership;

    public Student(String studentId, String fullName, int age, String email) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.age = age;
        this.email = email;
        this.enrolledClass = "Sin asignar";
        this.hasActiveMembership = false;
    }

    public void showStudentInfo() {
        System.out.println("=== ESTUDIANTE ===");
        System.out.println("ID: " + studentId);
        System.out.println("Nombre: " + fullName);
        System.out.println("Edad: " + age + " años");
        System.out.println("Email: " + email);
        System.out.println("Clase asignada: " + enrolledClass);
        System.out.println("Membresía: " + (hasActiveMembership ? "ACTIVA" : "INACTIVA"));
    }

    public void enrollInClass(String classCode) {
        this.enrolledClass = classCode;
        this.hasActiveMembership = true;
        System.out.println(fullName + " se ha inscrito en la clase " + classCode);
    }

    public boolean canEnroll() {
        return !hasActiveMembership;
    }

    public String getAgeCategory() {
        if (age < 3) {
            return "Bebés (0-2 años)";
        } else if (age <= 12) {
            return "Niños (3-12 años)";
        } else if (age <= 17) {
            return "Adolescentes (13-17 años)";
        } else {
            return "Adultos (18+ años)";
        }
    }

    public String getFullName() {
        return fullName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setActiveMembership(boolean hasActiveMembership) {
        this.hasActiveMembership = hasActiveMembership;
    }
}


