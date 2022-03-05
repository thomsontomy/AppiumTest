import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumApplication {

    private static WebDriver wd;

    public void initialiseAppium() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/thomson/projects/PushNotification/app/build/intermediates/apk/debug/app-debug.apk");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");

        try {
            wd = new AppiumDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    public void shutDown() {
        if (wd != null)
        wd.quit();
    }

    public WebDriver getDriver() {
        return wd;
    }
}
