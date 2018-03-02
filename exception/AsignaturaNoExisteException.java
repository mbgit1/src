package exception;
@SuppressWarnings("serial")
public class AsignaturaNoExisteException extends Exception {
  
		public AsignaturaNoExisteException() { super(); }
		
		public AsignaturaNoExisteException(String message) {
			super(message);
		}
}
