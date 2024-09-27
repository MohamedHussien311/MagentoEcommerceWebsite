package Tests;

import Pages.HomePage;
import Pages.MobilePage;
import Pages.ProductsCartPage;
import org.testng.annotations.Test;

public class ProductCartTest extends TestBase{
    HomePage homePage;
    MobilePage mobilePage;
    ProductsCartPage productsCartPage;
    @Test
    public void UserCannotExceedAvailableQuantityOfProduct() {
        homePage = new HomePage(driver);
        homePage.openMobilePage();
        mobilePage = new MobilePage(driver);
        mobilePage.addProductToCart();
        productsCartPage = new ProductsCartPage(driver);
        productsCartPage.updateQuantity();
        productsCartPage.EmptyCart();
    }
}
