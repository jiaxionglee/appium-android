package drivers;

import config.GlobalConfig;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by jiaxiong on 2019-01-13 15:06
 */
public class Driver {

    private static AndroidDriver<WebElement> driver;

    public static void start() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        GlobalConfig config = GlobalConfig.load("/data/globalConfig.yaml");
        config.appiumConfig.capabilities.keySet().forEach(key -> {
            Object value = config.appiumConfig.capabilities.get(key);
            desiredCapabilities.setCapability(key, value);
        });

        URL remoteUrl = null;
        try {
            remoteUrl = new URL(config.appiumConfig.url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(config.appiumConfig.wait, TimeUnit.SECONDS);
    }

    public static AndroidDriver<WebElement> getCurrentDriver() {
        return driver;
    }
}
