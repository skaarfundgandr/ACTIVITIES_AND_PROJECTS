public class PaypalPayment extends Payment {
    private String email;

    public PaypalPayment(String email) {
        this.email = email;
    }

    public void processPayment() {
        System.out.printf("Processing PayPal payment email: %s...\n", email);
        System.out.println("Process complete");
    }
}
