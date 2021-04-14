@regression
Feature: Library app login feature
  User Story: As a user, I should be able to login with correct credentials to different accounts. And dashboard
  should be displayed. Accounts are: librarian, student
  @smoke
  Scenario: Login as librarian
    #Given I am on the login page
    When I login as a librarian
    Then dashboard should be displayed

  @smoke
  Scenario: Login as student
    #Given I am on the login page
    When I login as a student
    Then books should be displayed



  Scenario Outline: verify both Students and librarians login
    Given the user login as a "<role>"
    Then the user on  "<page>"
    Examples:
      | role      | page      |
      | student   | books     |
      | librarian | dashboard |

