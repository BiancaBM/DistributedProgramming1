import java.io.IOException;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;

public class BroadcastClientD{
  public static void main(String[] args) throws IOException{
    int clientPort=7001;
    int serverPort=7000;
    if(args.length>0)
      clientPort=Integer.valueOf(args[0]);
    DatagramSocket socket=new DatagramSocket(clientPort);
    InetAddress address=InetAddress.getByName("localhost");

    byte[] buf = new byte[256];
    byte[] buf0="Hello".getBytes();
    DatagramPacket packet=new DatagramPacket(buf0,buf0.length,address,serverPort);
    socket.send(packet);
    
    for(int i=0;i<5;i++){      
      packet = new DatagramPacket(buf,buf.length);
      socket.receive(packet);
      String received = new String(packet.getData());
      System.out.println("Am primit:  " + received);
    }
    socket.close();
  }
}
