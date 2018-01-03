package client;
import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpRequest.BodyProcessor;
import jdk.incubator.http.HttpResponse;
//import jdk.incubator.http.HttpResponse.BodyHandler;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class MyHttpClient{
  public static void main(String[] args){
    Scanner scanner=new Scanner(System.in);
    System.out.println("m=");
    String m=scanner.nextLine().trim();
    System.out.println("n=");
    String n=scanner.nextLine().trim();
    String tip="text/plain";
    String params="?m="+m+"&n="+n+"&tip="+tip;
    
    URI uri=null;
    try{
      uri=new URI("http://localhost:8080/myservlet/cmmdc"+params);    
    }
    catch(URISyntaxException e){
      e.printStackTrace();
    }
    HttpClient client = HttpClient.newBuilder()
     .followRedirects(HttpClient.Redirect.ALWAYS)
     .build();
    System.out.println(client.version());
    HttpRequest request = HttpRequest.newBuilder(uri) 
     .GET()   
     .build();
    try{
      HttpResponse<String> response = 
       client.send(request, HttpResponse.BodyHandler.asString());
      System.out.println(response.statusCode());
      System.out.println(response.body());
    }
    catch(Exception e){
      e.printStackTrace();
    }
    /*
    try{
      uri=new URI("http://localhost:8080/apphelloP/hello");
    }
    catch(URISyntaxException e){
      e.printStackTrace();
    }
    request = HttpRequest.newBuilder(uri)
      .POST(BodyProcessor.fromString("name=abc&tip=text/plain"))   
      .build();
    try{
      HttpResponse<String> response = 
        client.send(request, HttpResponse.BodyHandler.asString());
      System.out.println(response.statusCode());
      System.out.println(response.body());
    }
    catch(Exception e){
      e.printStackTrace();
    }  
    */    
  }
}
