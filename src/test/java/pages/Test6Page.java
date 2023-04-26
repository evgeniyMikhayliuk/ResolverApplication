package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Test6Page extends BasePage {

    @FindBy(how = How.ID, using = "test-6-div")
    private WebElement test6Block;

    private By table = By.tagName("tbody");

    private By tableRow = By.tagName("tr");

    private By tableCell = By.tagName("td");

    public Test6Page(WebDriver driver) {
        super(driver);
    }

    /**
     * This method is used to scroll page to Test 6 Block.
     * @return
     */
    public Test6Page scrollToTest6Block(){
        scrollElementIntoView(test6Block);
        return this;
    }

    /**
     * This method is used for getting value from the table by entering row and column numbers.
     * @param row
     * @param col
     * @return
     */
    public String getCellValue(int row, int col) {
        WebElement tableElement = driver.findElement(table);
        WebElement tableRowElement = tableElement.findElements(tableRow).get(row);
        WebElement tableCellElement = tableRowElement.findElements(tableCell).get(col);
        return tableCellElement.getText();
    }
}
