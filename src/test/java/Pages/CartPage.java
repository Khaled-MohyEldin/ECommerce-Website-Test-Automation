package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class CartPage {
    WebDriver driver;
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css=".cart h3")
    List<WebElement> cartList;

    @FindBy(css=".subtotal .btn")
    WebElement checkOutBtn;

    public List<WebElement> getCartList(){
        return this.cartList;
    }

    public boolean cartOk (String[] srchItems){
        return cartList.stream().map(WebElement::getText)
                .allMatch(sourceItem -> Arrays.stream(srchItems).anyMatch(sourceItem::contains));
    }

    public PaymentPage chckout(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='80%'");
        checkOutBtn.click();
        PaymentPage payment = new PaymentPage(driver);
        return payment;
    }
}
