/**
 * Esta clase es la encargada de filtrar los parametros que ingresen en los
 * campos habilitados de las demas clases. Es decir en caso de que algun dato
 * se complete de forma errada, esta clase expondra un JoptionPane advirtiendo
 * al usuario el error.
 */
package co.edu.unbosque.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import co.edu.unbosque.util.exception.NegativeNumberException;
import co.edu.unbosque.util.exception.NumberTooLongException;
import co.edu.unbosque.util.exception.NumeroInvalidoException;
import co.edu.unbosque.util.exception.DatoVacioException;
import co.edu.unbosque.util.exception.EspecialCaracterException;
import co.edu.unbosque.util.exception.InvalidStringException;
import co.edu.unbosque.util.exception.InvalidoCorreoException;
import co.edu.unbosque.util.exception.InvalidoFormatoFechaException;

/**
 * @author Codernautas
 *
 */
public class Lecturas {
	private SimpleDateFormat formato;

	/**
	 * Clase constructor que inicializa los formatos a usar 
	 */
	public Lecturas() {
		formato = new SimpleDateFormat("dd/MM/yyyy");
	}

	/**
	 * Filtra el parametro ingresante de tipo String y lo reescribe 
	 * como un nuevo dato de tipo Date, controlando las posibles 
	 * exception que puedan surgir debido a la giditacion errada 
	 * por parte del usuario.
	 * @param fecha
	 * @return
	 */
	public Date leerFecha(String fecha) {
		try {
			Date date = formato.parse(fecha);
			return date;
		} catch (ParseException e) {
			try {
				throw new InvalidoFormatoFechaException();
			} catch (InvalidoFormatoFechaException e2) {
				JOptionPane.showMessageDialog(null, e2.getMessage());
			}
			return null;
		}
	}

	/**
	 * Pasara los datos de tipo Date a un formato estandar, legible 
	 * y comprensible para todos los usuarios
	 * @param date
	 * @return
	 */
	public String imprimirFecha(Date date) {
		String fecha = formato.format(date);
		return fecha;
	}

	/**
	 * Verificara que el dato tipo String que ingresa el usuario contenga las caracteristicas base
	 * de un correo electronico existente y funcional.
	 * @param text
	 * @return
	 */
	public String leerCorreo(String text) {
		try {
			if (text.contains("@gmail.com") && text.contains("@hotmail.com") && text.contains("@unbosque.edu.co")) {
				throw new InvalidoCorreoException();
			} else if (text.matches(".*[\\#?¿,.&%-].*")) {
				throw new EspecialCaracterException("correo");
			}
		} catch (InvalidoCorreoException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		} catch (EspecialCaracterException ee) {
			// TODO: handle exception
		}

		return text;
	}

	/**
	 * Verificara que cada dato de tipo int este bien digitado
	 * y no contenga letras o caracteres especiales.
	 * @param id
	 * @return
	 */
	public String leerEntero(String id) {
		try {
			if (id.length() > 10) {
				throw new NumberTooLongException();
			} else if (id.contains("-")) {
				throw new NegativeNumberException();
			} else if (id.contains(".*[a-zA-Z].*")) {
				throw new EspecialCaracterException("documento");
			}
			return id;
		} catch (NumberTooLongException e0) {
			JOptionPane.showMessageDialog(null, e0.getMessage());
			return null;
		} catch (NegativeNumberException ee) {
			JOptionPane.showMessageDialog(null, ee.getMessage());
			return null;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		} catch (EspecialCaracterException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
			return null;
		}
	}

	/**
	 * Verifica que los campos normales de tipo String se llenen adecuadamente
	 * y no tontengan ningun tipo de caracter especial incluyendo numeros, que 
	 * puedan afectar la comprension de la palabra.
	 * @param text
	 * @param parametro
	 * @return
	 */
	public String leerPalabra(String text, String parametro) {
		try {
			if (text == null) {
				throw new DatoVacioException();
			} else if (text.matches(".*[0-9].*")) {
				throw new InvalidStringException();
			} else if (text.matches(".*[\\@#?¿,.&%-].*")) {
				throw new EspecialCaracterException(parametro);
			} else if (text.length() == 0) {
				throw new DatoVacioException();
			}
			return text;
		} catch (InvalidStringException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		} catch (EspecialCaracterException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
			return null;
		} catch (DatoVacioException e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage());
			return null;
		}
	}
}
