package utils;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class CustomAndroidDriver {
    public AndroidDriver getAndroidDriver() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:platformVersion", "12.0");
        caps.setCapability("appium:deviceName", "Android Emulator");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:app", System.getProperty("user.dir") + "/apps/monefy.apk");
        caps.setCapability("appium:appWaitActivity", "*");

        return new AndroidDriver(new URL("http://127.0.0.1:4723/"), caps);
    }
}
