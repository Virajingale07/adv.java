import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ScrollText extends JPanel implements ActionListener {

    String text = "Welcome to Java Programming";
    int x = 0;
    int direction = 1;   // 1 = right, -1 = left
    Timer timer;

    public ScrollText() {
        timer = new Timer(50, this);  // speed of scrolling
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        x += direction * 5;

        // Change direction at window borders
        if (x > getWidth() - 200) {
            direction = -1;
        } else if (x < 0) {
            direction = 1;
        }

        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString(text, x, 100);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Scrolling Text");
        ScrollText panel = new ScrollText();

        frame.add(panel);
        frame.setSize(500, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}


//javac ScrollText.java
//java ScrollText
