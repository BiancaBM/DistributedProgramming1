import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.Executors;
import java.util.concurrent.Callable;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Function;

public class AplicC830{
  static final int NTHREADS=3;
  static ExecutorService exec=Executors.newFixedThreadPool(NTHREADS);
  
  static Function<Integer,Callable<Integer>> f=index->{
    Callable<Integer> c=()->{
      System.out.println("I am "+index);
      return index;
    };
    return c;
  };
  
  /*
  interface MyCallable{
    Callable<Integer> scrie(int index) throws Exception;
  }
  
  static MyCallable f=(int index)->{
    Callable<Integer> c=()->{
      System.out.println("I am "+index);
      return index;
    };
    return c;
  };
  */
  
  public static void main(String args[]){
    List<Callable<Integer>> tasks=new ArrayList<Callable<Integer>>(NTHREADS);
    try{
      for(int i=0;i<NTHREADS;i++){
        tasks.add(f.apply(i));
      } 
      List<Future<Integer>> results=exec.invokeAll(tasks);
      for(int i=0;i<NTHREADS;i++){
        Future<Integer> r=results.get(i);
        if(r.isDone()) System.out.println("Returned : "+r.get());
      }
      exec.shutdown();
    }
    catch(Exception e){
      System.out.println("Exception : "+e.getMessage());
    }    
  }        
}
