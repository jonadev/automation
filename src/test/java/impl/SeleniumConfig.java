package impl;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumConfig {

  private static ChromeDriver driver;

  @Before
  public void setup() {
    System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("https://imalittletester.com/");
    driver.manage().window().maximize();
  }

  @After
  public void tearDown(){
    driver.quit();
  }

  public static ChromeDriver getDriver(){
    return driver;
  }
}
