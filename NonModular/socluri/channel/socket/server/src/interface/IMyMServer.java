package cmmdc.socketchannel.i;
import java.nio.channels.ServerSocketChannel;
public interface IMyMServer{
  public ServerSocketChannel getServerSocketChannel(int port);
  public void myAction(ServerSocketChannel serverSocketChannel);
}  
