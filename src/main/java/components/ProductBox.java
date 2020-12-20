package components;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ProductBox {

    private WebDriver webDriver;

    private WebElement image;
    private String name;
    private String regularPrice;
    private String discountPercentage;
    private String price;
    private WebElement productFlag;

    public ProductBox(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public ProductBox(WebElement image, String name, String regularPrice, String discountPercentage, String price, WebElement productFlag) {
        this.image = image;
        this.name = name;
        this.regularPrice = regularPrice;
        this.discountPercentage = discountPercentage;
        this.price = price;
        this.productFlag = productFlag;
    }

    public List<ProductBox> getAllItems(By boxContainers){
        List<ProductBox> productBoxes = new ArrayList<>();
        List<WebElement> boxElements = webDriver.findElements(boxContainers);
        for (WebElement boxElement: boxElements){
            String name  = boxElement.findElement(By.xpath("//div//h3[@class='h3 product-title']")).getText();
            WebElement image = boxElement.findElement(By.xpath("//div[contains(@class, 'thumbnail-container')]//a//img"));
            String regularPrice = boxElement.findElement(By.xpath("//div//span[@class='regular-price']")).getText();
            String discountPercentage = boxElement.findElement(By.xpath("//div//span[@class='discount-percentage discount-product']")).getText();
            String price = boxElement.findElement(By.xpath("//div//span[@class='price']")).getText();
            WebElement productFlag = boxElement.findElement(By.xpath("//div//ul//li[@class='product-flag new']"));
        ProductBox productBox = new ProductBox(image,name,regularPrice,discountPercentage,price,productFlag);
        productBoxes.add(productBox);
            }
        return productBoxes;
    }
}




