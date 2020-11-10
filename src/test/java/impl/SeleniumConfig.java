package impl;

import config.DriverManager;
import config.DriverManagerFactory;
import config.DriverType;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

public class SeleniumConfig {

  private static WebDriver driver;
  private DriverManager manager;

  public static WebDriver getDriver() {
    return driver;
  }

  @Before
  public void setup() {
    manager = DriverManagerFactory.getManager(DriverType.CHROME);
    driver = manager.getDriver();
    driver.get("https://www.aa.com/");
    driver.manage().window().maximize();
  }

  @After
  public void tearDown() {
    driver.quit();
  }
}
