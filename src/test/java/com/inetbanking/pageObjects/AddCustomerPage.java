package com.inetbanking.pageObjects;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage
{
    // Create the Webdriver variable
    WebDriver ldriver;

    //Create the Constructor
    public AddCustomerPage(WebDriver rdriver)
    {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div/ul/li[2]/a")
    @CacheLookup
    WebElement lnkAddNewCustomer;

    @FindBy(how = How.NAME, using = "name")
    @CacheLookup
    WebElement txtCustomerName;

    @FindBy(how = How.NAME, using = "rad1")
    @CacheLookup
    WebElement rdGender;

    @FindBy(how = How.NAME, using = "dob")
    @CacheLookup
    WebElement txtdob;

//    @FindBy(how = How.XPATH, using = "//*[@id=\"dob\"]");
//    WebElement txtdob;


    @FindBy(how = How.NAME, using = "addr")
    @CacheLookup
    WebElement txtaddress;

    @FindBy(how = How.NAME, using = "city")
    @CacheLookup
    WebElement txtcity;

    @FindBy(how = How.NAME, using = "state")
    @CacheLookup
    WebElement txtstate;

    @FindBy(how = How.NAME, using = "pinno")
    @CacheLookup
    WebElement txtpinno;

    @FindBy(how = How.NAME, using = "telephoneno")
    @CacheLookup
    WebElement txttelephoneno;

    @FindBy(how = How.NAME, using = "emailid")
    @CacheLookup
    WebElement txtemailid;

    @FindBy(how = How.NAME, using = "password")
    @CacheLookup
    WebElement txtpassword;

    @FindBy(how = How.NAME, using = "sub")
    @CacheLookup
    WebElement btnsubmit;

    @FindBy(how = How.NAME, using = "res")
    @CacheLookup
    WebElement btnreset;

    public void clickAddNewCustomer(){
        lnkAddNewCustomer.click();
    }
    public  void custName(String cname){
        txtCustomerName.sendKeys(cname);
    }
    public void custGender(String cgender)
    {
        rdGender.click();
    }
    public void custdob(String cdob)
    {
        txtdob.sendKeys(cdob);
    }
   // public void custdob(String dd, String mm, String yy)
//    {
////        txtdob.click();
////        String strDate = dd + "/" + mm + "/" + yyyy;
////        txtdob.sendKeys(strDate);
//        txtdob.sendKeys(mm);
//        txtdob.sendKeys(dd);
//        txtdob.sendKeys(yy);
//    }
    public void custAddress(String caddress)
    {
        txtaddress.sendKeys(caddress);
    }
    public void custCity(String ccity)
    {
        txtcity.sendKeys(ccity);
    }
    public void custState(String cstate)
    {
        txtstate.sendKeys(cstate);
    }
    public void custPincode(String cpinno)
    {
        txtpinno.sendKeys(cpinno);
    }
    public void custTelephone(String ctelephone)
    {
        txttelephoneno.sendKeys(ctelephone);
    }
    public void custEmail(String cemail)
    {
        txtemailid.sendKeys(cemail);
    }
    public void custPassword(String cpassword)
    {
        txtpassword.sendKeys(cpassword);
    }
    public void custSubmit()
    {
        btnsubmit.click();
    }
    public void custReset()
    {
        btnreset.click();
    }

}
