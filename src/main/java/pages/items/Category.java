package pages.items;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private final WebDriver driver;
    public Category(WebDriver driver, String url) {
        this.driver = driver;
        driver.get(url);
        PageFactory.initElements(driver, this);
    }
    public void sortBy() {
        driver.findElement(By.cssSelector(".btn-unstyle")).click();
        driver.findElement(By.cssSelector(".select-list:nth-child(5)")).click();
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
