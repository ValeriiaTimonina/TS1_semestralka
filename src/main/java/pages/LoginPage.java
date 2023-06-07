package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage(WebDriver driver, String url) {
        this.driver = driver;
        driver.get(url);
        PageFactory.initElements(driver, this);
    }

    public void clickCookies() {
        try {
            driver.findElement(By.id("AcceptAll")).click();
        } catch (Exception var2) {
            System.out.print("");
        }
    }

    public void setLoginName(String loginString) {
        clickCookies();
        driver.findElement(By.name("email")).sendKeys(loginString);
    }

    public void setLoginPassword(String loginString) {
        driver.findElement(By.name("password")).sendKeys(loginString);
    }

    public void clickSubmitButton() {
        driver.findElement(By.id("submit-login")).click();
    }
}
