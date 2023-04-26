package tests;

import constants.Data;
import constants.UrlOfPages;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.Test5Page;

@Listeners({AllureTestNg.class})
public class Test5Test extends BaseTest {

    private BasePage basePage;
    private Test5Page test5Page;
    private UrlOfPages urlOfPages;
    private String landing = System.getProperty("landing");

    @BeforeMethod
    public void setUp(){
        basePage = new BasePage(driver);
        test5Page = new Test5Page(driver);
        urlOfPages = new UrlOfPages();

        urlOfPages.setBasePage(landing);
        basePage.loadPage(urlOfPages.homePage());

        test5Page.scrollToTest5Block();
    }

    @Test()
    @Description("Wait for a button to be displayed and then click it, assert that a success message is displayed and the button becomes disabled")
    @Epic("Test 5")
    public void checkAlertMessageAfterClickingTest5Button() {

        test5Page.clickTest5Button();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(test5Page.test5Alert().isDisplayed(),
                "\"Alert\" after clicking \"Button\" is not displayed in the \"Test 5 section\"");

        String alertMessage = test5Page.getAlertMessage();
        softAssert.assertEquals(alertMessage, Data.alertMessage,
                "Actual alert message is \"" + alertMessage + "\" but expected alert message is \"" +
                        Data.alertMessage + "\"");

        softAssert.assertFalse(test5Page.test5Button().isEnabled(),
                "\"Button\" after clicking is enabled in the \"Test 5 section\" but it should be disabled");

        softAssert.assertAll();
    }
}
