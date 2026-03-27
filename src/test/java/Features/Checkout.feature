Feature: Place the order for products

  @PlaceOrder
  Scenario Outline: Search Experience for product search in both home page and offers page

    Given User is on GreenCart Landing page
    When User searched with Shortname "<Veg Name>" and extracted actual name of product
    And Added "3" items of the selected product to cart
    And User proceeds to Checkout and validate the "<Veg Name>" items in checkout page
    Then Verify user has ability to enter promo code and place the order

    Examples:
      | Veg Name|
      | Tom     |