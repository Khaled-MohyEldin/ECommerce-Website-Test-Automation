package Pages;

import Utilities.Reusables;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends Reusables {
    WebDriver driver;
    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="userEmail")
    WebElement userEmail;

    @FindBy(id="userPassword")
    WebElement userPass;

    @FindBy(id="login")
    WebElement loginBtn;

    public ProductCatalogue loginApp (String email, String pass){
        userEmail.sendKeys(email);
        userPass.sendKeys(pass);
        loginBtn.click();
        super.handleOverlay();
        ProductCatalogue products = new ProductCatalogue(driver);
        return products;
    }
    public void goTo(){
        driver.get("https://rahulshettyacademy.com/client");
    }

}
