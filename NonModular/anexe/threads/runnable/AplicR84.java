import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;

public class AplicR84{
  static final int NTHREADS=100;
  static ExecutorService exec=Executors.newFixedThreadPool(NTHREADS);

  static Function<String,Thread> f=txt->{
    return new Thread(()->{
      System.out.println(txt);
    });
  };
  
  public static void main(String args[]){
    exec.execute(f.apply("Primul fir de executie"));
    exec.execute(f.apply("Al doilea fir de executie"));
    exec.execute(f.apply("Al treilea fir de executie"));
    exec.shutdown();
  }
}

