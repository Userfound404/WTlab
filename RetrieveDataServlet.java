package saranyahopes;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/retrieveData")
public class RetrieveDataServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Database connection parameters
        String dbURL = "jdbc:mysql://localhost:3306/sampleDB";
        String username = "root";
        String password = "root";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            connection = DriverManager.getConnection(dbURL, username, password);

            // Create SQL statement
            statement = connection.createStatement();

            // Execute SQL query
            String sql = "SELECT * FROM users";
            resultSet = statement.executeQuery(sql);

            // Process the result set
            out.println("<table border='1'>");
            out.println("<tr><th>ID</th><th>Name</th><th>Email</th></tr>");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");

                out.println("<tr>");
                out.println("<td>" + id + "</td>");
                out.println("<td>" + name + "</td>");
                out.println("<td>" + email + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
        } catch (Exception e) {
            e.printStackTrace();
            out.println("Error: " + e.getMessage());
        } finally {
            // Close the result set, statement, and connection
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}