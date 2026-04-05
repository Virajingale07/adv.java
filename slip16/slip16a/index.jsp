<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Login</title>
</head>
<body>
    <h2>Login Page</h2>
    <form action="checkLogin.jsp" method="post">
        Username: <input type="text" name="uname" required><br><br>
        Password: <input type="password" name="pass" required><br><br>
        <input type="submit" value="Login">
    </form>
</body>
</html>