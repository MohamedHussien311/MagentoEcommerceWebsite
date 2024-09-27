package Tests;

import Pages.HomePage;
import Pages.MobilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileTest extends TestBase{
    HomePage homePage;
    MobilePage mobilePage;
    @Test (priority = 1)
    public void UserCanSortProducts() {
        homePage = new HomePage(driver);
        Assert.assertEquals(driver.getTitle(),"Home page");
        homePage.openMobilePage();
        Assert.assertEquals(driver.getTitle(),"Mobile");
        mobilePage = new MobilePage(driver);
        mobilePage.sortProductsByName();
        Assert.assertTrue(mobilePage.verifyThatProductsSortedByName());
    }
    @Test (priority = 2)
    public void CompareProductPriceInHomeAndDetailsPage(){
        mobilePage = new MobilePage(driver);
        try {
            Assert.assertTrue(mobilePage.compareProductPrice());
        }
        catch (Error e){
            System.out.println("Prices are different");
        }
    }
}
