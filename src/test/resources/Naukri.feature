Feature: Naukri web Application Test
  Scenario: Login Funtionality
    Given User must launch the browser and navigate to the url
    When User must enter the valid username in user name field
    And User must enter the valid password in the password field
    And user must click the login button
    Then user will navigate to the home page