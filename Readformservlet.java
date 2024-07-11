import java.io.IOException;
import java.io.PrintWriter;
 
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 
/**
* Servlet implementation class LoginDetails
*/
@WebServlet("/LoginDetails")
public class LoginDetails extends HttpServlet {
​private static final long serialVersionUID = 1L;
 
   /**
    * Default constructor.
    */
   public LoginDetails() {
       // TODO Auto-generated constructor stub
   }
 
​/**
​ * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
​ */
​protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
​​// TODO Auto-generated method stub
​​String name = request.getParameter("name");
       String phNum = request.getParameter("phone");
       String gender = request.getParameter("gender");
         
       // To get all the values selected for
       // programming language, use 'getParameterValues'
       String progLang[] = request.getParameterValues("language");
       
       // Iterate through the String array to
       // store the selected values in form of String
       String langSelect = "";
       if(progLang!=null){
           for(int i=0;i<progLang.length;i++){
               langSelect= langSelect + progLang[i]+ ", ";
           }
       }
         
       String courseDur = request.getParameter("duration");
       String comment = request.getParameter("comment");
                 
       // set the content type of response to 'text/html'
       response.setContentType("text/html");
         
       // Get the PrintWriter object to write
       // the response to the text-output stream
       PrintWriter out = response.getWriter();
         
       // Print the data
       out.print("<html><body>");
       out.print("<h3>Details Entered</h3><br/>");
                 out.print("Full Name: "+ name + "<br/>");
       out.print("Phone Number: "+ phNum +"<br/>");
       out.print("Gender: "+ gender +"<br/>");
       out.print("Programming languages selected: "+ langSelect +"<br/>");
       out.print("Duration of course: "+ courseDur+"<br/>");
       out.print("Comments: "+ comment);
         out.print("</body></html>");
   }}
 
 
//LoginFile.html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Fill in the Form</h3>
<form action="LoginDetails" method="get">
<table>
<tr>
<td>Full Name:</td>
<td><input type="text" name="name" /></td>
</tr>
<tr>
<td>Phone Number:</td>
<td><input type="text" name="phone" /></td>
</tr>
<tr>
<td>Gender:</td>
<td><input type="radio" name="gender" value="male" />Male
<input type="radio" name="gender" value="female" />Female</td>
</tr>
<tr>
<td>Select Programming Languages to learn:</td>
<td><input type="checkbox" name="language" value="java" />Java
<input type="checkbox" name="language" value="python" />Python
<input type="checkbox" name="language" value="sql" />SQL
<input type="checkbox" name="language" value="php" />PHP</td>
</tr>
<tr>
<td>Select Course duration:</td>
<td><select name="duration">
<option value="3months">3 Months</option>
<option value="6months">6 Months</option>
<option value="9months">9 Months</option></select></td>
</tr>
<tr>
<td>Anything else you want to share:</td>
<td><textarea rows="5" cols="40" name="comment"></textarea></td>
</tr>
</table>
<input type="submit" value="Submit Details">
</form>
</body>
</html>
