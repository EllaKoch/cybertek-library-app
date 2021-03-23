package com.cybertek.library.pages;

import com.cybertek.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@href='#users']")
    public WebElement usersPageModule;

    @FindBy(xpath = "//a[@href='#books']")
    public WebElement booksPageModule;

    @FindBy(xpath = "//a[@href='#dashboard']")
    public WebElement dashboardPageModule;

    @FindBy(xpath = "//a[@id='navbarDropdown']")
    public WebElement accountHolderLink;

    @FindBy(className = "dropdown-item")
    public WebElement logoutButton;

    @FindBy(xpath = "//a[@href='#borrowing-books']")
    public WebElement borrowingBooksModule;


    @FindBy(xpath = "//*[@id='navbarDropdown']")
    public WebElement logoutDropdown;


}
