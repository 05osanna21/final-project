package stepdefs;

import components.ProductBox;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.MainPage;
import utils.RandomEmail;

public class MainPageStepdefs {
    MainPage mainPage = new MainPage();

    @Given("I open Main Page")
    public void i_open_main_page() {
        mainPage.openMainPage();
        mainPage.findIframe();
        mainPage.waitSpinner();
    }

    @When("I fill Get our latest news and special sales field with email")
    public void iFillGetOurLatestNewsAndSpecialSalesFieldWithEmail() {
        mainPage.scrollTo(mainPage.getEmailField());
        mainPage.fillInvalidEmail(RandomEmail.RandomEmail());
    }

    @Then("I see that message {string} appears")
    public void iSeeThatMessageYouHaveSuccessfullySubscribedToThisNewsletterAppears(String errorMessage) {
        mainPage.getInvalidError(errorMessage);
    }

    @Then("I see  that {int} languages exists in Language dropdown in the top menu")
    public void iSeeThatLanguagesExistsInLanguageDropdownInTheTopMenu(int amountLang) {
       Assert.assertEquals(amountLang, mainPage.checkAmountLang());
    }

    @And("I see that {string} language exist in dropdown")
    public void iSeeThatUkrLanguageExistInDropdown(String lang) {
        mainPage.clickOnDropDownLanguage();
        Assertions.assertThat(mainPage.checkLangExist(lang)).as(lang + "was not found in drop down").isEqualTo(true);
    }

    @When("I see that {int} products exist in POPULAR PRODUCTS section")
    public void iSeeThatProductsExistInPOPULARPRODUCTSSection(int amountProduct) {
      Assertions.assertThat(mainPage.getAllProducts().size()).isEqualTo(amountProduct);
    }

    @Then("I see that every product has name")
    public void iSeeThatEveryProductHasName() {

            }
}
