package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EditCustomerPage extends AddCustomerPage
{
    WebDriver ldriver;
    public EditCustomerPage(WebDriver rdriver) {
        super(rdriver);
    }
    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div/ul/li[3]/a")
    WebElement lnkEditCustomer;

    @FindBy(how = How.NAME, using = "cusid")
    @CacheLookup
    WebElement txtCustomerId;

    @FindBy(name ="AccSubmit")
    @CacheLookup
    WebElement btnAccSubmit;

    @FindBy(name ="city")
    WebElement txteditcity;

    public void editCustomerlnk()
    {
        lnkEditCustomer.click();
    }
    public void customerId(String custid)
    {
        txtCustomerId.sendKeys(custid);
    }
    public void accSubmit()
    {
        btnAccSubmit.click();
    }
    public void editCustCity(String eccity)
    {
        txteditcity.clear();
        txteditcity.sendKeys(eccity);
    }
}
