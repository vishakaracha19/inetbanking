package com.inetbanking.testCases;

import com.inetbanking.pageObjects.DeleteCustomerPage;
import org.openqa.selenium.support.CacheLookup;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_DeleteCustomerTest_005 extends BaseClass
{
    @Test
    public void deleteCustomer() throws IOException, InterruptedException {
        DeleteCustomerPage delcust = new DeleteCustomerPage(driver);
        delcust.deleteCustomer();
        logger.info("Delete Customer Page Opened");
        Thread.sleep(2000);

        boolean visibleText = driver.getPageSource().contains("Delete Customer Form");

        if(visibleText==true)
        {
            Assert.assertTrue(true);
            logger.info("Test case Passed");
        }
        else
        {
            captureScreen(driver, "DeleteCustomer");
            Assert.assertTrue(false);
            logger.info("Test Case Failed");
        }

        delcust.customerId("93383");
        logger.info("Customer ID provided");
        delcust.accSubmit();

        driver.switchTo().alert().accept();
        logger.info("User Deleted!!!");

//        driver.switchTo().alert().dismiss();
//        logger.info("Cancelled deleting user");

    }
}
