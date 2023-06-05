package co.edu.unbosque.util.exception;

/**
 * 
 * @author Codernautas
 *
 */

public class InvalidoCorreoException extends Exception {

	public InvalidoCorreoException() {
		super("El formato de correo ingresado no es valido");
	}
}
