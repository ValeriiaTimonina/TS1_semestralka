//package tests;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import pages.HomePage;
//
//import java.io.FileWriter;
//import java.io.IOException;
//import java.time.Duration;
//import java.util.ArrayList;
//
//public class CsvTests {
//    private WebDriver driver;
//    HomePage homePage;
//
//    @BeforeEach
//    public void browserWindowCreation() {
//        this.driver = new ChromeDriver();
//        this.driver.manage().window().setPosition(new Point(0, 0));
//        this.driver.manage().window().setSize(new Dimension(1920, 1080));
//        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//        this.homePage = new HomePage(this.driver, "https://simplyboutique.cz");
//    }
//
//    @AfterEach
//    public void closeBrowserWindow() { driver.quit(); }
//
//    @Test
//    public void shouldReturnCartInCsvFormat() {
//
//        ArrayList<String> links = new ArrayList<>();
//        homePage.clickSearch();
//
//        //Search -- 1
//        Search search = new Search(driver, driver.getCurrentUrl());
//        search.setKeyword("Lipstick");
//        search.submitSearch();
//
//        //Add the link to the links
//        links.add(driver.getCurrentUrl());
//
//        //Product
//        Product product = new Product(driver, driver.getCurrentUrl());
//        product.addToCart();
//
//        //Shopping Cart
//        ShoppingCart shoppingCart = new ShoppingCart(driver, driver.getCurrentUrl());
//        shoppingCart.continueShopping();
//
//        product.clickSearch();
//
//        //Search -- 2
//        search.submitModel();
//        search.submitDescription();
//        search.setKeyword("obsession");
//        search.submitSearch();
//        //shows three of them
//        search.setCategory("   Men");
//        search.submitSearch();
//        //only one
//
//        //Add the link to the links
//        links.add(driver.getCurrentUrl());
//
//        product.addToCart();
//        shoppingCart.continueShopping();
//        product.clickSearch();
//
//        //Search -- 3
//        search.submitSearch();
//        //nothing to show
//        search.setKeyword("mas");
//        search.submitDescription();
//        search.submitSearch();
//        search.clickOnTheArmaniToiletWaterCart();
//        //Add the link to the links
//        links.add("https://automationteststore.com/index.php?rt=product/product&product_id=81");
//
//        search.clickShoppingCart();
//
//        //CSV
//        StringBuilder dataForCSV = new StringBuilder();
//
//        for (String link : links) {
//            System.out.println(link);
//            product = new Product(driver, link);
//            dataForCSV.append(product.getName()).append(", ");
//            dataForCSV.append(product.getPrice()).append("\n");
//        }
//
//        // Writing in CSV
//        try {
//            FileWriter myWriter = new FileWriter("src/test/resources/searched_products.csv");
//            myWriter.write(dataForCSV.toString());
//            myWriter.close();
//        } catch (IOException ee) {
//            ee.printStackTrace();
//        }
//        //
//
//        product.clickShoppingCart();
//        shoppingCart.checkout();
//
//        //LoginPage
//        LoginPage loginPage = new LoginPage(driver, driver.getCurrentUrl());
//        loginPage.setLoginName("Wellplay");
//        loginPage.setLoginPassword("Qwerty12345");
//        //loginPage.submitLogin();
//
//        //Checkout
//        Checkout checkout = new Checkout(driver, driver.getCurrentUrl());
//        checkout.clickBack();
//        checkout.setBackComment("It is the best shop I have ever seen! Please, leave the order near my door.");
//        checkout.clickReturnPolicyAgree();
//        checkout.clickBackContinue();
//        checkout.confirmOrder();
//        checkout.clickContinue();
//
//        homePage.clickMyWishList();
//
//        //ProfilePage
//        ProfilePage profilePage = new ProfilePage(driver, driver.getCurrentUrl());
//        profilePage.clickLogOff();
//
//        //END
//    }
//}
