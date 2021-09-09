#Author: josejulian_ramos@hotmail.com
Feature: Register of a user in the reqres.in API
  As a Certification Analyst for Reqres.in
  I need to test the register user functionality
  to validate its correct operation

  Background:
    Given that the Analyst has access to the API

  Scenario Outline: Successful registration of a user
    When he performs the register of a user with the data <body>
    Then he should see the successful response code <responseCode>
    And that the successful registration response contains the id <id> and token <token> fields

    Examples:
      | body                                               | responseCode | id | token             |
      | {"email":"eve.holt@reqres.in","password":"pistol"} | 200          | 4  | QpwL5tke4Pnpja7X4 |
