package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.BooksPage;
import com.cybertek.library.pages.DashboardPage;
import com.cybertek.library.pages.UsersPage;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class PageNavigations_StepDefinitions {
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
    DashboardPage landingPage = new DashboardPage();
    Select select;
    UsersPage usersPage = new UsersPage();
    BooksPage booksPage = new BooksPage();

    @When("I click on {string} link")
    public void i_click_on_link(String link) {
        switch (link.toLowerCase()) {
            case "dashboard":
                landingPage.dashboardPageModule.click();
                break;
            case "users":
                landingPage.usersPageModule.click();
                break;
            case "books":
                landingPage.booksPageModule.click();
                break;
        }
    }


    @Then("show records default value should be {int}")
    public void show_records_default_value_should_be(Integer expected) {
        BrowserUtils.sleep(5);
        select = new Select(usersPage.showRecordsDropdown);
        String actual = select.getFirstSelectedOption().getText();

        Assert.assertEquals(expected + "", actual);

    }

    @Then("show records should have following options:")
    public void show_records_should_have_following_options(List<String> options) {
        System.out.println("options.size() = " + options.size());

    }


    @Then("table should have following column names:")
    public void tableShouldHaveFollowingColumnNames(List<String> columnNames) {
        List<String> actualColumnNames = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            actualColumnNames.add(usersPage.tableHeaders.get(i).getText());
        }
        Assert.assertEquals(actualColumnNames, columnNames);
        BrowserUtils.sleep(3);
    }


    @Then("the user should see the following column names:")
    public void theUserShouldSeeTheFollowingColumnNames(List<String> columnNames) {
        List<String> actualColumnNames = BrowserUtils.getElementsText(booksPage.bookTableNames);
        Assert.assertEquals(actualColumnNames, columnNames);
        BrowserUtils.sleep(1);
    }
}
