Feature: Search Results
  User Story: As a students, I should be able to see tables with default info

  Background: Given I am on the login page

  @regression
  Scenario: Table columns names
    And I login as a librarian
    And I click on "Users" link
    Then table should have following column names:
      | Actions   |
      | User ID   |
      | Full Name |
      | Email     |
      | Group     |
      | Status    |

  @regression
  Scenario: Table book columns names
    And I login as a student
    Then the user should see the following column names:
      | Actions     |
      | ISBN        |
      | Name        |
      | Author      |
      | Category    |
      | Year        |
      | Borrowed By |

