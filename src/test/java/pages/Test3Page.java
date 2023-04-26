package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class Test3Page extends BasePage {

    @FindBy(how = How.ID, using = "test-3-div")
    private WebElement test3Block;

    @FindBy(how = How.ID, using = "dropdownMenuButton")
    private WebElement dropdownMenuButton;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'dropdown-menu')]/a")
    private List<WebElement> dropdownMenuItems;

    public Test3Page(WebDriver driver) {
        super(driver);
    }

    /**
     * This method is used to scroll page to Test 3 Block.
     * @return
     */
    public Test3Page scrollToTest3Block(){
        scrollElementIntoView(test3Block);
        return this;
    }

    /**
     * This method is used to get selected option in the dropdown menu
     * @return
     */
    public String getSelectedOptionText(){
        return dropdownMenuButton.getText();
    }

    /**
     * This method is used to click dropdown menu button
     * @return
     */
    public Test3Page clickDropdownButton(){
        dropdownMenuButton.click();
        return this;
    }

    /**
     * This method is used to select option from dropdown menu with parameter
     * @param option
     * @return
     */
    public Test3Page selectOptionFromTheList(String option){
        waitVisibilityOfElement(dropdownMenuItems.get(0));

        for (WebElement dropdownItem : dropdownMenuItems) {
            if (dropdownItem.getText().equals(option)) {
                dropdownItem.click();
                break;
            }
        }
        return this;
    }
}
