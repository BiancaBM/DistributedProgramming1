import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/push")
public class PushGif extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res) 
    throws ServletException, IOException {
    req.newPushBuilder()
      .path("resources/walking_santa.gif")
      .push();
    getServletContext().getRequestDispatcher("/image.html")
      .forward(req, res);
  }
    
  public void doPost(HttpServletRequest req,HttpServletResponse res)
     throws ServletException,IOException{
    doGet(req,res);
  }
}