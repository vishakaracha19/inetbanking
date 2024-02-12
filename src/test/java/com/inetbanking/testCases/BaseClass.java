package com.inetbanking.testCases;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.ReadConfig;
import net.bytebuddy.implementation.FieldAccessor;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.properties.PropertiesConfiguration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class BaseClass
{
    ReadConfig readConfig = new ReadConfig();
    public String baseURL = readConfig.getApplicationUrl();
    public String username = readConfig.getUsername();
    public String password = readConfig.getPassword();
    public static WebDriver driver;

    public static Logger logger;

    @Parameters("browser")
    @BeforeClass
    public void setup(String br)
    {

//        File file = new File("C:\\Users\\Vishaka Racha\\IdeaProjects\\inetBankingV2\\log4j2.xml");
//
//        LoggerContext context = (LoggerContext) LogManager.getContext(false);
//        context.setConfigLocation(file.toURI());

        Configurator.initialize(null, "test-output\\log4j2.xml");
        logger  = LogManager.getLogger("ebanking");
        //PropertyConfigurator.configure("log4j.properties");

        if(br.equals("firefox"))
        {
            System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxPath());
            driver = new FirefoxDriver();
        }
        else if(br.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", readConfig.getFirefoxPath());
            driver = new ChromeDriver();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseURL);
        LoginPage lp = new LoginPage(driver);
        logger.info("Application is opened");
        driver.manage().window().maximize();
        lp.setUsername(username);
        logger.info("Username provided");
        lp.setPassword(password);
        logger.info("Password provided");
        lp.clickSubmit();
        logger.info("Successfully logged in into application!!!");

    }

//    @AfterClass
//    public void tearDown()
//    {
//        driver.quit();
//    }

    public void captureScreen(WebDriver driver, String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png" );
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot Taken");

    }

    //To generate the email dynamically we need to create the user defined function
    public String randomString()
    {
        String generatedstring = RandomStringUtils.randomAlphabetic(8);
        return(generatedstring);
    }

    public static String randomNum()
    {
        String generatedstring2 = RandomStringUtils.randomNumeric(5);
        return(generatedstring2);
    }
}
