package selector.server;
import java.util.function.BiFunction;

public class App{
  static public long cmmdc(long a,long b){
    BiFunction<Long,Long,Long> f=(m,n)->{ 
      long r,c;
      do{
        c=n;
        r=m % n;
        m=n;
        n=r;
      }
      while(r!=0);
      return Long.valueOf(c);
    };
    return f.apply(a,b).longValue();
  }  
}
