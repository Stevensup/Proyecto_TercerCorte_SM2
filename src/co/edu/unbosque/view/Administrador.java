/**
 * 
 */
package co.edu.unbosque.view;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * @author annie
 *
 */
public class Administrador extends JFrame {

	private ArrayList<JButton> editar;
	private ArrayList<JPanel> paneles;
	private ArrayList<JLabel> ndoc, names, lastname, user;
	private JComboBox<String> ordenar;
	private JTextField buscar;
	private JButton bus;
	private JLabel fondo;
	private JPanel panelprincipal;
	private JScrollPane scroll;

	public Administrador() {

		this.setSize(1000, 650);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);

		panelprincipal = new JPanel();
		panelprincipal.setLayout(new BoxLayout(panelprincipal, BoxLayout.Y_AXIS));

		editar = new ArrayList<JButton>();
		paneles = new ArrayList<JPanel>();
		ndoc = new ArrayList<JLabel>();
		names = new ArrayList<JLabel>();
		lastname = new ArrayList<JLabel>();
		user = new ArrayList<JLabel>();
		componentes();
	}
	
	public void componentes() {
		ordenar = new JComboBox<String>();
		ordenar.setBounds(153, 138, 425, 20);
		ordenar.addItem("2");
		this.add(ordenar);
		
		buscar = new JTextField();
		buscar.setBounds(580, 138, 300, 20);
		this.add(buscar);
		
		bus = new JButton("Buscar");
		bus.setBounds(881, 138, 100, 20);
		this.add(bus);
		
	}

	public void componentes(int a, String[] doc, String[] apellidos, String[] nombres, String[] usuario) {

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
			ndoc.get(i).setText(doc[i]);
			lastname.get(i).setText(apellidos[i]);
			names.get(i).setText(nombres[i]);
			user.get(i).setText(usuario[i]);
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
	 * @return the lastname
	 */
	public ArrayList<JLabel> getlastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setlastname(ArrayList<JLabel> lastname) {
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

}