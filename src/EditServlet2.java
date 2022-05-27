

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServlet2
 */
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet2() {
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
        String first_name=request.getParameter("first_name");  
        String last_name=request.getParameter("last_name"); 
		int age=Integer.parseInt(request.getParameter("age"));
		String email=request.getParameter("email");
		String gender=request.getParameter("gender"); 
        String phone=request.getParameter("phone"); 		
        String pass=request.getParameter("pass"); 
        String subject=request.getParameter("subject");  
          
        Emp e=new Emp();  
        e.setId(id);  
        e.setFirst_name(first_name);
		e.setLast_name(last_name);  		
        e.setAge(age);  
        e.setEmail(email);
		e.setPhone(phone);
		e.setPass(pass);
        e.setGender(gender);
        e.setSubject(subject);  
          
        int status=EmpDao.update(e);  
        if(status>0){  
            response.sendRedirect("viewservlet");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close(); 
		
	}

}
