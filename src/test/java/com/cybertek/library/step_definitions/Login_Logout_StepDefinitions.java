package com.cybertek.library.step_definitions;


import com.cybertek.library.pages.BooksPage;
import com.cybertek.library.pages.DashboardPage;
import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_Logout_StepDefinitions {


    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    BooksPage booksPage = new BooksPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);


    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);
        BrowserUtils.sleep(1);
    }

    @When("I login as a librarian")
    public void i_login_as_a_librarian() {
        loginPage.usernameBox.sendKeys(ConfigurationReader.getProperty("usernameL"));
        loginPage.passwordBox.sendKeys(ConfigurationReader.getProperty("passwordL"));
        BrowserUtils.sleep(1);
        loginPage.signInButton.click();
    }

    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {
        String expected = "dashboard";
        BrowserUtils.sleep(1);
        String actual = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actual.contains(expected));
        BrowserUtils.sleep(1);
    }


    @When("I login as a student")
    public void i_login_as_a_student() {
        loginPage.usernameBox.sendKeys(ConfigurationReader.getProperty("usernameS1"));
        loginPage.passwordBox.sendKeys(ConfigurationReader.getProperty("passwordS1"));
        BrowserUtils.sleep(2);
        loginPage.signInButton.click();

    }

    @Then("books should be displayed")
    public void books_should_be_displayed() {
        String expected = "books";
        wait.until(ExpectedConditions.urlContains(expected));
        String actual = Driver.getDriver().getCurrentUrl();
        System.out.println("actual = " + actual);
        Assert.assertTrue(actual.contains(expected));
        BrowserUtils.sleep(1);
    }


    @When("I enter username {string}")
    public void i_enter_username(String string) {
        loginPage.usernameBox.sendKeys(string);
    }

    @When("I enter password {string}")
    public void i_enter_password(String string) {
        loginPage.passwordBox.sendKeys(string);
    }

    @When("click the sign in button")
    public void click_the_sign_in_button() {
        loginPage.signInButton.click();
    }

    @Then("there should be {int} users")
    public void there_should_be_users(Integer int1) {

        String expectedCount = "" + int1;
        String actualCount = dashboardPage.usersCount.getText();

        BrowserUtils.sleep(2);
        Assert.assertTrue(actualCount.equals(expectedCount));
        BrowserUtils.sleep(2);
    }


    @When("I login using {string} and {string}")
    public void i_login_using_username_and_password(String str1, String str2) {
        loginPage.usernameBox.sendKeys(str1);
        loginPage.passwordBox.sendKeys(str2);
        loginPage.signInButton.click();
    }

    @When("I login using {string}and {string}")
    public void iLoginUsingAnd(String email, String password) {
        wait.until(ExpectedConditions.visibilityOf(loginPage.usernameBox));
        loginPage.usernameBox.sendKeys(email);
        wait.until(ExpectedConditions.visibilityOf(loginPage.passwordBox));
        loginPage.passwordBox.sendKeys(password);
        BrowserUtils.sleep(1);
        loginPage.signInButton.click();

    }

    @Then("account holder name should be {string}")
    public void accountHolderNameShouldBe(String expectedAccountHolderName) {
        BrowserUtils.sleep(1);

        String actualAccountHolderName = dashboardPage.accountHolderLink.getText();

        wait.until(ExpectedConditions.visibilityOf(dashboardPage.accountHolderLink));
        Assert.assertEquals(actualAccountHolderName, expectedAccountHolderName);
    }


    @Given("the user login as a {string}")
    public void the_user_login_as_a(String role) {
        switch (role) {
            case "student":
                i_am_on_the_login_page();
                i_login_as_a_student();
                break;
            case "librarian":
                i_am_on_the_login_page();
                i_login_as_a_librarian();
                break;
        }


    }

    @Then("the user on  {string}")
    public void the_user_on(String page) {
        String expected = page;
        wait.until(ExpectedConditions.urlContains(expected));
        String actual = Driver.getDriver().getCurrentUrl();
        System.out.println("actual = " + actual);
        Assert.assertTrue(actual.contains(expected));
        BrowserUtils.sleep(1);
    }


    @And("I click logout button")
    public void iClickLogoutButton() {
        BrowserUtils.sleep(1);
        String currentPage = Driver.getDriver().getCurrentUrl();
        if (currentPage.contains("books")) {
            booksPage.accountHolderLink.click();
            BrowserUtils.wait(1);
            booksPage.logoutButton.click();

        } else if (currentPage.contains("dashboard")) {
            dashboardPage.accountHolderLink.click();
            BrowserUtils.wait(1);
            dashboardPage.logoutButton.click();
        }
    }

    @Then("I am logged out")
    public void iAmLoggedOut() {
        String currentPage = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(currentPage.contains("login.html"));
    }
}
