<%
    String user = request.getParameter("uname");
    String pass = request.getParameter("pass");

    // Check if username and password are the same
    if (user != null && pass != null && user.equals(pass)) {
        response.sendRedirect("Login.html");
    } else {
        response.sendRedirect("Error.html");
    }
%>