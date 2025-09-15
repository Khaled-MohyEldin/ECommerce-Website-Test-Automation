package Tests;

import Pages.ProductCatalogue;
import TestComp.BaseTest;
import TestComp.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListeners.class)
public class ErrorValidationTest extends BaseTest {

    @Test
    public void failTest() {
        //just enter credentials and login
        String email = "one@two", password = "1&456twoThree";
        ProductCatalogue products = landingPage.loginApp(email, password);
        Assert.assertTrue(false, "Just testing with invalid credentials");
    }
}
