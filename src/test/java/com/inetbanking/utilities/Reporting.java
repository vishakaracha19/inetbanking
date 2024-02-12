package com.inetbanking.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ReporterConfigurable;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reporting extends TestListenerAdapter
{
    public ExtentReports extent;
    public ExtentSparkReporter htmlReporter;
    public ExtentTest logger;

    public void onStart(ITestContext testContext)
    {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String repName = "Test-Report"+timeStamp+".html";

        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+ "/test-output/Test-Reports/"+repName);
        try {
            htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/test-output/"+"extent-report.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        extent = new ExtentReports();

        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("host name", "localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("user", "vishaka");

        htmlReporter.config().setDocumentTitle("InetBanking Test Project");
        htmlReporter.config().setReportName("Functional Test Automation Report");
        //htmlReporter.config().setTestViewChartLocation(ChartLocation.Top);
        //htmlReporter.config().setTheme(Theme.DARK);

    }


    public void onTestSuccess(ITestResult tr)
    {
        logger=extent.createTest(tr.getName());
        logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
    }

    public void onTestFailure(ITestResult tr)
    {
        logger=extent.createTest(tr.getName());
        logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));

        String screenshotPath = System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";

        File f = new File(screenshotPath);

        if(f.exists())
        {
            logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
        }

    }

    public void onTestSkipped(ITestResult tr)
    {
        logger=extent.createTest(tr.getName());
        logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
    }

    public void onFinish(ITestContext testContext)
    {
        extent.flush();
    }

}
