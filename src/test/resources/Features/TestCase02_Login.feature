@tag
Feature: Checking the login and Delete Account functionality
  
  @Login
  Scenario: verifying the login functionality with valid credentials
    Given user is on login page
    When user enters email and password
    And click on login button
    Then user navigate on homepage
    
  @DeleteAccount
  Scenario: Verifying delete account functionality
    Given user is on login page
    When user enters email and password
    And click on login button
    Then user navigate on homepage
    And user click on delete acoount
    Then user navigate to account deleted page
  
