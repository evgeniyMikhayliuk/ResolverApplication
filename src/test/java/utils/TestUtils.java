package utils;

import constants.UrlOfPages;
import pages.BasePage;

public class TestUtils {
    BasePage basePage;
    UrlOfPages urlOfPages;
    public static void loadBasePage(BasePage basePage, UrlOfPages urlOfPages, String landing) {
        String projectPath = System.getProperty("user.dir");
        urlOfPages.setBasePage("file://" + projectPath + landing);
        basePage.loadPage(urlOfPages.homePage());
    }
}
