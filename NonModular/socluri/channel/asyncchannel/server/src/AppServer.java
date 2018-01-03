package channel.cmmdc.s;
import java.nio.channels.AsynchronousServerSocketChannel;
import channel.cmmdc.s.impl.MyMServer;
import channel.cmmdc.i.IMyMServer;

public class AppServer{
  public static void main(String[] args){
    int port=7999;
    if(args.length>0)
      port=Integer.parseInt(args[0]);
    IMyMServer myMServer=new MyMServer();
    AsynchronousServerSocketChannel asynchronousServerSocketChannel = 
      myMServer.getAsynchronousServerSocketChannel(port);
    myMServer.myAction(asynchronousServerSocketChannel);
  }
}