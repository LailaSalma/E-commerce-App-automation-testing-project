@testing

Feature: [Search] user could search for products using name and sku

  Scenario Outline: user could search using product name
    Given user types the product "<product>" in the search bar
    When user press on search button
    Then the relevant results of "<product>" are displayed
    Examples:
      | product |
      | book |
      | laptop |
      | nike |

  Scenario Outline: user could search using product sku
    Given user types the product "<sku>" in the search bar
    When user press on search button
    And user clicks on the product displayed in the results
    Then the relevant result of "<sku>" are displayed
    Examples:
      | sku |
      | SCI_FAITH |
      | APPLE_CAM |
      | SF_PRO_11 |
