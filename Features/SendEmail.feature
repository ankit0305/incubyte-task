Feature: Send Mail Feature

  Scenario: Login and send email with attachment
    Given I am on the rediff login
    And I enter my email and password
    And I send a mail
    Then I close the browser
