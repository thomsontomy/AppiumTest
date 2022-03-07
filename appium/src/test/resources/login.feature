Feature: Login using username and password

  Scenario: Invalid username or password
    Given The login screen is shown
    When The user enters username "thomson"
    And The user enters password "123456"
    And The user clicks login button
    Then The invalid username or password message should be showed

  Scenario: Valid username and password
    Given The login screen is shown
    When The user enters username "test"
    And The user enters password "password"
    And The user clicks login button
    Then The login success message should be showed
