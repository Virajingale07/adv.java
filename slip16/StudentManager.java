import java.sql.*;
import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_db_name";
        String user = "root";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Scanner sc = new Scanner(System.in)) {

            // 1. Storing 5 Records using PreparedStatement
            String insertSql = "INSERT INTO student (rno, sname, per) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertSql);

            System.out.println("--- Enter details for 5 students ---");
            for (int i = 1; i <= 5; i++) {
                System.out.println("Student " + i + ":");
                System.out.print("Roll No: ");
                int rno = sc.nextInt();
                System.out.print("Name: ");
                String name = sc.next();
                System.out.print("Percentage: ");
                double per = sc.nextDouble();

                pstmt.setInt(1, rno);
                pstmt.setString(2, name);
                pstmt.setDouble(3, per);
                pstmt.executeUpdate();
            }
            System.out.println("\nRecords stored successfully!");

            // 2. Displaying student with highest percentage
            String selectSql = "SELECT * FROM student WHERE per = (SELECT MAX(per) FROM student)";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(selectSql);

            System.out.println("\n--- Student with Highest Percentage ---");
            if (rs.next()) {
                System.out.println("Roll No: " + rs.getInt("rno"));
                System.out.println("Name   : " + rs.getString("sname"));
                System.out.println("Percent: " + rs.getDouble("per") + "%");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
//Compile: javac StudentManager.java
//Run: java -cp ".;mysql-connector-java.jar" StudentManager
