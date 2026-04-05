import java.sql.*;
import java.util.Scanner;

public class SalesReport {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_db";
        String user = "root";
        String password = "password";

        String query = "SELECT * FROM Sales WHERE SaleDate BETWEEN ? AND ?";

        try (Scanner sc = new Scanner(System.in);
             Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement(query)) {

            System.out.print("Enter start date (YYYY-MM-DD): ");
            ps.setString(1, sc.nextLine());

            System.out.print("Enter end date (YYYY-MM-DD): ");
            ps.setString(2, sc.nextLine());

            try (ResultSet rs = ps.executeQuery()) {
                System.out.println("\nPID\tPName\tQty\tRate\tAmount\tDate");
                System.out.println("------------------------------------------------------------");

                while (rs.next()) {
                    System.out.printf("%d\t%s\t%d\t%.2f\t%.2f\t%s%n",
                        rs.getInt("PID"),
                        rs.getString("PName"),
                        rs.getInt("Qty"),
                        rs.getDouble("Rate"),
                        rs.getDouble("Amount"),
                        rs.getDate("SaleDate"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

//javac SalesReport.java
//java -cp ".;mysql-connector-j-8.x.x.jar" SalesReport