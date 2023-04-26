package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class Test2Page extends BasePage{

    @FindBy(how = How.XPATH, using = "//ul[@class='list-group']/li[contains(@class,'item')]")
    private List<WebElement> listGroupItems;

    @FindBy(how = How.XPATH, using = "//ul[@class='list-group']/li[contains(@class,'item')]/span[contains(@class,'badge')]")
    private List<WebElement> listGroupBadges;

    public Test2Page(WebDriver driver) {
        super(driver);
    }

    /**
     * This method is used for getting 'List Item Value' from the list group without badge
     * @return
     */
    public String[] getListItemsValueFromListGroup() {

        String[] listItemValues = new String[listGroupItems.size()];
        for (int i = 0; i < listGroupItems.size(); i++) {
            listItemValues[i] = listGroupItems.get(i).getText().replaceAll("\\s\\d+$", "");
        }
        return listItemValues;
    }

    /**
     * This method is used for getting 'Badge' from the List item
     * @return
     */
    public String[] getListItemsBadgeValue() {

        String[] listItemValues = new String[listGroupBadges.size()];
        for (int i = 0; i < listGroupBadges.size(); i++) {
            listItemValues[i] = listGroupBadges.get(i).getText();
        }
        return listItemValues;
    }
}