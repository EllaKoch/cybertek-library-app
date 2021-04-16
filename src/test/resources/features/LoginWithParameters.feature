@regression
Feature: Login with parameters

  Scenario: Login as librarian 51
    #Given I am on the login page
    When I enter username "librarian51@library"
    And I enter password 'dBq7G87s'
    And click the sign in button
    Then dashboard should be displayed

  Scenario: Login as student 52
    #Given I am on the login page
    When I enter username "student52@library"
    And I enter password 'l43OOwss'
    And click the sign in button
    Then books should be displayed

    #Scenario: Login as librarian 52
    #Given I am on the login page
    #When I enter username "librarian52@library"
    #And I enter password 'QKjmEIhB'
    #And click the sign in button
    #Then dashboard should be displayed
    #And there should be 4821 users
     #number can be whatever you have there

   #Scenario: Login as librarian same line
    #Given I am on the login page
    #When I login using 'librarian52@library' and "QKjmEIhB"
    #Then dashboard should be displayed
    #And there should be 4821 users
    #number can be whatever you have there
