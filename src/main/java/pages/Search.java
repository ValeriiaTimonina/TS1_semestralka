package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class Search {

    private final WebDriver driver;

    public Search(WebDriver driver, String url) {
        this.driver = driver;
        driver.get(url);
        PageFactory.initElements(driver, this);
    }
    public void clickSearch() {
        clickCookies();
        driver.findElement(By.cssSelector(".search-wrapper > .search-button")).click();
    }
    public void clickCookies() {
        try {
            driver.findElement(By.id("AcceptAll")).click();
        } catch (Exception e) {
            System.out.print("");
        }
    }
    public void setSearchString(String inputString) {
        driver.findElement(By.name("s")).sendKeys(inputString);
    }
    public void submitSearchByButton() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    public void submitSearchByKeyboard() {
        driver.findElement(By.name("s")).sendKeys(Keys.ENTER);
    }
    public ArrayList<String> getResultsLinks(int quantity) {
        WebElement resultList = driver.findElement(By.xpath("//div[@class='products row']"));
        List<WebElement> items = resultList.findElements(By.xpath("//div[@class='thumbnail-container ']"));
        ArrayList<String> itemsLinks = new ArrayList<>();

        for (WebElement element : items.subList(0, quantity)) {
            itemsLinks.add(element.getAttribute("href"));
        }
        return itemsLinks;
    }
}
