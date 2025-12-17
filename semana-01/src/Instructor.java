/**
 * Clase adicional: Instructor del centro de natación
 * (Opcional - para demostrar más objetos del dominio)
 * @author Santiago Salamanca Narváez
 * @version 1.0
 */
public class Instructor {
    private String instructorId;
    private String fullName;
    private String certification;
    private int yearsOfExperience;
    private boolean isAvailable;

    public Instructor(String instructorId, String fullName, String certification, int yearsOfExperience) {
        this.instructorId = instructorId;
        this.fullName = fullName;
        this.certification = certification;
        this.yearsOfExperience = yearsOfExperience;
        this.isAvailable = true;
    }

    public void showInstructorInfo() {
        System.out.println("=== INSTRUCTOR ===");
        System.out.println("ID: " + instructorId);
        System.out.println("Nombre: " + fullName);
        System.out.println("Certificación: " + certification);
        System.out.println("Experiencia: " + yearsOfExperience + " años");
        System.out.println("Disponible: " + (isAvailable ? "Sí" : "No"));
    }

    public String getFullName() {
        return fullName;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}


