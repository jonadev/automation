package util;

import impl.SeleniumConfig;
import org.openqa.selenium.WebDriver;

public class TestBase {

  protected WebDriver driver = SeleniumConfig.getDriver();

}
