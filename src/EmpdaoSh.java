
import java.util.*;
import java.sql.*;
public class EmpdaoSh {
	public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int save(EmpS e){  
        int status=0;  
        try{  
            Connection con=EmpdaoSh.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into mtable(id,name,brand,quantity,total) values (?,?,?,?)");  
            
            ps.setString(1,e.getName());  
            ps.setString(2,e.getBrand()); 
            ps.setInt(3,e.getQuantity()); 
            ps.setString(4,e.getTotal());  
       
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(EmpS e){  
        int status=0;  
        try{  
            Connection con=EmpdaoSh.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update mtable set name=?,brand=?,quantity=?,total=? where id=?");  
           
            ps.setString(1,e.getName());  
            ps.setString(2,e.getBrand());
            ps.setInt(3,e.getQuantity());
            ps.setString(4,e.getTotal());
            ps.setInt(5,e.getId());
            
            status=ps.executeUpdate(); 
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=EmpdaoSh.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from mtable where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static EmpS getEmployeeById(int id){  
        EmpS e=new EmpS();  
          
        try{  
            Connection con=EmpdaoSh.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from mtable where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
            	e.setId(rs.getInt(1));
                e.setName(rs.getString(2));  
                e.setBrand(rs.getString(3));
                e.setQuantity(rs.getInt(4));
                e.setTotal(rs.getString(5)); 
                
                
                
                
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<EmpS> getAllEmployees(){  
        List<EmpS> list=new ArrayList<EmpS>();  
          
        try{  
            Connection con=EmpdaoSh.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from mtable");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                EmpS e=new EmpS();  
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setBrand(rs.getString(3));
                e.setQuantity(rs.getInt(4));
                e.setTotal(rs.getString(5));
                
                
                 
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}
