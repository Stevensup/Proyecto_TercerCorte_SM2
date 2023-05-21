import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.model.UsuarioDTO;
import co.edu.unbosque.model.UsuarioDAO;

public class GraficoTarta extends JFrame {

    private JPanel contentPane;
    private JTextField tf1;
    private JTextField tf2;
    private JTextField tf3;
    private boolean bandera = false;
    private UsuarioDAO usuarioDAO;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GraficoTarta frame = new GraficoTarta();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public GraficoTarta() {
        usuarioDAO = new UsuarioDAO();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblPartido = new JLabel("Partido 1:");
        lblPartido.setBounds(46, 39, 61, 14);
        contentPane.add(lblPartido);

        JLabel lblPartido_1 = new JLabel("Partido 2:");
        lblPartido_1.setBounds(46, 69, 61, 14);
        contentPane.add(lblPartido_1);

        JLabel lblPartido_2 = new JLabel("Partido 3:");
        lblPartido_2.setBounds(46, 103, 61, 14);
        contentPane.add(lblPartido_2);

        tf1 = new JTextField();
        tf1.setBounds(117, 36, 86, 20);
        contentPane.add(tf1);
        tf1.setColumns(10);

        tf2 = new JTextField();
        tf2.setBounds(117, 66, 86, 20);
        contentPane.add(tf2);
        tf2.setColumns(10);

        tf3 = new JTextField();
        tf3.setBounds(117, 97, 86, 20);
        contentPane.add(tf3);
        tf3.setColumns(10);

        JButton btnGraficar = new JButton("Graficar");
        btnGraficar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                bandera = true;
                repaint();
            }
        });
        btnGraficar.setBounds(45, 138, 107, 37);
        contentPane.add(btnGraficar);

        JButton btnTop3 = new JButton("Top 3");
        btnTop3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                mostrarTop3();
            }
        });
        btnTop3.setBounds(162, 138, 107, 37);
        contentPane.add(btnTop3);

        JButton btnPromedio = new JButton("Promedio");
        btnPromedio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                mostrarPromedio();
            }
        });
        btnPromedio.setBounds(279, 138, 107, 37);
        contentPane.add(btnPromedio);
    }

    public void paint(Graphics g) {
        super.paint(g);
        if (bandera) {
            int p1 = Integer.parseInt(tf1.getText());
            int p2 = Integer.parseInt(tf2.getText());
            int p3 = Integer.parseInt(tf3.getText());

            int suma = p1 + p2 + p3;

            float ang1 = (float) (p1 * 360) / suma;
            float ang2 = (float) (p2 * 360) / suma;
            float ang3 = (float) (p3 * 360) / suma;

            g.setColor(Color.RED);
            g.fillArc(300, 100, 200, 200, 0, (int) ang1);

            g.setColor(Color.BLUE);
            g.fillArc(300, 100, 200, 200, (int) ang1, (int) ang2);

            g.setColor(Color.GREEN);
            g.fillArc(300, 100, 200, 200, (int) (ang1 + ang2), (int) ang3);
        }
    }

    private void mostrarTop3() {
        ArrayList<UsuarioDTO> listaFiltrada = filtrarUsuarios(usuarioDAO.getLista());

        listaFiltrada.sort(new Comparator<UsuarioDTO>() {
            public int compare(UsuarioDTO u1, UsuarioDTO u2) {
                return Integer.compare(u2.getTime(), u1.getTime());
            }
        });

        StringBuilder sb = new StringBuilder("Top 3 Usuarios:\n");
        for (int i = 0; i < 3 && i < listaFiltrada.size(); i++) {
            UsuarioDTO usuario = listaFiltrada.get(i);
            sb.append("Nombre: ").append(usuario.getName()).append(", Tiempo: ").append(Integer.toString(usuario.getTime())).append("\n");
        }

        System.out.println(sb.toString());
    }

    private void mostrarPromedio() {
        ArrayList<UsuarioDTO> listaFiltrada = filtrarUsuarios(usuarioDAO.getLista());

        int suma = 0;
        for (UsuarioDTO usuario : listaFiltrada) {
            suma += usuario.getTime();
        }

        double promedio = (double) suma / listaFiltrada.size();
        System.out.println("Promedio de Tiempo: " + promedio);
    }

    private ArrayList<UsuarioDTO> filtrarUsuarios(ArrayList<UsuarioDTO> lista) {
        ArrayList<UsuarioDTO> listaFiltrada = new ArrayList<>();
        int tiempo1 = Integer.parseInt(tf1.getText());
        int tiempo2 = Integer.parseInt(tf2.getText());
        int tiempo3 = Integer.parseInt(tf3.getText());

        for (UsuarioDTO usuario : lista) {
            if (usuario.getTime() >= tiempo1 && usuario.getTime() >= tiempo2 && usuario.getTime() >= tiempo3) {
                listaFiltrada.add(usuario);
            }
        }

        return listaFiltrada;
    }

}
