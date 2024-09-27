package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterationPage {
    private WebDriver driver;
    public RegisterationPage(WebDriver driver){
        this.driver = driver;
    }
    By firstNameTxt = By.id("firstname");
    By lastNameTxt = By.id("lastname");
    By emailTxt = By.id("email_address");
    By passwordTxt = By.id("password");
    By confPasswordTxt = By.id("confirmation");
    By registerBtn = By.cssSelector("button[title='Register']");
    By successMsg = By.cssSelector("li[class='success-msg']");
    public void userRegisteration(String fName, String lName, String email, String password){
        driver.findElement(firstNameTxt).sendKeys(fName);
        driver.findElement(lastNameTxt).sendKeys(lName);
        driver.findElement(emailTxt).sendKeys(email);
        driver.findElement(passwordTxt).sendKeys(password);
        driver.findElement(confPasswordTxt).sendKeys(password);
        driver.findElement(registerBtn).click();
    }
    public String SuccessMessage(){
        return driver.findElement(successMsg).getText();//Thank you for registering with Main Website Store.
    }

}
