import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.text.Normalizer;
import java.util.ArrayList;

public class FormRegistro extends JFrame {
    private JPanel panelPrincipal;
    private JComboBox<String> cmbTipoId;
    private JTextField txtNumeroId;
    private JTextField txtPrimerNombre;
    private JTextField txtSegundoNombre;
    private JTextField txtPrimerApellido;
    private JTextField txtSegundoApellido;
    private JLabel lblUsername;
    private JPasswordField txtPassword;
    private JTextField txtTelefono;
    private JTextField txtCorreo;
    private JButton btnCargarFoto;
    private JLabel lblFoto;
    private JButton btnGuardar;

    private ArrayList<Usuario> usuarios;
    private String rutaFoto = "";

    public FormRegistro(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;

        setContentPane(panelPrincipal);
        setTitle("BookUsers · Registro");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        llenarCombo();
        DocumentListener vigilante = new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                actualizarUsername();
            }
            public void removeUpdate(DocumentEvent e) {
                actualizarUsername();
            }
            public void changedUpdate(DocumentEvent e) {
                actualizarUsername();
            }
        };

        txtPrimerNombre.getDocument().addDocumentListener(vigilante);
        txtPrimerApellido.getDocument().addDocumentListener(vigilante);
        txtSegundoApellido.getDocument().addDocumentListener(vigilante);

        btnCargarFoto.addActionListener(e -> {
            JFileChooser selector = new JFileChooser();
            selector.setFileFilter(new FileNameExtensionFilter("Imágenes", "png", "jpg"));

            int respuesta = selector.showOpenDialog(this);

            if (respuesta == JFileChooser.APPROVE_OPTION) {
                rutaFoto = selector.getSelectedFile().getAbsolutePath();

                ImageIcon icono = new ImageIcon(rutaFoto);
                icono = new ImageIcon(icono.getImage().getScaledInstance(120, 120, 1));
                lblFoto.setIcon(icono);
            }
        });

        btnGuardar.addActionListener(e-> {
                    String tipo = (String) cmbTipoId.getSelectedItem();
                    String numero = txtNumeroId.getText().trim();
                    String nombre1 = txtPrimerNombre.getText().trim();
                    String nombre2 = txtSegundoNombre.getText().trim();
                    String apellido1 = txtPrimerApellido.getText().trim();
                    String apellido2 = txtSegundoApellido.getText().trim();
                    String password = new String(txtPassword.getPassword());
                    String telefono = txtTelefono.getText().trim();
                    String correo = txtCorreo.getText().trim();

                    if (numero.isEmpty() || nombre1.isEmpty() || apellido1.isEmpty()
                            || password.isEmpty() || telefono.isEmpty() || correo.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Faltan campos obligatorios");
                        return;
                    }

                    boolean aceptaLetras = tipo.startsWith("41") || tipo.startsWith("42");
                    if (aceptaLetras == false && soloDigitos(numero) == false) {
                        JOptionPane.showMessageDialog(this, "El número solo debe tener dígitos");
                        return;
                    }
                    if (correo.contains("@") == false) {
                        JOptionPane.showMessageDialog(this, "El correo debe contener @");
                        return;
                    }

                    Usuario u = new Usuario(tipo, numero, nombre1, nombre2, apellido1, apellido2,
                            lblUsername.getText(), password, telefono, correo, rutaFoto);
                    usuarios.add(u);

                    JOptionPane.showMessageDialog(this, "Usuario registrado: " + u.getUsername());
                    limpiarFormulario();
                });
        Tema.panel(panelPrincipal);
        Tema.boton(btnGuardar, Tema.ROJO);
        Tema.boton(btnCargarFoto, Tema.NEGRO);
        pack();
        setSize(520, 680);
        setLocationRelativeTo(null);
        setVisible(true);

    }
    private void llenarCombo() {
        cmbTipoId.addItem("11 - Registro civil de nacimiento");
        cmbTipoId.addItem("12 - Tarjeta de identidad");
        cmbTipoId.addItem("13 - Cédula de ciudadanía");
        cmbTipoId.addItem("21 - Tarjeta de extranjería");
        cmbTipoId.addItem("22 - Cédula de extranjería");
        cmbTipoId.addItem("41 - Pasaporte");
        cmbTipoId.addItem("42 - Documento de identificación extranjero");
        cmbTipoId.addItem("47 - Permiso Especial de Permanencia (PEP)");
        cmbTipoId.addItem("91 - NUIP");
    }
    private String limpiarTexto(String texto) {
        String t = texto.trim();
        t = Normalizer.normalize(t, Normalizer.Form.NFD);
        t = t.replaceAll("\\p{M}", "");
        t = t.toLowerCase();
        t = t.replace(" ", "");
        return t;
    }

    private void actualizarUsername() {
        String apellido1 = limpiarTexto(txtPrimerApellido.getText());
        String apellido2 = limpiarTexto(txtSegundoApellido.getText());
        String nombre = limpiarTexto(txtPrimerNombre.getText());

        String username = "";

        if (apellido1.length() > 0) {
            username = username + apellido1.substring(0, 1);
        }
        if (apellido2.length() > 0) {
            username = username + apellido2.substring(0, 1);
        }
        username = username + nombre;

        lblUsername.setText(username);
    }

    private boolean soloDigitos(String texto) {
        for (int i = 0; i < texto.length(); i++) {
            if (Character.isDigit(texto.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    private void limpiarFormulario() {
        txtNumeroId.setText("");
        txtPrimerNombre.setText("");
        txtSegundoNombre.setText("");
        txtPrimerApellido.setText("");
        txtSegundoApellido.setText("");
        txtPassword.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        lblFoto.setIcon(null);
        rutaFoto = "";
    }
}

