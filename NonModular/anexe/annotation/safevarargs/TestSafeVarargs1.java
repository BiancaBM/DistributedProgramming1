public class TestSafeVarargs1{
  @SafeVarargs
  // Tipul argumentului trebuie sa para inaintea tupului rezultatului
  // For static generic methods, the type parameter section must 
  // appear before the method's return type.
  // static <T> T[] asArray(T... args) {
    static <T> String[] asArray(T... args) {
      String[] sargs=new String[args.length];
      int i=-1;
      for(int j=0;j<args.length;j++){
        if(args[j] instanceof String){
          i++;
          sargs[i]=(String)args[j];
        }
      }        
    return sargs;
  }

  //static <T> T[] arrayOfTwo(T a, T b) {
  static <T> String[] arrayOfTwo(T a, T b) {
    return asArray(a, b);
  }

  public static void main(String[] args) {
    String[] bar = arrayOfTwo("hello", "world");
    System.out.println(bar[0]+" "+bar[1]);
    //Integer[] bar=arrayOfTwo(Integer. valueOf(1),Integer.valueOf(2));
  }
}
