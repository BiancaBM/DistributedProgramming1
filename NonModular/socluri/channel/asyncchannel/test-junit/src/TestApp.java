package channel.cmmdc.test;
import channel.cmmdc.s.impl.App;
import org.junit.*;
import static org.junit.Assert.*;

public class TestApp{
  /*
  private App app;
  
  @Before
  public void initializare(){
    app=new App(); 
  }
  */
  
  @Test 
  public void test(){  
    assertEquals(8,App.cmmdc(56,24));
  }
  
  
  public static void main(String[] args){
    org.junit.runner.JUnitCore.main("server.TestApp");
  }
}