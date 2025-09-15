package Pages;

import Utilities.Reusables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PaymentPage extends Reusables {
    private WebDriver driver;
    public PaymentPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    private final By optionsLoc = By.cssSelector(".ta-results span");
    private final By countryTextLoc = By.cssSelector(".form-group .text-validated");
    private final By placeOrderBtnLoc = By.cssSelector(".action__submit");

    public void selectCountry(String cntrySrch){
        driver.findElement(countryTextLoc).sendKeys(cntrySrch);
        List<WebElement> options = driver.findElements(optionsLoc);
        for (WebElement option : options) {
            if(option.getText().contains(cntrySrch)){
                option.click(); break;}
        }
    }

    public Dashboard placeOrder() {
        driver.findElement(placeOrderBtnLoc).click();
        handleOverlay();
        return new Dashboard(driver);
    }
}
