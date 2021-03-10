@login
Feature: As user I want to be able to login under different roles
#background is precondition that will execute before any other ones
  Background: common steps
    Given user is on the landing

  Scenario: Login as a sales manager
    When user logs in
    Then user should see dashboard page

    @parametrized_test
    Scenario: parametrized login
      When user logs in as a "store manager"
      Then user should see dashboard page

       #" " makes the word parameter/ allow to re use test step
   @negative_login
      Scenario: Invalid Password
        When user logs in with "storemanager85" username and "wrong" password
        Then user verifies that "Invalid user name or password." message is displayed