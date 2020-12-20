Feature: Check languages on the site

  Scenario: Check languages
    Given I open Main Page
    Then I see  that 46 languages exists in Language dropdown in the top menu
    And I see that 'Українська' language exist in dropdown