package exception;

/**
 * 数据访问异常
 * @author ljd
 *
 */
public class DataAccessException extends RuntimeException {

	public DataAccessException() {
	}

	public DataAccessException(String message) {
		super(message);
	}

	public DataAccessException(Throwable cause) {
		super(cause);
	}

	public DataAccessException(String message, Throwable cause) {
		super(message, cause);
	}

}
