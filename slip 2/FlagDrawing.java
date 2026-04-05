import javax.swing.*;
import java.awt.*;

public class FlagDrawing extends JPanel implements Runnable {
    // Flag dimensions
    private int flagWidth = 300;
    private int flagHeight = 200;
    private int startX = 50;
    private int startY = 50;

    // Control variables for multithreaded drawing
    private int step = 0;

    public FlagDrawing() {
        // Create and start the drawing thread
        Thread animationThread = new Thread(this);
        animationThread.start();
    }

    @Override
    public void run() {
        try {
            // Draw each part of the flag with a delay to show multithreading
            for (step = 1; step <= 4; step++) {
                Thread.sleep(800); // 0.8 second delay between steps
                repaint();         // Tell the JVM to refresh the screen
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Step 1: Draw Saffron Band
        if (step >= 1) {
            g2d.setColor(new Color(255, 153, 51));
            g2d.fillRect(startX, startY, flagWidth, flagHeight / 3);
        }

        // Step 2: Draw White Band
        if (step >= 2) {
            g2d.setColor(Color.WHITE);
            g2d.fillRect(startX, startY + (flagHeight / 3), flagWidth, flagHeight / 3);
            // Outline for white part
            g2d.setColor(Color.BLACK);
            g2d.drawRect(startX, startY + (flagHeight / 3), flagWidth, flagHeight / 3);
        }

        // Step 3: Draw Green Band
        if (step >= 3) {
            g2d.setColor(new Color(19, 136, 8));
            g2d.fillRect(startX, startY + (2 * flagHeight / 3), flagWidth, flagHeight / 3);
        }

        // Step 4: Draw Ashoka Chakra (The Wheel)
        if (step >= 4) {
            g2d.setColor(new Color(0, 0, 128));
            int centerX = startX + (flagWidth / 2);
            int centerY = startY + (flagHeight / 2);
            int radius = 30;
            
            g2d.drawOval(centerX - radius, centerY - radius, radius * 2, radius * 2);
            
            for (int i = 0; i < 24; i++) {
                double angle = Math.toRadians(i * 15);
                int x2 = (int) (centerX + radius * Math.cos(angle));
                int y2 = (int) (centerY + radius * Math.sin(angle));
                g2d.drawLine(centerX, centerY, x2, y2);
            }
            
            // Draw the flagpole
            g2d.setColor(new Color(101, 67, 33));
            g2d.fillRect(startX - 10, startY - 20, 10, 400);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Multithreaded Flag Drawing");
        FlagDrawing panel = new FlagDrawing();
        
        frame.add(panel);
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}