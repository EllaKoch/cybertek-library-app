package com.cybertek.library.pages;

import com.cybertek.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UsersPage extends BasePage {

    public UsersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "tbl_users_length")
    public WebElement showRecordsDropdown;

    @FindBy(xpath = "//tr//th")
    public List<WebElement> tableHeaders;

    @FindBy(xpath = "//a[@href='tpl/add-user.html']")
    public WebElement addUserButton;

    @FindBy(name = "full_name")
    public WebElement fullNameInput;

    @FindBy(name = "password")
    public WebElement passwordInput;

    @FindBy(name = "email")
    public WebElement emailInput;

    @FindBy(id = "user_group_id")
    public WebElement userGroupDropdown;

    @FindBy(id = "user_status")
    public WebElement statusDropdown;

    @FindBy(name = "start_date")
    public WebElement startDateInput;

    @FindBy(name = "end_date")
    public WebElement endDateInput;

    @FindBy(id = "address")
    public WebElement addressInput;

    @FindBy(xpath = "//div[@class='modal-footer']/button[1]")
    public WebElement closeButton;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveChangesButton;

    @FindBy(xpath = "//table//tr//td[3][1]")
    public List<WebElement> namesData;

    @FindBy(xpath = "//a[@class='btn btn-primary btn-sm']")
    public List<WebElement> editButtons;


    @FindBy(xpath = "//div[@class='toast-message']")
    public WebElement newUserCreatedMessage;


}
