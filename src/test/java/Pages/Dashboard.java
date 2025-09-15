package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Dashboard {
    private WebDriver driver;
    public Dashboard(WebDriver driver) {
        this.driver = driver;
    }

    private final By ProductIDLoc = By.cssSelector(".em-spacer-1 .ng-star-inserted");
    private final By messageLoc = By.cssSelector(".hero-primary");

    public List<String> getProductIDs(){
        List<WebElement> ProductIDs = driver.findElements(ProductIDLoc);
        return ProductIDs.stream().map(WebElement::getText).toList();
    }

    public String getMsg(){
        return driver.findElement(messageLoc).getText();
    }
}
