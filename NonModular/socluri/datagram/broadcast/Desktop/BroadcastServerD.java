import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.Date;
import java.text.DateFormat;

public class BroadcastServerD{
  public static void main(String[] args){
    boolean sfarsit=false;
    int serverPort=7000;
    try(DatagramSocket socket=new DatagramSocket(serverPort)){
      socket.setBroadcast(true);
      while (! sfarsit) {
        byte[] bin=new byte[4048];
        DatagramPacket packet=new DatagramPacket(bin,bin.length);
        socket.receive(packet);
        int clientPort=packet.getPort();
        Action myAction=new Action(socket,clientPort);
        myAction.start();
      } 
    }  
    catch (Exception e) {
       System.out.println(e.getMessage());
    }
  }
}

class Action extends Thread{
  private int port;
  private DatagramSocket socket;
  private Date data = null;
  private long FIVE_SECONDS = 5000;
  
  Action(DatagramSocket socket,int port){
    this.port=port;
    this.socket=socket;
  }

  public void run(){
    byte[] buf=new byte[256];
    try{
      for(int i=0;i<5;i++){
        data=new Date();    
        String df=DateFormat.getTimeInstance().format(data);
        //System.out.println(df);
        buf = df.getBytes();
        // send it
        InetAddress group = InetAddress.getByName("255.255.255.255");
        DatagramPacket packet = new DatagramPacket(buf, buf.length, group, port);  
        socket.send(packet);
        // sleep for a while
        Thread.sleep(FIVE_SECONDS);
      } 
    }
    catch(Exception e){
      e.printStackTrace();
    }    
  }  
}