package channel.cmmdc.i;
import java.nio.channels.AsynchronousServerSocketChannel;
public interface IMyMServer{
  public AsynchronousServerSocketChannel getAsynchronousServerSocketChannel(int port);
  public void myAction(AsynchronousServerSocketChannel asynchronousServerSocketChannel);
}  