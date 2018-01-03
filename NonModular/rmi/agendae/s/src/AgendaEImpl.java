package agendae.rmi.s;
import agendae.rmi.i.IAgendaE;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AgendaEImpl implements IAgendaE{
  private static String jdbcURIDerby = "jdbc:derby://localhost:1527/AgendaEMail";
  private static String jdbcDriverDerby = "org.apache.derby.jdbc.ClientDriver";
  private Statement instructiune;
  
  public AgendaEImpl() {
    connect();
  }
  
  public String getEmailAddr(String nume){
    String nume0='\''+nume.trim()+'\'';
    String sql="select * from adrese where nume="+nume0;
    StringBuffer results=new StringBuffer(256);
    try{
      ResultSet rs=instructiune.executeQuery(sql);     
      if(rs!=null){
         while(rs.next()){
           results.append(rs.getString("nume")+" "+rs.getString("email")+"\n");
         }  
      }
    }
    catch(Exception e){
      e.printStackTrace();
    }    
    return results.toString();
  }
  
  public String getName(String email){
    String email0='\''+email.trim()+'\'';
    String sql="select * from adrese where email="+email0; 
    StringBuffer results=new StringBuffer(256);
    try{
      ResultSet rs=instructiune.executeQuery(sql);     
      if(rs!=null){
         while(rs.next()){
           results.append(rs.getString("nume")+" "+rs.getString("email")+"\n");
         }  
      }
    }
    catch(Exception e){
      e.printStackTrace();
    }    
    return results.toString();
  }
  
  private void connect(){
    Connection conn = null;
    try{
      Class.forName(jdbcDriverDerby).newInstance();
      conn = DriverManager.getConnection(jdbcURIDerby);
      instructiune=conn.createStatement();
    }
    catch(Exception e) {
      e.printStackTrace();
    }  
  }
}