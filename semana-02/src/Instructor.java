/**
 * Clase que representa un instructor del centro de natación
 * @author Santiago Salamanca Narváez
 * @version 1.0
 */
public class Instructor {
    private String instructorId;
    private String fullName;
    private String certification;
    private int yearsOfExperience;
    private String specialization;

    public Instructor(String instructorId, String fullName, String certification, int yearsOfExperience, String specialization) {
        this.instructorId = instructorId;
        this.fullName = fullName;
        this.certification = certification;
        this.yearsOfExperience = yearsOfExperience;
        this.specialization = specialization;
    }

    public void showInstructorInfo() {
        System.out.println("=== INSTRUCTOR ===");
        System.out.println("ID: " + instructorId);
        System.out.println("Nombre: " + fullName);
        System.out.println("Certificación: " + certification);
        System.out.println("Experiencia: " + yearsOfExperience + " años");
        System.out.println("Especialización: " + specialization);
    }

    public String getInstructorSummary() {
        return fullName + " - " + certification;
    }

    public boolean isExperienced() {
        return yearsOfExperience >= 5;
    }

    public String getInstructorId() {
        return instructorId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCertification() {
        return certification;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}

