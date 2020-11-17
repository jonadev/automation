package impl;

import static impl.pages.FlightSearchResultPage.ERROR_NO_RESULT_SECTION_LOCATOR;
import static impl.pages.FlightSearchResultPage.FLIGHT_RESULT_LIST_LOCATOR;
import static impl.pages.HomePage.DATE_BUTTON_LOCATOR;
import static impl.pages.HomePage.DESIRED_DATE_LOCATOR;
import static impl.pages.HomePage.DESTINATION_DROPDOWN_LOCATOR;
import static impl.pages.HomePage.DESTINATION_INPUT_LOCATOR;
import static impl.pages.HomePage.DESTINATION_MIA;
import static impl.pages.HomePage.ONE_WAY_CHECKBOX_LOCATOR;
import static impl.pages.HomePage.ORIGIN_BUE;
import static impl.pages.HomePage.ORIGIN_DROPDOWN_LOCATOR;
import static impl.pages.HomePage.ORIGIN_INPUT_LOCATOR;
import static impl.pages.HomePage.PASSENGERS_ADD_ADULT_LOCATOR;
import static impl.pages.HomePage.PASSENGERS_MODAL_CLOSE_BUTTON_LOCATOR;
import static impl.pages.HomePage.PASSENGERS_SELECT_LOCATOR;
import static impl.pages.HomePage.SUBMIT_BUTTON_LOCATOR;
import static impl.pages.HomePage.UNITED_AIRLINES_TITLE;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.TestBase;

public class Test extends TestBase {

  @Given("^User is in the home page of United Airlines$")
   public void user_is_in_the_home_page_of_United_Airlines() throws Throwable {
    Assert.assertTrue(driver.getTitle().contains(UNITED_AIRLINES_TITLE));
  }

  @When("^Search flights in the main form$")
  public void search_flights_in_the_main_form() throws Throwable {

    //Set one way mode
    driver.findElement(ONE_WAY_CHECKBOX_LOCATOR).click();

    //Select EZE
    driver.findElement(ORIGIN_INPUT_LOCATOR).sendKeys(ORIGIN_BUE);
    WebDriverWait originWait = new WebDriverWait(driver, 5);
    List<WebElement> originList = originWait
        .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ORIGIN_DROPDOWN_LOCATOR));
    originList.stream().filter(webElement -> webElement.getAttribute("aria-label").contains("EZE"))
        .findFirst().orElseThrow().click();

    //Select MIA
    driver.findElement(DESTINATION_INPUT_LOCATOR).sendKeys(DESTINATION_MIA);
    WebDriverWait destinationWait = new WebDriverWait(driver, 10);
    List<WebElement> destinationList = destinationWait
        .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(DESTINATION_DROPDOWN_LOCATOR));
    destinationList.stream().filter(webElement -> webElement.getText().contains("MIA"))
        .findFirst().orElseThrow().click();

    //Select departure date
    driver.findElement(DATE_BUTTON_LOCATOR).click();
    driver.findElement(DESIRED_DATE_LOCATOR).click();

    //select passenger number - 3 Adults
    driver.findElement(PASSENGERS_SELECT_LOCATOR).click();
    IntStream.range(1, 3)
        .forEach(passenger -> driver.findElement(PASSENGERS_ADD_ADULT_LOCATOR).click());
    driver.findElement(PASSENGERS_MODAL_CLOSE_BUTTON_LOCATOR).click();

    //Submit form
    driver.findElement(SUBMIT_BUTTON_LOCATOR).click();
  }

  @Then("^Flights available should be displayed$")
  public void flights_available_should_be_displayed() throws Throwable {
    WebElement flightsResultList = new WebDriverWait(driver, 10)
        .until(ExpectedConditions.visibilityOfElementLocated(FLIGHT_RESULT_LIST_LOCATOR));
    Assert.assertEquals(0, driver.findElements(ERROR_NO_RESULT_SECTION_LOCATOR).size());
    Assert.assertTrue(driver.findElements(FLIGHT_RESULT_LIST_LOCATOR).size() > 0);

  }

}
