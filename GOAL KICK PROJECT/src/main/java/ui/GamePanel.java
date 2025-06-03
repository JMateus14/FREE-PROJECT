package main.java.ui;

public class GamePanel extends JPanel implements KeyListener {
    private Player player;
    private Ball ball;
    private Goal goal;
    private Timer gameTimer;
    private int score = 0;
    private int timeLeft = 60;

    public GamePanel() {
        setPreferredSize(new Dimension(800, 600));
        setFocusable(true);
        addKeyListener(this);

        player = new Player(100, 400);
        ball = new Ball(150, 500);
        goal = new Goal(700, 250);

        startGame();
    }

    private void startGame() {
        gameTimer = new Timer(1000, e -> {
            timeLeft--;
            if (timeLeft <= 0) endGame();
            repaint();
        });
        gameTimer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar elementos
        player.draw(g);
        ball.draw(g);
        goal.draw(g);

        // Mostrar HUD
        g.drawString("Goles: " + score, 20, 20);
        g.drawString("Tiempo: " + timeLeft, 20, 40);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT -> player.move(-10);
            case KeyEvent.VK_RIGHT -> player.move(10);
            case KeyEvent.VK_SPACE -> kickBall();
        }
        repaint();
    }

    private void kickBall() {
        // Lógica de disparo
        ball.setVelocity(15, -10);
        new Timer(50, evt -> {
            ball.move();
            checkGoal();
            repaint();
        }).start();
    }

    private void checkGoal() {
        if (ball.getBounds().intersects(goal.getBounds())) {
            score++;
            ball.reset();
            // Efecto visual
            JOptionPane.showMessageDialog(this, "¡Gol!");
        }
    }

    private void endGame() {
        gameTimer.stop();
        String name = JOptionPane.showInputDialog("Nombre:");
        new ScoreDAO().saveScore(name, score);
        // Mostrar ranking
        new ScoreboardWindow().setVisible(true);
    }
}