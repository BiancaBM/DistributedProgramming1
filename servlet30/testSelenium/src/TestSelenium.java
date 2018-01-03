import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestSelenium{
  static WebDriver driver;
  static Wait<WebDriver> wait;

  public static void main(String[] args) {
    String browser=args[0];
    if(browser.equals("chrome")){
      // Pentru Google Chrome
      driver = new ChromeDriver();
    }
    else{
      // Pentru Mozilla Firefox
      driver = new FirefoxDriver();
    }
    wait = new WebDriverWait(driver, 30);
    driver.get("http://localhost:8080/apphelloP/");  //OK
    //driver.get("http://localhost:8080/myservlet/cmmdc.html");  //OK
    //driver.get("http://localhost:8080/cmmdc1/cmmdc1pagina.jsp"); //OK
    //driver.get("http://localhost:8080/CmmdcWebSocketParam/");  //OK
    
    boolean result;
    try {
      result=helloNameServlet();
      //result=cmmdcApp();
    }catch(Exception e) {
      e.printStackTrace();
      result = false;
    } finally {
        driver.close();
    }

    System.out.println("Test " + (result? "passed." : "failed."));
    if (!result) {
      System.exit(1);
    }
  }

  private static boolean helloNameServlet() {
    //type search query
    driver.findElement(By.name("name")).sendKeys("xyz");

    // click search
    driver.findElement(By.name("btn")).click();

    // Wait for search to complete
    /*
    wait.until(new ExpectedCondition<Boolean>() {
      public Boolean apply(WebDriver webDriver) {
        System.out.println("Searching ...");
        return webDriver.findElement(By.id("rezult")) != null;
      }
    });
    */
    wait.until(new ExpectedCondition<Boolean>() {
      public Boolean apply(WebDriver webDriver) {
        System.out.println("Searching ...");
        return webDriver.findElement(By.tagName("body"))
          .getText()
          .contains("Hi")!= false;
      }
    });
    return driver.findElement(By.tagName("body"))
      .getText()
      .contains("Hi");
  }
  
  private static boolean cmmdcApp() {
    //type search query
    driver.findElement(By.name("m")).sendKeys("56");
    driver.findElement(By.name("n")).sendKeys("42");
    // click search  
    driver.findElement(By.name("btn")).click();

    // Wait for search to complete
    wait.until(new ExpectedCondition<Boolean>() {
      public Boolean apply(WebDriver webDriver) {
        System.out.println("Searching ...");
        return webDriver.findElement(By.tagName("body"))
          .getText()
          .contains("Cmmdc")!= false;
      }
    });
    return driver.findElement(By.tagName("body"))
      .getText()
      .contains("Cmmdc");
  }
}
