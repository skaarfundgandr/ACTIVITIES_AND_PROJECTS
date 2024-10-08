public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException() {
        super();
    }
    public ProductNotFoundException(String msg) {
        super(msg);
    }
    public ProductNotFoundException(Throwable cause) {
        super(cause);
    }
}
