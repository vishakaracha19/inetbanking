package com.inetbanking.testCases;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginDDT_002 extends BaseClass
{


    @Test(dataProvider = "LoginData")
    public void loginDDT(String user, String pwd) throws InterruptedException {
        LoginPage lp = new LoginPage(driver);
        lp.setUsername(user);
        logger.info("User name provided");
        lp.setPassword(pwd);
        logger.info("Password provided");
        lp.clickSubmit();

        Thread.sleep(3000);

        if(isAlertPresent()==true)
        {
            driver.switchTo().alert().accept(); //close alert
            driver.switchTo().defaultContent(); // will focus on the main page
            Assert.assertTrue(false);
            logger.warn("Login failed");
        }
        else
        {
            Assert.assertTrue(true);
            logger.info("Login Passed");
            lp.clickLogout();
            Thread.sleep(3000);
            driver.switchTo().alert().accept(); // close the logout alert
            logger.info("User Logged out");
            driver.switchTo().defaultContent();
        }

    }

    public boolean isAlertPresent() //User defined method created to check alert is present or not
    {
        try
        {
            driver.switchTo().alert();
            return true;
        }
        catch(NoAlertPresentException e)
        {
            return false;
        }

    }


    //will take the data from excel and store that into 2 dimensional and finally it will to the actual test case
    @DataProvider(name="LoginData")
    String [][] getData() throws IOException {
        String path = System.getProperty("user.dir") + "\\src\\test\\java\\com\\inetbanking\\testData\\TestData.xlsx";
        logger.info("Test File path: " + path);

        Logger newLogger = XLUtils.getLogger();

        int rownum = XLUtils.getRowCount(path, "Sheet1");
        int colcount = XLUtils.getCellCount(path, "Sheet1",1);
        logger.info("Row Number: " + rownum);

        logger.info("Col Number: " + colcount);
        String logindata[][] = new String[rownum][colcount];

        for(int i = 1; i <=rownum; i++)
        {
            for(int j = 0; j <colcount; j++)
            {
                logindata[i-1][j] = XLUtils.getCellData(path, "Sheet1", i,j); //1,0
            }
        }
        return logindata;
    }


}