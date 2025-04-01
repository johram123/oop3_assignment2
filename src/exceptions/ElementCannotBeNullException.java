package exceptions;

public class ElementCannotBeNullException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3494648559481290653L;

	public ElementCannotBeNullException(String message) {
		super(message);
	}
	
	public ElementCannotBeNullException() {
		super();
	}
}
