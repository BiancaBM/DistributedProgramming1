public class TestSafeVarargs{
  @SafeVarargs
  // Tipul argumentului trebuie sa para inaintea tupului rezultatului
  // For static generic methods, the type parameter section must 
  // appear before the method's return type.
  static <T> T[] asArray(T... args) {
    return args;
  }

  static <T> T[] arrayOfTwo(T a, T b) {
    return asArray(a, b);
  }

  public static void main(String[] args) {
    String[] bar = arrayOfTwo("hello", "world");
    System.out.println(bar[0]+" "+bar[1]);
  }
}
