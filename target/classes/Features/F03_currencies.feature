@testing

Feature: [Currencies] user could choose the currency

  Scenario: user can change the currency
    Given user selects Euro currency from the dropdown list on the top left of home page
    Then the currency of products is changed