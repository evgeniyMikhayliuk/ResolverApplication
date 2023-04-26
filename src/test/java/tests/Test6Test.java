package tests;

import constants.Data;
import constants.UrlOfPages;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.Test6Page;

@Listeners({AllureTestNg.class})
public class Test6Test extends BaseTest {

    private BasePage basePage;
    private Test6Page test6Page;
    private UrlOfPages urlOfPages;

    private String landing = System.getProperty("landing");

    @BeforeMethod
    public void setUp(){
        basePage = new BasePage(driver);
        test6Page = new Test6Page(driver);
        urlOfPages = new UrlOfPages();

        urlOfPages.setBasePage(landing);
        basePage.loadPage(urlOfPages.homePage());

        test6Page.scrollToTest6Block();
    }

    @Test()
    @Description("Write a method that allows you to find the value of any cell on the grid, " +
            "then find the value of the cell at coordinates 2, 2 and assert that the value of the cell is \"Ventosanzap\"")
    @Epic("Test 6")
    public void checkAlertMessageAfterClickingTest5Button() {

        String cellValue = test6Page.getCellValue(2, 2);

        Assert.assertEquals(cellValue, Data.cellValue2_2,
                "Actual cell value is \"" + cellValue + "\" but expected cell value is \"" +
                        Data.cellValue2_2 + "\" ");
    }
}
