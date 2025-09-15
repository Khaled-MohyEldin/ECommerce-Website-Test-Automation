package Utilities;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
    // Use a ThreadLocal to make the driver instance thread-safe
    private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driverThread.get();
    }

    public static void setDriver(WebDriver driver) {
        driverThread.set(driver);
    }
}
