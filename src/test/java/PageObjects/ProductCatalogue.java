package PageObjects;

import AbstractComp.Reusables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalogue extends Reusables {
    WebDriver driver;

    public ProductCatalogue(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".card .card-body")
    List<WebElement> items;


    public List<WebElement> getItems() {
        return this.items;
    }

    public void addingItems(String[] srchItems) {
        By addItem = By.cssSelector(".fa-shopping-cart");
        for (String srch : srchItems) {
            WebElement item = this.items.stream().filter(s -> s.getText().contains(srch)).
                    findFirst().orElse(null);
            assert item != null;
            item.findElement(addItem).click();
            super.handleOverlay();
        }
    }



}
