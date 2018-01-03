package server.impl;
import org.testng.annotations.*;
import org.testng.Assert;
import cmmdc.socketchannel.s.impl.MyMServer;
import cmmdc.socketchannel.i.IMyMServer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;


public class TestMyMServer{
  private Object[] objs=new Object[1]; 
  private static int port=7999;
  public static final long M=12;
  public static final long N=15;
  public static final long RESULT=3;
  
  @Factory
  public Object[] initializare(){
    objs[0]=new MyMServer(); 
    return objs;
  }
  
  @Test (groups={"base"})
  public void test(){ 
    int port=8999;  
    Object result=((IMyMServer)objs[0]).getServerSocketChannel(port);
    Assert.assertNotNull(result);
    //assertEquals(ServerSocketChannel.class,result.getClass());
    Assert.assertTrue(result instanceof ServerSocketChannel);
  }
  
  @Test (groups={"base"})
  public void testMyAction(){
    long r=0;
    ServerSocketChannel ssc=((IMyMServer)objs[0]).getServerSocketChannel(port);
    EmbeddedThread thread=new EmbeddedThread(ssc);
    thread.start();
    try{
      SocketChannel sc=SocketChannel.open();  
      InetSocketAddress isa=new InetSocketAddress("localhost",port); 
      sc=SocketChannel.open();
      sc.connect(isa);
      ByteBuffer bb=ByteBuffer.allocate(16);
      bb.putLong(0,M).putLong(8,N);
      sc.write(bb);
      bb.clear();
      sc.read(bb);
      r=bb.getLong(0);
    } 
    catch(Exception e){
       System.err.println("Client comunication error : "+e.getMessage());
    }   
    Assert.assertEquals(r,RESULT);
  }
  
  class EmbeddedThread extends Thread{
    ServerSocketChannel ssc;
    
    EmbeddedThread(ServerSocketChannel ssc){
      this.ssc=ssc;
    }
    
    public void run(){
      ((IMyMServer)objs[0]).myAction(ssc);
    }
  }
}