/**
 * Esta clase es la encargada de mostrarle al usuario la ventana que 
 * corresponde al menu principal, donde podra tomar desicion sobre 
 * cada una de las opciones que tiene como usuario del sistema como
 * administrar o registrar a los UsuarioDTO y AdministradorDTO.
 */
package co.edu.unbosque.view;

import java.awt.Font;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URI;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * @author Codernautas
 *
 */
public class VentanaPrincipal extends JFrame {

	private JTextField usuario, contraseNa;
	private JButton iniciar, registrarEs, registrarAd;
	private JLabel fondo;

	/**
	 * Este método constructor crea  una ventana de tipo JFrame y le asigna 
	 * caracteristicas propias como tamaNo, posición. Ademas de agregar 
	 * los componentes corrrespondientes.
	 */
	public VentanaPrincipal() {
		this.setSize(1000, 650);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		Image logo = Toolkit.getDefaultToolkit().createImage("src/co/edu/unbosque/view/resources/logo.png");
		this.setIconImage(logo);
		
		fondo = new JLabel();
		fondo.setBounds(0, 0, 1000, 650);
		ImageIcon fond = new ImageIcon("src/co/edu/unbosque/view/resources/VentanaPrincipal.gif");
		fondo.setIcon(new ImageIcon(fond.getImage().getScaledInstance(1000, 650, Image.SCALE_DEFAULT)));

		componente();

		add(fondo);

	}

	/**
	 * Inicializa todos los componentes pertenecientes a esta clase les asigna una
	 * posicion y caracteristicas visuales.
	 */
	public void componente() {
		iniciar = new JButton();
		iniciar.setBounds(570, 530, 67, 29);
		iniciar.setOpaque(false);
		iniciar.setBorderPainted(false);
		iniciar.setContentAreaFilled(false);
		add(iniciar);

		usuario = new JTextField();
		usuario.setBounds(438, 425, 193, 26);
		usuario.setBorder(null);
		usuario.setOpaque(false);
		usuario.setFont(new Font("", Font.BOLD, 15));
		add(usuario);

		contraseNa = new JTextField();
		contraseNa.setBounds(438, 488, 193, 26);
		contraseNa.setBorder(null);
		contraseNa.setOpaque(false);
		contraseNa.setFont(new Font("", Font.BOLD, 15));
		add(contraseNa);

		registrarEs = new JButton();
		registrarEs.setBounds(362, 579, 110, 18);
		registrarEs.setOpaque(false);
		registrarEs.setBorderPainted(false);
		registrarEs.setContentAreaFilled(false);
		add(registrarEs);

		registrarAd = new JButton();
		registrarAd.setBounds(525, 579, 110, 18);
		registrarAd.setOpaque(false);
		registrarAd.setBorderPainted(false);
		registrarAd.setContentAreaFilled(false);
		add(registrarAd);

	}

	/**
	 * A continuacion se establecen los get y set de los componentes 
	 * de esta clase cuya funcion es perminir la manipulacion y edicion
	 * de las caracteristicas de los componentes
	 */
	
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
	 * @return the contraseNa
	 */
	public JTextField getContraseNa() {
		return contraseNa;
	}

	/**
	 * @param contraseNa the contraseNa to set
	 */
	public void setContraseNa(JTextField contraseNa) {
		this.contraseNa = contraseNa;
	}

	/**
	 * @return the iniciar
	 */
	public JButton getIniciar() {
		return iniciar;
	}

	/**
	 * @param iniciar the iniciar to set
	 */
	public void setIniciar(JButton iniciar) {
		this.iniciar = iniciar;
	}

	/**
	 * @return the registrarEs
	 */
	public JButton getRegistrarEs() {
		return registrarEs;
	}

	/**
	 * @param registrarEs the registrarEs to set
	 */
	public void setRegistrarEs(JButton registrarEs) {
		this.registrarEs = registrarEs;
	}

	/**
	 * @return the registrarAd
	 */
	public JButton getRegistrarAd() {
		return registrarAd;
	}

	/**
	 * @param registrarAd the registrarAd to set
	 */
	public void setRegistrarAd(JButton registrarAd) {
		this.registrarAd = registrarAd;
	}

}
