package exception;

@SuppressWarnings("serial")
public class PersistenciaException extends Exception {
	
	public PersistenciaException() {
		super();
	}
	
	public PersistenciaException(String mensaje) {
		super(mensaje);
	}
	
}