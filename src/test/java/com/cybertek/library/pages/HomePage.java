package com.cybertek.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{


    @FindBy(id = "navbarDropdown")
    public WebElement rightNavigationBAr;

    @FindBy(className = "dropdown-item")
    public WebElement logOutButton;

    @FindBy(linkText = "Users")
    public WebElement usersPageLink;

    @FindBy(xpath = "(//span[@class='title'])[2]")
    public WebElement borrowingBooksLink;

    @FindBy(linkText = "Books")
    public WebElement booksPageLink;

    @FindBy(linkText = "Dashboard")
    public WebElement dashboardPageLink;

    @FindBy(xpath = "//ul[@id='menu_item']//li")
    public List<WebElement> dashboard;
}
