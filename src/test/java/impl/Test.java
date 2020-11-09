package impl;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

  private ChromeDriver driver = SeleniumConfig.getDriver();

  @Given("^User is in the main page of Airlines$")
  public void user_is_in_the_main_page_of_Airlines() throws Throwable {
    String titleHomePage = "";
    Assert.assertEquals(titleHomePage, driver.getTitle());
  }

  @When("^Search flights in the form$")
  public void search_flights_in_the_form() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
  }

  @Then("^Flights available should be displayed$")
  public void flights_available_should_be_displayed() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
  }

}
