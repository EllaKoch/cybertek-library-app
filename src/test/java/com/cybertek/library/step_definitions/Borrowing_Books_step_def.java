package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.BooksPage;
import com.cybertek.library.pages.BorrowingBooksPage;
import com.cybertek.library.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Borrowing_Books_step_def {

    BorrowingBooksPage borrowingBooksPage = new BorrowingBooksPage();
    BooksPage booksPage = new BooksPage();

    @When("I click Borrowing Books module")
    public void i_click_borrowing_books_module() {
        booksPage.borrowingBooksModule.click();
    }


    @Then("the user sees the following column names:")
    public void the_user_sees_the_following_column_names(List<String> columnNames) {
        List<WebElement> actualColumnNames = new ArrayList<>();
        actualColumnNames.addAll(Arrays.asList(borrowingBooksPage.Column1, borrowingBooksPage.Column2, borrowingBooksPage.Column3,
                borrowingBooksPage.Column4, borrowingBooksPage.Column5, borrowingBooksPage.Column6));
        BrowserUtils.wait(3);
        for (int i = 0; i < columnNames.size(); i++) {
            Assert.assertTrue(columnNames.get(i).equals(actualColumnNames.get(i).getText()));

        }
        BrowserUtils.wait(3);
    }


}
