package hello;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletOutputStream;
//import javax.servlet.annotation.WebServlet; 

//@WebServlet(urlPatterns = "/hello") 

public class HelloServlet extends HttpServlet {
  
  public void doGet(HttpServletRequest req,HttpServletResponse res)
      throws ServletException,IOException{
    ServletOutputStream out=res.getOutputStream(); 
    String nume=req.getParameter("name");
    String tip=req.getParameter("tip");
    //req.login("hello","secret");
    if(tip.equals("text/html")){
      res.setContentType("text/html");
      out.println("<html>");
      out.println("<head><title>HelloServlet</title></head>");
      out.println("<body>");
      out.println("<h1>HelloServlet</h1>");
      out.println("<p>");
      out.println( "Hi "+ nume+" !");
      out.println("</p>");
      out.println("<p><a href=\"/servletshiro/home.jsp\"/>Return to the home page.</a></p>");
      out.println("<p><a href=\"/servletshiro/logout\"/>Log out.</a></p>");
      out.println("</body>");
      out.println("</html>");
    }
    else{
      res.setContentType("text/plain");
      out.println("Hi "+nume+" !");
    }
    out.close();
    //req.logout();
  }

  public void doPost(HttpServletRequest req,HttpServletResponse res)
     throws ServletException,IOException{
    doGet(req,res);
  }
}
