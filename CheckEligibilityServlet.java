package saranyahopes;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CheckEligibilityServlet")
public class CheckEligibilityServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));

        // Set response content type
        response.setContentType("text/html");

        // Get the response writer
        PrintWriter out = response.getWriter();

        // Determine voting eligibility
        if (age >= 18) {
            out.println("<html><body>");
            out.println("<h2>Hello, " + name + "!</h2>");
            out.println("<p>You are eligible to vote.</p>");
            out.println("</body></html>");
        } else {
            out.println("<html><body>");
            out.println("<h2>Hello, " + name + "!</h2>");
            out.println("<p>Sorry, you are not eligible to vote. You must be at least 18 years old.</p>");
            out.println("</body></html>");
        }
    }
}
