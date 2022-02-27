Feature: We can retrieve store data

  Scenario Outline: We can retrieve all stores
    When I request all stores
    Then I validate all stores

  Scenario: We can retrieve specific stores
    When I request store by displayName "3500 Ave Maria Dr"
    Then I validate store data
