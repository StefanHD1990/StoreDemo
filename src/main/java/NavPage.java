import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavPage extends  BasePage{

    @FindBy(xpath = "//a[text()= 'Cart']")
    WebElement cart;

    @FindBy(css = " li[class='nav-item active'] a[class='nav-link']")
    WebElement home;

    @FindBy(linkText = "Laptops")
    WebElement laptop;

    public  NavPage (ChromeDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void ClickCart(){ cart.click();}
    public void ClickHome(){home.click();}

    public void ClickLaptop() {
        laptop.click();
    }
}
