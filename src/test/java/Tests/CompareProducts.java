package Tests;

import Pages.CompareProductsPage;
import Pages.HomePage;
import Pages.MobilePage;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CompareProducts extends TestBase{
    HomePage homePage;
    MobilePage mobilePage;
    CompareProductsPage compareProductsPage;
    @Test
    public void UserCanCompareProducts(){
        homePage = new HomePage(driver);
        homePage.openMobilePage();
        mobilePage = new MobilePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        mobilePage.AddProductsToCompareList();
        mobilePage.openCompareList();
        Set<String> handles = driver.getWindowHandles();
        List<String> handleList = new ArrayList<>(handles);
        driver.switchTo().window(handleList.get(1));
        compareProductsPage = new CompareProductsPage(driver);
        compareProductsPage.verifySony();
        compareProductsPage.verifyIphone();
        compareProductsPage.closeWindow();
    }
}
