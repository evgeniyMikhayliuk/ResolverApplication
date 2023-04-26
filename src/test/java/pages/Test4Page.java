package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Test4Page extends BasePage {

    @FindBy(how = How.ID, using = "test-4-div")
    private WebElement test4Block;

    @FindBy(how = How.XPATH, using = "//div[@id='test-4-div']//button[contains(@class,'btn-primary')]")
    private WebElement primaryButton;

    @FindBy(how = How.XPATH, using = "//div[@id='test-4-div']//button[contains(@class,'btn-secondary')]")
    private WebElement secondaryButton;

    public Test4Page(WebDriver driver) {
        super(driver);
    }

    /**
     * This method is used to scroll page to Test 4 Block.
     * @return
     */
    public Test4Page scrollToTest4Block(){
        scrollElementIntoView(test4Block);
        return this;
    }

    public WebElement getPrimaryButton() {
        return primaryButton;
    }

    public WebElement getSecondaryButton() {
        return secondaryButton;
    }


}
