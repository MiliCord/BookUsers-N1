import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Tema {
    public static final Color FONDO = new Color(246, 234, 238);
    public static final Color BLANCO = Color.WHITE;
    public static final Color ROJO = new Color(190, 24, 60);
    public static final Color ROJO_OSCURO = new Color(110, 14, 40);
    public static final Color NEGRO = new Color(28, 22, 32);
    public static final Color VIOLETA = new Color(139, 92, 246);

    public static final Font TITULO = new Font("Georgia", Font.BOLD, 20);
    public static final Font TEXTO = new Font("Segoe UI", Font.PLAIN, 15);
    public static final Font BOTON = new Font("Segoe UI", Font.BOLD, 15);

    public static void boton(JButton boton, Color colorFondo) {
        boton.setBackground(colorFondo);
        boton.setForeground(Color.WHITE);
        boton.setFont(BOTON);
        boton.setFocusPainted(false);
        boton.setOpaque(true);
        boton.setBorderPainted(false);
        boton.setBorder(BorderFactory.createEmptyBorder(10, 16, 10, 16));
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        boton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                boton.setBackground(colorFondo.darker());
            }
            public void mouseExited(MouseEvent e) {
                boton.setBackground(colorFondo);
            }
        });
    }

    public static void panel(JPanel panel) {
        panel.setBackground(FONDO);

        String titulo = "BookUsers";
        Window ventana = SwingUtilities.getWindowAncestor(panel);
        if (ventana instanceof JFrame) {
            String t = ((JFrame) ventana).getTitle();
            if (t.contains("·")) {
                titulo = t.substring(t.indexOf("·") + 1).trim();
            }
        }

        TitledBorder marco = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(ROJO, 2), " " + titulo + " ");
        marco.setTitleFont(TITULO);
        marco.setTitleColor(ROJO);

        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(6, 6, 6, 6, ROJO),
                BorderFactory.createCompoundBorder(
                        BorderFactory.createEmptyBorder(12, 14, 12, 14), marco)));

        aplicarFuentes(panel);
    }

    private static void aplicarFuentes(Container contenedor) {
        for (Component c : contenedor.getComponents()) {
            if (c instanceof JPanel) {
                c.setBackground(FONDO);
            }
            if (c instanceof JLabel || c instanceof JTextField || c instanceof JTextArea
                    || c instanceof JComboBox || c instanceof JList) {
                c.setFont(TEXTO);
                c.setForeground(NEGRO);
            }
            if (c instanceof JTextArea) {
                ((JTextArea) c).setMargin(new Insets(12, 14, 12, 14));
            }
            if (c instanceof Container) {
                aplicarFuentes((Container) c);
            }
        }
    }
}