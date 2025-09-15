package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;


public class Dashboard {
    WebDriver driver;
    public Dashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css=".em-spacer-1 .ng-star-inserted")
    List<WebElement> ProductIDs;

    @FindBy(css=".hero-primary")
    WebElement message;

    public List<String> getProductIDs(){
        return ProductIDs.stream().map(WebElement::getText).toList();
    }

    public String getMsg(){
        return message.getText();
    }
}
