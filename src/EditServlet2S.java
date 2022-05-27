

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServlet2S
 */
@WebServlet("/EditServlet2S")
public class EditServlet2S extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet2S() {
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
          
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
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
          
        int status=EmpdaoSh.update(e);  
        if(status>0){  
            response.sendRedirect("viewservletS");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close(); 
	}

}
