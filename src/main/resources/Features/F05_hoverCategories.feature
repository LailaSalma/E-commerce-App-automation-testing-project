@testing

Feature: [Hover Categories] user could use the hovering functionality on the main categories
  Scenario: user hovers on a random category and chooses as subcategory
    Given user hovers on a random main category
    When user hovers on one of the displayed subcategories and clicks on it
    Then user is redirected to the chosen subcategory
