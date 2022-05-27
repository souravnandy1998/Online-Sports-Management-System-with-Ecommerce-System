

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class regD
 */
@WebServlet("/regD")
public class regD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public regD() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		 PrintWriter out=response.getWriter();
		 String first_name=request.getParameter("first_name");
		 String last_name=request.getParameter("last_name");
		 int age=Integer.parseInt(request.getParameter("age"));
		 String email=request.getParameter("email");
		 String gender=request.getParameter("gender");
		 String phone=request.getParameter("phone");
		 String pass=request.getParameter("pass");
		 String Subject=request.getParameter("subject");
		 
		try
		{
			
	    Class.forName("oracle.jdbc.driver.OracleDriver");
		 Connection con=DriverManager.getConnection
			 ("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		 PreparedStatement stmt=con.prepareStatement
			 ("insert into YoddhaReg1(id,first_name,last_name,age,email,gender,phone,pass,subject) values(ppp.NEXTVAL,?,?,?,?,?,?,?,?)");
		 stmt.setString(1,first_name);
		 stmt.setString(2, last_name);
		 stmt.setInt(3,age);
		 stmt.setString(4,email);
		 stmt.setString(5,gender);
		 stmt.setString(6,phone);
		 stmt.setString(7,pass);
		 stmt.setString(8,Subject);
		 
		 
		 stmt.executeUpdate();
		 out.println("<script type=\"text/javascript\">");
	       out.println("alert('Succesfully Register');");
			 out.println("location='login.html';");		
			 out.println("</script>");
	      
	      
		 con.close();
		}
		catch(Exception e)
		{
		 out.println("<b>Registration failed</b>");
		 out.println("<b>Error:</b>" +e);
		
		}
	}

}
