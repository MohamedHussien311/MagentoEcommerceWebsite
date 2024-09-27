package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    By mobileLink = By.cssSelector("a.level0");
    By accountLink = By.cssSelector("a[class='skip-link skip-account'] span[class='label']");
    By registerLink = By.linkText("Register");
    By tvLink = By.cssSelector("li[class='level0 nav-2 last']");
    public void openMobilePage(){
        driver.findElement(mobileLink).click();
    }
    public void openRegisterPage(){
        driver.findElement(accountLink).click();
        driver.findElement(registerLink).click();
    }
    public void openTVPage(){
        driver.findElement(tvLink).click();
    }
}
