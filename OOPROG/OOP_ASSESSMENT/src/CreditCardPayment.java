public class CreditCardPayment extends Payment {
    private int cardNumber;
    private String cardHolderName;
    private String expirationDate;
    private int cvv;

    public CreditCardPayment(int cardNumber, String cardHolderName, String expirationDate, int cvv) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }

    public void processPayment() {
        System.out.println("Processing credit card payment for " + cardHolderName);
        System.out.println("Process complete");
    }
}
