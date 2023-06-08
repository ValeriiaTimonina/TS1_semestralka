package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final WebDriver driver;

    public ShoppingCart(WebDriver driver, String url) {
        this.driver = driver;
        driver.get(url);
        PageFactory.initElements(driver, this);
    }
    public void addItemToCart() throws InterruptedException {
        driver.findElement(By.cssSelector(".product-miniature:nth-child(1) .b-lazy")).click();
        driver.findElement(By.cssSelector(".add-to-cart")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#js-cart-sidebar .btn")).click();
    }
    public void deleteItemFromCart() {
        driver.findElement(By.cssSelector(".remove-from-cart > .float-xs-left")).click();
    }

    public void clickOrderConfirmation() {
        driver.findElement(By.cssSelector(".text-sm-center > .btn")).click();
    }

    public void setFirstName(String firstName) {
        driver.findElement(By.cssSelector(".firstname:nth-child(1) .form-control")).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        driver.findElement(By.cssSelector(".lastname .live")).sendKeys(lastName);
    }

    public void setAddress(String firstAddress) {
        driver.findElement(By.name("address1")).sendKeys(firstAddress);
    }

    public void setCity(String secondAddress) {
        driver.findElement(By.name("city")).sendKeys(secondAddress);
    }

    public void setPostalCode(String postalCode) {
        driver.findElement(By.name("postcode")).sendKeys(postalCode);
    }

    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(By.name("phone")).sendKeys(phoneNumber);
    }

    public void chooseShipmentType() {
        driver.findElement(By.xpath("//input[@id='delivery_option_19']")).click();
    }

    public void choosePaymentType() {
        driver.findElement(By.xpath("//input[@id='payment-option-2']")).click();
    }
}
