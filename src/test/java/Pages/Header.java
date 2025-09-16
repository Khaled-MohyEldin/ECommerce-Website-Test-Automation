package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {
    private WebDriver driver;
    public Header(WebDriver driver) {
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


}
