<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Account Management</title>
    <style>
        table { width: 50%; border-collapse: collapse; margin-top: 20px; }
        th, td { border: 1px solid black; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
    <h2>Add New Account</h2>
    <form method="post">
        Account No: <input type="number" name="ano" required><br><br>
        Type: 
        <select name="type">
            <option value="Savings">Savings</option>
            <option value="Current">Current</option>
        </select><br><br>
        Balance: <input type="number" name="bal" step="0.01" required><br><br>
        <input type="submit" name="btnSave" value="Save Account">
    </form>

    <%
        // Database Connection Details
        String url = "jdbc:mysql://localhost:3306/your_db_name";
        String user = "root";
        String password = "your_password";
        
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);

            // 1. Logic to Insert Data
            if (request.getParameter("btnSave") != null) {
                int ano = Integer.parseInt(request.getParameter("ano"));
                String type = request.getParameter("type");
                double bal = Double.parseDouble(request.getParameter("bal"));

                String insertSql = "INSERT INTO account (ano, type, bal) VALUES (?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(insertSql);
                pstmt.setInt(1, ano);
                pstmt.setString(2, type);
                pstmt.setDouble(3, bal);
                pstmt.executeUpdate();
                out.println("<p style='color:green;'>Record added successfully!</p>");
            }

            // 2. Logic to Display Data
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM account");
    %>
            <h2>Account Details</h2>
            <table>
                <tr>
                    <th>Account No</th>
                    <th>Type</th>
                    <th>Balance</th>
                </tr>
                <% while (rs.next()) { %>
                <tr>
                    <td><%= rs.getInt("ano") %></td>
                    <td><%= rs.getString("type") %></td>
                    <td><%= rs.getDouble("bal") %></td>
                </tr>
                <% } %>
            </table>
    <%
        } catch (Exception e) {
            out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
        } finally {
            if (conn != null) conn.close();
        }
    %>
</body>
</html>

//CREATE TABLE account (
//  ano INT PRIMARY KEY,
//type VARCHAR(20),
//bal DECIMAL(10, 2)
//);
//Access: Open your browser to http://localhost:8080/AccountManager.jsp