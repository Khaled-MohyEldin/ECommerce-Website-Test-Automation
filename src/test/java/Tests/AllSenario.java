package Tests;

import Pages.CartPage;
import Pages.Dashboard;
import Pages.PaymentPage;
import Pages.ProductCatalogue;
import TestComp.BaseTest;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class AllSenario extends BaseTest {

    @Test(dataProvider = "getData")
    public void EndtoEnd(HashMap<Object, Object> input) throws IOException {

        String[] srchItems = ((List<String>) input.get("products")).toArray(new String[0]);
        //just enter credentials and login
        ProductCatalogue products = landingPage.loginApp((String) input.get("email"), (String) input.get("pass"));

        //Search for Item and add to cart
        products.addingItems(srchItems);
        Allure.step("Choosing Products");
        CartPage cartPage = products.goToCartPage();

        //check every product is what we chosen and then click checkout
        Assert.assertTrue(cartPage.cartOk(srchItems));
        PaymentPage payment = cartPage.chckout();

        //click on Select country filed
        String cntrySrch = "Egypt";
        Allure.step("Selecting country to place order");
        payment.selectCountry(cntrySrch);
        Dashboard dash = payment.placeOrder();

        // print products IDs and confirm success Message
        System.out.println(dash.getProductIDs());
        Allure.step("Printing list of order IDs");
        Assert.assertTrue(dash.getMsg().equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        //SignOut
        products.signOut();

    }

    // Reading from Json file
    @DataProvider
    public Object[][] getData() {
        List<HashMap<Object, Object>> list;
        try { list = getJsonData("PurchaseOrder.json");
        } catch (IOException e) { throw new RuntimeException(e);}

        return new Object[][]{ {list.get(0)}, {list.get(1)} };
    }

}

