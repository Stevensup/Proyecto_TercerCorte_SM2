/**
 * Esta clase es la encargada de mostrarle al usuario la ventana de edicion de 
 * un UsuarioDTO con sus respectivos componentes.
 */
package co.edu.unbosque.view;

import java.awt.Color;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * @author Codernautas
 *
 */
public class Editar extends JFrame {
	private JLabel fondo, identificador;
	private JTextField nombre, lastname, id, lugar, nacimiento, programa, correo, usuario;
	private JButton cancelar, eliminar, estado, guardar;

	/**
	 * Este método constructor crea  una ventana de tipo JFrame y le asigna 
	 * caracteristicas propias como tamaNo, posición. Ademas de agregar 
	 * los componentes corrrespondientes.
	 */
	public Editar() {
		this.setSize(800, 450);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.setLayout(null);
		Image logo = Toolkit.getDefaultToolkit().createImage("src/co/edu/unbosque/view/resources/logo.png");
		this.setIconImage(logo);

		fondo = new JLabel();
		fondo.setBounds(0, 0, 800, 450);

		componentes();
	}
	
	/**
	 * Inicializa cada componente y le asigna caracteristicas especificas
	 * como ubicacion y color
	 */
	public void componentes() {
		identificador = new JLabel();
		identificador.setBounds(200, 80, 10, 10);
		identificador.setForeground(Color.WHITE);
		add(identificador);

		nombre = new JTextField();
		nombre.setBounds(272, 82, 135, 22);
		nombre.setBorder(null);
		nombre.setFont(new Font("", Font.BOLD, 15));
		add(nombre);

		lastname = new JTextField();
		lastname.setBounds(272, 150, 135, 22);
		lastname.setBorder(null);
		lastname.setFont(new Font("", Font.BOLD, 15));
		add(lastname);

		id = new JTextField();
		id.setBounds(578, 83, 170, 22);
		id.setBorder(null);
		id.setFont(new Font("", Font.BOLD, 15));
		add(id);

		lugar = new JTextField();
		lugar.setBounds(578, 150, 170, 22);
		lugar.setBorder(null);
		lugar.setFont(new Font("", Font.BOLD, 15));
		add(lugar);

		nacimiento = new JTextField();
		nacimiento.setBounds(250, 217, 112, 22);
		nacimiento.setBorder(null);
		nacimiento.setFont(new Font("", Font.BOLD, 15));
		add(nacimiento);

		programa = new JTextField();
		programa.setBounds(577, 217, 173, 22);
		programa.setBorder(null);
		programa.setFont(new Font("", Font.BOLD, 15));
		add(programa);

		correo = new JTextField();
		correo.setBounds(130, 284, 235, 21);
		correo.setBorder(null);
		correo.setFont(new Font("", Font.BOLD, 15));
		add(correo);

		usuario = new JTextField();
		usuario.setBounds(576, 284, 173, 22);
		usuario.setBorder(null);
		usuario.setFont(new Font("", Font.BOLD, 15));
		add(usuario);

		cancelar = new JButton();
		cancelar.setBounds(60, 353, 110, 43);
		cancelar.setBorderPainted(false);
		cancelar.setContentAreaFilled(false);
		add(cancelar);

		eliminar = new JButton();
		eliminar.setBounds(218, 353, 110, 43);
		eliminar.setBorderPainted(false);
		eliminar.setContentAreaFilled(false);
		add(eliminar);

		estado = new JButton();
		estado.setBounds(372, 353, 125, 43);
		estado.setBorderPainted(false);
		estado.setContentAreaFilled(false);
		add(estado);

		guardar = new JButton();
		guardar.setBounds(540, 353, 202, 43);
		guardar.setBorderPainted(false);
		guardar.setContentAreaFilled(false);
		add(guardar);
	}

	/**
	 * Asigna Una imagen de fondo especifica dependiendo del parametro
	 * a que indica el estado del UsuarioDTO
	 * @param a
	 */
	public void componentes(int a) {
		fondo.setIcon(new ImageIcon("src/co/edu/unbosque/view/resources/Editar" + a + ".png"));
		add(fondo);
	}

	/***
	 * Permite volver a su estado original algunos elementos de esta clase
	 */
	public void reiniciar() {
		fondo.setIcon(null);
	}
	
	/**
	 * A continuacion se establecen los get y set de los componentes 
	 * de esta clase cuya funcion es perminir la manipulacion y edicion
	 * de las caracteristicas de los componentes
	 */

	/**
	 * @return the fondo
	 */
	public JLabel getFondo() {
		return fondo;
	}

	/**
	 * @param fondo the fondo to set
	 */
	public void setFondo(JLabel fondo) {
		this.fondo = fondo;
	}

	/**
	 * @return the nombre
	 */
	public JTextField getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(JTextField nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the lastname
	 */
	public JTextField getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(JTextField lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the id
	 */
	public JTextField getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(JTextField id) {
		this.id = id;
	}

	/**
	 * @return the lugar
	 */
	public JTextField getLugar() {
		return lugar;
	}

	/**
	 * @param lugar the lugar to set
	 */
	public void setLugar(JTextField lugar) {
		this.lugar = lugar;
	}

	/**
	 * @return the nacimiento
	 */
	public JTextField getNacimiento() {
		return nacimiento;
	}

	/**
	 * @param nacimiento the nacimiento to set
	 */
	public void setNacimiento(JTextField nacimiento) {
		this.nacimiento = nacimiento;
	}

	/**
	 * @return the programa
	 */
	public JTextField getPrograma() {
		return programa;
	}

	/**
	 * @param programa the programa to set
	 */
	public void setPrograma(JTextField programa) {
		this.programa = programa;
	}

	/**
	 * @return the correo
	 */
	public JTextField getCorreo() {
		return correo;
	}

	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(JTextField correo) {
		this.correo = correo;
	}

	/**
	 * @return the usuario
	 */
	public JTextField getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(JTextField usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the cancelar
	 */
	public JButton getCancelar() {
		return cancelar;
	}

	/**
	 * @param cancelar the cancelar to set
	 */
	public void setCancelar(JButton cancelar) {
		this.cancelar = cancelar;
	}

	/**
	 * @return the eliminar
	 */
	public JButton getEliminar() {
		return eliminar;
	}

	/**
	 * @param eliminar the eliminar to set
	 */
	public void setEliminar(JButton eliminar) {
		this.eliminar = eliminar;
	}

	/**
	 * @return the estado
	 */
	public JButton getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(JButton estado) {
		this.estado = estado;
	}

	/**
	 * @return the guardar
	 */
	public JButton getGuardar() {
		return guardar;
	}

	/**
	 * @param guardar the guardar to set
	 */
	public void setGuardar(JButton guardar) {
		this.guardar = guardar;
	}

	/**
	 * @return the identificador
	 */
	public JLabel getIdentificador() {
		return identificador;
	}

	/**
	 * @param identificador the identificador to set
	 */
	public void setIdentificador(JLabel identificador) {
		this.identificador = identificador;
	}

}
