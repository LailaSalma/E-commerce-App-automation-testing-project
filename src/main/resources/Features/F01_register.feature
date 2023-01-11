@testing

  Feature: [Register] user could register with valid data

    Scenario: user can register using valid data
      Given user goes to registration page
      When user select gender type
      And user enter first name "automation" and last name "tester"
      And user enter date of birth day "23" month "March" year "1997"
      And user enters email
      And user fills Password fields "P@ssw0rd" "P@ssw0rd"
      And user clicks on register button
      Then success message is displayed