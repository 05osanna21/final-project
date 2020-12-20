Feature: Check popular products
   Scenario:  Check popular products
     Given I open Main Page
     When  I see that 8 products exist in POPULAR PRODUCTS section
     Then  I see that every product has name

