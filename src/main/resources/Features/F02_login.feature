@testing

Feature: [Login] user could log into their account

  Scenario: user can login with valid email and password
    Given user go to login page
    When user logs in with the data "lassunslaila24@example.com" and "P@ssw0rd"
    And user press on login button
    Then user login to the system successfully

  Scenario: user could login with invalid email and password
    Given user go to login page
    When user logs in with the data "wrong@example.com" and "P@ssw0rd"
    And user press on login button
    Then user could not login to the system