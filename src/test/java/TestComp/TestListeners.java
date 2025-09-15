package TestComp;

import Utilities.DriverFactory;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListeners extends BaseTest implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        //use Thread-Safe driver Factory Pattern instead of passing driver
        WebDriver driver = DriverFactory.getDriver();

        String testName = result.getName(); // Get the test method name
        System.out.println("Test Failed: " + testName);

        // Screenshot file name with timestamp
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = testName + "_" + timestamp + ".png";

        if (driver != null) {
            try { // Saving a screenshot to screenshots Folder
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenshot, new File("screenshots/" + fileName));
                System.out.println("📸 Screenshot saved: screenshots/" + fileName);

                // Attach screenshot to Allure
                byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment("Screenshot on Failure", new ByteArrayInputStream(screenshotBytes));
                // Add log to Allure
                Allure.step("Test failed: " + testName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Driver is null, screenshot not captured.");
        }
    }
}
