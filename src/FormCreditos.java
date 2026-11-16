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
                + "Cedula: 1096203819\n"
                + "Carnet: UNP-D6HF-KSAL\n"
                + "Correo: luis.garciaguz@unipaz.edu.co\n\n"

                + "Integrante 2\n"
                + "Nombre: Jesus Adrian Ruiz González \n\n"
                + "Cedula: 1097189378\n"
                + "Carnet: UNP-NPXH-MS4J\n"
                + "Correo: jesus.ruizgon@unipaz.edu.co");

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}