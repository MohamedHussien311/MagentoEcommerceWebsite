package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
public class ProductsCartPage {
    private final WebDriver driver;
    public ProductsCartPage(WebDriver driver) {
        this.driver = driver;
    }
    By productQuantity = By.cssSelector("input[title='Qty']");
    By updateQuantity = By.cssSelector("button.button.btn-update");
    By errorMessage = By.className("error-msg");
    By emptyCartLink = By.id("empty_cart_button");
    By cartIsEmptyMessage = By.cssSelector("h1");
    By checkoutBtn = By.xpath("//ul[@class='checkout-types top']" +
            "//li//button[@title='Proceed to Checkout']//span//span[contains(text(),'Proceed to Checkout')]");
    public void updateQuantity() {
        driver.findElement(productQuantity).clear();
        driver.findElement(productQuantity).sendKeys("1000");
        driver.findElement(updateQuantity).click();
        Assert.assertTrue(driver.findElement(errorMessage).getText().contains("Some of the products cannot be ordered in requested quantity."));
    }
    public void EmptyCart() {
        driver.findElement(emptyCartLink).click();
        Assert.assertTrue(driver.findElement(cartIsEmptyMessage).getText().equalsIgnoreCase("Shopping Cart is Empty"));
    }
    public void openCheckoutPage(){
        driver.findElement(checkoutBtn).click();
    }
}
