package tests;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import pages.LoginPage;


public class LoginPageTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeEach
    public void browserWindowCreation() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().setPosition(new Point(0, 0));
        this.driver.manage().window().setSize(new Dimension(1920, 1080));
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        this.loginPage = new LoginPage(driver, "https://simplyboutique.cz/prihlaseni?back=my-account");
    }

    @AfterEach
    public void closeBrowserWindow() { driver.quit(); }

    @Test
    public void loginTest() throws InterruptedException {
        loginPage.setLoginName("uporoego@fel.cvut.cz");
        loginPage.setLoginPassword("1234567890");
        loginPage.clickSubmitButton();
        String expectedUrl = "https://simplyboutique.cz/muj-ucet";
        Thread.sleep(5000);
        assertEquals(expectedUrl, driver.getCurrentUrl());
        Thread.sleep(2000);
    }
}

