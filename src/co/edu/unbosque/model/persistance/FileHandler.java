/**
 * 
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
 * @author Annie Peña, David Centeno
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

	// staatic es una constante a nivel de codigo, solo existe una vez en memoria
	// siempre esta en el mismo lugar y todos lo usan

	public static String abrirArchivoDeTexto(String nombre) {
		archivo = new File("src/co/edu/unbosque/model/persistance/" + nombre);
		StringBuilder contenido = new StringBuilder();
		try {
			lector = new BufferedReader(new FileReader(archivo));
			String line;
			while ((line = lector.readLine()) != null) {
				contenido.append(line + "\n");
			}
			lector.close(); // libera el archivo, para uso externo
		} catch (FileNotFoundException e) {
			System.out.println("Error de lectura: Archivo no encontrado csv");
			e.printStackTrace();
		} catch (IOException e1) {
			System.out.println("Error de lectura: Revise permisos");
		}

		return contenido.toString();
	}

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

	public static void escribirSerializado(String nombre, Object obj) {

		try { // escribir //buscar
			oos = new ObjectOutputStream(new FileOutputStream("src/co/edu/unbosque/model/persistance/" + nombre));
			oos.writeObject(obj);
			oos.close();
		} catch (FileNotFoundException e) {
			System.out.println("Archivo serializado no encontrado (salida)");
		} catch (IOException e) {
			System.out.println("Revise permisos: Archivo serializado (salida)");
			e.printStackTrace();
		}

	}

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