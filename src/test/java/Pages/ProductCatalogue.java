package Pages;

import Utilities.Reusables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalogue extends Reusables {
    private WebDriver driver;
    public ProductCatalogue(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private final By itemsLoc = By.cssSelector(".card .card-body");
    private final By addItem = By.cssSelector(".fa-shopping-cart");

    public List<WebElement> getItems() {
        return driver.findElements(itemsLoc);
    }

    public void addingItems(List<String> srchItems) {
        List<WebElement> items = driver.findElements(itemsLoc);
        for (String srch : srchItems) {
            WebElement item = items.stream().filter(s -> s.getText().contains(srch)).
                    findFirst().orElse(null);
            assert item != null;
            item.findElement(addItem).click();
            handleOverlay();
        }
    }

}
