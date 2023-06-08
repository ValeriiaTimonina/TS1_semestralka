package tests;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.items.TemplateForCSV;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TemplateForCSVTest {
    private WebDriver driver;
    TemplateForCSV templateForCSV;

    @BeforeEach
    public void browserWindowCreation() {
        this.driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        templateForCSV = new TemplateForCSV(driver, "https://simplyboutique.cz/prihlaseni?back=my-account");
    }

    @Test
    public void priceTesting() {
        templateForCSV.clickCookies();
        driver.get("https://simplyboutique.cz/66-novinky?order=product.price.desc");
        ArrayList<String> links  = templateForCSV.getResultsLinks(8);
        try {
            FileWriter myWriter = new FileWriter("src/output/eight_the_most_expensive_items.csv");
            for (String link : links) {
                myWriter.write(link + "\n");
            }
            myWriter.close();
        } catch (IOException ee) {
            ee.printStackTrace();
        }
    }

    @Test(dataProvider="testdata")
    public void loginWithPasswordFromCSV(String login, String password) throws InterruptedException {
        this.driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        templateForCSV = new TemplateForCSV(driver, "https://simplyboutique.cz/prihlaseni?back=my-account");
        templateForCSV.setLoginName(login);
        templateForCSV.setLoginPassword(password);
        templateForCSV.clickSubmitButton();
        Thread.sleep(10000);
        assertEquals("Ověření se nezdařilo",
                driver.findElement(By.xpath("//section[@id='content']/section/div/ul/li")).getText());
        driver.quit();
    }

    @DataProvider(name="testdata")
    public Object[][] dpMethod() throws IOException, CsvValidationException {
        Object [][] data = new Object[10][2];
        CSVReader readCSV = new CSVReader(new FileReader("src/output/loginTest.csv"));
        String [] nextLine;
        int i = 0;
        while ((nextLine = readCSV.readNext())!= null) {
            data[i][0] = nextLine[0];
            data[i][1] = nextLine[1];
            i++;
        }
        return data;
    }
}
