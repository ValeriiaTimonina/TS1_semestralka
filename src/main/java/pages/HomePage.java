package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver, String url) {
        this.driver = driver;
        driver.get(url);
        PageFactory.initElements(driver, this);
    }

    public void clickCookies() {
        try {
            driver.findElement(By.id("AcceptAll")).click();
        } catch (Exception e) {
            System.out.print("");
        }
    }

    public void clickLogin() {
        clickCookies();
        driver.findElement(By.cssSelector(".account-login > .hidden-md-down")).click();
    }

    public void clickRegister() {
        clickLogin();
        driver.findElement(By.cssSelector(".no-account > a")).click();
    }

    public void clickSearch() {
        clickCookies();
        driver.findElement(By.cssSelector(".search-wrapper > .search-button")).click();
    }

    public void clickMyWishList() {
        clickCookies();
        driver.findElement(By.cssSelector(".col-md-4 > #\\_desktop_an_wishlist .hidden-md-down")).click();
    }
}