package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
            this.driver.findElement(By.id("AcceptAll")).click();
        } catch (Exception var2) {
            System.out.print("");
        }

    }

    public void clickLogin() {
        this.clickCookies();
        this.driver.findElement(By.cssSelector(".account-login > .hidden-md-down")).click();
    }

    public void clickRegister() {
        this.clickLogin();
        this.driver.findElement(By.cssSelector(".no-account > a")).click();
    }

    public void clickSearch() {
        this.clickCookies();
        this.driver.findElement(By.cssSelector(".search-wrapper > .search-button")).click();
    }

    public void clickMyWishList() {
        this.clickCookies();
        this.driver.findElement(By.cssSelector(".col-md-4 > #\\_desktop_an_wishlist .hidden-md-down")).click();
    }
}