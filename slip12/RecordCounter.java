import java.sql.*;

public class RecordCounter {
    public static void main(String[] args) {
        // Connection details (Change these for your DB)
        String url = "jdbc:mysql://localhost:3306/your_database_name";
        String user = "root";
        String password = "your_password";

        // SQL Query to count records
        String query = "SELECT COUNT(*) FROM employees";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                // Retrieve the count from the first column of the result
                int totalRecords = rs.getInt(1);
                System.out.println("Total number of records in the table: " + totalRecords);
            }

        } catch (SQLException e) {
            System.err.println("Database connection error!");
            e.printStackTrace();
        }
    }
}
//javac RecordCounter.java
//java -cp ".;mysql-connector-java.jar" RecordCounter