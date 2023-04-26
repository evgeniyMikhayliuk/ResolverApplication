package tests;

import constants.UrlOfPages;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.Test4Page;

import static utils.TestUtils.loadBasePage;

@Listeners({AllureTestNg.class})
public class Test4Test extends BaseTest {

    private BasePage basePage;
    private Test4Page test4Page;
    private UrlOfPages urlOfPages;
    private String landing = System.getProperty("landing");

    @BeforeMethod
    public void setUp(){
        basePage = new BasePage(driver);
        test4Page = new Test4Page(driver);
        urlOfPages = new UrlOfPages();

        loadBasePage(basePage, urlOfPages, landing);

        test4Page.scrollToTest4Block();
    }

    @Test()
    @Description("Assert that the first button is enabled and that the second button is disabled")
    @Epic("Test 4")
    public void checkButtonsState() {

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(test4Page.getPrimaryButton().isEnabled(),
                "\"Primary\" button is disabled in the \"Test 4 section\" but should be enabled");
        softAssert.assertFalse(test4Page.getSecondaryButton().isEnabled(),
                "\"Secondary\" button is enabled in the \"Test 4 section\" but should be disabled");

        softAssert.assertAll();
    }
}
