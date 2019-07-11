@tag
Feature: TestMe App functionally
  Test the TestMe App functionally

  
  Scenario: Login using valid credentials
    Given  user is on the home page and user must click on Signin button
    When user enter the valid credentails and user must click on the Login button
      |value|
      |AlexUser|
      |Alex123 |    
    Then user must in home page and display success message
