package com.inetbanking.testCases;

import com.inetbanking.pageObjects.EditCustomerPage;
import com.inetbanking.pageObjects.LoginPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.devtools.v85.layertree.model.StickyPositionConstraint;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TC_EditCustomerTest_004 extends BaseClass
{
    @Test
    public void editCustomer() throws IOException {
//        LoginPage lp = new LoginPage(driver);
//        logger.info("Application is opened");
//        driver.manage().window().maximize();
//        lp.setUsername(username);
//        logger.info("Username provided");
//        lp.setPassword(password);
//        logger.info("Password provided");
//        lp.clickSubmit();
//        logger.info("Successfully logged in into application!!!");

        EditCustomerPage editcust = new EditCustomerPage(driver);
        editcust.editCustomerlnk();
        logger.info("Clicked on Edit Customer link");
        editcust.customerId("93383");
        logger.info("CustomerId provided");
        editcust.accSubmit();

        if(driver.getTitle().equals("Guru99 Bank Edit Customer Edit Page"))
        {
            Assert.assertTrue(true);
        }
        else {
            captureScreen(driver, "EditCustomer");
            Assert.assertTrue(false);
        }
        editcust.editCustCity("Hyderabad");
        logger.info("User provided city");
        editcust.custSubmit();
        logger.info("Submitted successfully!!!");

        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

        Alert alert = driver.switchTo().alert();
        String alertMessage = driver.switchTo().alert().getText();
        alert.accept();
        String ActualResult = alertMessage;
        String ExpectedResult = "Customer details updated Successfully!!!";
        //"No Changes made to Customer records"

        try{
            Assert.assertEquals(ActualResult, ExpectedResult);
            Assert.assertTrue(true);
            logger.info("Valid message");
        }
        catch (Throwable e)
        {
            captureScreen(driver, "EditCustomerdetails");
            Assert.assertTrue(false);
            logger.info("Invalid message.");
        }





    }

}
