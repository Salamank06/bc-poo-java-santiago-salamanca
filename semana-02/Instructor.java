public class Instructor {
    private String employeeId;
    private String fullName;
    private double baseSalary;
    private int yearsOfExperience;

    public Instructor(String employeeId, String fullName, double baseSalary, int yearsOfExperience) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.baseSalary = baseSalary;
        this.yearsOfExperience = yearsOfExperience;
    }

    // Business Method: Calculates experience bonus
    public double calculateExperienceBonus() {
        if (yearsOfExperience >= 5) {
            return baseSalary * 0.10;
        } else if (yearsOfExperience >= 2) {
            return baseSalary * 0.05;
        }
        return 0.0;
    }

    public String getFullName() { return fullName; }
    public String getEmployeeId() { return employeeId; }
}