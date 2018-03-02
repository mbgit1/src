package exception;

@SuppressWarnings("serial")
public class AsignaturaYaAprobadaException extends Exception {
	public AsignaturaYaAprobadaException() { super(); }
	
	public AsignaturaYaAprobadaException(String message) {
		super(message);
	}
}
