Feature: Login using username and password

  Scenario: Invalid username or password
    Given The login screen is shown
    When The user enters username "thomson"
    And The user enters password "123456"
    And The user clicks login button
    Then The invalid username or password message should be showed