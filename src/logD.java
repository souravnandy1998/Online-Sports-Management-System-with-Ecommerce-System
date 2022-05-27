

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class logD
 */
@WebServlet("/logD")
public class logD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logD() {
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
		 String email=request.getParameter("email");
		 String pass=request.getParameter("pass");
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		 Connection con=DriverManager.getConnection
			 ("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		 PreparedStatement ps=con.prepareStatement("select * from YoddhaReg1  where email=? and pass=?");
        ps.setString(1, email);
        ps.setString(2, pass);
        ResultSet rs=ps.executeQuery();
        if(rs.next())
        {
        	 out.println("<script type='text/javascript'>");
      	     out.println("alert('welcome " +" " + email +"')");  
        	 out.println("location='index.html';");
             out.println("</script>");

         }
        else
        {
              //out.println("<center><h3>invalid username/password Enter Correct username/password</h3></center>");
              out.println("<script type='text/javascript'>");
       	     out.println("alert('invalid username/password Enter Correct username/password')");  
         	 out.println("location='login.html';");
              out.println("</script>");
               }
  }
  catch (SQLException e) 
        {
        e.printStackTrace();
        } catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}

}
