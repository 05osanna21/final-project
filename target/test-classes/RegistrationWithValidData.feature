Feature: Registration with valid data
  Scenario: Registration with valid data
    Given I open Main Page
    When  I fill registration form with valid data
    Then  I  see my name appear near cart button