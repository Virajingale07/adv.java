import java.io.*;
import java.net.*;

public class FileServer {
    public static void main(String[] args) {
        int port = 6000;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                try (Socket socket = serverSocket.accept();
                     DataInputStream dis = new DataInputStream(socket.getInputStream());
                     PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

                    // Read filename from client
                    String fileName = dis.readUTF();
                    File file = new File(fileName);

                    if (file.exists() && !file.isDirectory()) {
                        out.println("FOUND"); // Send status to client
                        BufferedReader br = new BufferedReader(new FileReader(file));
                        String line;
                        while ((line = br.readLine()) != null) {
                            out.println(line);
                        }
                        br.close();
                    } else {
                        out.println("NOT_FOUND");
                    }
                } catch (IOException e) {
                    System.out.println("Connection error: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}