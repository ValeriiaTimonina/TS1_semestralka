package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

import pages.Register;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterTest {
    WebDriver driver;
    Register register;

    @BeforeEach
    public void browserWindowCreation() {
        driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        register = new Register(driver, "https://simplyboutique.cz/prihlaseni?create_account=1");
    }

    @Test
    public void registerTest() {
        register.registrationProcess("Female", "Mary", "Sew",
                "MarySew@email.com", "1234567890");
        register.clickSubmit();
        String expectedUrl = "https://simplyboutique.cz/";
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }
}
