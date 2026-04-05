<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<!DOCTYPE html>
<html>
<head>
    <title>Time-Based Greeting</title>
</head>
<body>
    <h2>Enter Your Name</h2>
    <form method="post">
        Name: <input type="text" name="username" required>
        <input type="submit" value="Greet Me!">
    </form>

    <hr>

    <%
        String name = request.getParameter("username");
        
        if (name != null && !name.trim().isEmpty()) {
            // Get the current hour from the server's calendar
            Calendar cal = Calendar.getInstance();
            int hour = cal.get(Calendar.HOUR_OF_DAY);
            String greeting = "";

            if (hour >= 0 && hour < 12) {
                greeting = "Good Morning";
            } else if (hour >= 12 && hour < 17) {
                greeting = "Good Afternoon";
            } else if (hour >= 17 && hour < 21) {
                greeting = "Good Evening";
            } else {
                greeting = "Good Night";
            }
    %>
            <h3><%= greeting %>, <%= name %>!</h3>
            <p>The current server time is: <%= new java.util.Date() %></p>
    <%
        }
    %>
    
</body>
</html>