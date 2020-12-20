package stepdefs;

import components.HeaderTop;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import pages.MainPage;

import java.util.List;


public class HeaderTopStepdefs {
    HeaderTop headerTop = new HeaderTop();


    @Then("I check that <ListSClothesCategories> sub menu items appears")
    public void iCheckThatListSClothesCategoriesSubMenuItemsAppears(DataTable dataTable) {
        WebElement categoryClothes = headerTop.getClothesCategory();
        headerTop.hoverCategory(categoryClothes);
        List<String> clothes = dataTable.asList();
        WebElement clothesCategory = headerTop.getClothesCategory();
        Assertions.assertThat(headerTop.getSubMenuItems(clothesCategory)).isEqualTo(clothes);

    }

    @And("I check that <ListAccessoriesCategories> sub menu items appears")
    public void iCheckThatListAccessoriesCategoriesSubMenuItemsAppears(DataTable dataTable2) {
        WebElement categoryAccessories = headerTop.getAccessoriesCategories();
        headerTop.hoverCategory(categoryAccessories);
        List<String> accessories = dataTable2.asList();
        WebElement accessoriesCategory = headerTop.getAccessoriesCategories();
        Assertions.assertThat(headerTop.getSubMenuItems(accessoriesCategory)).isEqualTo(accessories);
    }

    @And("I check that no subcategory is displayed after hovering the mouse over ART")
    public void iCheckThatNoSubcategoryIsDisplayedAfterHoveringTheMouseOverART() {
        WebElement categoryArt = headerTop.getArtCategories();
        headerTop.hoverCategory(categoryArt);
        WebElement artCategory = headerTop.getAccessoriesCategories();
        Assertions.assertThat(headerTop.getSubMenuItems(artCategory)).isEmpty();
    }
}


