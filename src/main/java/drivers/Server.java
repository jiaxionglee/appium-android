package drivers;

import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.net.URL;

/**
 * Created by jiaxiong on 2019-01-17 16:08
 */
public abstract class Server {

    private static AppiumDriverLocalService service;

    public static void globalSetup (){
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
    }

    public static void globalTearDown () {
        service.stop();
    }

    public static URL getServiceUrl () {
        return service.getUrl();
    }
}
