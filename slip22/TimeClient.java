import java.io.*;
import java.net.*;

public class TimeClient {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Use IP address if server is on another PC
        int port = 8000;

        try (Socket socket = new Socket(serverAddress, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            
            // Read the time sent by the server
            String serverResponse = in.readLine();
            System.out.println("Response from Server: " + serverResponse);

        } catch (IOException e) {
            System.err.println("Could not connect to server. Ensure TimeServer is running.");
        }
    }
}