package com.cybertek.library.pages;

import com.cybertek.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//img[@class='mb-4']")
    public WebElement loginLogo;

    @FindBy(id = "inputEmail")
    public WebElement usernameBox;

    @FindBy(id = "inputPassword")
    public WebElement passwordBox;

    @FindBy(css = "button[type='submit']")
    public WebElement signInButton;

    @FindBy(className = "mt-5 mb-3 text-muted text-center")
    public WebElement yearText;



}
