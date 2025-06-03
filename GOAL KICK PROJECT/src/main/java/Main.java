package main.java;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection.initializeDatabase();
        SwingUtilities.invokeLater(() -> {
            MenuWindow menu = new MenuWindow();
            menu.setVisible(true);
        });
    }
}