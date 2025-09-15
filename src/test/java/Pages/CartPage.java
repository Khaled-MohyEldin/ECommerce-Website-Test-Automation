package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class CartPage {
    private WebDriver driver;
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    private final By cartListLoc = By.cssSelector(".cart h3");
    private final By checkOutBtnLoc = By.cssSelector(".subtotal .btn");

    public boolean cartOk (List<String> srchItems){

        List<WebElement> cartList = driver.findElements(cartListLoc);
        return cartList.stream()
                .map(WebElement::getText)
                .allMatch(sourceItem -> srchItems.stream()
                .anyMatch(sourceItem::contains));
    }

    public PaymentPage chckout(){
        ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='80%'");
        driver.findElement(checkOutBtnLoc).click();
        return  new PaymentPage(driver);
    }
}
