package exceptions;

public class QueueEmptyException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8664660047545153720L;

	public QueueEmptyException(String message) {
		super(message);
	}
	
	public QueueEmptyException() {
		super();
	}
}
