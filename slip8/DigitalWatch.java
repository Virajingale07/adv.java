import java.applet.Applet;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalWatch extends Applet implements Runnable {

    Thread t;
    String time;

    public void init() {
        t = new Thread(this);
        t.start();
    }

    public void run() {
        try {
            while (true) {
                // Get current system time
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                time = sdf.format(new Date());

                repaint(); // refresh display
                Thread.sleep(1000); // update every 1 second
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void paint(Graphics g) {
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.setColor(Color.BLUE);

        g.drawString("Digital Clock", 50, 50);
        g.drawString(time, 80, 100);
    }
}