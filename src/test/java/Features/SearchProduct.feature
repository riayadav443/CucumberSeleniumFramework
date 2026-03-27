Feature: Search and Place the order for products

  @OffersPage
  Scenario Outline: Search Experience for product search in both home page and offer page
    Given User is on GreenCart Landing page
    When User searched with Shortname "<Veg Name>" and extracted actual name of product
    Then User searched for same ShortName "<Veg Name>" in offers page to check if product exist
    And Validate product name in offers page matches with landing page

    Examples:
    | Veg Name|
    | Tom     |
    | Beet    |

