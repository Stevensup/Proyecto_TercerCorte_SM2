package co.edu.unbosque.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

import co.edu.unbosque.controller.Controller;
import co.edu.unbosque.model.Correo;

public class CorreoTest {

	private static int count = 0;
	
	@BeforeAll
	public static void startTest() {
		System.out.println("Iniciando pruebas de correo");
	}
	
	@AfterAll
	public static void endTest() {
		System.out.println("Se terminaron las pruebas de correo");
	}
	
//	@Test
	void startCodigoVerficacionTest() {
		Controller con = new Controller();
		assertEquals(true, con.codigoVerificacion("dcenteno388@gmail.com", "David"));
	}
}
