/**
 * Clase Instructor con encapsulación completa y validaciones
 * @author Santiago Salamanca Narváez
 * @version 2.0 - Semana 03
 */
public class Instructor {
    private String instructorId;
    private String fullName;
    private String certification;
    private int yearsOfExperience;
    private String specialization;

    // Constructor completo con validaciones
    public Instructor(String instructorId, String fullName, String certification, 
                     int yearsOfExperience, String specialization) {
        setInstructorId(instructorId);
        setFullName(fullName);
        setCertification(certification);
        setYearsOfExperience(yearsOfExperience);
        setSpecialization(specialization);
    }

    // Constructor sobrecargado: sin especialización
    public Instructor(String instructorId, String fullName, String certification, int yearsOfExperience) {
        this(instructorId, fullName, certification, yearsOfExperience, "General");
    }

    // Constructor sobrecargado: instructor nuevo (0 años experiencia)
    public Instructor(String instructorId, String fullName, String certification) {
        this(instructorId, fullName, certification, 0, "General");
    }

    // Métodos privados de validación
    private boolean isValidInstructorId(String id) {
        return id != null && id.matches("I\\d{3}");
    }

    private boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty() && name.length() >= 3;
    }

    private boolean isValidCertification(String cert) {
        return cert != null && !cert.trim().isEmpty();
    }

    private boolean isValidExperience(int years) {
        return years >= 0 && years <= 50;
    }

    private boolean isValidSpecialization(String spec) {
        return spec != null && !spec.trim().isEmpty();
    }

    // Métodos públicos
    public void showInstructorInfo() {
        System.out.println("=== INSTRUCTOR ===");
        System.out.println("ID: " + instructorId);
        System.out.println("Nombre: " + fullName);
        System.out.println("Certificación: " + certification);
        System.out.println("Experiencia: " + yearsOfExperience + " años");
        System.out.println("Especialización: " + specialization);
        System.out.println("Nivel: " + getExperienceLevel());
    }

    public String getInstructorSummary() {
        return fullName + " - " + certification;
    }

    public boolean isExperienced() {
        return yearsOfExperience >= 5;
    }

    public String getExperienceLevel() {
        if (yearsOfExperience == 0) {
            return "Novato";
        } else if (yearsOfExperience < 3) {
            return "Junior";
        } else if (yearsOfExperience < 5) {
            return "Intermedio";
        } else if (yearsOfExperience < 10) {
            return "Senior";
        } else {
            return "Experto";
        }
    }

    public void incrementExperience() {
        if (yearsOfExperience < 50) {
            yearsOfExperience++;
        }
    }

    // Getters
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

    // Setters con validaciones
    public void setInstructorId(String instructorId) {
        if (!isValidInstructorId(instructorId)) {
            throw new IllegalArgumentException("ID de instructor inválido. Debe tener formato IXXX");
        }
        this.instructorId = instructorId;
    }

    public void setFullName(String fullName) {
        if (!isValidName(fullName)) {
            throw new IllegalArgumentException("Nombre inválido. Debe tener al menos 3 caracteres");
        }
        this.fullName = fullName.trim();
    }

    public void setCertification(String certification) {
        if (!isValidCertification(certification)) {
            throw new IllegalArgumentException("Certificación inválida. No puede estar vacía");
        }
        this.certification = certification.trim();
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        if (!isValidExperience(yearsOfExperience)) {
            throw new IllegalArgumentException("Años de experiencia inválidos. Debe estar entre 0 y 50");
        }
        this.yearsOfExperience = yearsOfExperience;
    }

    public void setSpecialization(String specialization) {
        if (!isValidSpecialization(specialization)) {
            throw new IllegalArgumentException("Especialización inválida. No puede estar vacía");
        }
        this.specialization = specialization.trim();
    }
}
