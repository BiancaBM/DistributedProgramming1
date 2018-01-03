import java.util.function.Consumer;
public class AplicR83{

  static Consumer<String> f=(txt)->{
    new Thread(()->{
      System.out.println(txt);
    }).start();
  };
  
  public static void main(String args[]){
    f.accept("Primul fir de executie");
    f.accept("Al doilea fir de executie");
    f.accept("Al treilea fir de executie");
  }
}

