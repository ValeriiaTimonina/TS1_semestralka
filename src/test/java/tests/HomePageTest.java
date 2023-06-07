package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

import java.time.Duration;

public class HomePageTest {
    WebDriver driver;
    HomePage homePage;

    @BeforeEach
    public void browserWindowCreation() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().setPosition(new Point(0, 0));
        this.driver.manage().window().setSize(new Dimension(1920, 1080));
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        this.homePage = new HomePage(this.driver, "https://simplyboutique.cz");
    }

    @Test
    public void shouldMakeClickOnLoginButton() {
        String expectedUrl = "https://simplyboutique.cz/prihlaseni?back=my-account";
        this.homePage.clickLogin();
        Assertions.assertEquals(expectedUrl, this.driver.getCurrentUrl());
        this.driver.quit();
    }

    @Test
    public void shouldMakeClickOnRegisterButton() {
        String expectedUrl = "https://simplyboutique.cz/prihlaseni?create_account=1";
        this.homePage.clickRegister();
        Assertions.assertEquals(expectedUrl, this.driver.getCurrentUrl());
        this.driver.quit();
    }

    @Test
    public void shouldMakeClickOnSearchButton() {
        this.homePage.clickSearch();
        String expectedString = this.driver.findElement(By.xpath("//div[@class='search-widget open']")).getAttribute("visibility");
        Assertions.assertNull(expectedString);
        this.driver.quit();
    }

    @Test
    public void shouldMakeClickOnMyWishlistButton() {
        String expectedUrl = "https://simplyboutique.cz/module/an_wishlist/list";
        this.homePage.clickMyWishList();
        Assertions.assertEquals(expectedUrl, this.driver.getCurrentUrl());
        this.driver.quit();
    }
}