import java.io.*;
import java.net.*;

public class PrimeServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Server is running... Waiting for client.");
            
            while (true) {
                try (Socket socket = serverSocket.accept();
                     DataInputStream input = new DataInputStream(socket.getInputStream());
                     DataOutputStream output = new DataOutputStream(socket.getOutputStream())) {
                    
                    int number = input.readInt();
                    boolean isPrime = checkPrime(number);
                    
                    if (isPrime) {
                        output.writeUTF(number + " is a Prime Number.");
                    } else {
                        output.writeUTF(number + " is NOT a Prime Number.");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Logic to check prime
    private static boolean checkPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}