import javax.swing.*;
import java.util.ArrayList;

public class FormMenu extends JFrame {
    private JPanel panelPrincipal;
    private JButton btnRegistrar;
    private JButton btnListado;
    private JButton btnCreditos;

    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public FormMenu(){
        setContentPane(panelPrincipal);
        setTitle("BookUsers Jesus Ruiz y Luis Garcia");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Tema.panel(panelPrincipal);
        Tema.boton(btnRegistrar, Tema.ROJO);
        Tema.boton(btnListado, Tema.NEGRO);
        Tema.boton(btnCreditos, Tema.VIOLETA);
        pack();
        setSize(400, 330);
        setLocationRelativeTo(null);
        setVisible(true);

        btnRegistrar.addActionListener(e -> {
            new FormRegistro(usuarios);
        });

        btnListado.addActionListener(e -> {
            new FormListado(usuarios);
        });

        btnCreditos.addActionListener(e -> {
             new FormCreditos();
        });
    }

    public static void main(String[] args) {
        new FormMenu();
    }
}
