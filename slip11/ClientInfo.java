import java.net.InetAddress;

public class ClientInfo {
    public static void main(String[] args) {
        try {
            // Get local host information
            InetAddress ip = InetAddress.getLocalHost();

            // Display Host Name
            System.out.println("Host Name: " + ip.getHostName());

            // Display IP Address
            System.out.println("IP Address: " + ip.getHostAddress());

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}