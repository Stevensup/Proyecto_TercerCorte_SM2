/**
 * 
 */
package co.edu.unbosque.util.exception;

/**
 * @author Codernautas
 *
 */
public class EspecialCaracterException extends Exception {

	public EspecialCaracterException(String parametro) {
		super("El parametro de " + parametro + " contiene caracteres invalidos");
	}
}
