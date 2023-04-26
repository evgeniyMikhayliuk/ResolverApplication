package tests;

import driverInstance.DriverInstance;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BaseTest {
    public WebDriver driver;
    BasePage basePage;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void classLevelSetup() {
        basePage = new BasePage(driver);
    }

    @BeforeMethod
    public void methodLevelSetup() {
        driver = new DriverInstance().getDriver();
    }

    @AfterMethod
    public void teardown(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
            //capture screenshot
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenshot, new File("screenshots/" + result.getName() + ".png"));
                //add screenshot to Allure report
                Allure.addAttachment(result.getName() + " screenshot", "image/png", new FileInputStream(screenshot),"png");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        driver.quit();
    }
}