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

Feature: Proceed to Payment without product
  I want to use this template for my feature file

Background:
Given Launch the browser and open test me app

  Scenario: To check if user can proceed to payment without any product in cart        
    When User Search a product like headphones
    And Try to proceed to payment without adding it to cart
    Then TestMeApp doesn't display the cart Icon
   
 
    Scenario: successful shopping        
    When User Search a product and User adds product to cart and checksout
    And  User Proceeds to Payment
    Then User should be in Payment Page

  