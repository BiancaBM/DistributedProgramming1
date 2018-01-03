import java.io.IOException;
import javax.servlet.AsyncContext;
import javax.servlet.ReadListener;
import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.ServletInputStream;
import java.io.IOException;

public class CmmdcListener implements ReadListener, WriteListener{
  private ServletInputStream input = null;
  private AsyncContext context = null;
  private ServletOutputStream out = null;
  private boolean readFinished=false;
  private String rez=null;
  private String data=null;
  
  public CmmdcListener(ServletInputStream in, AsyncContext ac, ServletOutputStream output) throws IOException{
    input = in;
    context = ac;
    out = output;
	  in.setReadListener(this);
    out.setWriteListener(this);
  }

  @Override
  public void onDataAvailable() {
	  try {
      int len = 0;
      byte b[] = new byte[1024];
      StringBuffer sb=new StringBuffer(1024);
      while (input.isReady() && (len>-1)) {
        len=input.read(b);
        if(len>0) sb.append(new String(b,0,len));
      }
      data = sb.toString();
      System.out.println(data);
    } 
    catch (IOException e) {
      System.out.println("onAvailableException : "+e.getMessage());
    }
  }

  @Override
  public void onAllDataRead() throws IOException{
    System.out.println("onAllDataRead");
    readFinished=true;
    System.out.println(data);
    rez=solver(data);
    context.complete();
    onWritePossible();
    
  }

  @Override
  public void onWritePossible() throws IOException { 
    while(!readFinished);
    StringBuffer sb=new StringBuffer(1024);
    sb.append("<html><head><title>Servlet ReadTestServlet</title></head>");
    sb.append("<body><h1>Servlet NonBlockingServlet</h1><p>");
    sb.append(rez);
    sb.append("</p></body></html>");
    out.print(sb.toString());
  }
  
  @Override
  public void onError(Throwable t) {
    t.printStackTrace();
    context.complete();
  }
  
  private String solver(String data){
    String[] s=data.split("&");
    String[] s0=s[0].split("=");
    long m=Long.parseLong(s0[1]);
    String[] s1=s[1].split("=");
    long n=Long.parseLong(s1[1]);
    String r=Long.valueOf(cmmdc(m,n)).toString();
    return "Cmmdc : "+r;
  }
  
  private long cmmdc(long m, long n){
     long r,c;
     do{
        c=n;
        r=m%n;
        m=n;
        n=r;
     }while(r!=0);
     return c;
  }   
}
