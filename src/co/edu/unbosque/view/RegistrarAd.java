package co.edu.unbosque.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

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

public class RegistrarAd extends JFrame {

	private JLabel fondo, formulario;
	private JPanel panel;
	private JScrollPane scroll;
	private JTextField nombre, apellido, documento, correo, usuario, contraseña;
	private JButton guardar, cancelar;
	private JRadioButton m, f;
	private ButtonGroup grupo;;

	public RegistrarAd() {
		this.setSize(1000, 650);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);

		fondo = new JLabel();
		fondo.setBounds(0, 0, 1000, 650);
		ImageIcon fond = new ImageIcon("src/co/edu/unbosque/view/resources/Agregar.png");
		fondo.setIcon(new ImageIcon(fond.getImage().getScaledInstance(995, 600, Image.SCALE_DEFAULT)));

		componente();

		cancelar = new JButton();
		cancelar.setBounds(90, 513, 235, 80);
		cancelar.setBorderPainted(false);
		cancelar.setContentAreaFilled(false);
		add(cancelar);

		guardar = new JButton();
		guardar.setBorderPainted(false);
		guardar.setContentAreaFilled(false);
		guardar.setBounds(660, 513, 235, 80);
		add(guardar);

		add(fondo);
	}

	public void componente() {

		panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(953, 1003));

		nombre = new JTextField();
		nombre.setBounds(542, 349, 390, 33);
		nombre.setBorder(null);
		nombre.setFont(new Font("", Font.PLAIN, 20));
		panel.add(nombre);

		apellido = new JTextField();
		apellido.setBounds(542, 440, 390, 33);
		apellido.setBorder(null);
		apellido.setFont(new Font("", Font.PLAIN, 20));
		panel.add(apellido);

		documento = new JTextField();
		documento.setBounds(542, 527, 390, 33);
		documento.setBorder(null);
		documento.setFont(new Font("", Font.PLAIN, 20));
		panel.add(documento);

		correo = new JTextField();
		correo.setBounds(542, 617, 390, 33);
		correo.setBorder(null);
		correo.setFont(new Font("", Font.PLAIN, 20));
		panel.add(correo);

		f = new JRadioButton();
		f.setBounds(696, 711, 20, 20);
		f.setOpaque(false);
		f.setBorderPainted(false);
		f.setContentAreaFilled(false);
		panel.add(f);

		m = new JRadioButton();
		m.setBounds(911, 711, 20, 20);
		m.setOpaque(false);
		m.setBorderPainted(false);
		m.setContentAreaFilled(false);
		panel.add(m);

		grupo = new ButtonGroup();
		grupo.add(f);
		grupo.add(m);

		usuario = new JTextField();
		usuario.setBounds(542, 846, 390, 33);
		usuario.setBorder(null);
		usuario.setFont(new Font("", Font.PLAIN, 20));
		panel.add(usuario);

		contraseña = new JTextField();
		contraseña.setBounds(542, 924, 390, 33);
		contraseña.setBorder(null);
		contraseña.setFont(new Font("", Font.PLAIN, 20));
		panel.add(contraseña);

		formulario = new JLabel();
		formulario.setBounds(0, 0, 970, 1003);
		ImageIcon form = new ImageIcon("src/co/edu/unbosque/view/resources/FormularioAdmi.png");
		formulario.setIcon(new ImageIcon(form.getImage().getScaledInstance(970, 1003, Image.SCALE_DEFAULT)));
		panel.add(formulario);

		scroll = new JScrollPane();
		scroll.setSize(984, 510);
		scroll.setViewportView(panel);
		add(scroll);
	}

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
	 * @return the formulario
	 */
	public JLabel getFormulario() {
		return formulario;
	}

	/**
	 * @param formulario the formulario to set
	 */
	public void setFormulario(JLabel formulario) {
		this.formulario = formulario;
	}

	/**
	 * @return the panel
	 */
	public JPanel getPanel() {
		return panel;
	}

	/**
	 * @param panel the panel to set
	 */
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	/**
	 * @return the scroll
	 */
	public JScrollPane getScroll() {
		return scroll;
	}

	/**
	 * @param scroll the scroll to set
	 */
	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
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
	 * @return the apellido
	 */
	public JTextField getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(JTextField apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the documento
	 */
	public JTextField getDocumento() {
		return documento;
	}

	/**
	 * @param documento the documento to set
	 */
	public void setDocumento(JTextField documento) {
		this.documento = documento;
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
	 * @return the m
	 */
	public JRadioButton getM() {
		return m;
	}

	/**
	 * @param m the m to set
	 */
	public void setM(JRadioButton m) {
		this.m = m;
	}

	/**
	 * @return the f
	 */
	public JRadioButton getF() {
		return f;
	}

	/**
	 * @param f the f to set
	 */
	public void setF(JRadioButton f) {
		this.f = f;
	}

	/**
	 * @return the grupo
	 */
	public ButtonGroup getGrupo() {
		return grupo;
	}

	/**
	 * @param grupo the grupo to set
	 */
	public void setGrupo(ButtonGroup grupo) {
		this.grupo = grupo;
	}

}
