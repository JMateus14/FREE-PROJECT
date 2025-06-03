package main.java.ui;

public class ScoreboardWindow extends JFrame {
    public ScoreboardWindow() {
        setTitle("Top 10 Puntuaciones");
        setSize(400, 500);

        DefaultTableModel model = new DefaultTableModel(
                new Object[]{"Nombre", "Puntuación", "Fecha"}, 0
        );

        List<Score> scores = new ScoreDAO().getTopScores(10);
        scores.forEach(score -> model.addRow(new Object[]{
                score.getPlayerName(),
                score.getScore(),
                score.getDate()
        }));

        add(new JScrollPane(new JTable(model)));
    }
}