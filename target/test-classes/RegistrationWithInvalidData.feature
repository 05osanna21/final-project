Feature: Registration with invalid data
  Scenario: Registration with invalid First Name
    Given I open Main Page
    When  I fill First name field with invalid data 'James8'
    Then I check that  field First name highlighted in red
    And I check that pop-up with text Invalid name appear under field