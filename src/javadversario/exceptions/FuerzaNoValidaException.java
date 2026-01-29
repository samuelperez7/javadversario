package javadversario.exceptions;

public class FuerzaNoValidaException extends Exception {
	
	private String message;

	public FuerzaNoValidaException(String message) {
		this.message = message;
	}

	public FuerzaNoValidaException() {
		message="La fuerza de un personaje debe estar comprendida entre 0 y 7";
	}
	
	public String getMessage() {
		return message;
	}
	
}