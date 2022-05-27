

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveServlets
 */
@WebServlet("/SaveServlets")
public class SaveServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveServlets() {
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
        String total=request.getParameter("total"); 		
         
          
        EmpS e=new EmpS();  
        e.setId(id);
		e.setName(name);  		
        e.setBrand(brand);  
        e.setQuantity(quantity);
		e.setTotal(total);
          
        int status=EmpdaoSh.save(e);  
        if(status>0){  
            out.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("indexreg.html").include(request, response);  
        }else{  
            out.println("Sorry! unable to save record");  
        }  
          
        out.close();
	}

}
