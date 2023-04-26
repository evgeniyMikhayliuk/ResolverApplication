package tests;

import constants.Data;
import constants.UrlOfPages;
import io.qameta.allure.*;

import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.Test1Page;

@Listeners({AllureTestNg.class})
public class Test1Test extends BaseTest {

    private BasePage basePage;
    private Test1Page test1Page;
    private UrlOfPages urlOfPages;
    private Data data;

    private String landing = System.getProperty("landing");

    @BeforeMethod
    public void setUp(){
        basePage = new BasePage(driver);
        test1Page = new Test1Page(driver);
        urlOfPages = new UrlOfPages();
        data = new Data();

        urlOfPages.setBasePage(landing);
        basePage.loadPage(urlOfPages.homePage());
    }

    @Test()
    @Description("Assert that both the email address and password inputs are present as well as the login button")
    @Epic("Test 1")
    public void checkEmailPasswordFieldsOnTheHomePage() {

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(test1Page.getEmailAddressInputField().isDisplayed(),
                "\"Email Address\" input field is not displayed on the \"Home Page\"");
        softAssert.assertTrue(test1Page.getPasswordInputField().isDisplayed(),
                "\"Password\" input field is not displayed on the \"Home Page\"");
        softAssert.assertTrue(test1Page.getSignInButton().isDisplayed(),
                "\"Sign in\" button is not displayed on the \"Home Page\"");

        softAssert.assertAll();

    }

    @Test()
    @Description("Enter in an email address and password combination into the respective fields")
    @Epic("Test 1")
    public void fillEmailPasswordFieldsOnTheHomePage() {

        test1Page
                .fillEmailField(data.getRegisteredEmailAddress())
                .fillPasswordField(data.getRegisteredPassword());

        String valuesInTheEmailField = test1Page.getEmailAddressInputField().getAttribute("value");
        String valuesInThePasswordField = test1Page.getPasswordInputField().getAttribute("value");

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(valuesInTheEmailField, data.getRegisteredEmailAddress(),
                "Email field value is not as expected. Expected: " + data.getRegisteredEmailAddress() +
                        ", Actual: " + valuesInTheEmailField);
        softAssert.assertEquals(valuesInThePasswordField, data.getRegisteredPassword(),
                "Password field value is not as expected. Expected: " + data.getRegisteredPassword() +
                        ", Actual: " + valuesInThePasswordField);

        softAssert.assertAll();
    }

}