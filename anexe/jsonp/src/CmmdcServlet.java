package cmmdc;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet; 
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/cmmdc") 

public class CmmdcServlet extends HttpServlet{
  public long cmmdc(long m, long n){
     long r,c;
     do{
        c=n;
        r=m%n;
        m=n;
        n=r;
     }while(r!=0);
     return c;
  }   
   
  public void doGet(HttpServletRequest req,HttpServletResponse res)
      throws ServletException,IOException{
    String sm=req.getParameter("m"),sn=req.getParameter("n");  
    long m=Long.parseLong(sm),n=Long.parseLong(sn);  
    long x=cmmdc(m,n);
    PrintWriter out=res.getWriter();   
    res.setContentType("text/plain");
    String r="{\"Cmmdc\":"+Long.valueOf(x).toString()+"}";
    out.println("myFct("+r+")");   
    out.close();   
  }
  
  public void doPost(HttpServletRequest req,HttpServletResponse res)
      throws ServletException,IOException{
    doGet(req,res);
  } 
}