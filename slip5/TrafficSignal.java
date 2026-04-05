import java.applet.Applet;
import java.awt.*;
import java.lang.Thread;

public class TrafficSignal extends Applet implements Runnable {

    Thread t;
    String signal = "RED";

    public void init() {
        t = new Thread(this);
        t.start();
    }

    public void run() {
        try {
            while (true) {
                signal = "RED";
                repaint();
                Thread.sleep(3000);

                signal = "YELLOW";
                repaint();
                Thread.sleep(2000);

                signal = "GREEN";
                repaint();
                Thread.sleep(3000);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void paint(Graphics g) {

        // Draw signal box
        g.setColor(Color.black);
        g.fillRect(100, 50, 80, 200);

        // RED Light
        if (signal.equals("RED"))
            g.setColor(Color.red);
        else
            g.setColor(Color.gray);
        g.fillOval(115, 60, 50, 50);

        // YELLOW Light
        if (signal.equals("YELLOW"))
            g.setColor(Color.yellow);
        else
            g.setColor(Color.gray);
        g.fillOval(115, 120, 50, 50);

        // GREEN Light
        if (signal.equals("GREEN"))
            g.setColor(Color.green);
        else
            g.setColor(Color.gray);
        g.fillOval(115, 180, 50, 50);
    }
}