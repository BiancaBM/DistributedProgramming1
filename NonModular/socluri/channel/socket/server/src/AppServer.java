package cmmdc.socketchannel.s;
import java.nio.channels.ServerSocketChannel;
import cmmdc.socketchannel.s.impl.MyMServer;
import cmmdc.socketchannel.i.IMyMServer;

public class AppServer{
  public static void main(String[] args){
    int port=7999;
    if(args.length>0)
      port=Integer.parseInt(args[0]);
    IMyMServer myMServer=new MyMServer();
    ServerSocketChannel serverSocketChannel = 
      myMServer.getServerSocketChannel(port);
    myMServer.myAction(serverSocketChannel);
  }
}
