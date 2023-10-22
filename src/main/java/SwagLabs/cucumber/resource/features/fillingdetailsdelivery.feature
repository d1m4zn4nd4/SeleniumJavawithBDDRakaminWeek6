Feature: Filling Details Buyer to Delivery Product

  @positive
  Scenario: Filling with valid details buyer
    Given : User successfully add product
    When : User input first name
    And : User input last name
    And : User input Postal Zip Code
    And : Click Continue Button
    Then : User should success navigate to second step requirement for check out

  @negative
  Scenario: Filling with empty details buyer
    Given : User successfully add product
    When : User input empty in first name
    And : User input empty in last name
    And : User input empty in Postal Zip Code
    And : Click Continue Button
    Then : User should get error warning that filling details buyer required