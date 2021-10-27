Feature: Test for Booking
  Scenario: Searching hotel and hotel's rate
    Given the booking page
    When  enter hotel in the search line and Click search button
    Then the hotel is displayed with correct name and Exceptional rate
