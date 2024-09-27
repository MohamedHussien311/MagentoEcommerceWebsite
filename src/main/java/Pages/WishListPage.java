package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishListPage {
    private WebDriver driver;
    public WishListPage(WebDriver driver){
        this.driver = driver;
    }
    By shareWishListBtn = By.name("save_and_share");
    By emailAddressTxt = By.cssSelector("textarea[class='validate-emails required-entry']");
    By messageTxt = By.id("message");
    By shareBtn = By.cssSelector("button[title='Share Wishlist']");
    By sharedSuccessfully = By.cssSelector("li[class='success-msg']");
    By addToCartBtn = By.cssSelector("button[class='button btn-cart']");
    public void openShareWishList(){
        driver.findElement(shareWishListBtn).click();
    }
    public void shareWishlist(String email, String message){
        driver.findElement(emailAddressTxt).sendKeys(email);
        driver.findElement(messageTxt).sendKeys(message);
        driver.findElement(shareBtn).click();
    }
    public String  SharedSuccessfully(){
        return driver.findElement(sharedSuccessfully).getText();//Your Wishlist has been shared.
    }
    public void addProductToCart(){
        driver.findElement(addToCartBtn).click();
    }
}
