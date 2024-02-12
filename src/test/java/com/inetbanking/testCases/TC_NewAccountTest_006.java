package com.inetbanking.testCases;

import com.inetbanking.pageObjects.NewAccountPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC_NewAccountTest_006 extends BaseClass
{
    @Test
    public void newAccount() throws InterruptedException {
        NewAccountPage newAcc = new NewAccountPage(driver);
        newAcc.NewAccountLnk();
        logger.info("New Account page opened");

        newAcc.customerId("68937");
        logger.info("Customer ID provided");

        newAcc.selectAccount("Current");
        logger.info("Savings Account Selected");

        Thread.sleep(3000);

        newAcc.InitialDeposit("1000");
        logger.info("Amount entered");

        newAcc.submitAccount();
        logger.info("Initial Amount Deposited");



    }
}
