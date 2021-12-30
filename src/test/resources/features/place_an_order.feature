Feature: As a valid user place an order

  Scenario: Place an order
    Given I'm on the Products Page LoggedIn With Details
      | username      | password     |
      | standard_user | secret_sauce |
    And My billing details are
      | firstname | lastname | postal |
      | test      | user     | 12345  |
    And I have product added in the cart
    And I'm on the Checkout page
    When I provide billing details
    And I place an order
    Then the order should be placed successfully