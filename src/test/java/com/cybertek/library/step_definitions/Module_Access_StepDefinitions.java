package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.BooksPage;
import com.cybertek.library.pages.DashboardPage;
import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class Module_Access_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    BooksPage booksPage = new BooksPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Given("the student on the home page")
    public void the_student_on_the_home_page() {
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);
        loginPage.usernameInput.sendKeys(ConfigurationReader.getProperty("usernameS1"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("passwordS1"));
        BrowserUtils.sleep(2);
        loginPage.signInButton.click();

    }


    @Given("the librarian on the homepage")
    public void the_librarian_on_the_homepage() {
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);
        loginPage.usernameInput.sendKeys(ConfigurationReader.getProperty("usernameL"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("passwordL"));
        BrowserUtils.sleep(1);
        loginPage.signInButton.click();
    }

    @Then("the user should see following modules")
    public void the_user_should_see_following_modules(List<String> dataTable) {
        String currentPage = Driver.getDriver().getCurrentUrl();
        List<String> actualTable = new ArrayList<>();
        if (currentPage.contains("books")) {
            actualTable.add(booksPage.booksPageModule.getText());
            actualTable.add(booksPage.borrowingBooksModule.getText());
            Assert.assertTrue(actualTable.equals(dataTable));
        } else if (currentPage.contains("dashboard")) {
            actualTable.add(dashboardPage.dashboardPageModule.getText());
            actualTable.add(dashboardPage.usersPageModule.getText());
            actualTable.add(dashboardPage.booksPageModule.getText());
            Assert.assertTrue(actualTable.equals(dataTable));
        }

    }


}


