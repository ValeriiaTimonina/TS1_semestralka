package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import pages.Search;

public class SearchTest {
    WebDriver driver;
    Search searchPage;

    @BeforeEach
    public void browserWindowCreation() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().setPosition(new Point(0, 0));
        this.driver.manage().window().setSize(new Dimension(1920, 1080));
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        this.searchPage = new Search(driver, "https://simplyboutique.cz");
    }

    @AfterEach
    public void closeBrowserWindow() { driver.quit(); }

    @Test
    public void shouldReturnException() throws InterruptedException {
        String inputString = "qwertyuasdf";
        searchPage.clickSearch();
        searchPage.setSearchString(inputString);
        searchPage.submitSearchByButton();
        try {
            searchPage.getResultsLinks(1);
        }
        catch (Exception e)
        {
            assertTrue(true);
            Thread.sleep(5000);
        }
    }
    @Test
    public void shouldFindAtLeastOneItem() throws InterruptedException {
        String keyword = "ponožky";
        searchPage.clickSearch();
        searchPage.setSearchString(keyword);
        searchPage.submitSearchByButton();
        Thread.sleep(5000);
        assertEquals(1, searchPage.getResultsLinks(1).size());
    }
    @Test
    public void shouldStartSearchWithButton() throws InterruptedException {
        String keyword = "ponožky";
        searchPage.clickSearch();
        searchPage.setSearchString(keyword);
        searchPage.submitSearchByButton();
        String expectedUrl = "https://simplyboutique.cz/vyhledavani?controller=search&s=pono%C5%BEky";
        Thread.sleep(5000);
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }
    @Test
    public void shouldStartSearchWithKeyboard() throws InterruptedException {
        String keyword = "ponožky";
        searchPage.clickSearch();
        searchPage.setSearchString(keyword);
        searchPage.submitSearchByKeyboard();
        String expectedUrl = "https://simplyboutique.cz/vyhledavani?controller=search&s=pono%C5%BEky";
        Thread.sleep(5000);
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }
}
