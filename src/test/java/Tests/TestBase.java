package Tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static java.time.Duration.ofSeconds;

public class TestBase {
    protected WebDriver driver;
    protected Faker fakeData = new Faker();
    @BeforeSuite
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(300,10));
        driver.get("http://live.techpanda.org/index.php/");
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
    }
    @AfterSuite
    public void closeDriver(){
        driver.quit();
    }
}
