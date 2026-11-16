import javax.swing.*;

public class FormDetalle extends JFrame {
    private JPanel panelPrincipal;
    private JLabel lblFoto;
    private JTextArea txtInfo;
    private JButton btnGenerarPdf;

    private Usuario usuario;

    public FormDetalle(Usuario usuario) {
        this.usuario = usuario;

        setContentPane(panelPrincipal);
        setTitle("BookUsers · Detalle");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        ImageIcon icono = new ImageIcon(usuario.getRutaFoto());
        icono = new ImageIcon(icono.getImage().getScaledInstance(120, 120, 1));
        lblFoto.setIcon(icono);

        txtInfo.setEditable(false);
        txtInfo.setText(armarTexto());

        btnGenerarPdf.addActionListener(e -> {
            generarPdf();
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private String armarTexto() {
        String texto = "ID: " + usuario.getId() + "\n";
        texto = texto + "Tipo de identificación: " + usuario.getTipoIdentificacion() + "\n";
        texto = texto + "Número: " + usuario.getNumeroIdentificacion() + "\n";
        texto = texto + "Nombres: " + usuario.getPrimerNombre() + " " + usuario.getSegundoNombre() + "\n";
        texto = texto + "Apellidos: " + usuario.getPrimerApellido() + " " + usuario.getSegundoApellido() + "\n";
        texto = texto + "Username: " + usuario.getUsername() + "\n";
        texto = texto + "Teléfono: " + usuario.getTelefono() + "\n";
        texto = texto + "Correo: " + usuario.getCorreo();
        return texto;
    }

    private void generarPdf() {
        //
    }
}