package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CompareProductsPage {
    private final WebDriver driver;
    public CompareProductsPage(WebDriver driver){
        this.driver = driver;
    }
    By sonyName = By.xpath("//a[normalize-space()='Sony Xperia']");
    By IphoneName = By.xpath("//a[normalize-space()='IPhone']");
    By closeWindowBtn = By.cssSelector("button[title='Close Window']");
    public void verifySony(){
        Assert.assertTrue(driver.findElement(sonyName).getText().equalsIgnoreCase("Sony Xperia"));
    }
    public void verifyIphone(){
        Assert.assertTrue(driver.findElement(IphoneName).getText().equalsIgnoreCase("IPhone"));
    }
    public void closeWindow(){
        driver.findElement(closeWindowBtn);
    }
}
