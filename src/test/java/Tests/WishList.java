package Tests;

import Pages.HomePage;
import Pages.RegisterationPage;
import Pages.TVPage;
import Pages.WishListPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WishList extends TestBase{
    HomePage homePage;
    WishListPage wishListPage;
    TVPage tvPage;
    RegisterationPage registerationPage;
    String fName = fakeData.name().firstName();
    String lName = fakeData.name().lastName();
    String email = fakeData.internet().emailAddress();
    String password = fakeData.number().digits(8);
    String emailAddress = fakeData.internet().emailAddress();
    String message = "Hi friend, Check this product";
    @Test(priority = 1)
    public void userCanRegisterSuccessfully(){
        homePage = new HomePage(driver);
        homePage.openRegisterPage();
        registerationPage = new RegisterationPage(driver);
        registerationPage.userRegisteration(fName,lName,email,password);
        Assert.assertEquals(registerationPage.SuccessMessage(),"Thank you for registering with Main Website Store.");
    }
    @Test(dependsOnMethods = {"userCanRegisterSuccessfully"})
    public void userCanShareWishlist(){
        homePage = new HomePage(driver);
        homePage.openTVPage();
        tvPage = new TVPage(driver);
        tvPage.addProductToWishList();
        wishListPage = new WishListPage(driver);
        wishListPage.openShareWishList();
        wishListPage.shareWishlist(emailAddress,message);
        Assert.assertEquals(wishListPage.SharedSuccessfully(),"Your Wishlist has been shared.");
    }
}
