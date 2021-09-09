#Author: josejulian_ramos@hotmail.com
Feature: Consult of a user in the reqres.in API
  As a Certification Analyst for Reqres.in
  I need to test the consult user functionality
  to validate its correct operation

  Background:
    Given that the Analyst has access to the API

  Scenario Outline: Successful query of a user for his id
    When he makes the query of a user for his id <userID>
    Then he should see the successful response code <responseCode>
    And that the response contains the id <userID> and email <email> fields

    Examples:
      | responseCode | userID | email                    |
      | 200          | 2      | janet.weaver@reqres.in   |
      | 200          | 5      | charles.morris@reqres.in |