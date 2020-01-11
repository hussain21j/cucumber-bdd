Feature: User feature

  Scenario: create a user with valid details
    Given api is available
    When I add user with name "name-1" and code "code-1"
    Then the response code should be successful

  Scenario Outline: Add user with details <name> & <code>
    Given api is available
    When I add a new user "<string>" and code "<string>"
    Then the response code should be successful

    Examples:
      | name | code |
      | Jack | CD001 |
      | John | CD002 |
      | Thomas | CD003 |


