package com.cybertek.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BorrowingBooksPage extends BasePage{
    @FindBy(xpath = "//*[@id=\"borrowed_list\"]/thead/tr/th[1]")
    public WebElement Column1;
    @FindBy(xpath = "//*[@id=\"borrowed_list\"]/thead/tr/th[2]")
    public WebElement Column2;
    @FindBy(xpath = "//*[@id=\"borrowed_list\"]/thead/tr/th[3]")
    public WebElement Column3;
    @FindBy(xpath = "//*[@id=\"borrowed_list\"]/thead/tr/th[4]")
    public WebElement Column4;
    @FindBy(xpath = "//*[@id=\"borrowed_list\"]/thead/tr/th[5]")
    public WebElement Column5;
    @FindBy(xpath = "//*[@id=\"borrowed_list\"]/thead/tr/th[6]")
    public WebElement Column6;

}
