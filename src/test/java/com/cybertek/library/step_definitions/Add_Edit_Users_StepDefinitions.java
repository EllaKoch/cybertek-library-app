package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.DashboardPage;
import com.cybertek.library.pages.UsersPage;
import com.cybertek.library.utilities.BrowserUtils;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class Add_Edit_Users_StepDefinitions {
    DashboardPage dashboardPage = new DashboardPage();
    UsersPage usersPage = new UsersPage();
    Faker faker = new Faker();
    Select select;
    String name = faker.name().fullName();

    @When("I click on Users module")
    public void i_click_on_users_module() {
        dashboardPage.usersPageModule.click();
    }


    @When("click the Add User button")
    public void click_the_Add_User_button() {
        usersPage.addUserButton.click();
    }

    @And("click close button")
    public void clickCloseButton() {
        BrowserUtils.wait(2);
        usersPage.closeButton.click();
        BrowserUtils.wait(2);
    }

    @Then("user form is closed")
    public void userFormIsClosed() {
        Assert.assertFalse(usersPage.closeButton.isDisplayed());
    }


    @Then("click Edit button")
    public void clickEditButton() {
        usersPage.editButtons.get(0).click();
        BrowserUtils.wait(2);
    }

    @And("I fill out user's information form")
    public void iFillOutUserSInformationForm() {
        usersPage.fullNameInput.sendKeys(name);
        usersPage.passwordInput.sendKeys(faker.internet().password());
        usersPage.emailInput.sendKeys(faker.internet().emailAddress());
        select = new Select(usersPage.userGroupDropdown);
        select.selectByIndex(1);
        select = new Select(usersPage.statusDropdown);
        select.selectByVisibleText("INACTIVE");
        usersPage.addressInput.sendKeys(faker.address().fullAddress());
    }


    @Then("{string} message should be displayed")
    public void message_should_be_displayed(String message) {
        System.out.println(usersPage.newUserCreatedMessage.getText().equals(message) + " - " + usersPage.newUserCreatedMessage.getText());
        Assert.assertTrue(usersPage.newUserCreatedMessage.isDisplayed());
        BrowserUtils.wait(2);
    }


    @When("edit users information")
    public void edit_users_information() {
        usersPage.passwordInput.sendKeys(faker.internet().password());
        usersPage.addressInput.sendKeys(faker.address().fullAddress());
    }

    @When("click Save Changes button")
    public void click_save_changes_button() {
        BrowserUtils.wait(1);
        usersPage.saveChangesButton.click();
    }


    @Then("New User's name should be displayed in the user's table")
    public void newUserShouldBeDisplayedInTheUsersTable() {
        BrowserUtils.wait(1);
        usersPage.namesData.get(0).equals(name);
    }
}
