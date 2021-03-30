Feature: Column names
  As a user, I should able to see my borrowing books.
  @regression
  Scenario: Borrowing books table columns names
    Given I login as a student
    When  I click Borrowing Books module
    Then the user sees the following column names:
      | Action              |
      | Book Name           |
      | Borrowed Date       |
      | Planned Return Date |
      | Return Date         |
      | Is Returned ?        |