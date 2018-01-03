import java.util.concurrent.Callable;

public class AplicC8{
  interface MyCallable{
    void scrie(int index) throws Exception;
  }
  
  static MyCallable f=(int index)->{
    Callable<Integer> c=()->{
      System.out.println("I am "+index);
      return index;
    };
    c.call();
  };

  public static void main(String args[]){
    int numarFire=5;
    try{
      for(int i=0;i<numarFire;i++){
        f.scrie(i);
      }
    }
    catch(Exception e){
      System.out.println("Exception : "+e.getMessage());
    }    
  }        
}
