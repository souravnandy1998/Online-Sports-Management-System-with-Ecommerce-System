
import java.util.*;
import java.sql.*;
public class EmpDao {
	public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int save(Emp e){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into YoddhaReg1(id,first_name,last_name,age,email,gender,phone,pass,subject) values (pp.NEXTVAL,?,?,?,?,?,?,?,?)");  
            
            ps.setString(1,e.getFirst_name());  
            ps.setString(2,e.getLast_name());  
            ps.setInt(3,e.getAge());  
            ps.setString(4,e.getEmail());  
            ps.setString(5,e.getGender());
            ps.setString(6,e.getPhone()); 
            ps.setString(7,e.getPass()); 
            ps.setString(8,e.getSubject()); 
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(Emp e){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update YoddhaReg1 set first_name=?,last_name=?,age=?,email=?,gender=?,phone=?,pass=?,subject=? where id=?");  
           
            ps.setString(1,e.getFirst_name());  
            ps.setString(2,e.getLast_name());  
            ps.setInt(3,e.getAge());  
            ps.setString(4,e.getEmail());  
            ps.setString(5,e.getGender());
            ps.setString(6,e.getPhone());
            ps.setString(7,e.getPass()); 
            ps.setString(8,e.getSubject());
            ps.setInt(9,e.getId());
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from YoddhaReg1 where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static Emp getEmployeeById(int id){  
        Emp e=new Emp();  
          
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from YoddhaReg1 where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));
                e.setFirst_name(rs.getString(2));  
                e.setLast_name(rs.getString(3));  
                e.setAge(rs.getInt(4)); 
                e.setEmail(rs.getString(5));
                e.setGender(rs.getString(6));
                e.setPhone(rs.getString(7));
                e.setPass(rs.getString(8));
                e.setSubject(rs.getString(9));
                
                
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<Emp> getAllEmployees(){  
        List<Emp> list=new ArrayList<Emp>();  
          
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from YoddhaReg1");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Emp e=new Emp();  
                e.setId(rs.getInt(1));
                e.setFirst_name(rs.getString(2));  
                e.setLast_name(rs.getString(3));  
                e.setAge(rs.getInt(4)); 
                e.setEmail(rs.getString(5));
                e.setGender(rs.getString(6));
                e.setPhone(rs.getString(7));
                e.setPass(rs.getString(8));
                e.setSubject(rs.getString(9));
                 
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}
