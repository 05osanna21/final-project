package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='no-account']//a")
    private WebElement noAccountHref;

    public void clickNoAccountHref(){
        waitUntilVisible(noAccountHref,5).click();

    }

}
