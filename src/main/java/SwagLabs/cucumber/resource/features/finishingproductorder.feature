Feature: Validating Order Complete Process

  @positive
  Scenario: User successfully order and product ready to shipped
    Given : User successfully finishing checkout requirement
    When : User validating the product description
    And : User validating payment information
    And : User validating shipping information
    And : User validating price total
    And : Click finish Button
    Then : User should success navigate to last checkout process and see complete order message

  @negative
  Scenario: User successfully order and product ready to shipped
    Given : User successfully finishing checkout requirement
    When : User validating the product description
    And : User validating payment information
    And : User validating shipping information
    And : User validating price total
    And : User click Log out Button
    Then : User should get validation modal to confirm canceling the order