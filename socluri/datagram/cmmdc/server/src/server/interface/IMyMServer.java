package cmmdc.datagram.i;
import java.net.DatagramSocket;
public interface IMyMServer{
  public DatagramSocket getDatagramSocket(int port);
  public void myAction(DatagramSocket datagramSocket);
}  
