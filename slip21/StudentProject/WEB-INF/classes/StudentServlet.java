import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // 1. Accept Details
        String seatNo = request.getParameter("seatNo");
        String name = request.getParameter("studName");
        String className = request.getParameter("className");
        double marks = Double.parseDouble(request.getParameter("totalMarks"));

        // 2. Calculate Percentage (assuming total is 500)
        double percentage = (marks / 500) * 100;

        // 3. Calculate Grade
        String grade;
        if (percentage >= 75) grade = "Distinction";
        else if (percentage >= 60) grade = "First Class";
        else if (percentage >= 50) grade = "Second Class";
        else if (percentage >= 40) grade = "Pass Class";
        else grade = "Fail";

        // 4. Display Details
        out.println("<html><body>");
        out.println("<h2>Student Result</h2>");
        out.println("<table border='1' cellpadding='5'>");
        out.println("<tr><td>Seat No:</td><td>" + seatNo + "</td></tr>");
        out.println("<tr><td>Student Name:</td><td>" + name + "</td></tr>");
        out.println("<tr><td>Class:</td><td>" + className + "</td></tr>");
        out.println("<tr><td>Total Marks:</td><td>" + marks + "</td></tr>");
        out.println("<tr><td>Percentage:</td><td>" + String.format("%.2f", percentage) + "%</td></tr>");
        out.println("<tr><td><b>Grade:</b></td><td><b>" + grade + "</b></td></tr>");
        out.println("</table>");
        out.println("<br><a href='index.html'>Back</a>");
        out.println("</body></html>");
    }
}