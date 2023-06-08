package pages.items;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class TemplateForCSV {
    private final WebDriver driver;

    public TemplateForCSV(WebDriver driver, String url) {
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

    public ArrayList<String> getResultsLinks(int quantity) {
        WebElement resultList = driver.findElement(By.xpath("//div[@class='products row']"));
        List<WebElement> items = resultList.findElements(By.xpath("//div[@class='product-description']"));
        ArrayList<String> itemsLinks = new ArrayList<>();

        for (WebElement element : items.subList(0, quantity)) {
            itemsLinks.add(element.getText());
        }
        return itemsLinks;
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
}