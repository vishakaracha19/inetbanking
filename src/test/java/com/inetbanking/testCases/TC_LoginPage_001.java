package com.inetbanking.testCases;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.ReadConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;


public class TC_LoginPage_001 extends BaseClass
{

    @Test
    public void loginTest() throws IOException {

        logger.info("URL is opened");
        LoginPage lp = new LoginPage(driver);

        lp.setUsername(username);
        logger.info("Entered Username");

        lp.setPassword(password);
        logger.info("Entered Password");
        lp.clickSubmit();

        if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
        {
            Assert.assertTrue(true);
            logger.info("Login Test Passed");
        }
        else
        {
            captureScreen(driver, "loginTest");
            Assert.assertTrue(false);
            logger.info("Login Test Failed");
        }


    }
}
