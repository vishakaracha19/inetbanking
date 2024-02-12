package com.inetbanking.testCases;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Random;

public class TC_AddCustomerTest_003 extends BaseClass
{
    @Test
    public void addNewCustomer() throws InterruptedException, IOException {
        LoginPage lp = new LoginPage(driver);
        lp.setUsername(username); //From Baseclass
        logger.info("User name provided");
        lp.setPassword(password);
        logger.info("Password provided");
        lp.clickSubmit();

        Thread.sleep(1000);

        AddCustomerPage addcust = new AddCustomerPage(driver);
        addcust.clickAddNewCustomer();

        logger.info("Providing customer details....");
        addcust.custName("Vishaka");
        addcust.custGender("male");

        addcust.custdob("05/25/1993");
        //addcust.custdob("10", "05", "2019");
//        addcust.custAddress("Airoli");
//        addcust.custCity("Navi Mumbai");
//        addcust.custState("Maharashtra");
//        addcust.custPincode("400708");
//        addcust.custTelephone("8898274874");
//
//        String email = randomString()+"@gmail.com";
//        addcust.custEmail(email);
//
//        addcust.custPassword("abcdef");
//        addcust.custSubmit();
//

        Thread.sleep(3000);

        logger.info("Validation started....");
        boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
        if(res==true)
        {
            Assert.assertTrue(true);
            logger.info("Test case passed");
        }
        else
        {
            captureScreen(driver, "addNewCustomer");
            Assert.assertTrue(false);
            logger.info("Test case failed");
        }

    }


}
