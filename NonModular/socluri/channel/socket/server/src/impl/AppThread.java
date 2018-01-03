package cmmdc.socketchannel.s.impl;
import java.io.IOException;
import java.nio.channels.SocketChannel;
import java.nio.ByteBuffer;
import java.util.function.Function;

public class AppThread extends Thread{
  Function<SocketChannel,Thread> service=socketChannel->{
    return new Thread(()->{
      try{
        ByteBuffer bb = ByteBuffer.allocate(16);    
        //LongBuffer lb = bb.asLongBuffer();
        socketChannel.read(bb);
        // Varianta 1
        long m=bb.getLong(0);
        long n=bb.getLong(8);
        // Varianta 2
        // long m=lb.get(0);
        // long n=lb.get(1);
        long r=App.cmmdc(m,n);
        bb.clear();
        // Varianta 1
        bb.putLong(0,r);
        // Varianta 2
        // lb.put(r);
        socketChannel.write(bb);
        socketChannel.close(); 
      }
      catch(IOException e){
        e.printStackTrace();
      }  
    });
  };
}
