package co.edu.unbosque.model.persistance;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileHandler {
	private static Scanner sc;
	private static File arc;
	private static PrintWriter pw;

	public FileHandler() {

	}

	public static String openFileTxt(String name) {

		arc = new File("src/co/edu/unbosque/model/persistance/" + name);

		StringBuilder content = new StringBuilder();
		try {
			sc = new Scanner(arc);
			while (sc.hasNext()) {
				content.append(sc.nextLine() + "\n");

			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error, archivo no encontrado");
			e.printStackTrace();
		} catch (IOException e1) {
			System.out.println("Error al abrir y leer el archivo, revise permisos");
			e1.printStackTrace();
		}

		return content.toString();
	}

	public static void writeFileTxt(String name, String content) {
		arc = new File("src/co/edu/unbosque/model/persistance/" + name);
		try {
			pw = new PrintWriter(arc);
			pw.println(content);
			pw.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error de escritura: Archivo no encontrado");
			e.printStackTrace();
			try {
				arc.createNewFile();
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		} catch (IOException e1) {
			System.out.println("Error de escritura: revise permisos");
			e1.printStackTrace();
		}
	}
}
