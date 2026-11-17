import javax.swing.*;
import java.util.ArrayList;

public class FormListado extends JFrame {
    private JPanel panelPrincipal;
    private JList<Usuario> lstUsuarios;
    private JButton btnVerDetalle;

    private DefaultListModel<Usuario> modelo = new DefaultListModel<>();

    public FormListado(ArrayList<Usuario> usuarios) {
        setContentPane(panelPrincipal);
        setTitle("BookUsers · Listado");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        for (Usuario u : usuarios) {
            modelo.addElement(u);
        }
        lstUsuarios.setModel(modelo);

        btnVerDetalle.addActionListener(e -> {
            int posicion = lstUsuarios.getSelectedIndex();

            if (posicion == -1) {
                JOptionPane.showMessageDialog(this, "Selecciona un usuario");
                return;
            }

            Usuario elegido = modelo.getElementAt(posicion);
            new FormDetalle(elegido);
        });
        Tema.panel(panelPrincipal);
        Tema.boton(btnVerDetalle, Tema.ROJO);
        setTitle("BookUsers · Listado · Luis García y Jesús Ruiz");
        pack();
        setSize(460, 360);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}




