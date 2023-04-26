package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Properties;
import java.util.Random;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getAssertUrl(){
        return driver.getCurrentUrl();
    }

    public boolean isElementLoaded(WebElement loadElement) {
        new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds((long) 20.0))
                .pollingEvery(Duration.ofSeconds((long) 1.0))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOf(loadElement));
        return loadElement.isDisplayed();
    }

    public void waitOfElement(WebElement element){
        (new WebDriverWait(driver,Duration.ofSeconds(30)))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitVisibilityOfElement(WebElement element){
        (new WebDriverWait(driver,Duration.ofSeconds(30)))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void waitInvisibilityOfElement(WebElement element){
        (new WebDriverWait(driver,Duration.ofSeconds(30)))
                .until(ExpectedConditions.invisibilityOf(element));
    }

    public BasePage loadPage(String pageName){
        driver.get(pageName);
        return this;
    }

    public void scrollElementIntoView(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
