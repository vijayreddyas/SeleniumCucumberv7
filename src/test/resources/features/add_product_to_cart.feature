Feature: As a valid user add product to cart

  @smoke
  Scenario Outline: Add one quantity from Store
    Given I'm on the Products Page LoggedIn With Details
      | username      | password     |
      | standard_user | secret_sauce |
    When I add a "<product>" to the cart
    Then I should see 1 "<product>" in the cart
    Examples:
      | product    |
      | Sauce Labs Backpack|
      | Sauce Labs Bike Light |