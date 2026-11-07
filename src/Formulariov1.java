import javax.swing.*;
import java.util.ArrayList;

public class Formulariov1 extends JFrame {
    private JLabel textodenombre;
    private JTextField txtNombre;
    private JButton btnRegistrar;
    private JPanel panel1;
    private JLabel lblMensaje;
    private JList lstNombres;
    private JLabel lblTotal;



    private ArrayList<String> nombres = new ArrayList<>();
private DefaultListModel<String> modelo = new DefaultListModel<>();

    public Formulariov1() {
        setContentPane(panel1);
        lstNombres.setModel(modelo);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        btnRegistrar.addActionListener(e -> {
            String nombre = txtNombre.getText();
            lblMensaje.setText("Bienvenido, " + nombre);
            nombres.add(nombre);
            modelo.addElement(nombre);
            int total = nombres.size();
            lblTotal.setText("Total: " + total);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Formulariov1());
    }
}