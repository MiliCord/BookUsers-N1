import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formulariov1 extends JFrame {
    private JLabel textodenombre;
    private JTextField txtNombre;
    private JButton btnRegistrar;
    private JPanel panel1;
    private JLabel lblMensaje;

    public Formulariov1() {
        setContentPane(panel1);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        btnRegistrar.addActionListener(e -> {
            String nombre = txtNombre.getText();
            lblMensaje.setText("Bienvenido, " + nombre);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Formulariov1());
    }
}