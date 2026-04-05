<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Perfect Number Checker</title>
</head>
<body>

    <h2>Perfect Number Checker</h2>

    <form method="post" action="">
        <label>Enter Number:</label>
        <input type="number" name="num" required>
        <input type="submit" value="Check">
    </form>

    <hr>

    <%
        // Check if form is submitted
        String number = request.getParameter("num");
        if (number != null) {
    %>

        <!-- Include logic file only after form submission -->
        <%@ include file="checkPerfect.jsp" %>

    <%
        }
    %>

</body>
</html>