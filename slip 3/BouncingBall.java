import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class BouncingBall extends JPanel implements Runnable {
    // Ball properties
    private int x = 50, y = 50;           // Initial position
    private int dx = 5, dy = 5;           // Speed/Direction
    private int ballSize = 40;
    private Color ballColor = Color.RED;  // Initial color
    private Random random = new Random();

    public BouncingBall() {
        // Start the animation thread
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        while (true) {
            // Update position
            x += dx;
            y += dy;

            // Check boundaries and change color on bounce
            boolean bounced = false;

            // Bounce off left or right walls
            if (x < 0 || x > getWidth() - ballSize) {
                dx = -dx;
                bounced = true;
            }

            // Bounce off top or bottom walls
            if (y < 0 || y > getHeight() - ballSize) {
                dy = -dy;
                bounced = true;
            }

            // Change to a random color if a bounce occurred
            if (bounced) {
                ballColor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            }

            repaint(); // Refresh the screen

            try {
                Thread.sleep(20); // Control the speed of animation (50 FPS)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Draw the ball
        g2d.setColor(ballColor);
        g2d.fillOval(x, y, ballSize, ballSize);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bouncing Ball - Random Colors");
        BouncingBall panel = new BouncingBall();
        
        frame.add(panel);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}