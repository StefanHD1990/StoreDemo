import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SaleTest extends BaseTest{

    ChromeDriver driver;
    WebDriverWait wait;
    ProductPage productPage;
    InfoProduct infoProduct;
    NavPage naviPage;
    CartPage cartPage;

    @BeforeMethod
    public void  SetUp(){
        driver = openBrowser();
        productPage = new ProductPage(driver);
        infoProduct = new InfoProduct(driver);
        naviPage = new NavPage(driver);
        cartPage = new CartPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void  BuyTwoProducts(){
        productPage.ClickOnSamsung();
        infoProduct.ClickAddToCart();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        naviPage.ClickHome();
        productPage.ClickNexus();
        infoProduct.ClickAddToCart();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        naviPage.ClickCart();
        cartPage.ClickPlaceOrder();
        cartPage.name.sendKeys("Stefan");
        cartPage.country.sendKeys("Srbija");
        cartPage.city.sendKeys("Beograd");
        cartPage.card.sendKeys("245246");
        cartPage.mount.sendKeys("April");
        cartPage.year.sendKeys("2023");
        cartPage.purchase.click();

        Assert.assertEquals(cartPage.GetInfoMessage(), "Thank you for your purchase!");

    }

    @Test
    public void  BuyTwoOnProducts(){
        productPage.ClickOnSamsung();
        infoProduct.ClickAddToCart();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        naviPage.ClickHome();
        naviPage.ClickLaptop();
        productPage.ClickOnNexus();
        infoProduct.ClickAddToCart();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        naviPage.ClickHome();
        naviPage.ClickCart();
        cartPage.ClickPlaceOrder();
        cartPage.name.sendKeys("Stefan");
        cartPage.country.sendKeys("Srbija");
        cartPage.city.sendKeys("Beograd");
        cartPage.card.sendKeys("245246");
        cartPage.mount.sendKeys("April");
        cartPage.year.sendKeys("2023");
        cartPage.purchase.click();

        Assert.assertEquals(cartPage.GetInfoMessage(), "Thank you for your purchase!");

    }

    @AfterMethod
    public void After(){
        driver.quit();
    }
}
