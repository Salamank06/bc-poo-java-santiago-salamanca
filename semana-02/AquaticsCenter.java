import java.util.ArrayList;

public class AquaticsCenter { // Manager Class
    private String name;
    private ArrayList<SwimClass> offeredClasses; // ArrayList of Classes
    private ArrayList<Payment> paymentHistory;   // ArrayList of Payments

    public AquaticsCenter(String name) {
        this.name = name;
        this.offeredClasses = new ArrayList<>();
        this.paymentHistory = new ArrayList<>();
    }

    public void addClass(SwimClass swimClass) {
        offeredClasses.add(swimClass);
    }

    public void registerPayment(Payment payment) {
        paymentHistory.add(payment);
    }

    // Business Method: List classes with availability
    public void displayClassesWithCapacity() {
        System.out.println("\n--- Classes at " + this.name + " ---");
        for (SwimClass cls : offeredClasses) {
            System.out.println(cls.getClassCode() +
                    " (" + cls.getLevel() +
                    ") | Available Slots: " + cls.getAvailableCapacity());
        }
    }

    public void displayPaymentHistory() {
        System.out.println("\n--- Payment History (" + paymentHistory.size() + " transactions) ---");
        for (Payment payment : paymentHistory) {
            System.out.println(payment.getSummary());
        }
    }

    public int countClasses() {
        return offeredClasses.size();
    }
}