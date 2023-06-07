package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import pages.HomePage;

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

    @AfterEach
    public void closeBrowserWindow() { driver.quit(); }

    @Test
    public void shouldMakeClickOnLoginButton() throws InterruptedException {
        String expectedUrl = "https://simplyboutique.cz/prihlaseni?back=my-account";
        homePage.clickLogin();
        Assertions.assertEquals(expectedUrl, this.driver.getCurrentUrl());
        Thread.sleep(5000);
    }
    @Test
    public void shouldMakeClickOnRegisterButton() throws InterruptedException {
        String expectedUrl = "https://simplyboutique.cz/prihlaseni?create_account=1";
        homePage.clickRegister();
        Assertions.assertEquals(expectedUrl, this.driver.getCurrentUrl());
        Thread.sleep(5000);
    }
    @Test
    public void shouldMakeClickOnSearchButton() throws InterruptedException {
        homePage.clickSearch();
        String expectedString = this.driver.findElement(By.xpath("//div[@class='search-widget open']")).getAttribute("visibility");
        Assertions.assertNull(expectedString);
        Thread.sleep(5000);
    }
    @Test
    public void shouldMakeClickOnMyWishlistButton() throws InterruptedException {
        String expectedUrl = "https://simplyboutique.cz/module/an_wishlist/list";
        homePage.clickMyWishList();
        Assertions.assertEquals(expectedUrl, this.driver.getCurrentUrl());
        Thread.sleep(5000);
    }
}