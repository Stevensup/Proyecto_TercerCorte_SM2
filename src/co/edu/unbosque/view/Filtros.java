/**
 * Esta clase es la encargada de mostrarle al usuario un panel que 
 * indica las viNetas y color correspondiente a los filtrados por 
 * cantidad de estudiantes registrados y cantidad de estudiantes 
 * nacionales.
 */
package co.edu.unbosque.view;

import java.awt.Color;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Codernautas
 *
 */
public class Filtros extends JPanel {

	private JLabel uno, dos, tres;
	private JLabel item1, item2, item3;

	/**
	 * Este método constructor crea  una ventana de tipo JPanel y le asigna 
	 * caracteristicas propias como tamaNo, posición. Ademas de agregar 
	 * los componentes corrrespondientes inicializandolos y asignandoles 
	 * caractesristicas visuales como titulo, color y letra.
	 */
	
	public Filtros() {
		this.setBounds(10, 10, 250, 120);
		this.setBackground(new Color(17, 134, 120));
		this.setLayout(new GridLayout(3, 3));

		uno = new JLabel("         TOP 1");
		uno.setOpaque(true);
		uno.setFont(new Font("", Font.BOLD, 15));
		uno.setBackground(Color.CYAN);
		add(uno);

		item1 = new JLabel();
		item1.setForeground(Color.WHITE);
		item1.setFont(new Font("", Font.BOLD, 15));
		add(item1);

		dos = new JLabel("         TOP 2");
		dos.setOpaque(true);
		dos.setFont(new Font("", Font.BOLD, 15));
		dos.setBackground(Color.YELLOW);
		add(dos);

		item2 = new JLabel();
		item2.setForeground(Color.WHITE);
		item2.setFont(new Font("", Font.BOLD, 15));
		add(item2);

		tres = new JLabel("         TOP 3");
		tres.setOpaque(true);
		tres.setFont(new Font("", Font.BOLD, 15));
		tres.setBackground(Color.MAGENTA);
		add(tres);

		item3 = new JLabel();
		item3.setForeground(Color.WHITE);
		item3.setFont(new Font("", Font.BOLD, 15));
		add(item3);
	}
	
	/**
	 * A continuacion se establecen los get y set de los componentes 
	 * de esta clase cuya funcion es perminir la manipulacion y edicion
	 * de las caracteristicas de los componentes
	 */
	
	/**
	 * @return the uno
	 */
	public JLabel getUno() {
		return uno;
	}

	/**
	 * @param uno the uno to set
	 */
	public void setUno(JLabel uno) {
		this.uno = uno;
	}

	/**
	 * @return the dos
	 */
	public JLabel getDos() {
		return dos;
	}

	/**
	 * @param dos the dos to set
	 */
	public void setDos(JLabel dos) {
		this.dos = dos;
	}

	/**
	 * @return the tres
	 */
	public JLabel getTres() {
		return tres;
	}

	/**
	 * @param tres the tres to set
	 */
	public void setTres(JLabel tres) {
		this.tres = tres;
	}

	/**
	 * @return the item1
	 */
	public JLabel getItem1() {
		return item1;
	}

	/**
	 * @param item1 the item1 to set
	 */
	public void setItem1(JLabel item1) {
		this.item1 = item1;
	}

	/**
	 * @return the item2
	 */
	public JLabel getItem2() {
		return item2;
	}

	/**
	 * @param item2 the item2 to set
	 */
	public void setItem2(JLabel item2) {
		this.item2 = item2;
	}

	/**
	 * @return the item3
	 */
	public JLabel getItem3() {
		return item3;
	}

	/**
	 * @param item3 the item3 to set
	 */
	public void setItem3(JLabel item3) {
		this.item3 = item3;
	}
}
