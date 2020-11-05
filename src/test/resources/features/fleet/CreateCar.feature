Feature: As a user, I want to be able to create new cars

  @add_car
  Scenario: 1. Add same car
    Given user is on the login page
    And user logs in as a "store manager"
    And user navigates to "Flee" and "Vehicles"
    And user clicks on create car button
    When user adds new vehicle information
    | License Plate|SDET|
    | Model Year  |2021|
    And user clicks on save and close button