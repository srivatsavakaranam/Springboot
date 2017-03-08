package egen.io.weather.exception;

public class BadrequestException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6034920661241620718L;
	public BadrequestException(String Message){
		super(Message);
	}
	public BadrequestException(String Message,Throwable cause){
		super(Message, cause);	
	}

}
