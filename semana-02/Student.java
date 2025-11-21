public class Student {
    private int studentId;
    private String fullName;
    private String contactPhone;
    private String assignedLevel;
    private double outstandingBalance;

    public Student(int studentId, String fullName, String contactPhone, String assignedLevel) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.contactPhone = contactPhone;
        this.assignedLevel = assignedLevel;
        this.outstandingBalance = 0.0;
    }

    public String getFullName() {
        return fullName;
    }

    public boolean makePayment(double amount) {
        if (amount < 50000.0) {
            return false;
        }
        this.outstandingBalance -= amount;
        return true;
    }

    public int getStudentId() { return studentId; }
}