package exception;

public class Exception_A extends Exception{
	public Exception_A() {
	}

	public Exception_A(String message) {
		super(message);
	}

	public Exception_A(Throwable cause) {
		super(cause);
	}

	public Exception_A(String message, Throwable cause) {
		super(message, cause);
	}
}
