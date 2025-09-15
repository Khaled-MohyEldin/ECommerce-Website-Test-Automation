package Pages;

import Utilities.Reusables;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PaymentPage extends Reusables {
    WebDriver driver;
    public PaymentPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css=".ta-results span")
    List<WebElement> options;

    @FindBy(css=".form-group .text-validated")
    WebElement countryText;

    @FindBy(css=".action__submit")
    WebElement placeOrderBtn;

    public void selectCountry(String cntrySrch){
        countryText.sendKeys(cntrySrch);
        for (WebElement option : options) {
            if(option.getText().contains(cntrySrch)){
                option.click(); break;}
        }
    }

    public Dashboard placeOrder() {
        placeOrderBtn.click();
        handleOverlay();
        Dashboard dash = new Dashboard(driver);
        return dash;
    }
}
