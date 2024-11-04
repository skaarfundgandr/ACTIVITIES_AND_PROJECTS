public class ContactNotFoundException extends RuntimeException {
    public ContactNotFoundException() {
        super();
    }

    public ContactNotFoundException(String message) {
        super(message);
    }

    public ContactNotFoundException(Throwable cause) {
        super(cause);
    }
}
