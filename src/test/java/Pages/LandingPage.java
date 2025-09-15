package Pages;

import Utilities.Reusables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends Reusables {

    private WebDriver driver;
    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private final By userEmailLoc = By.id("userEmail");
    private final By userPassLoc = By.id("userPassword");
    private final By loginBtnLoc = By.id("login");

    public ProductCatalogue loginApp(String email, String pass){
        driver.findElement(userEmailLoc).sendKeys(email);
        driver.findElement(userPassLoc).sendKeys(pass);
        driver.findElement(loginBtnLoc).click();

        super.handleOverlay();
        return new ProductCatalogue(driver);
    }

    public void goTo(){
        driver.get("https://rahulshettyacademy.com/client");
    }

}
