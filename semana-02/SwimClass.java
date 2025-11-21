import java.util.ArrayList;

public class SwimClass { // Renamed from ClaseNatacion
    private String classCode;
    private String level;
    private Instructor instructor; // RELATIONSHIP with Instructor
    private int maxCapacity;
    private double monthlyPrice;
    private boolean isActive;
    private ArrayList<Student> enrolledStudents; // USE OF ARRAYLIST

    public SwimClass(String classCode, String level, Instructor instructor, int maxCapacity, double monthlyPrice) {
        this.classCode = classCode;
        this.level = level;
        this.instructor = instructor;
        this.maxCapacity = maxCapacity;
        this.monthlyPrice = monthlyPrice;
        this.isActive = true;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getInstructorDetails() {
        return instructor.getFullName() +
                " (ID: " + instructor.getEmployeeId() +
                ") | Bonus: $" + String.format("%.2f", instructor.calculateExperienceBonus());
    }

    // Uses ArrayList: Enrollment
    public boolean enrollStudent(Student student) {
        if (isActive && enrolledStudents.size() < maxCapacity) {
            enrolledStudents.add(student);
            return true;
        }
        return false;
    }

    public int getAvailableCapacity() { return maxCapacity - enrolledStudents.size(); }
    public String getClassCode() { return classCode; }
    public String getLevel() { return level; }
}