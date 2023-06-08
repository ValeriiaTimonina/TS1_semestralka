package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ProfilePage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfilePageTest {
    WebDriver driver;
    ProfilePage profilePage;

    @BeforeEach
    public void browserWindowCreation() throws InterruptedException {
        this.driver = new ChromeDriver();
        this.driver.manage().window().setPosition(new Point(0, 0));
        this.driver.manage().window().setSize(new Dimension(1920, 1080));
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        profilePage = new ProfilePage(driver, "https://simplyboutique.cz/prihlaseni?back=my-account");
        profilePage.setLoginName("onlyTesting@mail.com");
        profilePage.setLoginPassword("1234567890");
        profilePage.clickSubmitButton();
        Thread.sleep(5000);
    }

    @AfterEach
    public void closeBrowserWindow() { driver.quit(); }

    @Test
    public void shouldEditProfileInformation() {
        String expectedString = "MaryJaneSpiderman@UWU.com";
        profilePage.clickEditProfileInfo();
        profilePage.editProfileInfo("Female", "Mary",
                "Jane", "Spiderman@UWU.com", "1234567890");

        profilePage.saveChangesAfterEdit();
        assertEquals(expectedString, profilePage.checkDataAfterEdit());
    }
    @Test
    public void shouldExecuteLogOutProcess() {
        String expectedUrl = "https://simplyboutique.cz/prihlaseni?back=my-account";
        profilePage.clickLogOff();
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    @Test
    public void shouldAddFirstAddress() {
        String expectedUrl = "https://simplyboutique.cz/adresy";
        profilePage.clickAddress();
        profilePage.addNewAddress("For", "Testing", "Purpose", "Used", "123456",
                "7890", "Maybe", "10", "10000", "People", "123456789");
        profilePage.clickSaveAddress();
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }
}
