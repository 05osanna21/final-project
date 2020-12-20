package pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.RandomEmail;
import utils.UserConfig;

@Getter
public class RegistrasionPage extends BasePage {

    public RegistrasionPage() {
        PageFactory.initElements(getDriver(), this);
    }

    // @FindBy(xpath = "//div[@class='form-group row ']//label[contains(text(),'Social title')]")
    @FindBy(xpath = "//label[@class='radio-inline'][2]")
    private WebElement socialTitle;

    @FindBy(xpath = "//div[@class='col-md-6']//input[@name='firstname']")
    private WebElement firstNameField;

    @FindBy(xpath = "//div[@class='col-md-6']//input[@name='lastname']")
    private WebElement lastNameField;

    @FindBy(xpath = "//div[@class='col-md-6']//input[@name='email']")
    private WebElement emailField;

    @FindBy(xpath = "//div[@class='col-md-6']//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//div[@class='col-md-6']//input[@name='birthday']")
    private WebElement birthdateField;

    @FindBy(xpath = "//span[@class='custom-checkbox']//label//input[@name='optin']")
    private WebElement checkBoxReceive;

    @FindBy(xpath = "//span[@class='custom-checkbox']//label//input[@name='customer_privacy']")
    private WebElement checkBoxCustomer;

    @FindBy(xpath = "//span[@class='custom-checkbox']//label//input[@name='newsletter']")
    private WebElement checkBoxSignUp;

    @FindBy(xpath = "//span[@class='custom-checkbox']//label//input[@name='psgdpr']")
    private WebElement checkBoxAgree;

    @FindBy(xpath = "//section[@class='register-form']//button[contains(text(),'Save')]")
    private WebElement saveButton;

    @FindBy(xpath = "//ul//li[text() = 'Invalid format.']")
    private WebElement errorInvalidFormat;

    public void chooseSocialTitle() {
        waitUntilVisible(socialTitle, 5).click();
    }

    public void fillFirstNameField() {
        waitUntilVisible(firstNameField, 5).sendKeys(UserConfig.USER_FIRST_NAME);
    }

    public void fillLastNameField() {
        waitUntilVisible(lastNameField, 5).sendKeys(UserConfig.USER_LAST_NAME);
    }

    public void fillEmailField() {
        waitUntilVisible(emailField, 5).sendKeys(RandomEmail.RandomEmail());
    }

    public void fillPasswordField() {
        waitUntilVisible(passwordField, 5).sendKeys(UserConfig.USER_PASSWORD);
    }

    public void fillBirthdateField() {
        waitUntilVisible(birthdateField, 5).sendKeys(UserConfig.USER_BIRTHDATE);
    }

    public void clickCheckBoxReceive() {
        checkBoxReceive.click();
    }

    public void clickCheckBoxCustomer() {
        checkBoxCustomer.click();
    }

    public void clickCheckBoxSignUp() {
        checkBoxSignUp.click();
    }

    public void clickCheckBoxAgree() {
        checkBoxAgree.click();
    }

    public void fillInvalidFirstName(String firstName) {
        firstNameField.sendKeys("James8");
    }

    public String highlightedField() {
        String actHighField = firstNameField.getCssValue("outline-color");
        return actHighField;
    }

    public String getErrorInvalidFormat() {
        String actInvalidError = errorInvalidFormat.getText();
        return actInvalidError;
    }
}
