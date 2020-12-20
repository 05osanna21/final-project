package pages;

import components.ProductBox;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

@Getter
@Slf4j
public class MainPage extends BasePage {

    @FindBy(xpath = "//iframe[@id='framelive']")
    private WebElement iframe;

    @FindBy(xpath = "//div[@id='loadingMessage']")
    private WebElement spinner;

    @FindBy(xpath = "//footer//div[@class='container']//div[@class='block_newsletter col-lg-8 col-md-12 col-sm-12']")
    private WebElement footerSubscribe;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@value='Subscribe']")
    private WebElement buttonSubscribe;

    @FindBy(xpath = "//p[@class='alert alert-success block_newsletter_alert']")
    private WebElement invalidErrorMessage;

    @FindBy(xpath = "//ul[@class='dropdown-menu hidden-sm-down']//li//a")
    private List<WebElement> languagesList;

    @FindBy(xpath = "//button[@data-toggle='dropdown']")
    private WebElement languageDropdown;

    @FindBy(xpath = "//ul[@class='dropdown-menu hidden-sm-down']//li")
    private WebElement count;

    private By productList = By.xpath("//div[@class='products row']//div[@itemprop='itemListElement']");

    ProductBox productBox = new ProductBox(getDriver());

    public MainPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void openMainPage() {
        getDriver().get("https://demo.prestashop.com/");
    }

    public void fillInvalidEmail(String email) {
        waitUntilVisible(footerSubscribe, 10);
        emailField.sendKeys(email);
        buttonSubscribe.click();
    }

    public void getInvalidError(String errorMessage) {
        waitUntilVisible(invalidErrorMessage, 5).getText();
    }

    public void clickOnDropDownLanguage() {
        waitUntilVisible(languageDropdown, 10).click();
    }

    public int checkAmountLang() {
        log.info("checkAmountLang");
        log.info("Found {} elements", languagesList.size());
        return languagesList.size();
    }

    public boolean checkLangExist(String lang) {
        log.info("checkLangExist");
        for (int i = 0; i < languagesList.size(); i++) {
            if (languagesList.get(i).getText().equals(lang)) {
                return true;
            }
        }
        return false;
    }

    public List<ProductBox> getAllProducts() {
        return productBox.getAllItems(productList);
    }

   public boolean checkAllProductsHasName() {
       log.info("checkAllProductsHasName");
       List<ProductBox> allProductBoxesFromPage = getAllProducts();
       List<ProductBox> productsWithoutName = new ArrayList<>();
       for (ProductBox product : allProductBoxesFromPage){
             if(product.getName().isEmpty()){
               productsWithoutName.add(product);
           }
       }
       return productsWithoutName.size()==0;
   }
    public boolean checkAllPricesAreMoreNull(){
        log.info("checkAllPricesAreMoreNull");
        List<ProductBox> allProductBoxesFromPage = getAllProducts();
        List<ProductBox> notNullPriseProducts = new ArrayList<>();
        for (ProductBox product : allProductBoxesFromPage){
            if(product.getPrice()<= 0){
                notNullPriseProducts.add(product);
            }
        }
        return notNullPriseProducts.size()==0;
    }
    }


