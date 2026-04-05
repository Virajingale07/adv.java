import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class ChatClient extends JFrame implements ActionListener {

    JTextArea area;
    JTextField text;
    Socket socket;
    DataInputStream din;
    DataOutputStream dout;

    ChatClient() {

        setTitle("Client Chat");

        area = new JTextArea();
        area.setEditable(false);
        text = new JTextField();

        add(new JScrollPane(area), BorderLayout.CENTER);
        add(text, BorderLayout.SOUTH);

        text.addActionListener(this);

        setSize(400,400);
        setVisible(true);

        try {
            socket = new Socket("localhost",5000);

            din = new DataInputStream(socket.getInputStream());
            dout = new DataOutputStream(socket.getOutputStream());

            String msg="";
            while(!msg.equals("exit")){
                msg = din.readUTF();
                area.append("\nServer: " + msg);
            }

        } catch(Exception e) {}
    }

    public void actionPerformed(ActionEvent e) {
        try {
            String msg = text.getText();
            area.append("\nClient: " + msg);
            dout.writeUTF(msg);
            text.setText("");
        } catch(Exception ex) {}
    }

    public static void main(String args[]) {
        new ChatClient();
    }
}