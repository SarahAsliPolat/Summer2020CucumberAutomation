Feature: As a user, I want to be able create new cars

  @add_car
  Scenario: 1.Add some car
    Given user is on the landing
    And user logs in as a "store manager"
    And user navigates to "Fleet" and "Vehicles"
    And user clicks on create car button
    When user adds new vehicle information
    |License Plate| SDET|
    |Model Year   | 2021|