package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Test1Page extends  BasePage {

    @FindBy(how = How.XPATH, using = "//h2[@class='form-signin-heading']")
    private WebElement h2;

    @FindBy(how = How.ID, using = "inputEmail")
    private WebElement emailAddressInputField;

    @FindBy(how = How.ID, using = "inputPassword")
    private WebElement passwordInputField;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private WebElement signInButton;

    public Test1Page(WebDriver driver) {
        super(driver);
    }

    public WebElement getEmailAddressInputField() {
        return emailAddressInputField;
    }

    public WebElement getPasswordInputField() {
        return passwordInputField;
    }

    public WebElement getSignInButton() {
        return signInButton;
    }

    /**
     * This method is used to fill 'email' field
     * @param email
     * @return
     */
    public Test1Page fillEmailField(String email){
        emailAddressInputField.sendKeys(email);
        return this;
    }

    /**
     * This method is used to fill 'password' field
     * @param password
     * @return
     */
    public Test1Page fillPasswordField(String password){
        passwordInputField.sendKeys(password);
        return this;
    }

    /**
     * This method is used to click 'Sign in' button
     * @return
     */
    public Test1Page clickSignInButton(){
        signInButton.click();
        return this;
    }
}