package main.java.database;

public class DatabaseConnection {
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            Properties props = new Properties();
            props.load(new FileInputStream("resources/config.properties"));

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/goalrush_db",
                    props.getProperty("user"),
                    props.getProperty("password")
            );
        }
        return connection;
    }
    public static void initializeDatabase() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/", "usuario", "contraseña");
             Statement stmt = conn.createStatement()) {

            // Crear DB si no existe
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS goalrush_db");

            // Usar DB y crear tabla
            stmt.executeUpdate("USE goalrush_db");
            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS scores (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    player_name VARCHAR(50) NOT NULL,
                    score INT NOT NULL,
                    date DATETIME NOT NULL
                )
                """);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}