import java.time.LocalDate;

public class Payment {
    private String transactionCode;
    private Student student; // RELATIONSHIP with Student
    private double amount;
    private LocalDate paymentDate;

    public Payment(String transactionCode, Student student, double amount) {
        this.transactionCode = transactionCode;
        this.student = student;
        this.amount = amount;
        this.paymentDate = LocalDate.now();
    }

    // Business Method: Check if amount is high
    public boolean isHighAmount() {
        return this.amount > 100000.0;
    }

    public String getSummary() {
        return "Transaction: " + transactionCode +
                " | Student: " + student.getFullName() +
                " | Amount: $" + String.format("%.2f", amount) +
                " | Date: " + paymentDate;
    }

    public Student getStudent() { return student; }
}