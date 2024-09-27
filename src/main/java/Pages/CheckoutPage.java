package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CheckoutPage {
    private final WebDriver driver;
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
    By addressTxt = By.cssSelector("input[class='input-text  required-entry'][id='billing:street1']");
    By countryTxt = By.name("billing[country_id]"); //dropdown list
    By cityTxt = By.name("billing[city]");
    By zipCode = By.name("billing[postcode]");
    By phoneTxt = By.name("billing[telephone]");
    By continueBtn = By.cssSelector("button[onclick='billing.save()']");
    By continueBtn2 = By.cssSelector("button[onclick='shippingMethod.save()']");
    By selectMoneyOrder = By.cssSelector("input[title='Check / Money order']");
    By continueBtn3 = By.cssSelector("button[onclick='payment.save()']");
    By subtotalCost = By.cssSelector("tr[class='first'] span[class='price']");// $615
    By totalCost = By.cssSelector("strong span[class='price']");// $620
    By placeOrderBtn = By.cssSelector("button[onclick='review.save();']");
    By orderID = By.xpath("//div[@class='main-container col1-layout']//p[1]");
    public void orderCheckout(String address,String country,String city,String zip,String phoneNo){
        driver.findElement(addressTxt).sendKeys(address);
        Select select = new Select(driver.findElement(countryTxt));
        select.selectByVisibleText(country);
        driver.findElement(cityTxt).sendKeys(city);
        driver.findElement(zipCode).sendKeys(zip);
        driver.findElement(phoneTxt).sendKeys(phoneNo);
        driver.findElement(continueBtn).click();
        driver.findElement(continueBtn2).click();
        driver.findElement(selectMoneyOrder).click();
        driver.findElement(continueBtn3).click();
        Assert.assertTrue(driver.findElement(subtotalCost).getText().contains("$615.00"));
        Assert.assertTrue(driver.findElement(totalCost).getText().contains("$620.00"));
        driver.findElement(placeOrderBtn).click();
        System.out.println(driver.findElement(orderID).getText());
    }

}
