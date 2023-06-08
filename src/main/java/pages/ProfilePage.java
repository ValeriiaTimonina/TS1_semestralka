package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
    private final WebDriver driver;
    public ProfilePage(WebDriver driver, String url) {
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
    public void setLoginName(String inputString) {
        clickCookies();
        driver.findElement(By.name("email")).sendKeys(inputString);
    }
    public void setLoginPassword(String inputString) {
        driver.findElement(By.name("password")).sendKeys(inputString);
    }
    public void clickSubmitButton() {
        driver.findElement(By.id("submit-login")).click();
    }
    public void clickEditProfileInfo() {
        driver.findElement(By.id("identity-link")).click();
    }
    public void editProfileInfo(String gender, String firstName, String lastname, String eMail, String oldPassword) {
        if (gender.equals("Male")) {
            driver.findElement(By.xpath("//input[@name='id_gender'][@value='1']")).click();
        }
        else {
            driver.findElement(By.xpath("//input[@name='id_gender'][@value='2']")).click();
        }
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys(firstName);
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys(lastname);
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(eMail);
        driver.findElement(By.name("password")).sendKeys(oldPassword);
        driver.findElement(By.name("newsletter")).click();
    }
    public void saveChangesAfterEdit() {
        driver.findElement(By.xpath("//button[@class='btn btn-primary form-control-submit']")).click();
    }
    public String checkDataAfterEdit() {
        return driver.findElement(By.name("firstname")).getAttribute("value") +
                driver.findElement(By.name("lastname")).getAttribute("value") +
                driver.findElement(By.name("email")).getAttribute("value");
    }
    public void clickLogOff() {
        driver.findElement(By.cssSelector(".text-sm-center > a")).click();
    }
    public void clickAddress() {
        driver.findElement(By.xpath("//a[@id='address-link']/span")).click();
    }
    public void addNewAddress(String alias, String firstName, String lastName, String company, String personalNumber,
                              String vatNumber, String street, String homeNumber, String postalCode, String city,
                              String phoneNumber) {
        driver.findElement(By.name("alias")).sendKeys(alias);
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys(firstName);
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys(lastName);
        driver.findElement(By.name("company")).sendKeys(company);
        driver.findElement(By.name("dni")).sendKeys(personalNumber);
        driver.findElement(By.name("vat_number")).sendKeys(vatNumber);
        driver.findElement(By.name("address1")).sendKeys(street);
        driver.findElement(By.name("address2")).sendKeys(homeNumber);
        driver.findElement(By.name("postcode")).sendKeys(postalCode);
        driver.findElement(By.name("city")).sendKeys(city);
        driver.findElement(By.name("phone")).sendKeys(phoneNumber);
    }
    public void clickSaveAddress() {
        driver.findElement(By.cssSelector(".btn")).click();
    }
}
