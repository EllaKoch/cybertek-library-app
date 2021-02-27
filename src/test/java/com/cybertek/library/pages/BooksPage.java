package com.cybertek.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BooksPage extends BasePage {

    @FindBy(xpath = "//table//th")
    public List<WebElement> bookTableNames;


}
