# language:en

Feature: Is it Friday yet?
  Everybody wants to know when it's Friday
#https://cucumber.io/docs/gherkin/reference/
  Scenario: Sunday isn't Friday
    Given today is Sunday
    When I ask whether it's Friday yet
    Then I should be told "Nope"

  Scenario: Today is Friday
    Given today is Friday
    When I ask whether it's Friday yet
    Then I should be told "TGIF"

    Scenario: Count Fridays
    Given the following days:
      | Monday |
      | Friday |
      | Sunday |
      Then tell me there is 1 Fridays

  Scenario Outline: Today is or is not Friday
    Given today is "<day>"
    When I ask whether it's Friday yet
    Then I should be told "<answer>"

    Examples:
      | day            | answer |
      | Friday         | TGIF   |
      | Sunday         | Nope   |
      | anything else! | Nope   |