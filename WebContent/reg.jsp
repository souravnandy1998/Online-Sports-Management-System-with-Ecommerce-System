<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>REG</title>
<style type="text/css">
.right {text-align: right;
}
</style>
</head>

<body>
 <%@ page language="java" %>
        <table width="993" height="102" border="0">
          <tr>
            <td width="251" height="96"><img src="images/logo.jpg" width="251" height="88" alt="Logo" /></td>
            <td width="726" class="right">24X7 Customer Support - <a href="contact.jsp">Contact us</a> | <a href="main.jsp">Home</a> |
              <% if(session.getAttribute("uname")==null) {
			%>
              <a href="login.jsp">Login</a>
              <%} else {
				%>
              <a href="logout.jsp">Logout</a>
              <%}%></td>
          </tr>
        </table>
        <%@ page import="java.sql.*" %>
         <%@ page import="java.sql.DriverManager.*" %>
       
<%
        String m=null, mn=null;
        String name=request.getParameter("name");
        String id=request.getParameter("id");
        String password=request.getParameter("password");
        String dob=request.getParameter("date");
        String address=request.getParameter("address");
		String phone=request.getParameter("phone");
        PreparedStatement ps;
        Connection con;
        ResultSet rs= null;
       Class.forName("oracle.jdbc.driver.OracleDriver");
        con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
      
         Statement st=con.createStatement();
       
          ps= con.prepareStatement("insert into register1 values (?,?,?,?,?,?)");
            ps.setString(1,name);
            ps.setString(2,id);
            ps.setString(3,password);
            ps.setString(4,dob);
            ps.setString(5,address);
           ps.setString(6,phone);
               int insertResult = ps.executeUpdate();
             if (insertResult!=0)
            {
                 out.println("Successfully registered");
            }          
        %>
        <br><hr>
               To Login <a href="login.jsp">Click Here</a>
                <hr>
</body>
</html>