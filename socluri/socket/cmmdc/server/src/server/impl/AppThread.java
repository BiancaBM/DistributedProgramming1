package cmmdc.socket.server.impl;

import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.function.Function;

public class AppThread{
  // Firul de executie lansat de server
  Function<Socket,Thread> service=socket->{
    return new Thread(()->{
      try(DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream())){  
        long m=0,n=0,r;
        m=in.readLong();
        n=in.readLong();
        r=App.cmmdc(m,n);
        out.writeLong(r);
        socket.close();
      }
      catch(IOException e){
         e.printStackTrace();
      }  
    });
  };
}
