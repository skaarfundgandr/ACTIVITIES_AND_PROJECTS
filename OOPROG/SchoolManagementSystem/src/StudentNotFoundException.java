public class StudentNotFoundException extends RuntimeException {
	public StudentNotFoundException() {
		super();
	}
	public StudentNotFoundException(String message) {
		super(message);
	}
	public StudentNotFoundException(Throwable cause) {
		super(cause);
	}
}