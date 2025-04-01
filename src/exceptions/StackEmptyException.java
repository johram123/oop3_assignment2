package exceptions;

public class StackEmptyException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8833918636812042797L;
	
	public StackEmptyException(String message) {
		super(message);
	}
	
	public StackEmptyException() {
		super();
	}

}
