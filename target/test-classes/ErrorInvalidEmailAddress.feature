Feature: Get error "Invalid email address" on the Prestashop

  Scenario: Get error "Invalid email address" on the main page
    Given I open Main Page
    When I fill Get our latest news and special sales field with email
    Then I see that message 'You have successfully subscribed to this newsletter.' appears