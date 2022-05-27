

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
 * Servlet implementation class Add
 */
@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add() {
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
		 int id=Integer.parseInt(request.getParameter("id"));
		 String name=request.getParameter("name");
		 String brand=request.getParameter("brand");
		 int quantity=Integer.parseInt(request.getParameter("quantity"));
		 int total=Integer.parseInt(request.getParameter("total"));
		 
		try
		{
			
	    Class.forName("oracle.jdbc.driver.OracleDriver");
		 Connection con=DriverManager.getConnection
			 ("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		 PreparedStatement stmt=con.prepareStatement
			 ("insert into mtable(id,name,brand,quantity,total) values(?,?,?,?,?)");
		 stmt.setInt(1,id);
		 stmt.setString(2,name);
		 stmt.setString(3,brand);
		 stmt.setInt(4,quantity);
		 stmt.setInt(5,total);
		 
		 
		 stmt.executeUpdate();
		 out.println("<script type=\"text/javascript\">");
	       out.println("alert('Succesfully Add Item');");
			 out.println("location='main.jsp';");		
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
