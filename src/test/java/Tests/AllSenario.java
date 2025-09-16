package Tests;

import Pages.CartPage;
import Pages.Dashboard;
import Pages.PaymentPage;
import Pages.ProductCatalogue;
import TestComp.BaseTest;
import Utilities.TestData;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class AllSenario extends BaseTest {

    @Test(dataProvider = "getData")
    public void EndtoEnd(TestData data) {

        //Entering credentials and login
        ProductCatalogue products = landingPage.loginApp(data.getEmail(), data.getPass());

        //Search for Item and add to cart
        products.addingItems(data.getProducts());
        CartPage cartPage = products.header.goToCartPage();

        //check every product is what we have chosen and then click checkout
        Assert.assertTrue(cartPage.cartOk(data.getProducts()));
        PaymentPage payment = cartPage.chckout();

        //Select country from a suggestion list
        payment.selectCountry(data.getCountry());
        Dashboard dash = payment.placeOrder();

        // print products IDs and confirm success Message
        System.out.println(dash.getProductIDs());
        Assert.assertTrue(dash.getMsg().equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        //SignOut
        products.header.signOut();
    }

    // Reading from Json file
    @DataProvider
    public Object[][] getData() throws IOException {
        List<TestData> data = getJsonData("PurchaseOrder.json");
        return new Object[][]{ {data.get(0)}, {data.get(1)} };
    }

}

