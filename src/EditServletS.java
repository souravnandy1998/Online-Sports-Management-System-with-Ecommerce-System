

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServletS
 */
@WebServlet("/EditServletS")
public class EditServletS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServletS() {
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
        out.println("<h1>Update Item</h1>");  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
          
        EmpS e=EmpdaoSh.getEmployeeById(id);  
          
        out.print("<form action='EditServlet2S' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td>Id:</td><td><input type='text' name='id' value='"+e.getId()+"'/></td></tr>");  
        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");
        out.print("<tr><td>Brand:</td><td><input type='text' name='brand' value='"+e.getBrand()+"'/></td></tr>");
        out.print("<tr><td>Quantity:</td><td><input type='text' name='quantity' value='"+e.getQuantity()+"'/></td></tr>");
        out.print("<tr><td>Total:</td><td><input type='text' name='total' value='"+e.getTotal()+"'/></td></tr>");
        
    
        
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
	}

}
