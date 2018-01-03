package simple.app.cmmdc.test;
import org.junit.*;
import static org.junit.Assert.*;
import simple.app.cmmdc.MyCmmdc;

public class TestApp{
  private MyCmmdc app;
  
  @Before
  public void initializare(){
    app=new MyCmmdc(); 
  }
  
  @Test 
  public void test(){  
    assertEquals(8,app.cmmdc(56,24));
  }
  
  
  public static void main(String[] args){
    org.junit.runner.JUnitCore.main("server.TestApp");
  }
}
