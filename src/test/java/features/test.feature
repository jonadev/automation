Feature: Search a flight
  As an user, I want to search a flight from Buenos Aires to Miami

  Scenario: Go to main page
    Given   User is in the main page of Airlines
    When    Search flights in the form
    Then    Flights available should be displayed