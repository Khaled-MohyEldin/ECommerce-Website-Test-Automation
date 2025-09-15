package Tests;

import PageObjects.ProductCatalogue;
import TestComp.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestComp.Listeners.class)
public class ErrorValidationTest extends BaseTest {

    @Test
    public void EndtoEnd() {
        //just enter credentials and login
        String email = "one@two", password = "1&456twoThree";
        ProductCatalogue products = landingPage.loginApp(email, password);
        Assert.assertTrue(false, "Just testing with invalid credentials");
    }
}
