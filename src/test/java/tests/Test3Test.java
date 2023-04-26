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
import pages.Test3Page;

import static utils.TestUtils.loadBasePage;

@Listeners({AllureTestNg.class})
public class Test3Test extends BaseTest {

    private BasePage basePage;
    private Test3Page test3Page;
    private UrlOfPages urlOfPages;
    private String landing = System.getProperty("landing");

    @BeforeMethod
    public void setUp(){
        basePage = new BasePage(driver);
        test3Page = new Test3Page(driver);
        urlOfPages = new UrlOfPages();

        loadBasePage(basePage, urlOfPages, landing);

        test3Page.scrollToTest3Block();
    }

    @Test()
    @Description("Assert that \"Option 1\" is the default selected value, then select \"Option 3\" from the select list")
    @Epic("Test 3")
    public void checkDropDownField() {

        String defaultSelectedOptionText = test3Page.getSelectedOptionText();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(defaultSelectedOptionText, Data.option1,
                "Actual default selected option is " + defaultSelectedOptionText + " but expected option is " +
                        Data.option1);

        test3Page
                .clickDropdownButton()
                .selectOptionFromTheList(Data.option3);

        String selectedOptionText = test3Page.getSelectedOptionText();

        softAssert.assertEquals(selectedOptionText, Data.option3,
                "Actual selected option is " + defaultSelectedOptionText + " but expected option is " +
                        Data.option3);

        softAssert.assertAll();

    }
}
