/**
 * Clase Student con encapsulación completa y validaciones
 * @author Santiago Salamanca Narváez
 * @version 2.0 - Semana 03
 */
public class Student {
    private String studentId;
    private String fullName;
    private int age;
    private String email;
    private String phoneNumber;
    private boolean hasActiveMembership;

    // Constructor completo con validaciones
    public Student(String studentId, String fullName, int age, String email, String phoneNumber) {
        setStudentId(studentId);
        setFullName(fullName);
        setAge(age);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        this.hasActiveMembership = false;
    }

    // Constructor sobrecargado: sin teléfono
    public Student(String studentId, String fullName, int age, String email) {
        this(studentId, fullName, age, email, "Sin teléfono");
    }

    // Constructor sobrecargado: datos mínimos
    public Student(String studentId, String fullName, int age) {
        this(studentId, fullName, age, fullName.toLowerCase().replace(" ", ".") + "@aquafitness.com", "Sin teléfono");
    }

    // Métodos privados de validación
    private boolean isValidStudentId(String id) {
        return id != null && id.matches("EST-\\d{3}");
    }

    private boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty() && name.length() >= 3;
    }

    private boolean isValidAge(int age) {
        return age >= 0 && age <= 100;
    }

    private boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }

    private boolean isValidPhoneNumber(String phone) {
        return phone != null && (phone.matches("\\d{10}") || phone.equals("Sin teléfono"));
    }

    // Métodos públicos
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
        System.out.println("✓ Membresía activada para " + fullName);
    }

    public void deactivateMembership() {
        this.hasActiveMembership = false;
        System.out.println("✓ Membresía desactivada para " + fullName);
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

    // Getters
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

    // Setters con validaciones
    public void setStudentId(String studentId) {
        if (!isValidStudentId(studentId)) {
            throw new IllegalArgumentException("ID de estudiante inválido. Debe tener formato EST-XXX");
        }
        this.studentId = studentId;
    }

    public void setFullName(String fullName) {
        if (!isValidName(fullName)) {
            throw new IllegalArgumentException("Nombre inválido. Debe tener al menos 3 caracteres");
        }
        this.fullName = fullName.trim();
    }

    public void setAge(int age) {
        if (!isValidAge(age)) {
            throw new IllegalArgumentException("Edad inválida. Debe estar entre 0 y 100 años");
        }
        this.age = age;
    }

    public void setEmail(String email) {
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Email inválido. Debe contener @ y dominio");
        }
        this.email = email.trim().toLowerCase();
    }

    public void setPhoneNumber(String phoneNumber) {
        if (!isValidPhoneNumber(phoneNumber)) {
            throw new IllegalArgumentException("Teléfono inválido. Debe tener 10 dígitos o 'Sin teléfono'");
        }
        this.phoneNumber = phoneNumber;
    }

    public void setActiveMembership(boolean hasActiveMembership) {
        this.hasActiveMembership = hasActiveMembership;
    }
}
