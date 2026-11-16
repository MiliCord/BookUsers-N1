import javax.swing.*;
import com.sha2cs.generatepdf.DocumentoPDF;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

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
        try {
            DocumentoPDF documento = new DocumentoPDF("Ficha de usuario");

            if (usuario.getRutaFoto() != null && new File(usuario.getRutaFoto()).isFile()) {
                documento.imagen(usuario.getRutaFoto());
            }

            documento.campo("Id", usuario.getId());
            documento.campo("Tipo de identificación", usuario.getTipoIdentificacion());
            documento.campo("Número de identificación", usuario.getNumeroIdentificacion());
            documento.campo("Primer nombre", usuario.getPrimerNombre());
            documento.campo("Segundo nombre", usuario.getSegundoNombre());
            documento.campo("Primer apellido", usuario.getPrimerApellido());
            documento.campo("Segundo apellido", usuario.getSegundoApellido());
            documento.campo("Username", usuario.getUsername());
            documento.campo("Teléfono", usuario.getTelefono());
            documento.campo("Correo", usuario.getCorreo());

            File pdf = documento.guardar("usuario-" + usuario.getId() + ".pdf");

            JOptionPane.showMessageDialog(this, "PDF generado: " + pdf.getAbsolutePath());
            Desktop.getDesktop().open(pdf);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "No se pudo generar el PDF: " + e.getMessage());
        }
    }
    }
