package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Register {
    private final WebDriver driver;
    public Register(WebDriver driver, String url) {
        this.driver = driver;
        driver.get(url);
        PageFactory.initElements(driver, this);
    }

    public void registrationProcess(String gender, String firstName, String lastname, String eMail, String password) {
        if (gender.equals("Male")) {
            driver.findElement(By.xpath("//input[@name='id_gender'][@value='1']")).click();
        } else {
            driver.findElement(By.xpath("//input[@name='id_gender'][@value='2']")).click();
        }
        driver.findElement(By.name("firstname")).sendKeys(firstName);
        driver.findElement(By.name("lastname")).sendKeys(lastname);
        driver.findElement(By.name("email")).sendKeys(eMail);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("newsletter")).click();
        driver.findElement(By.xpath("//input[@id='shaim_gdpr_active']")).click();
    }

    public void clickSubmit() {
        driver.findElement(By.cssSelector(".form-control-submit")).click();
    }
}
