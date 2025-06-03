import javax.swing.*;
        import java.awt.*;

public class MainForm {
    public static void main(String[] args) {
        // Crear el frame principal
        JFrame frame = new JFrame("Formulario Pildora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Panel principal con BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        frame.add(mainPanel);

        // Panel Norte
        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        northPanel.setBackground(new Color(50, 50, 50));

        // Botones Flow01 y Flow02
        JButton flow01 = new JButton("Boton01");
        styleButton(flow01, new Color(205, 72, 185), Color.WHITE);

        JButton flow02 = new JButton("Boton02");
        styleButton(flow02, new Color(205, 72, 185), Color.WHITE);

        northPanel.add(flow01);
        northPanel.add(flow02);
        mainPanel.add(northPanel, BorderLayout.NORTH);

        // Panel Oeste
        JPanel westPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        westPanel.setBackground(new Color(144, 143, 145));

        // Botones
        JButton flow03 = new JButton("Boton03");
        styleButton(flow03, new Color(62, 70, 140), Color.WHITE);

        JButton flow04 = new JButton("Boton04");
        styleButton(flow04, new Color(62, 70, 140), Color.WHITE);

        westPanel.add(flow03);
        westPanel.add(flow04);
        mainPanel.add(westPanel, BorderLayout.WEST);

        // Panel Centro
        JPanel centerPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        centerPanel.setBackground(new Color(201, 199, 205));

        // Botones
        JButton grid01 = new JButton("Color01");
        styleButton(grid01, new Color(224, 26, 47), Color.WHITE);

        JButton grid02 = new JButton("Color02");
        styleButton(grid02, new Color(217, 107, 40), Color.WHITE);

        JButton grid03 = new JButton("Color03");
        styleButton(grid03, new Color(122, 49, 99), Color.WHITE);

        JButton grid04 = new JButton("Color04");
        styleButton(grid04, new Color(58, 173, 52), Color.WHITE);

        centerPanel.add(grid01);
        centerPanel.add(grid02);
        centerPanel.add(grid03);
        centerPanel.add(grid04);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private static void styleButton(JButton button, Color bgColor, Color textColor) {
        button.setBackground(bgColor);
        button.setForeground(textColor);
        button.setOpaque(true);
        button.setBorderPainted(false);
    }
}