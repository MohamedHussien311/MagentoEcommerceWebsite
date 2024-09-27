package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MobilePage {
    private WebDriver driver;
    public MobilePage(WebDriver driver){
        this.driver = driver;
    }
    By dropdownList = By.cssSelector("select[title='Sort By']");
    By sonyPriceInHomePage = By.id("product-price-1");
    By sonyDetailsLink = By.id("product-collection-image-1");
    By sonyPriceDetails = By.cssSelector("span#product-price-1.regular-price");
    By addToCartLink = By.xpath("//ul[1]/li[2]/div[1]/div[3]/button[1]");
    By addSonyToCompareBtn = By.xpath("//li[2]//div[1]//div[3]//ul[1]//li[2]//a[1]");
    By addIphoneToCompareBtn = By.xpath("//li[3]//div[1]//div[3]//ul[1]//li[2]//a[1]");
    By compareBtn = By.cssSelector("button[title='Compare']");
    public void sortProductsByName(){
        Select select = new Select(driver.findElement(dropdownList));
        select.selectByVisibleText("Name");
    }
    public boolean verifyThatProductsSortedByName(){
        List<WebElement> productList = driver.findElements(By.cssSelector("ul.products-grid products-grid--max-4-col.first.last.odd"));
        List<String>names = new ArrayList<>();
        for (WebElement i : productList)
            names.add(i.getText());
        List<String> sortedNames;
        sortedNames = names;
        Collections.sort(sortedNames);
        return sortedNames.equals(names);
    }
    public boolean compareProductPrice(){
        String sonyPrice = driver.findElement(sonyPriceInHomePage).getText();
        driver.findElement(sonyDetailsLink).click();
        return driver.findElement(sonyPriceDetails).getText().equals(sonyPrice);
    }
    public void addProductToCart(){
        driver.findElement(addToCartLink).click();
    }
    public void AddProductsToCompareList(){
        driver.findElement(addSonyToCompareBtn).click();
        driver.findElement(addIphoneToCompareBtn).click();
    }
    public void openCompareList(){
        driver.findElement(compareBtn).click();
    }
}
