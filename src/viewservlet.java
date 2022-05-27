

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class viewservlet
 */
@WebServlet("/viewservlet")
public class viewservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewservlet() {
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
        out.println("<a href='reg.html'>Add New Employee</a>");  
        out.println("<h1>Employees List</h1>");  
          
        List<Emp> list=EmpDao.getAllEmployees();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>First Name</th><th>Last Name</th><th>Age</th><th>Email</th><th>Gender</th><th>Phone</th><th>Password</th><th>Subject</th><th>edit</th><th>delete</th>  </tr>");  
        for(Emp e:list){  
         out.print("<tr><td>"+e.getId()+"</td><td>"+e.getFirst_name()+"</td><td>"+e.getLast_name()+"</td><td>"+e.getAge()+"</td><td>"+e.getEmail()+"</td><td>"+e.getGender()+"</td><td>"+e.getPhone()+"</td><td>"+e.getPass()+"</td><td>"+e.getSubject()+"</td><td><a href='EditServlet?id="+e.getId()+"'>edit</a></td><td><a href='DeletServlet?id="+e.getId()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();
	}

}
