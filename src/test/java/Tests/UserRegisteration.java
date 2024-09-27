package Tests;

import Pages.HomePage;
import Pages.RegisterationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserRegisteration extends TestBase{
    HomePage homePage;
    RegisterationPage registerationPage;
    String fName = fakeData.name().firstName();
    String lName = fakeData.name().lastName();
    String email = fakeData.internet().emailAddress();
    String password = fakeData.number().digits(8);
    @Test
    public void userCanRegisterSuccessfully(){
        homePage = new HomePage(driver);
        homePage.openRegisterPage();
        registerationPage = new RegisterationPage(driver);
        registerationPage.userRegisteration(fName,lName,email,password);
        Assert.assertEquals(registerationPage.SuccessMessage(),"Thank you for registering with Main Website Store.");
    }
}
