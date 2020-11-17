package impl.pages;

import org.openqa.selenium.By;

public class HomePage {

  public static final By ONE_WAY_CHECKBOX_LOCATOR = By
      .cssSelector("label[for='oneway']");
  public static final By ORIGIN_INPUT_LOCATOR = By
      .id("bookFlightOriginInput");
  public static final By ORIGIN_DROPDOWN_LOCATOR = By
      .xpath("//ul[@id='bookFlightOriginInput-menu']/li/button");
  public static final By DESTINATION_INPUT_LOCATOR = By
      .id("bookFlightDestinationInput");
  public static final By DESTINATION_DROPDOWN_LOCATOR = By
      .xpath("//ul[@id='bookFlightDestinationInput-menu']/li/button");
  public static final By PASSENGERS_SELECT_LOCATOR = By
      .id("bookFlightModel.passengers");
  public static final By PASSENGERS_ADD_ADULT_LOCATOR = By
      .id("NumOfAdults plusBtn");
  public static final By PASSENGERS_MODAL_CLOSE_BUTTON_LOCATOR = By
      .id("passengersCloseBtn");
  public static final By DATE_BUTTON_LOCATOR = By
      .id("DepartDate");
  public static final By DESIRED_DATE_LOCATOR = By
      .xpath("//td[contains(@class, \"selected\")]/following-sibling::td");
  public static final By SUBMIT_BUTTON_LOCATOR = By
      .cssSelector("button[type=submit]");


  public static final String UNITED_AIRLINES_TITLE = "United Airlines";
  public static final String ORIGIN_BUE = "BUE";
  public static final String DESTINATION_MIA = "MIA";

}
