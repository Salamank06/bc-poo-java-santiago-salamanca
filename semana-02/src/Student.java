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
    private String phoneNumber;
    private boolean hasActiveMembership;

    public Student(String studentId, String fullName, int age, String email, String phoneNumber) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hasActiveMembership = false;
    }

    public void showStudentInfo() {
        System.out.println("=== ESTUDIANTE ===");
        System.out.println("ID: " + studentId);
        System.out.println("Nombre: " + fullName);
        System.out.println("Edad: " + age + " años");
        System.out.println("Email: " + email);
        System.out.println("Teléfono: " + phoneNumber);
        System.out.println("Membresía: " + (hasActiveMembership ? "ACTIVA" : "INACTIVA"));
    }

    public void activateMembership() {
        this.hasActiveMembership = true;
        System.out.println("Membresía activada para " + fullName);
    }

    public String getAgeCategory() {
        if (age < 3) {
            return "Bebés";
        } else if (age <= 12) {
            return "Niños";
        } else if (age <= 17) {
            return "Adolescentes";
        } else {
            return "Adultos";
        }
    }

    public String getStudentSummary() {
        return fullName + " (" + age + " años) - " + getAgeCategory();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean hasActiveMembership() {
        return hasActiveMembership;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setActiveMembership(boolean hasActiveMembership) {
        this.hasActiveMembership = hasActiveMembership;
    }
}

