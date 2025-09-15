package Utilities;

import Pages.CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Reusables {

    private WebDriver driver;
    public Reusables(WebDriver driver){
        this.driver = driver;
    }

    private final By orderBtn = By.cssSelector(".fa-handshake-o");
    private final By cartBtn = By.cssSelector(".fa-shopping-cart");
    private final By homeBtn = By.cssSelector(".fa-home");
    private final By signOut = By.cssSelector(".fa-sign-out");

    public void goHomePage(){
        driver.findElement(homeBtn).click();
    }

    public void goToOrdersPage(){
        driver.findElement(orderBtn).click();
    }

    public void signOut(){
        driver.findElement(signOut).click();
    }

    public CartPage goToCartPage(){
        driver.findElement(cartBtn).click();
        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }

    public void handleOverlay() {
        WebDriver driver = DriverFactory.getDriver();
        By toastContainer = By.id("toast-container");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(toastContainer));
        System.out.println("MSG => " + driver.findElement(toastContainer).getText());
        wait.until(ExpectedConditions.invisibilityOfElementLocated(toastContainer));
    }
}
