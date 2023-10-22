Feature: Checkout Product

  @positive
  Scenario: Checkout with product selected
    Given : User successfully to login page
    When : User see list of product
    And : User click add product want to buy
    And : User click cart button to proceed checkout process
    And : User click button checkout
    Then : User should success navigate to first step requirement for check out

  @negative
  Scenario: Checkout without product selected
    Given : User successfully to login page
    When : User see list of product
    And : User click cart button to proceed checkout process
    And : User click button checkout
    Then : User should get error warning that product not selected