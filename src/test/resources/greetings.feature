Feature: api greeting feature

  Scenario: call greeting feature when api is not available
    Given Create a FizzBuzz game play
    When I play with number 3
    Then The result is "Fizz"

  Scenario: call greeting feature when api is available
    Given api is available
    When I call greeting endpoint
    Then The api result is "Hello, World!"
