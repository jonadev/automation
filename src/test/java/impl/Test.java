package impl;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Test {

  private WebDriver driver = SeleniumConfig.getDriver();

  @Given("^User is in the home page of American Airlines$")
  public void user_is_in_the_home_page_of_American_Airlines() throws Throwable {
    String titleHomePage = "American Airlines";
    Assert.assertTrue(driver.getTitle().contains(titleHomePage));
  }

  @When("^Search flights in the main form$")
  public void search_flights_in_the_main_form() throws Throwable {
    String origin = "BUE";
    String destination = "MIA";

    //Set one way mode
    driver.findElement(By.xpath("//*[@id='bookingCheckboxContainer']/div[1]/div[2]/label")).click();

    //Select EZE
    driver.findElement(By.id("reservationFlightSearchForm.originAirport")).sendKeys(origin);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    List<WebElement> originList = driver
        .findElements(By.xpath("//*[@id='ui-id-1']/li/a"));
    originList.stream().filter(webElement -> webElement.getText().contains("EZE"))
        .findFirst().orElseThrow().click();

    //Select MIA
    driver.findElement(By.id("reservationFlightSearchForm.destinationAirport"))
        .sendKeys(destination);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    List<WebElement> destinationList = driver
        .findElements(By.xpath("//*[@id='ui-id-2']/li/a"));
    destinationList.stream().filter(webElement -> webElement.getText().contains("MIA"))
        .findFirst().orElseThrow().click();

    //select passenger number
    Select passengerNumber = new Select(
        driver.findElement(By.id("flightSearchForm.adultOrSeniorPassengerCount")));
    passengerNumber.selectByVisibleText("1");

    //Select departure date
    driver.findElement(By.id("aa-leavingOn")).click();
    driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[2]/td[7]/a"))
        .click();

    //Submit form
    driver.findElement(By.id("flightSearchForm.button.reSubmit")).click();
  }

  @Then("^Flights available should be displayed$")
  public void flights_available_should_be_displayed() throws Throwable {
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    Assert.assertEquals(0,
        driver.findElements(By.cssSelector("div.message-error.margin-bottom")).size());

  }

}
