package com.cybertek.library.tests;


import com.cybertek.library.pages.HomePage;
import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LoginExcelTest {
    //workbook > sheet > row> cell
    // we create the references and page Objects
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    FileInputStream fileInputStream;
    FileOutputStream fileOutputStream;
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();


    @Test
    public void login_test() throws IOException {

        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);


        String path = "src/test/resources/TestData/LoginData.xlsx";

        // load file
        fileInputStream = new FileInputStream(path);

        //to load the workbook to the class
        workbook = new XSSFWorkbook(fileInputStream);

        sheet = workbook.getSheet("Sheet1"); // sheet name

        for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
            XSSFRow currentRow = sheet.getRow(rowNum);

            if (!currentRow.getCell(0).toString().equals("Y")) {

                if (currentRow.getCell(5) == null) {
                    currentRow.createCell(5);
                }
                currentRow.getCell(5).setCellValue("Skip Requested!");
                continue;
            }

            // string current = userName value in excel
            // will get the value of the cell to store in String

            String userName = currentRow.getCell(1).getStringCellValue();
            loginPage.usernameInput.sendKeys(userName);

            String password = currentRow.getCell(2).getStringCellValue();
            loginPage.passwordInput.sendKeys(password);

            BrowserUtils.wait(1);
            loginPage.signInButton.click();

            String expectedUrl = sheet.getRow(rowNum).getCell(3).getStringCellValue();
            // explicit wait for url to change
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
            wait.until(ExpectedConditions.urlContains("#"));
            String actualUrl = Driver.getDriver().getCurrentUrl();


            if (currentRow.getCell(4) == null) {
                currentRow.createCell(4);
            }

            //passing the 'actual' into our Excel Sheet "Actual" cell
            currentRow.getCell(4).setCellValue(actualUrl);


            //===========================================================================

            if (currentRow.getCell(5) == null) {
                currentRow.createCell(5);
            }

            // comparing actual vs expected and passing the result into the excel sheet
            if (actualUrl.equals(expectedUrl)) {
                //System.out.println("Pass");
                currentRow.getCell(5).setCellValue("PASS!");
            } else {
                //System.out.println("Fail!");
                currentRow.getCell(5).setCellValue("Fail!");
            }

            //===========================================================================
            // ENTERING THE CURRENT TIME WHEN TEST IS RUNNING THAT SPECIFIC LINE
            if (currentRow.getCell(6) == null) {
                currentRow.createCell(6);
            }

            DateTimeFormatter dt = DateTimeFormatter.ofPattern("hh:mm:ss a");
            currentRow.getCell(6).setCellValue(LocalTime.now().format(dt));

            homePage.logoutDropdown.click();
            //BrowserUtils.wait(1);
            homePage.logOutButton.click();
           // BrowserUtils.wait(1);
        }

        //we must write into excel file using .write method, otherwise changes will not be applied
        fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

        workbook.close();
        fileInputStream.close();
        fileOutputStream.close();

        Driver.closeDriver();

    }

}




