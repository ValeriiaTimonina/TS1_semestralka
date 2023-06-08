package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ShoppingCart;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {
    WebDriver driver;
    ShoppingCart shoppingCart;

    @BeforeEach
    public void browserWindowCreation() throws InterruptedException {
        this.driver = new ChromeDriver();
        this.driver.manage().window().setPosition(new Point(0, 0));
        this.driver.manage().window().setSize(new Dimension(1920, 1080));
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        shoppingCart = new ShoppingCart(driver, "https://simplyboutique.cz/64-panske");
        Thread.sleep(5000);
    }

    @Test
    public void addItemToCart() throws InterruptedException {
        String expectedUrl = "https://simplyboutique.cz/kosik?action=show";
        shoppingCart.addItemToCart();
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    @Test
    public void deleteItemFromCart() throws InterruptedException {
        String actualString = driver.findElement(By.className("no-items")).getAttribute("display");
        shoppingCart.addItemToCart();
        shoppingCart.deleteItemFromCart();
        assertNull(actualString);
    }

    @Test
    public void orderConfirmation() throws InterruptedException {
        shoppingCart.addItemToCart();
        shoppingCart.clickOrderConfirmation();
        Thread.sleep(1000);
        shoppingCart.setFirstName("Mary");
        shoppingCart.setLastName("Jane");
        shoppingCart.setAddress("Technicka 2");
        shoppingCart.setCity("Praha");
        shoppingCart.setPostalCode("10000");
        shoppingCart.setPhoneNumber("123456789");
        Thread.sleep(1000);
        shoppingCart.chooseShipmentType();
        Thread.sleep(1000);
        shoppingCart.choosePaymentType();
        assertTrue(true);
    }
}
