package components;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

@Getter
public class HeaderTop extends BasePage {
    private WebDriver webDriver;
    private WebDriverWait wait;
    private Actions actions;

    public HeaderTop(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 5);
        actions = new Actions(webDriver);
    }

    public HeaderTop() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//li//a[contains(., 'Clothes')]")
    private WebElement clothesCategory;

    @FindBy(xpath = "//a[contains(@class,'dropdown-submenu')]")
    public List<WebElement> subCategories;

    @FindBy(xpath = "//ul[@class='top-menu']//li[@id='category-5']")
    public WebElement womenCategories;

    @FindBy(xpath = "//li[@id='category-6']//li")
    public WebElement accessoriesCategories;

    @FindBy(xpath = "//ul[@class='top-menu']//li[@id='category-7']//a[contains(text(),'Stationery')]")
    public WebElement stationeryCategories;

    @FindBy(xpath = "//ul[@class='top-menu']//li[@id='category-7']//a[contains(text(),'Home Accessories')]")
    public WebElement homeAccessoriesCategories;

    @FindBy(xpath = "//li//a[contains(., 'Art')]")
    public WebElement artCategories;


    public void hoverCategory(WebElement category) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(category).build().perform();
    }

    public List<String> getSubMenuItems(WebElement category) {
        List<String> visibleCategories = new ArrayList<>();
        List<WebElement> subCategories = category.findElements(By.xpath("./..//div//a"));
        for (int i = 0; i < subCategories.size(); i++) {
            String text = subCategories.get(i).getText();
            visibleCategories.add(text);
        }
        return visibleCategories;
    }

}
