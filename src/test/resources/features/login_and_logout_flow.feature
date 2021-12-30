@smoke
Feature: Login and Logout flow

  Scenario: Login flow test with valid details
    Given I'm on SwagLabs LoginPage
    When My Login details are
      | username      | password     |
      | standard_user | secret_sauce |
    Then Login should be success

  Scenario: Login flow test with invalid details
    Given I'm on SwagLabs LoginPage
    When My Login details are
      | username      | password |
      | standard_user | invalid  |
    Then Login should be failure