Feature: Check categories

  Scenario: Check categories
    Given I open Main Page
    Then I check that <ListSClothesCategories> sub menu items appears
      |MEN|WOMEN|
    And I check that <ListAccessoriesCategories> sub menu items appears
      |STATIONERY|HOME ACCESSORIES|
    And  I check that no subcategory is displayed after hovering the mouse over ART



