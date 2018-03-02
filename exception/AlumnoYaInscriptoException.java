package exception;

@SuppressWarnings("serial")
public class AlumnoYaInscriptoException extends Exception {
	public AlumnoYaInscriptoException() { super(); }
	
	public AlumnoYaInscriptoException(String message) {
		super(message);
	}
}
