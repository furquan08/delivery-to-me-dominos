Feature: We can retrieve user data

  Scenario Outline: We can retrieve stores by passing coordinates
    When I request for  stores by "<longitude>","<latitude>"
    Then I validate all Stores
    Examples:
      | longitude  | latitude  |
      | -83.684302 | 42.321008 |

