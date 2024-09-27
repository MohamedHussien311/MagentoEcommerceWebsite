package Tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends TestBase{
    HomePage homePage;
    RegisterationPage registerationPage;
    TVPage tvPage;
    WishListPage wishListPage;
    ProductsCartPage productsCartPage;
    CheckoutPage checkoutPage;
    String fName = fakeData.name().firstName();
    String lName = fakeData.name().lastName();
    String email = fakeData.internet().emailAddress();
    String password = fakeData.number().digits(8);
    String address = fakeData.address().streetAddress();
    String city = fakeData.address().city();
    String country = fakeData.country().name();
    String zipCode = fakeData.address().zipCode();
    String phone = fakeData.number().digits(11);
    @Test(priority = 1)
    public void userCanRegisterSuccessfully(){
        homePage = new HomePage(driver);
        homePage.openRegisterPage();
        registerationPage = new RegisterationPage(driver);
        registerationPage.userRegisteration(fName,lName,email,password);
        Assert.assertEquals(registerationPage.SuccessMessage(),"Thank you for registering with Main Website Store.");
    }
    @Test(dependsOnMethods = {"userCanRegisterSuccessfully"})
    public void userCanCheckoutOrders(){
        homePage = new HomePage(driver);
        homePage.openTVPage();
        tvPage = new TVPage(driver);
        tvPage.addProductToWishList();
        wishListPage = new WishListPage(driver);
        wishListPage.addProductToCart();
        productsCartPage = new ProductsCartPage(driver);
        productsCartPage.openCheckoutPage();
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.orderCheckout(address,country,city,zipCode,phone);
    }
}
