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
@smoke
Feature: Test the e-commerce app landing page
         for smoke test
      1.URL Redirection
      2.Landing page title test



  @appRedirection
  Scenario: Test the URL redirection for the application
    Given user open the browser
    And user maximize the browser
    When user open the URL "http://automationpractice.com/"
    Then user is gets redirected to "My Store"
    And user close the browser

  @appLogin
  Scenario: Registered user login test
   Given user open the browser
    And user maximize the browser
    When user open the URL "http://automationpractice.com/"
    And user click on signin butten
    When user enter his registered "usertest123@gmail.com"
    And user click on signin butten
    Then user first and last name is displayed as "john patric" in top right corner
    And user close the browser

  @appMainList
  Scenario: App main category list validation
    Given user open the browser
    And user maximize the browser
    When user open the URL "http://automationpractice.com/"
    Then user is able to see the main categories
      | WOMEN   |
      | DRESSES |
      | T-SHIRT |
    And user close the browser

  @search
  Scenario Outline: user is able to search multiple products
  Given user open the browser
    And user maximize the browser
    When user open the URL "http://automationpractice.com/"
    When user search for product "<product_name>"
    Then Search result page is displayed
    And user close the browser

    Examples: 
      | product_name |
      | T-shirt      |
      | Dresses      |
      | Casual       |
