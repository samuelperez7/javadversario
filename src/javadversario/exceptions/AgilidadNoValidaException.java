package javadversario.exceptions;

public class AgilidadNoValidaException extends Exception {
	
	private String message;

	public AgilidadNoValidaException(String message) {
		this.message = message;
	}

	public AgilidadNoValidaException() {
		message="Un agilidad de un personaje debe estar comprendida entre 0 y 5";
	}
	
	public String getMessage() {
		return message;
	}
	
}