import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class ChatServer extends JFrame implements ActionListener {

    JTextArea area;
    JTextField text;
    ServerSocket server;
    Socket socket;
    DataInputStream din;
    DataOutputStream dout;

    ChatServer() {
        setTitle("Server Chat");

        area = new JTextArea();
        area.setEditable(false);
        text = new JTextField();

        add(new JScrollPane(area), BorderLayout.CENTER);
        add(text, BorderLayout.SOUTH);

        text.addActionListener(this);

        setSize(400,400);
        setVisible(true);

        try {
            server = new ServerSocket(5000);
            socket = server.accept();

            din = new DataInputStream(socket.getInputStream());
            dout = new DataOutputStream(socket.getOutputStream());

            String msg="";
            while(!msg.equals("exit")){
                msg = din.readUTF();
                area.append("\nClient: " + msg);
            }

        } catch(Exception e) {}
    }

    public void actionPerformed(ActionEvent e) {
        try {
            String msg = text.getText();
            area.append("\nServer: " + msg);
            dout.writeUTF(msg);
            text.setText("");
        } catch(Exception ex) {}
    }

    public static void main(String args[]) {
        new ChatServer();
    }
}