package cmmdc.socket.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class MyMServer {
  public static void main(String[] args){
    //Create Publisher
    SubmissionPublisher<Socket> publisher=new SubmissionPublisher<>();
    //Register Subscriber
    MySubscriber<Socket> subscriber=new MySubscriber<>();
    publisher.subscribe(subscriber);

    int port=7999;
    boolean listening=true;
    try(ServerSocket serverSocket=new ServerSocket(port)){
      System.out.println("Server ready . . ");
      while(listening){
        Socket socket=serverSocket.accept();
        publisher.submit(socket);
      }
      publisher.close();
    }
    catch (IOException e){
      e.printStackTrace();
    }
  }
}

class MySubscriber<T> implements Subscriber<T> {  
  private Subscription subscription;  
  
  @Override  
  public void onSubscribe(Subscription subscription) {  
    this.subscription = subscription;  
    subscription.request(1); 
    //a value of  Long.MAX_VALUE may be considered as effectively    unbounded  
    }  
  
  @Override  
  public void onNext(T s) {  
    //System.out.println("Got an item"); 
    Socket socket=(Socket)s;
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
    subscription.request(1); 
    //a value of  Long.MAX_VALUE may be considered as effectively unbounded  
  }  
  
  @Override  
  public void onError(Throwable t) {  
    t.printStackTrace();  
  }  
  
  @Override  
  public void onComplete() {  
    System.out.println("Done");  
  }  
}  

