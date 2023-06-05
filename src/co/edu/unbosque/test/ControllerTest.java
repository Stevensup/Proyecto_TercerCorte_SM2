package co.edu.unbosque.test;

import static org.junit.Assert.assertArrayEquals;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.swing.JOptionPane;

import org.junit.jupiter.api.*;

import co.edu.unbosque.controller.Controller;
import co.edu.unbosque.model.AdministradorDAO;
import co.edu.unbosque.model.AdministradorDTO;
import co.edu.unbosque.model.UsuarioDAO;
import co.edu.unbosque.model.UsuarioDTO;
import co.edu.unbosque.view.Administrador;
import co.edu.unbosque.view.Editar;
import co.edu.unbosque.view.Lecturas;
import co.edu.unbosque.view.RegistrarAd;
import co.edu.unbosque.view.RegistrarEs;
import co.edu.unbosque.view.VentanaPrincipal;

public class ControllerTest {

	
	private static int count = 0;
	private VentanaPrincipal vp;
	private RegistrarAd resad;
	private RegistrarEs reses;
	private Administrador admi;
	private Editar edit;
	private Lecturas lec;
	private Controller c;
	private AdministradorDAO adao;
	private UsuarioDAO udao;
	private String origen;
	
	public ControllerTest() {
		vp = new VentanaPrincipal();
		resad = new RegistrarAd();
		reses = new RegistrarEs();
		admi = new Administrador();
		edit = new Editar();
		lec = new Lecturas();
		c = new Controller();
		adao = new AdministradorDAO();
		udao = new UsuarioDAO();
	}
	
	@BeforeAll
	public static void startTest() {
		System.out.println("Iniciando pruebas del controller");
	}
	
	@AfterAll
	public static void endTest() {
		System.out.println("Se terminaron las pruebas del controller");
		
	}
	
//	@BeforeEach
//	void setUp() {
//		vp = new VentanaPrincipal();
//		resad = new RegistrarAd();
//		reses = new RegistrarEs();
//		admi = new Administrador();
//		edit = new Editar();
//		lec = new Lecturas();
//		c = new Controller();
//		c.agregarLectores();
//		
//
//	}
	
//	@Test
//	void agregarLectoresTest() {
//		
//	    Component[] vpComponents = vp.getContentPane().getComponents();
//	    Component[] resadComponents = resad.getContentPane().getComponents();
//	    Component[] resesComponents = reses.getContentPane().getComponents();
//	    Component[] admiComponents = admi.getContentPane().getComponents();
//	    Component[] editComponents = edit.getContentPane().getComponents();
////	    Component[] lecComponents = lec.getContentPane().getComponents();
//		
//		System.out.println(vp.getRegistrarEs().getActionCommand());
//		assertEquals("RegisNuevoEstudiante", (vpComponents[0]).get);
//		assertEquals("RegisNuevoEstudiante", vp.getRegistrarEs().getActionCommand());
//		assertEquals("RegisNuevoAdministrador", vp.getRegistrarAd().getActionCommand());
//		assertEquals("Iniciar", vp.getIniciar().getActionCommand());
//		assertEquals("pais", reses.getPaisNacimiento().getActionCommand());
//		assertEquals("departamento", reses.getDepartamento().getActionCommand());
//		assertEquals("municipio", reses.getMunicipio().getActionCommand());
//		assertEquals("programa", reses.getPrograma().getActionCommand());
//		assertEquals("RegistrarEstudiante", reses.getGuardar().getActionCommand());
//		assertEquals("RegistrarAdministrador", resad.getGuardar().getActionCommand());
//		assertEquals("Ordenamiento", admi.getOrdenar().getActionCommand());
//		assertEquals("Eliminar", edit.getEliminar().getActionCommand());
//		assertEquals("Estado", edit.getEstado().getActionCommand());
//		assertEquals("GuardarCambios", edit.getGuardar().getActionCommand());
//		assertEquals("GuardarCambios", edit.getGuardar().getActionCommand());
//		
////		Cancelar
//		assertEquals("CANCELAR", reses.getCancelar().getActionCommand());
//		assertEquals("CANCELAR", resad.getCancelar().getActionCommand());
//		assertEquals("CANCELAR", admi.getSalir().getActionCommand());
//		assertEquals("ATRAS", edit.getCancelar().getActionCommand());
//		assertSame(adao, editComponents);
//	}
	
	
	@Test
	void registrarAdministradorTest() {
		String id = resad.getDocumento().getText();
		String name = resad.getNombre().getText();
		String lastname = resad.getApellido().getText();
		String gender = "";
		if (reses.getF().isSelected()) {
			gender = "F";
		} else if (reses.getM().isSelected()) {
			gender = "M";
		}
		String user = resad.getUsuario().getText();
		String email = resad.getCorreo().getText();
		String password = resad.getContraseNa().getText();
		AdministradorDTO administrador = new AdministradorDTO(id, name, lastname, gender, user, email, password);
		adao.add(administrador);
		
		assertTrue(administrador instanceof AdministradorDTO);
		count++;
	}
	
	@Test
	void registrarEstudianteTest() {
		UsuarioDTO userr = null;
		try {
			String id = "9999999";
			String name = "David";
			String lastname = "Centeno";
			String gender = "M";
			String user = "dcentenog";
			String email = "dcenteno388@gmail.com";
			String career = "Ingenieria de sistemas";
			String time = "Diurna";
			Date birthdate = lec.leerFecha("29/03/2005");
			Date registro = lec.leerFecha("04/06/2023");
			if (id != null && name != null && lastname != null && user != null && email != null && birthdate != null) {
				boolean state = c.codigoVerificacion(email,name);
				assertTrue(state);
				userr = new UsuarioDTO(id, name, lastname, gender, user, email, birthdate, state, career, time,
						"", registro);
				udao.add(userr);
			} 

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Alguno de los parametros no ha sido ingresado");
		}
		
		assertTrue(userr instanceof UsuarioDTO);
		count++;
	}
	
	@Test
	void codigoVerficacionTest() {
		boolean t=c.codigoVerificacion("dcenteno388@gmail.com", "David");
		assertTrue(t);
		count++;
	}
	
	@Test
	void ordenamientosTest() {
		ArrayList<UsuarioDTO> usuarios = new ArrayList<>();
		usuarios.add(new UsuarioDTO("111111111", "aaaaa", "aaaaa", "M", "aaaaa", "dcentenog388@gmail.com", lec.leerFecha("29/03/2005"), true, "Ing.Sistemas", "day", "a", lec.leerFecha("04/06/2023")));
		usuarios.add(new UsuarioDTO("222222222", "bbbbb", "bbbbb", "M", "bbbbb", "dcentenog388@gmail.com", lec.leerFecha("29/03/2005"), true, "Ing.Sistemas", "day", "a", lec.leerFecha("04/06/2023")));
		usuarios.add(new UsuarioDTO("333333333", "ccccc", "ccccc", "M", "ccccc", "dcentenog388@gmail.com", lec.leerFecha("29/03/2005"), true, "Ing.Sistemas", "day", "a", lec.leerFecha("04/06/2023")));
		usuarios.add(new UsuarioDTO("444444444", "ddddd", "ddddd", "M", "ddddd", "dcentenog388@gmail.com", lec.leerFecha("29/03/2005"), true, "Ing.Sistemas", "day", "a", lec.leerFecha("04/06/2023")));
		
//		Por nombre
		ArrayList<UsuarioDTO> resultado = new ArrayList<>();
		resultado=c.ordenar("Nombre", false, usuarios);
		
		ArrayList<UsuarioDTO> esperado = new ArrayList<>();
		esperado.add(new UsuarioDTO("444444444", "ddddd", "ddddd", "M", "ddddd", "dcentenog388@gmail.com", lec.leerFecha("29/03/2005"), true, "Ing.Sistemas", "day", "a", lec.leerFecha("04/06/2023")));
		esperado.add(new UsuarioDTO("333333333", "ccccc", "ccccc", "M", "ccccc", "dcentenog388@gmail.com", lec.leerFecha("29/03/2005"), true, "Ing.Sistemas", "day", "a", lec.leerFecha("04/06/2023")));
		esperado.add(new UsuarioDTO("222222222", "bbbbb", "bbbbb", "M", "bbbbb", "dcentenog388@gmail.com", lec.leerFecha("29/03/2005"), true, "Ing.Sistemas", "day", "a", lec.leerFecha("04/06/2023")));
		esperado.add(new UsuarioDTO("111111111", "aaaaa", "aaaaa", "M", "aaaaa", "dcentenog388@gmail.com", lec.leerFecha("29/03/2005"), true, "Ing.Sistemas", "day", "a", lec.leerFecha("04/06/2023")));
//		assertTrue(esperado.equals(resultado));
		System.out.println(esperado.size()+ " y "+resultado.size());
		assertEquals(esperado, resultado);
		
		
        ArrayList<UsuarioDTO> diffList = new ArrayList<>();


        for (UsuarioDTO i : esperado) {
        	if (!esperado.contains(i)) {
                diffList.add(i);
            }
		}

        for (UsuarioDTO i : resultado) {
        	if (!resultado.contains(i)) {
                diffList.add(i);
            }
		}
		System.out.println(diffList);
//		Por apellido
		esperado.clear();
		resultado.clear();
		resultado=c.ordenar("Apellido", false, usuarios);
		assertEquals(esperado, resultado);
		

		esperado.add(new UsuarioDTO("444444444", "ddddd", "ddddd", "M", "ddddd", "dcentenog388@gmail.com", lec.leerFecha("29/03/2005"), true, "Ing.Sistemas", "day", "a", lec.leerFecha("04/06/2023")));
		esperado.add(new UsuarioDTO("333333333", "ccccc", "ccccc", "M", "ccccc", "dcentenog388@gmail.com", lec.leerFecha("29/03/2005"), true, "Ing.Sistemas", "day", "a", lec.leerFecha("04/06/2023")));
		esperado.add(new UsuarioDTO("222222222", "bbbbb", "bbbbb", "M", "bbbbb", "dcentenog388@gmail.com", lec.leerFecha("29/03/2005"), true, "Ing.Sistemas", "day", "a", lec.leerFecha("04/06/2023")));
		esperado.add(new UsuarioDTO("111111111", "aaaaa", "aaaaa", "M", "aaaaa", "dcentenog388@gmail.com", lec.leerFecha("29/03/2005"), true, "Ing.Sistemas", "day", "a", lec.leerFecha("04/06/2023")));
//		assertEquals(esperado, resultado);
		
		
//		Por usuario
		esperado.clear();
		resultado.clear();
		resultado=c.ordenar("Usuario", false, usuarios);
		

		esperado.add(new UsuarioDTO("444444444", "ddddd", "ddddd", "M", "ddddd", "dcentenog388@gmail.com", lec.leerFecha("29/03/2005"), true, "Ing.Sistemas", "day", "a", lec.leerFecha("04/06/2023")));
		esperado.add(new UsuarioDTO("333333333", "ccccc", "ccccc", "M", "ccccc", "dcentenog388@gmail.com", lec.leerFecha("29/03/2005"), true, "Ing.Sistemas", "day", "a", lec.leerFecha("04/06/2023")));
		esperado.add(new UsuarioDTO("222222222", "bbbbb", "bbbbb", "M", "bbbbb", "dcentenog388@gmail.com", lec.leerFecha("29/03/2005"), true, "Ing.Sistemas", "day", "a", lec.leerFecha("04/06/2023")));
		esperado.add(new UsuarioDTO("111111111", "aaaaa", "aaaaa", "M", "aaaaa", "dcentenog388@gmail.com", lec.leerFecha("29/03/2005"), true, "Ing.Sistemas", "day", "a", lec.leerFecha("04/06/2023")));
//		assertEquals(esperado, resultado);
		
//		Por documento
		esperado.clear();
		resultado.clear();
		resultado=c.ordenar("Documento", false, usuarios);
		

		esperado.add(new UsuarioDTO("444444444", "ddddd", "ddddd", "M", "ddddd", "dcentenog388@gmail.com", lec.leerFecha("29/03/2005"), true, "Ing.Sistemas", "day", "a", lec.leerFecha("04/06/2023")));
		esperado.add(new UsuarioDTO("333333333", "ccccc", "ccccc", "M", "ccccc", "dcentenog388@gmail.com", lec.leerFecha("29/03/2005"), true, "Ing.Sistemas", "day", "a", lec.leerFecha("04/06/2023")));
		esperado.add(new UsuarioDTO("222222222", "bbbbb", "bbbbb", "M", "bbbbb", "dcentenog388@gmail.com", lec.leerFecha("29/03/2005"), true, "Ing.Sistemas", "day", "a", lec.leerFecha("04/06/2023")));
		esperado.add(new UsuarioDTO("111111111", "aaaaa", "aaaaa", "M", "aaaaa", "dcentenog388@gmail.com", lec.leerFecha("29/03/2005"), true, "Ing.Sistemas", "day", "a", lec.leerFecha("04/06/2023")));
//		assertEquals(esperado, resultado);
	}
}
