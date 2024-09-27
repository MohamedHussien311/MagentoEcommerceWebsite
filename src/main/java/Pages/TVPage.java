package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TVPage {
    private WebDriver driver;
    public TVPage(WebDriver driver){
        this.driver = driver;
    }
    By addLGToWishListBtn = By.xpath("//li[1]//div[1]//div[3]//ul[1]//li[1]//a[1]");
    public void addProductToWishList(){
        driver.findElement(addLGToWishListBtn).click();
    }
}
