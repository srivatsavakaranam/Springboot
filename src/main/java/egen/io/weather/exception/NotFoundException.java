package egen.io.weather.exception;

public class NotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2867929775114286955L;
	public NotFoundException(String Message){
		super(Message);
	}
	public NotFoundException(String Message,Throwable cause){
		super(Message, cause);	
	}

}
