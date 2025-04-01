package exceptions;

public class InvalidQueueException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4846323005384463026L;

	public InvalidQueueException(String message) {
		super(message);
	}
	
	public InvalidQueueException() {
		super();
	}
}
