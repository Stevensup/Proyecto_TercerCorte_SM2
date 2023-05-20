/**
 * 
 */
package co.edu.unbosque.view;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * @author annie
 *
 */
public class VentanaPrincipal extends JFrame {

	private JTextField usuario, contraseña;
	private JButton iniciar, registrarEs, registrarAd;
	private JLabel fondo;

	public VentanaPrincipal() {
		this.setSize(1000, 650);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);

		fondo = new JLabel();
		fondo.setBounds(0, 0, 1000, 650);
		ImageIcon fond = new ImageIcon("src/co/edu/unbosque/view/resources/VentanaPrincipal.gif");
		fondo.setIcon(new ImageIcon(fond.getImage().getScaledInstance(1000, 650, Image.SCALE_DEFAULT)));

		componente();

		add(fondo);

	}

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

		contraseña = new JTextField();
		contraseña.setBounds(438, 488, 193, 26);
		contraseña.setBorder(null);
		contraseña.setOpaque(false);
		contraseña.setFont(new Font("", Font.BOLD, 15));
		add(contraseña);

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
	 * @return the contraseña
	 */
	public JTextField getContraseña() {
		return contraseña;
	}

	/**
	 * @param contraseña the contraseña to set
	 */
	public void setContraseña(JTextField contraseña) {
		this.contraseña = contraseña;
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
