package exceptions;

public class InvalidStackCompareException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2383679730147684858L;
	
	public InvalidStackCompareException(String message) {
		super(message);
	}
	
	public InvalidStackCompareException() {
		super();
	}
}
