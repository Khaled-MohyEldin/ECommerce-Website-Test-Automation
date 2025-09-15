package AbstractComp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import PageObjects.CartPage;

import java.time.Duration;

public class Reusables {
    WebDriver driver;
    public Reusables(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(css=".fa-home")
    WebElement homeBtn;

    @FindBy(css=".fa-handshake-o")
    WebElement ordersBtn;

    @FindBy(css=".fa-shopping-cart")
    WebElement cartBtn;

    @FindBy(css=".fa-sign-out")
    WebElement signOutBtn;

    public void goHomePage(){ homeBtn.click(); }
    public void goToOrdersPage(){ ordersBtn.click(); }
    public void signOut(){ signOutBtn.click(); }
    public CartPage goToCartPage(){
        cartBtn.click();
        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }

    public void handleOverlay() {
        By toastContainer = By.id("toast-container");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(toastContainer));
        System.out.println("MSG => " + driver.findElement(toastContainer).getText());
        wait.until(ExpectedConditions.invisibilityOfElementLocated(toastContainer));
    }
}
