Feature: We can retrieve user data
  Scenario: We can retrieve specific user
    When I request person by userId "2464"
    Then I validate all users

