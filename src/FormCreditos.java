import javax.swing.*;

public class FormCreditos extends JFrame {
    private JPanel panelPrincipal;
    private JTextArea txtCreditos;

    public FormCreditos() {
        setContentPane(panelPrincipal);
        setTitle("BookUsers · Créditos");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        txtCreditos.setEditable(false);
        txtCreditos.setText("Integrante 1\n"
                + "Nombre: Luis Fernando García Guzmán\n"
                + "Carnet: UNP-D6HF-KSAL\n"
                + "Correo: luis.garciaguz@unipaz.edu.co\n\n"

                + "Integrante 2\n"
                + "Nombre: Jesus Adrian Ruiz González \n\n"
                + "Carnet: UNP-NPXH-MS4J\n"
                + "Correo: jesus.ruizgon@unipaz.edu.co");

        Tema.panel(panelPrincipal);
        txtCreditos.setBackground(Tema.BLANCO);
        txtCreditos.setForeground(Tema.NEGRO);
        pack();
        setSize(480, 330);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}