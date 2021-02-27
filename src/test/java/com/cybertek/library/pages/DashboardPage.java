package com.cybertek.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

//    public DashboardPage() {
//        PageFactory.initElements(Driver.getDriver(), this);
//    }

    @FindBy(xpath ="//span[.='Dashboard']")
    public WebElement dashboardModule;

    @FindBy(xpath = "//div//h2[@id='user_count']")
    public WebElement usersCount;


}
