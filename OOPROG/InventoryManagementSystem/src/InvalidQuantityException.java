public class InvalidQuantityException extends RuntimeException {
    public InvalidQuantityException() {
        super();
    }
    public InvalidQuantityException(String msg) {
        super(msg);
    }
    public InvalidQuantityException(Throwable cause) {
        super(cause);
    }
}