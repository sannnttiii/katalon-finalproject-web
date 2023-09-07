@Login 

Feature: Login Feature

As a user, I want to login to AdvantageDemo Shopping.



@Valid

Scenario Outline: Login with a valid input

When I click profile button to login

And I enter username <username> and password <password>

And I click Log in button

Then I should be able to login successfully

Given I navigate to AdvantageDemo System homepage

Examples:

| username | password |

| Admin | AdminPassword |