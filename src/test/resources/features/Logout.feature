@regression
Feature: Logout feature
  As a user, I should be able to logout from the library app.

  Scenario Outline: verify users can logout
    #Given I am on the login page
    When I login using "<email>"and "<password>"
    And I click logout button
    Then I am logged out

      #TEST DATA
    Examples:
      | email               | password |
      | student27@library   | kkMksO2i |
      | student28@library   | 19Ceq2sT |
      | librarian13@library | 9rf6axdD |
      | librarian14@library | 87x8afWY |


