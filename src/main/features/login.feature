# Gherkin language structure

Feature: Login
  Scenario: Unsuccessful Login
    Given the login page is opened
    When I enter registered users's email in the email field
    And I enter wrong password in the password field
    And I submit
    Then an error text displays
    And I'm not logged in 
    
  Scenario: Invalid Email Login
    Given the login page is opened
    When I enter invalid email in the email field
    And I enter some password in the password field
    And I submit
    Then a invalid email text displays
    And I'm not logged in 