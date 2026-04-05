<%
    String numStr = request.getParameter("num");
    if (numStr != null && !numStr.isEmpty()) {
        int n = Integer.parseInt(numStr);
        int sum = 0;

        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }

        if (sum == n && n > 0) {
            out.println("<h3 style='color:green;'>" + n + " is a Perfect Number!</h3>");
        } else {
            out.println("<h3 style='color:red;'>" + n + " is NOT a Perfect Number.</h3>");
        }
    }
%>