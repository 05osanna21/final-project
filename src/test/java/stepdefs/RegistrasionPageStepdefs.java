package stepdefs;

import components.HeaderNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import pages.MainPage;
import pages.RegistrasionPage;
import utils.UserConfig;

public class RegistrasionPageStepdefs {

    HeaderNav headerNav = new HeaderNav();
    LoginPage loginPage = new LoginPage();
    RegistrasionPage registrasionPage = new RegistrasionPage();

    @When("I fill registration form with valid data")
    public void iFillRegistrationFormWithValidData() {
        headerNav.clickSignInButton();
        loginPage.clickNoAccountHref();
        registrasionPage.chooseSocialTitle();
        registrasionPage.fillFirstNameField();
        registrasionPage.fillLastNameField();
        registrasionPage.fillEmailField();
        registrasionPage.fillPasswordField();
        registrasionPage.fillBirthdateField();
        registrasionPage.clickCheckBoxReceive();
        registrasionPage.clickCheckBoxCustomer();
        registrasionPage.clickCheckBoxSignUp();
        registrasionPage.clickCheckBoxAgree();
        WebElement saveButton = registrasionPage.getSaveButton();
        registrasionPage.scrollTo(saveButton);
        registrasionPage.clickWithJavaScript(saveButton);
        registrasionPage.clickWithJavaScript(saveButton);

    }

    @Then("I  see my name appear near cart button")
    public void iSeeMyNameAppearNearCartButton() {
        String userInfo = "Kseniya Zdanova";
        Assertions.assertThat(headerNav.checkUserInfo()).contains(userInfo);
    }

    @When("I fill First name field with invalid data {string}")
    public void iFillFirstNameFieldWithInvalidDataJames(String firstName) {
        headerNav.clickSignInButton();
        loginPage.clickNoAccountHref();
        registrasionPage.chooseSocialTitle();
        registrasionPage.fillInvalidFirstName(firstName);
        registrasionPage.fillLastNameField();
        registrasionPage.fillEmailField();
        registrasionPage.fillPasswordField();
        registrasionPage.fillBirthdateField();
        registrasionPage.clickCheckBoxReceive();
        registrasionPage.clickCheckBoxCustomer();
        registrasionPage.clickCheckBoxSignUp();
        registrasionPage.clickCheckBoxAgree();
        WebElement saveButton = registrasionPage.getSaveButton();
        registrasionPage.clickWithJavaScript(saveButton);
    }

    @Then("I check that  field First name highlighted in red")
    public void iCheckThatFieldFirstNameHighlightedInRed() {
        String expHighlightedField = "rgba(255, 76, 76, 1)";
        Assertions.assertThat(registrasionPage.highlightedField()).contains(expHighlightedField);
    }

    @And("I check that pop-up with text Invalid name appear under field")
    public void iCheckThatPopUpWithTextInvalidNameAppearUnderField() {
        String expErrorMessageInvalidFormat = "Invalid format.";
        Assert.assertEquals(registrasionPage.getErrorInvalidFormat(), expErrorMessageInvalidFormat);
    }
}
