package personajerol.exceptions;

public class VidaNoValidaException extends Exception {
	
	private String message;

	public VidaNoValidaException(String message) {
		this.message = message;
	}

	public VidaNoValidaException() {
		message="La vida de un personaje debe estar comprendida entre 0 y 20";
	}
	
	public String getMessage() {
		return message;
	}
	
}