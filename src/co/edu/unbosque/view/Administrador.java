/**
 * Esta clase es la encargada de mostrarle al usuario la ventana que 
 * permite administrar todos los UsuarioDTO con sus respectivos componentes
 * y herramientas.
 */
package co.edu.unbosque.view;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * @author Codernautas
 */
public class Administrador extends JFrame {

	private ArrayList<JButton> editar;
	private ArrayList<JPanel> paneles;
	private ArrayList<JLabel> ndoc, names, lastname, user;
	private JComboBox<String> ordenar;
	private JRadioButton acti, inacti, registrado, nacional, todos;
	private ButtonGroup grupo;
	private JTextField buscar;
	private JButton bus, salir;
	private JLabel fondo;
	private JPanel panelprincipal;
	private JScrollPane scroll;
	private Filtros fil;

	/**
	 * Este método constructor crea  una ventana de tipo JFrame y le asigna 
	 * caracteristicas propias como tamaNo, posición. Ademas de agregar 
	 * los componentes corrrespondientes e inicializar los Arraylist de esta
	 * clase, que permiten cargar la informacion de todos los UsuarioDTO.
	 */
	public Administrador() {
		this.setSize(1000, 650);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		Image logo = Toolkit.getDefaultToolkit().createImage("src/co/edu/unbosque/view/resources/logo.png");
		this.setIconImage(logo);

		panelprincipal = new JPanel();
		panelprincipal.setLayout(new BoxLayout(panelprincipal, BoxLayout.Y_AXIS));

		editar = new ArrayList<JButton>();
		paneles = new ArrayList<JPanel>();
		ndoc = new ArrayList<JLabel>();
		names = new ArrayList<JLabel>();
		lastname = new ArrayList<JLabel>();
		user = new ArrayList<JLabel>();
		fil = new Filtros();
		add(fil);
		componentes();
	}

	
	/**
	 * Inicializa todos los componentes pertenecientes a esta clase les asigna una
	 * posicion y caracteristicas visuales
	 */
	public void componentes() {
		ordenar = new JComboBox<String>();
		ordenar.setBounds(153, 138, 425, 20);
		ordenar.addItem("↓↑ Ordenar");
		ordenar.addItem("Documento (Menor-Mayor)");
		ordenar.addItem("Documento (Mayor-Menor)");
		ordenar.addItem("Nombre (A-Z)");
		ordenar.addItem("Nombre (Z-A)");
		ordenar.addItem("Apellido (A-Z)");
		ordenar.addItem("Apellido (Z-A)");
		ordenar.addItem("Usuario (A-Z)");
		ordenar.addItem("Usuario (Z-A)");
		this.add(ordenar);

		buscar = new JTextField();
		buscar.setBounds(580, 138, 300, 20);
		this.add(buscar);

		bus = new JButton("Buscar");
		bus.setBounds(881, 138, 100, 20);
		this.add(bus);

		salir = new JButton();
		salir.setBounds(23, 554, 100, 50);
		salir.setBorderPainted(false);
		salir.setContentAreaFilled(false);
		this.add(salir);

		acti = new JRadioButton();
		acti.setBounds(119, 230, 20, 20);
		acti.setOpaque(false);
		acti.setBorderPainted(false);
		acti.setContentAreaFilled(false);
		this.add(acti);

		inacti = new JRadioButton();
		inacti.setBounds(119, 280, 20, 20);
		inacti.setOpaque(false);
		inacti.setBorderPainted(false);
		inacti.setContentAreaFilled(false);
		this.add(inacti);

		registrado = new JRadioButton();
		registrado.setBounds(119, 332, 20, 20);
		registrado.setOpaque(false);
		registrado.setBorderPainted(false);
		registrado.setContentAreaFilled(false);
		this.add(registrado);

		nacional = new JRadioButton();
		nacional.setBounds(119, 387, 20, 20);
		nacional.setOpaque(false);
		nacional.setBorderPainted(false);
		nacional.setContentAreaFilled(false);
		this.add(nacional);

		todos = new JRadioButton();
		todos.setBounds(119, 440, 20, 20);
		todos.setOpaque(false);
		todos.setBorderPainted(false);
		todos.setContentAreaFilled(false);
		this.add(todos);

		grupo = new ButtonGroup();
		grupo.add(acti);
		grupo.add(inacti);
		grupo.add(registrado);
		grupo.add(nacional);
		grupo.add(todos);

	}

	/**
	 * Le asigna a cada label la información de su respectivo usuario según la
	 * posición asignada a este
	 * 
	 * @param doc
	 * @param apellidos
	 * @param nombres
	 * @param usuario
	 * @param a
	 */
	public void componentes(String[] doc, String[] apellidos, String[] nombres, String[] usuario, int a) {
		for (int i = 0; i < a; i++) {
			ndoc.get(i).setText(doc[i]);
			lastname.get(i).setText(apellidos[i]);
			names.get(i).setText(nombres[i]);
			user.get(i).setText(usuario[i]);
		}
	}

	/**
	 * Llena cada arraylist con su respectivo elemento segun la cantidad que ingresa
	 * como parametro. Adicionalmente agrega todos los label pertenecientes al mismo
	 * usuario a su respectivo panel. Finalmente todos los paneles se adicionan al
	 * panel principal
	 * 
	 * @param a
	 */
	public void componentes(int a) {

		for (int i = 0; i < a; i++) {
			paneles.add(new JPanel());
			editar.add(new JButton("EDITAR"));
			ndoc.add(new JLabel());
			names.add(new JLabel());
			lastname.add(new JLabel());
			user.add(new JLabel());
		}
		for (int i = 0; i < a; i++) {
			paneles.get(i).setSize(300, 20);
			paneles.get(i).setLayout(new GridLayout(1, 5));
			paneles.get(i).add(ndoc.get(i));
			paneles.get(i).add(lastname.get(i));
			paneles.get(i).add(names.get(i));
			paneles.get(i).add(user.get(i));
			paneles.get(i).add(editar.get(i));
		}

		for (int i = 0; i < a; i++) {
			panelprincipal.add(paneles.get(i));
		}

		scroll = new JScrollPane();
		scroll.setBounds(153, 166, 830, 435);
		scroll.setViewportView(panelprincipal);
		this.add(scroll);

		fondo = new JLabel();
		fondo.setBounds(0, 0, 1000, 650);
		fondo.setIcon(new ImageIcon("src/co/edu/unbosque/view/resources/Administrador.png"));
		this.add(fondo);
	}

	/**
	 * A continuacion se establecen los get y set de los componentes 
	 * de esta clase cuya funcion es perminir la manipulacion y edicion
	 * de las caracteristicas de los componentes
	 */

	/**
	 * @return the editar
	 */
	public ArrayList<JButton> getEditar() {
		return editar;
	}


	/**
	 * @param editar the editar to set
	 */
	public void setEditar(ArrayList<JButton> editar) {
		this.editar = editar;
	}


	/**
	 * @return the paneles
	 */
	public ArrayList<JPanel> getPaneles() {
		return paneles;
	}


	/**
	 * @param paneles the paneles to set
	 */
	public void setPaneles(ArrayList<JPanel> paneles) {
		this.paneles = paneles;
	}


	/**
	 * @return the ndoc
	 */
	public ArrayList<JLabel> getNdoc() {
		return ndoc;
	}


	/**
	 * @param ndoc the ndoc to set
	 */
	public void setNdoc(ArrayList<JLabel> ndoc) {
		this.ndoc = ndoc;
	}


	/**
	 * @return the names
	 */
	public ArrayList<JLabel> getNames() {
		return names;
	}


	/**
	 * @param names the names to set
	 */
	public void setNames(ArrayList<JLabel> names) {
		this.names = names;
	}


	/**
	 * @return the lastname
	 */
	public ArrayList<JLabel> getLastname() {
		return lastname;
	}


	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(ArrayList<JLabel> lastname) {
		this.lastname = lastname;
	}


	/**
	 * @return the user
	 */
	public ArrayList<JLabel> getUser() {
		return user;
	}


	/**
	 * @param user the user to set
	 */
	public void setUser(ArrayList<JLabel> user) {
		this.user = user;
	}


	/**
	 * @return the ordenar
	 */
	public JComboBox<String> getOrdenar() {
		return ordenar;
	}


	/**
	 * @param ordenar the ordenar to set
	 */
	public void setOrdenar(JComboBox<String> ordenar) {
		this.ordenar = ordenar;
	}


	/**
	 * @return the acti
	 */
	public JRadioButton getActi() {
		return acti;
	}


	/**
	 * @param acti the acti to set
	 */
	public void setActi(JRadioButton acti) {
		this.acti = acti;
	}


	/**
	 * @return the inacti
	 */
	public JRadioButton getInacti() {
		return inacti;
	}


	/**
	 * @param inacti the inacti to set
	 */
	public void setInacti(JRadioButton inacti) {
		this.inacti = inacti;
	}


	/**
	 * @return the registrado
	 */
	public JRadioButton getRegistrado() {
		return registrado;
	}


	/**
	 * @param registrado the registrado to set
	 */
	public void setRegistrado(JRadioButton registrado) {
		this.registrado = registrado;
	}


	/**
	 * @return the nacional
	 */
	public JRadioButton getNacional() {
		return nacional;
	}


	/**
	 * @param nacional the nacional to set
	 */
	public void setNacional(JRadioButton nacional) {
		this.nacional = nacional;
	}


	/**
	 * @return the todos
	 */
	public JRadioButton getTodos() {
		return todos;
	}


	/**
	 * @param todos the todos to set
	 */
	public void setTodos(JRadioButton todos) {
		this.todos = todos;
	}


	/**
	 * @return the buscar
	 */
	public JTextField getBuscar() {
		return buscar;
	}


	/**
	 * @param buscar the buscar to set
	 */
	public void setBuscar(JTextField buscar) {
		this.buscar = buscar;
	}


	/**
	 * @return the bus
	 */
	public JButton getBus() {
		return bus;
	}


	/**
	 * @param bus the bus to set
	 */
	public void setBus(JButton bus) {
		this.bus = bus;
	}


	/**
	 * @return the salir
	 */
	public JButton getSalir() {
		return salir;
	}


	/**
	 * @param salir the salir to set
	 */
	public void setSalir(JButton salir) {
		this.salir = salir;
	}

	/**
	 * @return the panelprincipal
	 */
	public JPanel getPanelprincipal() {
		return panelprincipal;
	}


	/**
	 * @param panelprincipal the panelprincipal to set
	 */
	public void setPanelprincipal(JPanel panelprincipal) {
		this.panelprincipal = panelprincipal;
	}


	/**
	 * @return the fil
	 */
	public Filtros getFil() {
		return fil;
	}


	/**
	 * @param fil the fil to set
	 */
	public void setFil(Filtros fil) {
		this.fil = fil;
	}
}