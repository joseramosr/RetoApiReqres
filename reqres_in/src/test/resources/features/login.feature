#Author: josejulian_ramos@hotmail.com
Feature: Login of a user in the reqres.in API
  As a Certification Analyst for Reqres.in
  I need to test the login functionality
  to validate its correct operation

  Background:
    Given that the Analyst has access to the API

  Scenario Outline: Successful login of a user
    When he performs the login of a user with the credentials <body>
    Then he should see the successful response code <responseCode>
    And that the successful login response contains the token <token> field

    Examples:
      | body                                                     | responseCode | token             |
      | {"email": "eve.holt@reqres.in","password": "cityslicka"} | 200          | QpwL5tke4Pnpja7X4 |
