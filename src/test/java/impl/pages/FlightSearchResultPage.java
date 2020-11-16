package impl.pages;

import org.openqa.selenium.By;

public class FlightSearchResultPage {

  public static final By ERROR_NO_RESULT_SECTION_LOCATOR = By
      .xpath("//section[@id='fl-no-flight-search']/div/div/h2");
  public static final By FLIGHT_RESULT_LIST_LOCATOR = By
      .id("flight-result-list-revised");
}
