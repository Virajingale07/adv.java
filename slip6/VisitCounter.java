import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class VisitCounter extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int visitCount = 0;
        boolean newUser = true;

        // Get cookies from request
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("visit")) {
                    visitCount = Integer.parseInt(c.getValue());
                    newUser = false;
                }
            }
        }

        // Increment count
        visitCount++;

        // Create/update cookie
        Cookie visitCookie = new Cookie("visit", String.valueOf(visitCount));
        visitCookie.setMaxAge(60 * 60 * 24); // 1 day
        response.addCookie(visitCookie);

        // Output
        out.println("<html><body>");

        if (newUser) {
            out.println("<h2>Welcome! This is your first visit.</h2>");
        } else {
            out.println("<h2>You have visited this page " + visitCount + " times.</h2>");
        }

        out.println("</body></html>");
    }
}
//javac -cp ".;C:\Program Files\Apache Software Foundation\Tomcat 9.0\lib\servlet-api.jar" VisitCounter.java