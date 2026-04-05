import java.io.*;
import java.net.*;
import java.util.Date;

public class TimeServer {
    public static void main(String[] args) {
        int port = 8000;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Time Server is running on port " + port);
            
            while (true) {
                // Wait for a client connection
                try (Socket socket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                    
                    // Get current server date and time
                    String serverTime = new Date().toString();
                    
                    // Send it to the client
                    out.println("Server Date & Time: " + serverTime);
                    System.out.println("Sent time to client: " + socket.getInetAddress());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}