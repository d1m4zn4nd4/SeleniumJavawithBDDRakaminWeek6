Feature: Navigate and Input Credential to Login

  @positive
  Scenario: Login using valid credential
    Given : User navigate to login page
    When : User input valid username
    And : User input valid password
    And : Click Login Button
    Then : User can login to choose product

  @negative
  Scenario: Login using empty password
    Given : User navigate to login page
    When : User input valid username
    And : User input empty password
    And : Click Login Button
    Then : User can't login and show error message