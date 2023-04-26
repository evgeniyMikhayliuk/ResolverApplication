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
import pages.Test2Page;

@Listeners({AllureTestNg.class})
public class Test2Test extends BaseTest {

    private BasePage basePage;
    private Test2Page test2Page;
    private UrlOfPages urlOfPages;

    private String landing = System.getProperty("landing");

    @BeforeMethod
    public void setUp(){
        basePage = new BasePage(driver);
        test2Page = new Test2Page(driver);
        urlOfPages = new UrlOfPages();

        urlOfPages.setBasePage(landing);
        basePage.loadPage(urlOfPages.homePage());
    }

    @Test()
    @Description("Assert that there are three values in the listgroup, " +
            "second list item's value is set to \"List Item 2\" and badge value is \"6\"")
    @Epic("Test 2")
    public void checkTheListGroup() {

        SoftAssert softAssert = new SoftAssert();

        int listGroupCount = test2Page.getListItemsValueFromListGroup().length;

        softAssert.assertEquals(listGroupCount, 3,
                "Actual list group count is " + listGroupCount + " but expected count is 3");

        String secondListGroupValue = test2Page.getListItemsValueFromListGroup()[1];

        softAssert.assertEquals(secondListGroupValue, Data.listItem2,
                "Actual second list item value is \"" + secondListGroupValue + "\" but expected value is " +
                        Data.listItem2);

        String secondListGroupBadge = test2Page.getListItemsBadgeValue()[1];
        softAssert.assertEquals(secondListGroupBadge, "6",
                "Actual second list item badge is \"" + secondListGroupBadge + "\" but expected badge is \"6\"");

        softAssert.assertAll();

    }
}
