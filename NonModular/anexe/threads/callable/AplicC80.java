import java.util.concurrent.Callable;
import java.util.function.Function;

public class AplicC80{
  static Function<Integer,Callable<Integer>> f=index->{
    Callable<Integer> c=()->{
      System.out.println("I am "+index);
      return index;
    };
    try{
      c.call();
    }
    catch(Exception e){
      e.printStackTrace();
    }
    return c;
  };
  
  public static void main(String args[]){
    int numarFire=5;
    try{
      for(int i=0;i<numarFire;i++){
        f.apply(i);
      }
    }
    catch(Exception e){
      System.out.println("Exception : "+e.getMessage());
    }    
  }        
}
