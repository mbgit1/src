package exception;

@SuppressWarnings("serial")
public class InscripcionNoExisteException extends Exception{
		public InscripcionNoExisteException() { super(); }
		public InscripcionNoExisteException(String message) {
			super(message);
		}


}
