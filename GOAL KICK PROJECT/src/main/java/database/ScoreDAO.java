package main.java.database;

public class ScoreDAO {
    public void saveScore(String playerName, int score) {
        String sql = "INSERT INTO scores (player_name, score, date) VALUES (?, ?, NOW())";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, playerName);
            stmt.setInt(2, score);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Score> getTopScores(int limit) {
        List<Score> scores = new ArrayList<>();
        String sql = "SELECT * FROM scores ORDER BY score DESC LIMIT ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, limit);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                scores.add(new Score(
                        rs.getString("player_name"),
                        rs.getInt("score"),
                        rs.getDate("date")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scores;
    }
}