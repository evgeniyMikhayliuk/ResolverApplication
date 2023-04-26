package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Test5Page extends BasePage {

    @FindBy(how = How.ID, using = "test-5-div")
    private WebElement test5Block;

    @FindBy(how = How.ID, using = "test5-button")
    private WebElement test5Button;

    @FindBy(how = How.ID, using = "test5-alert")
    private WebElement test5Alert;

    public Test5Page(WebDriver driver) {
        super(driver);
    }

    /**
     * This method is used to scroll page to Test 5 Block.
     * @return
     */
    public Test5Page scrollToTest5Block(){
        scrollElementIntoView(test5Block);
        return this;
    }

    public WebElement test5Button() {
        return test5Button;
    }

    /**
     * This method is used to wait until button becomes visible and then click it in the Test 5 Block
     * @return
     */
    public Test5Page clickTest5Button(){
        isElementLoaded(test5Button);
        test5Button.click();
        return this;
    }

    public WebElement test5Alert() {
        waitVisibilityOfElement(test5Alert);
        return test5Alert;
    }

    /**
     * This method is used to get text from alert block
     * @return
     */
    public String getAlertMessage() {
        return test5Alert.getText();
    }
}
