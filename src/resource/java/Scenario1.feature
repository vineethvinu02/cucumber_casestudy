#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag

Feature: User Registration for TestMeApp
  I want to use this template for my Registeration feature file

 @launch
  Scenario: New User Registration
    Given User should be in TestMeApp and SignUP page.
    And User provides all valid details
   
   |username |First Name|Last Name|Password|Confirm Password|Gender|E-Mail					|Mobile Number|DOB		     |Address|Answer|
   |AlexUser11  |Alex      |S				|Alex123|Alex123|	driver.findElement(By.xpath("/html/body/main/div/div/form/fieldset/div/div[6]/div/div/label/span[1]")).click();	   |parthi@gmail.com|9876543210		|09/23/1997	|21 Park Avenue Street|Vellore|
   
    When User Clicks on the Register 
    Then User should be in Login page 