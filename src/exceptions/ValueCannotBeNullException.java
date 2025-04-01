package exceptions;

public class ValueCannotBeNullException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4763479289777337641L;
	
	public ValueCannotBeNullException(String message) {
		super(message);
	}
	
	public ValueCannotBeNullException() {
		super();
	}
}
