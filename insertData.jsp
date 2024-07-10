<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>

<%
    String name = request.getParameter("name");
    String email = request.getParameter("email");

    // Database connection parameters
    String dbURL = "jdbc:mysql://localhost:3306/sampleDB";
    String username = "root";
    String password = "root";
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
        // Load JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish connection
        connection = DriverManager.getConnection(dbURL, username, password);

        // Create SQL insert statement
        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, email);

        // Execute the insert
        int rows = preparedStatement.executeUpdate();

        // Check if insert was successful
        if (rows > 0) {
            out.println("<p>Data inserted successfully!</p>");
        } else {
            out.println("<p>Failed to insert data.</p>");
        }
    } catch (Exception e) {
        e.printStackTrace();
        out.println("Error: " + e.getMessage());
    } finally {
        // Close the prepared statement and connection
        try {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
%>
