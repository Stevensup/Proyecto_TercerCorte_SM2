/**
 * Esta clase es la encargada de la lectura y escritura de los archivos
 * serializados.
 */
package co.edu.unbosque.model.persistance;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

/**
 * @author Codernautas
 * 
 */
public class FileHandler {

	private static BufferedReader lector;
	private static File archivo;
	private static PrintWriter escritor; // Syso para archivos
	private static ObjectInputStream ois; // LECTURA recibe arraylis variables y aarchivos
	private static ObjectOutputStream oos; // ESCRITURAEnvia ""

	public FileHandler() {

	}
	
	/**
	 * Este método estático tiene como función abrir el archivo de texto csv
	 * para leerlo línea por línea y almacenarlo en la variable contenido.
	 * <b>pre</b> El archivo exista.<br>
	 * <b>post</b> Se ha abierto el archivo csv.<br> 
	 * @param nombre Es el nombre del archivo csv.
	 * @return retorna el contenido del archivo csv como una cadena de texto 
	 * utilizando el método toString del objeto StringBuilder.
	 * @trows Exception si no es encontrado el archivo, dispara una excepción indicando 
	 * que este archivo csv no fue hallado.
	 * @trows Exception si hay un error en la lectura del archivo, dispara una excepción
	 * indicando una revision en los permisos de lectura del archivo.
	 */

	public static String abrirArchivoDeTexto(String nombre) {
		archivo = new File("src/co/edu/unbosque/model/persistance/" + nombre);
		StringBuilder contenido = new StringBuilder();
		System.out.println(contenido);
		try {
			lector = new BufferedReader(new FileReader(archivo));
			String line;
			while ((line = lector.readLine()) != null) {
				contenido.append(line + "\n");
			}
			lector.close(); // libera el archivo, para uso externo
		} catch (FileNotFoundException e) {
			
		} catch (IOException e1) {
			System.out.println("Error de lectura: Revise permisos");
		}

		return contenido.toString();
	}
	/**
	 * Este método estático tiene como función escribir en el archivo csv 
	 * la cadena de texto almacenada en la variable contenido del objeto StringBuilder.
	 * <b>pre</b> El archivo exista.<br>
	 * <b>pre</b> La informacion en la variable de tipo StringBuilder exista<br>
	 * <b>post</b> Se ha escrito el archivo csv.<br> 
	 * @param nombre Es el nombre del archivo csv.
	 * @param contenido Es la información que existe en la variable de tipo StringBuilder.
	 * @trows Exception si no es encontrado el archivo, dispara una excepción indicando 
	 * que este archivo no fue hallado.
	 * @trows Exception si hay un error en la escritura del archivo, dispara una excepción
	 * indicando una revision en los permisos de escritura del archivo.
	 */

	public static void escribirArchivoDeTexto(String nombre, String contenido) {
		archivo = new File("src/co/edu/unbosque/model/persistance/" + nombre);
		try {
			escritor = new PrintWriter(archivo);
			escritor.println(contenido);
			escritor.close(); // libera el archivo, para uso externo
		} catch (FileNotFoundException e) {
			System.out.println("Error de escritura: Archivo no encontrado");
			try {
				archivo.createNewFile();
			} catch (IOException io) {

			}
		} catch (IOException e1) {
			System.out.println("Error de escritura: Revise permisos");
		}

	}
	/**
	 * Este método estático tiene como función escribir en el archivo  
	 * un objeto serializado.
	 * <b>pre</b> El archivo exista.<br>
	 * <b>pre</b> El objeto serializado exista<br>
	 * <b>post</b> Se ha escrito el serializado en el archivo.<br> 
	 * @param nombre Es el nombre del archivo.
	 * @param obj Es el objeto serializado que se va a escribir.
	 * @trows Exception si no es encontrado el archivo, dispara una excepción indicando 
	 * que este archivo serializado no fue hallado.
	 * @trows Exception si hay un error en la escritura del serializado, dispara una excepción
	 * indicando una revision en los permisos de escritura.
	 */

	public static void escribirSerializado(String nombre, Object obj) {

		try { // escribir //buscar
			oos = new ObjectOutputStream(new FileOutputStream("src/co/edu/unbosque/model/persistance/" + nombre));
			oos.writeObject(obj);
			oos.close();
		} catch (FileNotFoundException e) {
			System.out.println("Archivo serializado no encontrado (salida)");
		} catch (IOException e) {
			System.out.println("Revise permisos: Archivo serializado (salida)");
			//e.printStackTrace();
		}

	}
	/**
	 * Este método estático tiene como función leer el objeto serializado
	 * desde el archivo. 
	 * <b>pre</b> El archivo exista.<br>
	 * <b>post</b> Se ha leído el objeto serializado desde el archivo.<br> 
	 * @param nombre Es el nombre del archivo.
	 * @return null.
	 * @trows Exception si no es encontrado el archivo serializado, dispara 
	 * una excepción indicando que este archivo serializado no fue hallado.
	 * @trows Exception si hay un error en la lectura del serializado, dispara 
	 * una excepción indicando una revisión en los permisos de escritura.
	 * @trows Exception si hay un error en la conversión del serializado, dispara 
	 * una excepción indicando un problema con la conversión de clases serializadas.
	 */

	public static Object leerSerializado(String nombre) {
		try {
			ois = new ObjectInputStream(new FileInputStream("src/co/edu/unbosque/model/persistance/" + nombre));
			Object obj = ois.readObject();
			ois.close();
			return obj;
		} catch (FileNotFoundException e) {
			System.out.println("Archivo serializado no encontrado (entrada)");
			escribirSerializado(nombre, new Object());
		} catch (IOException e) {
			System.out.println("Revise permisos del archivo serializado (entrada)");
		} catch (ClassNotFoundException e) {
			System.out.println("Problema con la conversion de clases serializadas (entrada)");
		}
		return null;
	}
}