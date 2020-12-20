package components;

import utils.UserConfig;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

@Getter
public class HeaderNav extends BasePage {
    private WebDriver webDriver;

    public HeaderNav(WebDriver driver) {
        webDriver = driver;

    }

    public HeaderNav() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//span[@class='hidden-sm-down' and text()='Sign in']")
    private WebElement SignInButton;

    @FindBy(xpath = "//a[@class='account']//span[@class='hidden-sm-down' and contains(text(),'"+UserConfig.USER_FIRST_LAST_NAME+"')]")
    private WebElement userInfo;


    public void clickSignInButton(){
        waitUntilVisible(SignInButton,5).click();
    }

    public String checkUserInfo(){
        String ui= waitUntilVisible(userInfo,10).getText();
        return ui;
    }
}
