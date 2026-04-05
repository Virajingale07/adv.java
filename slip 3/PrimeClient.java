import java.io.*;
import java.net.*;
import java.util.Scanner;

public class PrimeClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000);
             Scanner sc = new Scanner(System.in);
             DataOutputStream output = new DataOutputStream(socket.getOutputStream());
             DataInputStream input = new DataInputStream(socket.getInputStream())) {

            System.out.print("Enter a number to check prime: ");
            int num = sc.nextInt();
            
            // Sending number to server
            output.writeInt(num);
            
            // Receiving and displaying result
            String result = input.readUTF();
            System.out.println("Server says: " + result);

        } catch (IOException e) {
            System.out.println("Error: Ensure the Server is running first!");
        }
    }
}