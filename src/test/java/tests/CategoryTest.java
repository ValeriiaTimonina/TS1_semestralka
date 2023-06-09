package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import pages.items.Category;

public class CategoryTest {
    WebDriver driver;
    Category category;

    @BeforeEach
    public void browserWindowCreation() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().setPosition(new Point(0, 0));
        this.driver.manage().window().setSize(new Dimension(1920, 1080));
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        this.category = new Category(driver, "https://simplyboutique.cz/64-panske");
    }

    @AfterEach
    public void closeBrowserWindow(){ driver.quit(); }

    @Test
    public void shouldSortItemsInDescendingOrder() throws InterruptedException {
        String expectedUrl = "https://simplyboutique.cz/64-panske?order=product.price.desc";
        category.sortBy();
        Thread.sleep(5000);
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }
    @Test
    public void shouldReturnItemsLinks() {
        assertEquals(12, category.getResultsLinks(12).size());
    }
}
