/**
 * 
 */
package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.AdministradorDAO;
import co.edu.unbosque.model.Correo;
import co.edu.unbosque.model.UsuarioDAO;
import co.edu.unbosque.model.UsuarioDTO;
import co.edu.unbosque.model.persistance.FileHandler;
import co.edu.unbosque.view.Administrador;
import co.edu.unbosque.view.RegistrarAd;
import co.edu.unbosque.view.RegistrarEs;
import co.edu.unbosque.view.VentanaPrincipal;

/**
 * @author annie
 *
 */
public class Controller implements ActionListener {

	private VentanaPrincipal vp;
	private RegistrarAd resad;
	private RegistrarEs reses;
	private Administrador admi;

	private UsuarioDAO usdao;
	private AdministradorDAO addao;

	private String origen;
	private Correo cor;

	public Controller() {
		vp = new VentanaPrincipal();
		resad = new RegistrarAd();
		reses = new RegistrarEs();
		admi = new Administrador();

		usdao = new UsuarioDAO();
		addao = new AdministradorDAO();

		vp.setVisible(true);
		resad.setVisible(false);
		reses.setVisible(false);
		admi.setVisible(false);

		reses.getDepartamento().setVisible(false);
		reses.getMunicipio().setVisible(false);
		reses.getJornada().setVisible(false);

		origen = "";
		cor = new Correo();
		agregarLectores();
	}

	public void agregarLectores() {

		vp.getRegistrarEs().addActionListener(this);
		vp.getRegistrarEs().setActionCommand("RegisNuevoEstudiante");

		vp.getRegistrarAd().addActionListener(this);
		vp.getRegistrarAd().setActionCommand("RegisNuevoAdministrador");

		vp.getIniciar().addActionListener(this);
		vp.getIniciar().setActionCommand("Iniciar");

		reses.getPaisNacimiento().addActionListener(this);
		reses.getPaisNacimiento().setActionCommand("pais");

		reses.getDepartamento().addActionListener(this);
		reses.getDepartamento().setActionCommand("departamento");

		reses.getMunicipio().addActionListener(this);
		reses.getMunicipio().setActionCommand("municipio");

		reses.getPrograma().addActionListener(this);
		reses.getPrograma().setActionCommand("programa");

		reses.getGuardar().addActionListener(this);
		reses.getGuardar().setActionCommand("RegistrarEstudiante");

		// cancelar
		reses.getCancelar().addActionListener(this);
		reses.getCancelar().setActionCommand("CANCELAR");

		resad.getCancelar().addActionListener(this);
		resad.getCancelar().setActionCommand("CANCELAR");

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {

		case "RegisNuevoEstudiante": {
			vp.setVisible(false);
			reses.setVisible(true);
			break;
		}

		case "RegisNuevoAdministrador": {
			vp.setVisible(false);
			resad.setVisible(true);
			break;
		}

		case "Iniciar": {
			vp.setVisible(false);
			visualizarEstudiante();
			admi.setVisible(true);
			break;
		}

		case "pais": {
			origen = (String) reses.getPaisNacimiento().getSelectedItem();
			if (origen.equals("Colombia")) {
				reses.getDep().setVisible(false);
				reses.getDepartamento().setVisible(true);
			} else {
				reses.getDep().setVisible(true);
				reses.getDepartamento().setVisible(false);
			}
			break;
		}

		case "departamento": {
			String temp = (String) reses.getDepartamento().getSelectedItem();
			String contenido = FileHandler.abrirArchivoDeTexto("ComboBox/" + temp + ".txt");
			String[] lineas = contenido.split("\n");
			for (int i = 0; i < lineas.length; i++) {
				reses.getMunicipio().addItem(lineas[i]);
			}
			reses.getMunicipio().setVisible(true);
			reses.getMuni().setVisible(false);
			break;
		}

		case "municipio": {
			origen = (String) reses.getMunicipio().getSelectedItem();
			break;
		}

		case "programa": {
			String programa = (String) reses.getPrograma().getSelectedItem();
			if (programa.equals("Ingenieria Electronica") || programa.equals("Ingenieria de Sistemas")) {
				reses.getJornada().setVisible(true);
			} else {
				reses.getJornada().setVisible(false);
			}
			break;
		}

		case "RegistrarEstudiante": {
			registrarEstudiante();
			break;
		}

		case "CANCELAR": {
			resad.setVisible(false);
			reses.setVisible(false);
			vp.setVisible(true);
			break;
		}

		}
	}

	public void registrarEstudiante() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String id = reses.getDocumento().getText();
		String name = reses.getNombre().getText();
		String lastname = reses.getApellido().getText();
		String gender = "";
		if (reses.getF().isSelected()) {
			gender = "F";
		} else if (reses.getM().isSelected()) {
			gender = "M";
		}
		String user = reses.getUsuario().getText();
		String email = reses.getCorreo().getText();
		String career = (String) reses.getPrograma().getSelectedItem();
		String time = (String) reses.getJornada().getSelectedItem();
		Date birthdate = null;
		Date registro = null;
		try {
			registro = formato.parse(reses.getFecha().getText());
			birthdate = formato.parse(reses.getFecha().getText());
		} catch (ParseException eee) {
		}
		boolean state = codigoVerificacion(email);
		usdao.add(new UsuarioDTO(id, name, lastname, gender, user, email, birthdate, state, career, time, origen,
				registro));
	}

	public boolean codigoVerificacion(String email) {
		Random codigo = new Random();
		String[] letras = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
				"S", "T", "U", "V", "W", "X", "Y", "Z" };
		String[] numeros = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		String cod = "";
		for (int i = 0; i < 4; i++) {
			cod += letras[codigo.nextInt(25)];
			cod += numeros[codigo.nextInt(10)];
		}
		cor.start(email, cod);
		String verifica = JOptionPane.showInputDialog("Ingrese el codigo de verificacion enviado a su correo");
		if (cod.equals(verifica)) {
			return true;
		}
		return false;
	}

	public void visualizarEstudiante() {
		int cantidad = usdao.getLista().size();
		String[] docs = new String[cantidad];
		String[] nombres = new String[cantidad];
		String[] apellidos = new String[cantidad];
		String[] usuarios = new String[cantidad];

		for (int i = 0; i < cantidad; i++) {
			docs[i] = usdao.getLista().get(i).getId();
			nombres[i] = usdao.getLista().get(i).getName();
			apellidos[i] = usdao.getLista().get(i).getLastname();
			usuarios[i] = usdao.getLista().get(i).getUser();
		}
		admi.componentes(cantidad, docs, apellidos, nombres, usuarios);
	}

}
