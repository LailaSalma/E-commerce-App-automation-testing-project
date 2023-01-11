@testing

Feature: [Wishlist] user could add product to their wishlist

  Scenario: user could add a product to wishlist by pressing the heart icon
    Given user click on heart icon below the product image
    Then user is able to see a successful message

  Scenario: a product is added to wishlist upon clicking on the heart icon
    Given user click on heart icon below the product image
    And user clicks on wishlist button after the success message disappears
    Then user could see item added successfully in wishlist