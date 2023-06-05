/**
 * 
 */
package co.edu.unbosque.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import co.edu.unbosque.model.AdministradorDAO;
import co.edu.unbosque.model.AdministradorDTO;
import co.edu.unbosque.model.Correo;
import co.edu.unbosque.model.Pdf;
import co.edu.unbosque.model.UsuarioDAO;
import co.edu.unbosque.model.UsuarioDTO;
import co.edu.unbosque.model.persistance.FileHandler;
import co.edu.unbosque.model.persistance.Ordenamientos;
import co.edu.unbosque.view.Administrador;
import co.edu.unbosque.view.Editar;
import co.edu.unbosque.view.Filtros;
import co.edu.unbosque.view.Lecturas;
import co.edu.unbosque.view.RegistrarAd;
import co.edu.unbosque.view.RegistrarEs;
import co.edu.unbosque.view.VentanaPrincipal;
/**
 * Esta clase se utiliza como mediadora entre el modelo y la vista para poder 
 * mostrar el debido proceso del sistema de gestión estudiantil.
 * @author Codernautas
 */
public class Controller implements ActionListener {

	private VentanaPrincipal vp;
	private RegistrarAd resad;
	private RegistrarEs reses;
	private Administrador admi;
	private Editar edit;
	private Lecturas lec;

	private UsuarioDAO usdao;
	private AdministradorDAO addao;

	private String origen;
	private int fot;
	private int tamaNo;
	private Correo cor;
	
	/**
	 * Este metodo constructor crea las instancias de los objetos e inicializa
	 * las variables empleadas en la clase.
	 */
	public Controller() {
		vp = new VentanaPrincipal();
		resad = new RegistrarAd();
		reses = new RegistrarEs();
		admi = new Administrador();
		edit = new Editar();
		lec = new Lecturas();

		usdao = new UsuarioDAO();
		addao = new AdministradorDAO();

		vp.setVisible(true);
		resad.setVisible(false);
		reses.setVisible(false);
		reses.getDepartamento().setVisible(false);
		reses.getMunicipio().setVisible(false);
		reses.getJornada().setVisible(false);
		admi.setVisible(false);

		origen = "";
		fot = 0;
		tamaNo = 0;
		cor = new Correo();
		JOptionPane.showMessageDialog(null,
				"Querido Profesor:\n Para ingresar como administrador\n Usuario: ingenieria\n ContraseNa: Unibosqu3\n De igual forma si lo desea puede registrarse como un nuevo administrador");
		agregarLectores();
	}

	/**
     * Este método agrega los comandos de acción respectivos a cada botón 
     * en la interfaz de usuario gráfica (GUI). 
     */
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

		resad.getGuardar().addActionListener(this);
		resad.getGuardar().setActionCommand("RegistrarAdministrador");

		admi.getOrdenar().addActionListener(this);
		admi.getOrdenar().setActionCommand("Ordenamiento");

		admi.getBus().addActionListener(this);
		admi.getBus().setActionCommand("Buscar");

		admi.getActi().addActionListener(this);
		admi.getActi().setActionCommand("Activos");

		admi.getInacti().addActionListener(this);
		admi.getInacti().setActionCommand("Inactivos");

		admi.getTodos().addActionListener(this);
		admi.getTodos().setActionCommand("Todos");

		admi.getRegistrado().addActionListener(this);
		admi.getRegistrado().setActionCommand("Top registrados");

		admi.getNacional().addActionListener(this);
		admi.getNacional().setActionCommand("Top nacionales");

		edit.getEliminar().addActionListener(this);
		edit.getEliminar().setActionCommand("Eliminar");

		edit.getEstado().addActionListener(this);
		edit.getEstado().setActionCommand("Estado");

		edit.getGuardar().addActionListener(this);
		edit.getGuardar().setActionCommand("GuardarCambios");

		// cancelar
		reses.getCancelar().addActionListener(this);
		reses.getCancelar().setActionCommand("CANCELAR");

		resad.getCancelar().addActionListener(this);
		resad.getCancelar().setActionCommand("CANCELAR");

		admi.getSalir().addActionListener(this);
		admi.getSalir().setActionCommand("CANCELAR");

		edit.getCancelar().addActionListener(this);
		edit.getCancelar().setActionCommand("ATRAS");
	}

	/**
	 * Sobreescritura del método actionPerformed en una clase que implementa
	 * la interfaz ActionListener,se realiza el manejo de la estructura de 
	 * control switch.Dependiendo del codigo de acción recibido, se ejecuta 
	 * un bloque de código específico. 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String codigo = e.getActionCommand();

		switch (codigo) {

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
			boolean state = false;
			String user = vp.getUsuario().getText();
			String pas = vp.getContraseNa().getText();
			for (int i = 0; i < addao.getLista().size(); i++) {
				String name = addao.getLista().get(i).getUser();
				String pass = addao.getLista().get(i).getPassword();
				if (user.equals(name) && pas.equals(pass)) {
					admi.componentes(usdao.getLista().size());
					tamaNo = usdao.getLista().size();
					state = true;
					vp.setVisible(false);
					visualizarEstudiante(usdao.getLista());
					admi.setVisible(true);
					nombrar();
					break;
				} else {
					state = false;
				}
			}
			if (state == false) {
				JOptionPane.showMessageDialog(null, "Usuario y/o contraseNa incorrecta \n Intente nuevamente");
			}
			normal();
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
				if(temp.equals("Seleccione")) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar un departamento");
				}else {
					String contenido = FileHandler.abrirArchivoDeTexto("ComboBox/" + temp + ".txt");
			String[] lineas = contenido.split("\n");
			for (int i = 0; i < lineas.length; i++) {
				reses.getMunicipio().addItem(lineas[i]);
			}
			reses.getMunicipio().setVisible(true);
			reses.getMuni().setVisible(false);
				}
			
			
			
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

		case "Eliminar": {
			tamaNo--;
			admi.getPanelprincipal().remove(admi.getPaneles().get(tamaNo));
			JOptionPane.showMessageDialog(null, "Eliminado exitosamente");
			usdao.delete(edit.getId().getText());
			visualizarEstudiante(usdao.getLista());
			nombrar();
			edit.setVisible(false);
			break;
		}
		case "Estado": {
			if (fot == 1) {
				actualizaciones(false);
				JOptionPane.showMessageDialog(null, "Perfil desactivado exitosamente");
			} else if (fot == 2) {
				actualizaciones(true);
				JOptionPane.showMessageDialog(null, "Perfil activado exitosamente");
			}
			edit.setVisible(false);
			break;
		}

		case "GuardarCambios": {
			int iden = Integer.parseInt(edit.getIdentificador().getText());
			boolean estado = usdao.getLista().get(iden).isState();
			actualizaciones(estado);
			JOptionPane.showMessageDialog(null, "Cambios guardados de forma exitosa");
			visualizarEstudiante(usdao.getLista());
			edit.setVisible(false);
			break;
		}

		case "RegistrarAdministrador": {
			registrarAdministrador();
			break;
		}

		case "Activos": {
			normal();
			ArrayList<UsuarioDTO> aux = new ArrayList<>();
			aux.addAll(ordenar("Activo", false, usdao.getLista()));
			usdao.getLista().clear();
			usdao.getLista().addAll(aux);
			visualizarEstudiante(usdao.getLista());

			for (int i = 0; i < usdao.getLista().size(); i++) {
				if (usdao.getLista().get(i).isState()) {

				} else {
					admi.getPaneles().get(i).setVisible(false);
				}
			}

			break;
		}

		case "Inactivos": {
			normal();
			ArrayList<UsuarioDTO> aux = new ArrayList<>();
			aux.addAll(ordenar("Inactivo", true, usdao.getLista()));
			usdao.getLista().clear();
			usdao.getLista().addAll(aux);
			visualizarEstudiante(usdao.getLista());

			for (int i = 0; i < usdao.getLista().size(); i++) {
				if (!usdao.getLista().get(i).isState()) {

				} else {
					admi.getPaneles().get(i).setVisible(false);
				}
			}

			break;
		}

		case "Top nacionales": {
		    normal();
		    admi.getFil().setVisible(true);
		    String[] top = Ordenamientos.filtrar2(usdao.getLista());
		    admi.getFil().getItem1().setText(top[0]);
		    admi.getFil().getItem2().setText(top[1]);
		    admi.getFil().getItem3().setText(top[2]);

		    for (int i = 0; i < usdao.getLista().size(); i++) {
		        if (usdao.getLista().get(i).getCareer().contains(top[0])) {
		            admi.getPaneles().get(i).setBackground(Color.CYAN);
		        } else if (usdao.getLista().get(i).getCareer().contains(top[1])) {
		            admi.getPaneles().get(i).setBackground(Color.YELLOW);
		        } else if (usdao.getLista().get(i).getCareer().contains(top[2])) {
		            admi.getPaneles().get(i).setBackground(Color.MAGENTA);
		        } else {
		            admi.getPaneles().get(i).setVisible(false);
		        }
		    }

		    // Guardar la información como PDF
		    StringBuilder sb = new StringBuilder();
		    sb.append("Top Nacionales:\n");
		    sb.append("1. ").append(top[0]).append("\n");
		    sb.append("2. ").append(top[1]).append("\n");
		    sb.append("3. ").append(top[2]).append("\n");

		    Pdf.guardarPDF("top_nacionales.pdf", sb.toString());

		    break;
		}

		case "Top registrados":
		    normal();
		    admi.getFil().setVisible(true);
		    String[] top = Ordenamientos.filtrar1(usdao.getLista());
		    admi.getFil().getItem1().setText(top[0]);
		    admi.getFil().getItem2().setText(top[1]);
		    admi.getFil().getItem3().setText(top[2]);

		    // Eliminar los componentes existentes del panel
		    admi.getFil().removeAll();

		    JButton graficarButton = new JButton("Graficar Top 3");
		    graficarButton.setPreferredSize(new Dimension(100, graficarButton.getPreferredSize().height));
		    graficarButton.addActionListener(new ActionListener() {
		        private JFrame ventanaGrafico; // Ventana de gráfico

		        public void actionPerformed(ActionEvent e) {
		            // Cerrar la ventana de gráfico anterior, si existe
		            if (ventanaGrafico != null) {
		                ventanaGrafico.dispose();
		            }

		            // Crear dataset para la gráfica de pastel
		            DefaultPieDataset dataset = new DefaultPieDataset();
		            dataset.setValue(top[0], 1);
		            dataset.setValue(top[1], 1);
		            dataset.setValue(top[2], 1);

		            // Crear el gráfico de pastel
		            JFreeChart chart = ChartFactory.createPieChart("Top 3", dataset, true, true, false);

		            // Crear el panel de la gráfica
		            ChartPanel chartPanel = new ChartPanel(chart);
		            chartPanel.setPreferredSize(new java.awt.Dimension(500, 300));

		            // Crear una nueva ventana y agregar el panel de la gráfica a la ventana
		            ventanaGrafico = new JFrame("Gráfica Top 3");
		            ventanaGrafico.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		            ventanaGrafico.getContentPane().add(chartPanel);
		            ventanaGrafico.pack();
		            ventanaGrafico.setVisible(true);

		            // Cambiar el color de fondo de los paneles según el top
		            for (int i = 0; i < usdao.getLista().size(); i++) {
		                if (usdao.getLista().get(i).getCareer().contains(top[0])) {
		                    admi.getPaneles().get(i).setBackground(Color.CYAN);
		                } else if (usdao.getLista().get(i).getCareer().contains(top[1])) {
		                    admi.getPaneles().get(i).setBackground(Color.YELLOW);
		                } else if (usdao.getLista().get(i).getCareer().contains(top[2])) {
		                    admi.getPaneles().get(i).setBackground(Color.MAGENTA);
		                } else {
		                    admi.getPaneles().get(i).setVisible(false);
		                }
		            }

		            // Guardar la gráfica como PDF
		            Pdf.guardarPDF("grafica.pdf", ventanaGrafico);
		        }
		    });

		    admi.getFil().add(graficarButton, BorderLayout.SOUTH);
		    admi.getFil().revalidate();
		    admi.getFil().repaint();

		    break;
		case "Todos": {
			normal();
			break;
		}

		case "Ordenamiento": {
			String item = (String) admi.getOrdenar().getSelectedItem();
			ArrayList<UsuarioDTO> aux = new ArrayList<>();
			if (item.contains("A-Z") || item.contains("Menor-Mayor")) {
				aux.addAll(ordenar(item, true, usdao.getLista()));
				usdao.getLista().clear();
				usdao.getLista().addAll(aux);
				visualizarEstudiante(usdao.getLista());
			} else if (item.contains("Z-A") || item.contains("Mayor-Menor")) {
				aux.addAll(ordenar(item, false, usdao.getLista()));
				usdao.getLista().clear();
				usdao.getLista().addAll(aux);
				visualizarEstudiante(usdao.getLista());
			}
			break;
		}

		case "Buscar": {
			String item = admi.getBuscar().getText();
			ArrayList<UsuarioDTO> aux = new ArrayList<>();
			aux.addAll(ordenar(item, true, usdao.getLista()));
			usdao.getLista().clear();
			usdao.getLista().addAll(aux);
			visualizarEstudiante(usdao.getLista());
			break;
		}

		case "CANCELAR": {
			resad.setVisible(false);
			reses.setVisible(false);
			vp.setVisible(true);
			break;
		}
		case "ATRAS": {
			edit.setVisible(false);
			break;
		}

		default: {
			fot = 0;
			for (int i = 0; i < admi.getPaneles().size(); i++) {
				if (codigo.equals("num" + i)) {
					edit.reiniciar();
					edit.getNombre().setText(usdao.getLista().get(i).getName());
					edit.getLastname().setText(usdao.getLista().get(i).getLastname());
					edit.getId().setText(usdao.getLista().get(i).getId());
					edit.getLugar().setText(usdao.getLista().get(i).getOrigin());
					edit.getNacimiento().setText(lec.imprimirFecha(usdao.getLista().get(i).getBirthdate()));
					edit.getPrograma().setText(usdao.getLista().get(i).getCareer());
					edit.getCorreo().setText(usdao.getLista().get(i).getAlternativemail());
					edit.getUsuario().setText(usdao.getLista().get(i).getUser());
					edit.getIdentificador().setText(i + "");
					fot = (usdao.getLista().get(i).isState()) ? 1 : 2;
					edit.componentes(fot);
				}
			}
			edit.setVisible(true);
		}
		}
	}

	/**
	 * Este método se emplea para registrar un nuevo administrador en el sistema
	 * Los campos obligatorios deben estar completos.
	 * Se ha registrado un nuevo administrador en el sistema.
	 */
	public void registrarAdministrador() {
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
		// boolean state = codigoVerificacion(email, name);
		addao.add(new AdministradorDTO(id, name, lastname, gender, user, email, password));

	}

	/**
	 * Este método recopila la información ingresada en el formulario de
	 * registro, realiza las validaciones y luego crea y agrega un nuevo
	 * objeto de tipo UsuarioDTO a la lista de estudiantes.
	 * Los campos ingresados no sean nulos.
	 * La fecha sea valida.
	 * Se ha registrado un nuevo estudiante en el sistema.
	 * @trows Exception si un usuario no diligencia todos los campos
	 * obligatorios, dispara una excepción indicando que se deben completar
	 * todos los campos.
	 */
	public void registrarEstudiante() {
		try {
			String id = lec.leerEntero(reses.getDocumento().getText());
			String name = lec.leerPalabra(reses.getNombre().getText(), "nombre");
			String lastname = lec.leerPalabra(reses.getApellido().getText(), "apellido");
			String gender = "";
			if (reses.getF().isSelected()) {
				gender = "F";
			} else if (reses.getM().isSelected()) {
				gender = "M";
			}
			String user = lec.leerPalabra(reses.getUsuario().getText(),"usuario");
			String email = lec.leerCorreo(reses.getCorreo().getText());
			String career = (String) reses.getPrograma().getSelectedItem();
			String time = (String) reses.getJornada().getSelectedItem();
			Date birthdate = lec.leerFecha(reses.getFecha().getText());
			Date registro = new Date();
			if (id != null && name != null && lastname != null && user != null && email != null && birthdate != null) {
				boolean state = codigoVerificacion(email, name);
				usdao.add(new UsuarioDTO(id, name, lastname, gender, user, email, birthdate, state, career, time,
						origen, registro));
				reses.setVisible(false);
				JOptionPane.showMessageDialog(null, "Has sido registrado exitosamente");
				vp.setVisible(true);
				reses.getPaisNacimiento().setSelectedIndex(0);
				reses.getDepartamento().setSelectedIndex(0);
				reses.getMunicipio().setSelectedIndex(0);
				reses.getPrograma().setSelectedIndex(0);
				reses.getJornada().setSelectedIndex(0);
				reses.reiniciar();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Alguno de los parametros no ha sido ingresado correctamente");
		}
	}

	/**
	 * Este método recopila la información ingresada en el formulario de
	 * registro y actualiza la lista de estudiantes.
	 * Los campos ingresados no sean nulos.
	 * La fecha sea valida.
	 * Se ha actualizado la lista de estudiantes en el sistema.
	 * @param estado Es el estado que puede presentar un estudiante, bien sea 
	 * activo o inactivo. 
	 */
	public void actualizaciones(boolean estado) {
		String id = edit.getId().getText();
		String name = edit.getNombre().getText();
		String lastname = edit.getLastname().getText();
		String origen = edit.getLugar().getText();
		Date birthdate = lec.leerFecha(edit.getNacimiento().getText());
		String programa = edit.getPrograma().getText();
		String correo = edit.getCorreo().getText();
		String usuario = edit.getUsuario().getText();
		int iden = Integer.parseInt(edit.getIdentificador().getText());
		String gender = usdao.getLista().get(iden).getGender();
		String time = usdao.getLista().get(iden).getTime();
		Date registro = usdao.getLista().get(iden).getRegistrationdate();
		usdao.update(iden, new UsuarioDTO(id, name, lastname, gender, usuario, correo, birthdate, estado, programa,
				time, origen, registro));
	}

	/**
	 * Este método genera un código alfanumerico de verificación que se envia
	 * a un correo previamente .
	 * El email igresado sea válido.
	 * Se ha generado el codigo de verificación.
	 * @param email Es el email que ingresa el usuario al cual se le envia 
	 * el codigo de verificación.
	 * @param name Es el nombre ingresado por el usuario.
	 * @return boolean Si el código de verificación ingresado por el usuario es
	 * igual al código generado retorna verdadero, de lo contrari retorna falso.
	 */
	public boolean codigoVerificacion(String email, String name) {
		Random codigo = new Random();
		String[] letras = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
				"S", "T", "U", "V", "W", "X", "Y", "Z" };
		String[] numeros = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		String cod = "";
		for (int i = 0; i < 4; i++) {
			cod += letras[codigo.nextInt(25)];
			cod += numeros[codigo.nextInt(10)];
		}
		cor.start(email, cod, name);
		String verifica = JOptionPane.showInputDialog("Ingrese el codigo de verificacion enviado a su correo");
		if (cod.equals(verifica)) {
			return true;
		}
		return false;
	}

	/**
	 * Este método guarda el Id, nombre, apellido y usuario del estudiante en 
	 * cuatro arreglos distintos, los cuales se emplearan como parametro en 
	 * un metodo de visualización en la ventana editar.  
	 * La lista de UsuarioDTO está inicializada(no es null).
	 * Se han agregado los arreglos al metodo de visualización.
	 * @param lis Es el ArrayList de UsuarioDTO.
	 */
	public void visualizarEstudiante(ArrayList<UsuarioDTO> lis) {
		int cantidad = lis.size();
		String[] docs = new String[cantidad];
		String[] nombres = new String[cantidad];
		String[] apellidos = new String[cantidad];
		String[] usuarios = new String[cantidad];

		for (int i = 0; i < cantidad; i++) {
			docs[i] = lis.get(i).getId();
			nombres[i] = lis.get(i).getName();
			apellidos[i] = lis.get(i).getLastname();
			usuarios[i] = lis.get(i).getUser();
		}
		admi.componentes(docs, apellidos, nombres, usuarios, cantidad);
	}

	/**
	 * Este método asigna los oyentes a cada botón del arreglo, con un respectivo
	 * comando que los identifica de acuerdo a la posición en que se encuentra con 
	 * el fin de qe el administrador pueda editar cada uno de os estudiantes.  
	 * La lista de botones Editar está inicializada(no es null).
	 * Se ha asignado un oyente a cada botón del arreglo.
	 */
	public void nombrar() {
		for (int i = 0; i < admi.getEditar().size(); i++) {
			admi.getEditar().get(i).addActionListener(this);
			admi.getEditar().get(i).setActionCommand("num" + i);
		}

	}

	/**
	 * Este método genera un ordenamiento en los datos de acuerdo al item y al 
	 * orden que indique el usuario.
	 * El item y orden han sido seleccionados por el usuario.
	 * La lista de UsuarioDTO está inicializada(no es null).
	 * Se ha ordenado la información.
	 * @param item Es la opción que selecciona el usuario para ordenar los datos.
	 * @param orden Es una variable booleana que indica si el orden es ascendente o descendente.
	 * @param aux Lista de UsuariosDTO
	 * @return Arraylist<UsuarioDTO> retorna la lista de estudiantes ordenada de 
	 * acuerdo al método de ordenamiento elegido por el usuario.
	 */
	public ArrayList<UsuarioDTO> ordenar(String item, boolean orden, ArrayList<UsuarioDTO> aux) {
		if (item.contains("Nombre")) {
			aux = Ordenamientos.quickSort(orden, aux, 0, aux.size() - 1);
		} else if (item.contains("Apellido")) {
			aux = Ordenamientos.quickSort2(orden, aux, 0, aux.size() - 1);
		} else if (item.contains("Usuario")) {
			aux = Ordenamientos.bubbleSort(orden, aux);
		} else if (item.contains("Documento")) {
			aux = Ordenamientos.bubbleSort2(orden, aux);
		} else if (item.equals("Activo")) {
			aux = Ordenamientos.shellSort(orden, aux);
		} else if (item.equals("Inactivo")) {
			aux = Ordenamientos.shellSort(orden, aux);
		} else {
			aux = Ordenamientos.busqueda(item, aux);
		}
		return aux;
	}

	/**
	 * Este método permite la visualización de toda la lista de estudiantes sin 
	 * presentarse ningun filtrado ni ordenamiento en especifico.  
	 * La lista de estdiantes está inicializada(no es null).
	 * Se muestra toda la lista de estudiantes.
	 */
	public void normal() {
		for (int i = 0; i < usdao.getLista().size(); i++) {
			admi.getFil().setVisible(false);
			admi.getPaneles().get(i).setVisible(true);
			admi.getPaneles().get(i).setBackground(null);
		}
	}
}