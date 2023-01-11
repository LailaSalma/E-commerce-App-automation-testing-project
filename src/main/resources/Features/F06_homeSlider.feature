@testing

Feature: [Home sliders] user would be redirected to the corresponding product upon clicking on the slider

  Scenario: first slider is clickable on home page
    Given user clicks on slider no. "1" button
    When user clicks on the product shown in the slider
    Then user is redirected to the page of the first product

  Scenario: Second slider is clickable on home page
    Given user clicks on slider no. "2" button
    When user clicks on the product shown in the slider
    Then user is redirected to the page of the second product