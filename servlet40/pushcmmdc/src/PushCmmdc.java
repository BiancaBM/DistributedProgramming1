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

public class PushCmmdc extends HttpServlet{
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
    req.newPushBuilder()
      .path("resources/waljing_santa.gif")
      .push();

    String sm=req.getParameter("m"),sn=req.getParameter("n"); 
    long m=Long.parseLong(sm),n=Long.parseLong(sn);  
    long x=cmmdc(m,n);
    PrintWriter out=res.getWriter();   
    String title="Cmmdc Servlet";
    res.setContentType("text/html");
    out.println("<HTML><HEAD><TITLE>");
    out.println(title);
    out.println("</TITLE></HEAD><BODY>");
    out.println("<img src=\"resources/walking_santa.gif\">");
    out.println("<H1>"+title+"</H1>");
    out.println("<P>Cmmdc is "+x);
    out.println("</BODY></HTML>");  
    out.close();   
  }
  
  public void doPost(HttpServletRequest req,HttpServletResponse res)
      throws ServletException,IOException{
    doGet(req,res);
  } 
}