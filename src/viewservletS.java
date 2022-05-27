

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class viewservletS
 */
@WebServlet("/viewservletS")
public class viewservletS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewservletS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter(); 
        out.println("<a href='indexreg.html'>Add New Product</a>");  
        out.println("<h1>Product List</h1>");  
          
        List<EmpS> list=EmpdaoSh.getAllEmployees();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Name</th><th>Brand</th><th>Quantity</th><th>Total</th><th>edit</th><th>delete</th>  </tr>");  
        for(EmpS e:list){  
         out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getBrand()+"</td><td>"+e.getQuantity()+"</td><td>"+e.getTotal()+"</td><td><a href='EditServletS?id="+e.getId()+"'>edit</a></td><td><a href='DeleteServletS?id="+e.getId()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();
	}

}
