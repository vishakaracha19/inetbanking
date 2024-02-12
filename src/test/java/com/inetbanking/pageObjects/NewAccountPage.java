package com.inetbanking.pageObjects;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.enterprise.inject.New;
import javax.xml.xpath.XPath;

public class NewAccountPage
{
    WebDriver ldriver;
    public NewAccountPage(WebDriver rdriver)
    {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div/ul/li[5]/a")
    @CacheLookup
    WebElement lnkNewAccount;

    @FindBy(name = "cusid")
    @CacheLookup
    WebElement txtcustomerid;

    @FindBy(how = How.NAME, using = "selaccount")
    @CacheLookup
    WebElement selAccount;

    @FindBy(name = "inideposit")
    @CacheLookup
    WebElement txtinitialdeposit;

    @FindBy(name = "button2")
    @CacheLookup
    WebElement btnsubmitaccount;

    public void NewAccountLnk()
    {
        lnkNewAccount.click();
    }
    public void customerId(String custid)
    {
        txtcustomerid.sendKeys(custid);
    }
    public void selectAccount(String accType)
    {
       Select accountType = new Select(selAccount);
       accountType.selectByVisibleText(accType);
    }
    public void InitialDeposit(String inideposit)
    {
        txtinitialdeposit.sendKeys(inideposit);
    }
    public void submitAccount()
    {
        btnsubmitaccount.click();
    }
}
