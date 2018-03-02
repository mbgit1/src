package exception;

@SuppressWarnings("serial")
public class AlumnoNoExisteException extends Exception{
	public AlumnoNoExisteException() { super(); }
	public AlumnoNoExisteException(String message) {
		super(message);
	}

}
