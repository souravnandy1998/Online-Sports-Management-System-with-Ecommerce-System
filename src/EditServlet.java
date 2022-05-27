

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Employee</h1>");  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
          
        Emp e=EmpDao.getEmployeeById(id);  
          
        out.print("<form action='EditServlet2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");  
        out.print("<tr><td>first_name:</td><td><input type='text' name='first_name' value='"+e.getFirst_name()+"'/></td></tr>");
        out.print("<tr><td>last_name:</td><td><input type='text' name='last_name' value='"+e.getLast_name()+"'/></td></tr>");
        out.print("<tr><td>Age:</td><td><input type='text' name='age' value='"+e.getAge()+"'/></td></tr>");
        
        out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+e.getEmail()+"'/></td></tr>");
        out.print("<tr><td>Gender:</td><td><input type='radiobtn' name='gender' value='"+e.getGender()+"'/></td></tr>");
        out.print("<tr><td>Phone:</td><td><input type='text' name='phone' value='"+e.getPhone()+"'/></td></tr>");
        out.print("<tr><td>Password:</td><td><input type='password' name='pass' value='"+e.getPass()+"'/></td></tr>");
        out.print("<tr><td>Subject:</td><td>");  
        out.print("<select name='subject' style='width:150px'>");  
        out.print("<option>martial art</option>");  
        out.print("<option>zumba</option>");  
        out.print("<option>yoga</option>");  
         
        out.print("</select>");  
        out.print("</td></tr>");  
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
	}

}
