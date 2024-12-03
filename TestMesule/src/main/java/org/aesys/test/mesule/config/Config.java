package org.aesys.test.mesule.config;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.flutter.android.FlutterAndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class Config {

    protected static FlutterAndroidDriver _flutterDriver;
    protected static AndroidDriver _androidDriver;
    private static final URL apk = Config.class.getResource("/app-mesule-debug.apk");

    public static void setupAndroid() {
        assert apk != null;
        var capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:app", apk.getFile());
        capabilities.setCapability("appium:autoGrantPermissions", true);

        var _appiumDriverLocalService = AppiumDriverLocalService.buildService(createAppiumServiceBuilder(capabilities));
        _appiumDriverLocalService.start();
        _androidDriver = new AndroidDriver(_appiumDriverLocalService, capabilities);

//        try {
//            _androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
//        } catch (Exception _) {}
    }

    public static void setupFlutter() {
        assert apk != null;
        var capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:automationName", "Flutter");
        capabilities.setCapability("appium:app", apk.getFile());
        capabilities.setCapability("appium:autoGrantPermissions", true);

        var _appiumDriverLocalService = AppiumDriverLocalService.buildService(createAppiumServiceBuilder(capabilities));
        _appiumDriverLocalService.start();
        _flutterDriver = new FlutterAndroidDriver(_appiumDriverLocalService, capabilities);
    }

    public static void tearDown() {
        if (_androidDriver != null) _androidDriver.quit();
    }

    private static AppiumServiceBuilder createAppiumServiceBuilder(DesiredCapabilities caps) {
        return new AppiumServiceBuilder()
                .withIPAddress("0.0.0.0")
                .usingPort(4723)
                .withCapabilities(caps)
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withArgument(GeneralServerFlag.LOG_LEVEL, "error")
                .withArgument(GeneralServerFlag.BASEPATH, "/wd/hub");
    }
}