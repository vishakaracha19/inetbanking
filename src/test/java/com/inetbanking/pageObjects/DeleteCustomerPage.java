package com.inetbanking.pageObjects;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerPage extends EditCustomerPage
{
    //WebDriver ldriver;
    public DeleteCustomerPage(WebDriver rdriver)
    {
        super(rdriver);
//        ldriver = rdriver;
//        PageFactory.initElements(rdriver, this);
    }

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div/ul/li[4]/a")
    @CacheLookup
    WebElement lnkdeletecustomer;

//    @FindBy(how = How.NAME, using = "cusid")
//    @CacheLookup
//    WebElement txtcustid;


    public void deleteCustomer()
    {
        lnkdeletecustomer.click();
    }
//    public void custid(String cid)
//    {
//        txtcustid.sendKeys(cid);
//    }
}
