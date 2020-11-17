Feature: Search a flight in United Airlines
  As a final user
  I want to search a one way flight from Buenos Aires to Miami
  So that I can book it

  Scenario: Search flights in the home page
    Given   User is in the home page of United Airlines
    When    Search flights in the main form
    Then    Flights available should be displayed