Feature: add users
  User Story: As a librarian, I should be able to add users from users page.

  Background: Given I am on the login page
    When I login as a librarian


  Scenario: add users with all valid info
    And I click on Users module
    And click the Add User button
    And I fill out user's information form
    And click Save Changes button
    Then 'The user has been created.' message should be displayed

  Scenario: verify user's name is added to the user's table
    And I click on Users module
    And click the Add User button
    And I fill out user's information form
    And click Save Changes button
    Then New User's name should be displayed in the user's table

  @now
  Scenario: Librarians able to close the add user window with "close" button
    And I click on Users module
    And click the Add User button
    And click close button
    Then user form is closed


@now
  Scenario: Librarians able to edit user info.
    And I click on Users module
    And click Edit button
    And edit users information
    And click Save Changes button
    Then 'The user updated.' message should be displayed