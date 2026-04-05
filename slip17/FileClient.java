import java.io.*;
import java.net.*;
import java.util.Scanner;

public class FileClient {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 6000;

        try (Socket socket = new Socket(hostname, port);
             Scanner sc = new Scanner(System.in);
             DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.print("Enter the filename to search on server: ");
            String fileName = sc.nextLine();

            // Send filename to server
            dos.writeUTF(fileName);

            // Read first line from server (the status)
            String status = in.readLine();

            if ("FOUND".equals(status)) {
                System.out.println("--- File Contents ---");
                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                }
            } else {
                System.out.println("File Not Found");
            }

        } catch (IOException e) {
            System.err.println("Client Error: " + e.getMessage());
        }
    }
}