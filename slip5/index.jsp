<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Sum of First and Last Digit</title>
</head>
<body>

    <h2>Sum of First and Last Digit</h2>

    <form method="post">
        Enter Number:
        <input type="number" name="num" required>
        <input type="submit" value="Calculate">
    </form>

    <hr>

    <%
        String n = request.getParameter("num");

        if (n != null) {
            int num = Integer.parseInt(n);

            int lastDigit = num % 10;

            int firstDigit = num;
            while (firstDigit >= 10) {
                firstDigit = firstDigit / 10;
            }

            int sum = firstDigit + lastDigit;
    %>

    <p style="color:red; font-size:18px;">
        Sum of first and last digit = <%= sum %>
    </p>

    <%
        }
    %>

</body>
</html>