package exception;

@SuppressWarnings("serial")
public class AsignaturaYaExisteException extends Exception {

	public AsignaturaYaExisteException() { super(); }
	
	public AsignaturaYaExisteException(String message) {
		super(message);
	}
}
