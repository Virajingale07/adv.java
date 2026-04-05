import java.awt.*;
import javax.swing.*;

public class BlinkImage extends Frame implements Runnable {

    Image img;
    boolean visible = true;
    Thread t;

    public BlinkImage() {
        setTitle("Blinking Image");
        setSize(400, 400);
        setVisible(true);

        // Load image (place image in same folder)
        img = Toolkit.getDefaultToolkit().getImage("image.png");

        t = new Thread(this);
        t.start();
    }

    public void run() {
        try {
            while (true) {
                visible = !visible;  // toggle visibility
                repaint();
                Thread.sleep(500);   // blink every 0.5 second
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void paint(Graphics g) {
        if (visible) {
            g.drawImage(img, 100, 100, 200, 200, this);
        }
    }

    public static void main(String[] args) {
        new BlinkImage();
    }
}