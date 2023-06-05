/**
 * Esta clase es la encargada de estructurar la ventana de registro de 
 * un estudiante con sus respectivos componentes.
 */
package co.edu.unbosque.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

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

import co.edu.unbosque.model.persistance.FileHandler;

public class RegistrarEs extends JFrame {

	private JLabel fondo, formulario, dep, muni;
	private JPanel panel;
	private JScrollPane scroll;
	private JTextField nombre, apellido, documento, fecha, correo, usuario;
	private JButton guardar, cancelar;
	private JRadioButton m, f;
	private ButtonGroup grupo;
	private JComboBox<String> paisNacimiento, departamento, municipio, programa, jornada;

	/**
	 * Este método crea  una ventana, establece su tamaNo, posición,
	 * comportamiento de cierre. Agrega componentes de interfaz de 
	 * usuario, como botones y etiquetas, y los configura con la vista.
	 */
	public RegistrarEs() {
		this.setSize(1000, 650);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		Image logo = Toolkit.getDefaultToolkit().createImage("src/co/edu/unbosque/view/resources/logo.png");
		this.setIconImage(logo);
		
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
	/**
	 * Este método crea y configura varios componentes de la interfaz gráfica
	 * del usuario, tales como campos de texto,botones de radio, combobox y etiquetas,
	 * y los coloca en una ventana. El panel se coloca dentro de un JScrollPane para
	 * determinar el desplazamiento si los componentes exceden el tamaNo del área visible. 
	 */

	public void componente() {

		panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(950, 1200));

		nombre = new JTextField();
		nombre.setBounds(540, 334, 396, 34);
		nombre.setBorder(null);
		nombre.setFont(new Font("", Font.PLAIN, 20));
		panel.add(nombre);

		apellido = new JTextField();
		apellido.setBounds(540, 418, 396, 34);
		apellido.setBorder(null);
		apellido.setFont(new Font("", Font.PLAIN, 20));
		panel.add(apellido);

		documento = new JTextField();
		documento.setBounds(540, 503, 396, 34);
		documento.setBorder(null);
		documento.setFont(new Font("", Font.PLAIN, 20));
		panel.add(documento);

		fecha = new JTextField();
		fecha.setBounds(540, 587, 396, 34);
		fecha.setBorder(null);
		fecha.setFont(new Font("", Font.PLAIN, 20));
		panel.add(fecha);

		correo = new JTextField();
		correo.setBounds(540, 671, 396, 34);
		correo.setBorder(null);
		correo.setFont(new Font("", Font.PLAIN, 20));
		panel.add(correo);

		f = new JRadioButton();
		f.setBounds(704, 763, 20, 20);
		f.setOpaque(false);
		f.setBorderPainted(false);
		f.setContentAreaFilled(false);
		panel.add(f);

		m = new JRadioButton();
		m.setBounds(933, 763, 20, 20);
		m.setOpaque(false);
		m.setBorderPainted(false);
		m.setContentAreaFilled(false);
		panel.add(m);

		grupo = new ButtonGroup();
		grupo.add(f);
		grupo.add(m);

		usuario = new JTextField();
		usuario.setBounds(540, 1064, 396, 34);
		usuario.setBorder(null);
		usuario.setFont(new Font("", Font.PLAIN, 20));
		panel.add(usuario);

		paisNacimiento = new JComboBox<String>();
		paisNacimiento.setBounds(540, 840, 396, 34);
		cargarItemPais();

		dep = new JLabel();
		dep.setIcon(new ImageIcon("src/co/edu/unbosque/view/resources/bloque.png"));
		dep.setBounds(20, 924, 230, 38);
		panel.add(dep);

		departamento = new JComboBox<String>();
		departamento.setBounds(256, 924, 260, 34);
		cargarItemDepartamento();

		muni = new JLabel();
		muni.setIcon(new ImageIcon("src/co/edu/unbosque/view/resources/bloque.png"));
		muni.setBounds(520, 924, 170, 38);
		panel.add(muni);

		municipio = new JComboBox<String>();
		municipio.setBounds(695, 924, 260, 34);
		panel.add(municipio);

		programa = new JComboBox<String>();
		programa.setBounds(540, 1136, 250, 34);
		programa.addItem("Seleccione");
		programa.addItem("Ingenieria de Sistemas");
		programa.addItem("Ingenieria Ambiental");
		programa.addItem("Bioingenieria");
		programa.addItem("Ingenieria Electronica");
		programa.addItem("Ingenieria Industrial");
		panel.add(programa);

		jornada = new JComboBox<String>();
		jornada.setBounds(800, 1136, 150, 34);
		jornada.addItem("Diurno");
		jornada.addItem("Nocturno");
		panel.add(jornada);

		formulario = new JLabel();
		formulario.setBounds(0, 0, 984, 1200);
		ImageIcon form = new ImageIcon("src/co/edu/unbosque/view/resources/Formulario.png");
		formulario.setIcon(new ImageIcon(form.getImage().getScaledInstance(984, 1200, Image.SCALE_DEFAULT)));
		panel.add(formulario);

		scroll = new JScrollPane();
		scroll.setSize(984, 510);
		scroll.setViewportView(panel);
		add(scroll);
	}
	/**
	 * Este método se emplea para cargar los paises desde un archivo de 
	 * texto y los agrega como elementos a un JComboBox, que luego se 
	 * agrega a la vista.
	 *  El archivo de texto exista.
	 *  Se ha cargado todos los paises y se ha agregado al JComboBox.
	 */

	public void cargarItemPais() {
		String contenido = FileHandler.abrirArchivoDeTexto("ComboBox/Pais.txt");
		String[] lineas = contenido.split("\n");
		for (int i = 0; i < lineas.length; i++) {
			paisNacimiento.addItem(lineas[i]);
		}
		panel.add(paisNacimiento);
	}
	
	/**
	 * Este método se emplea para cargar los departamentos desde un archivo de 
	 * texto y los agrega como elementos a un JComboBox, que luego se 
	 * agrega a la vista.
	 * El archivo de texto exista.
	 * Se ha cargado todos los departamentos y se ha agregado al JComboBox.
	 */

	public void cargarItemDepartamento() {
		String contenido = FileHandler.abrirArchivoDeTexto("ComboBox/Departamento.txt");
		String[] lineas = contenido.split("\n");
		for (int i = 0; i < lineas.length; i++) {
			departamento.addItem(lineas[i]);
		}
		panel.add(departamento);
	}

	/**
	 * Este método reinicia los valores de los campos de texto y oculta 
	 * ciertos componentes de la interfaz para reestablecerla a su estado
	 * inicial.
	 * Se ha limpiado todos los valores de lo campos de texto.
	 */
	public void reiniciar() {
		nombre.setText("");
		apellido.setText("");
		documento.setText("");
		fecha.setText("");
		correo.setText("");
		usuario.setText("");
		
		departamento.setVisible(false);
		municipio.setVisible(false);
		jornada.setVisible(false);

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
	 * @return the dep
	 */
	public JLabel getDep() {
		return dep;
	}

	/**
	 * @param dep the dep to set
	 */
	public void setDep(JLabel dep) {
		this.dep = dep;
	}

	/**
	 * @return the muni
	 */
	public JLabel getMuni() {
		return muni;
	}

	/**
	 * @param muni the muni to set
	 */
	public void setMuni(JLabel muni) {
		this.muni = muni;
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
	 * @return the fecha
	 */
	public JTextField getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(JTextField fecha) {
		this.fecha = fecha;
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

	/**
	 * @return the paisNacimiento
	 */
	public JComboBox<String> getPaisNacimiento() {
		return paisNacimiento;
	}

	/**
	 * @param paisNacimiento the paisNacimiento to set
	 */
	public void setPaisNacimiento(JComboBox<String> paisNacimiento) {
		this.paisNacimiento = paisNacimiento;
	}

	/**
	 * @return the departamento
	 */
	public JComboBox<String> getDepartamento() {
		return departamento;
	}

	/**
	 * @param departamento the departamento to set
	 */
	public void setDepartamento(JComboBox<String> departamento) {
		this.departamento = departamento;
	}

	/**
	 * @return the municipio
	 */
	public JComboBox<String> getMunicipio() {
		return municipio;
	}

	/**
	 * @param municipio the municipio to set
	 */
	public void setMunicipio(JComboBox<String> municipio) {
		this.municipio = municipio;
	}

	/**
	 * @return the programa
	 */
	public JComboBox<String> getPrograma() {
		return programa;
	}

	/**
	 * @param programa the programa to set
	 */
	public void setPrograma(JComboBox<String> programa) {
		this.programa = programa;
	}

	/**
	 * @return the jornada
	 */
	public JComboBox<String> getJornada() {
		return jornada;
	}

	/**
	 * @param jornada the jornada to set
	 */
	public void setJornada(JComboBox<String> jornada) {
		this.jornada = jornada;
	}

}