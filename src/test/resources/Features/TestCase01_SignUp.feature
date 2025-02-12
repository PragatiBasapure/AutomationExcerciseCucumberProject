@tag
Feature: Checking SignUp Functionality
  

  @SignUp
  Scenario: Verifying SignUp Functionality With Valid Credentials
    Given User is on SignUp Page
    When User Enters Username and Password
    And User click on SignUp button
    Then User Navigate on Create account page
    Then User Enters all the Data
    And User click on createAccount button
		Then User Navigate on account created page
  
