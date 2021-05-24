package driver;

import constants.Constants;
import constants.OS;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;

import java.util.concurrent.TimeUnit;

public class DriverContext {
    public static DriverManager driverManager = new DriverManager();


    public static void setUp(OS os, String udId, String puerto, String fileName, Boolean rootMac) {
        driverManager.resolveDriver(os, udId, puerto, fileName, rootMac);
    }

    public static void setUp(OS os, String udId, String deviceName, Boolean emulador, String fileName) {
        driverManager.resolveDriver(os, udId, deviceName, emulador, fileName);
    }

    public static void setUp(OS os, String udId, String deviceName, Boolean emulador, String fileName, String versionDispositivo) {
        driverManager.resolveDriver(os, udId, deviceName, emulador, fileName, versionDispositivo);
    }

    public static void setUp(OS os, String udId, String deviceName, Boolean emulador, String fileName, Boolean continueFlow) {
        driverManager.resolveDriver(os, udId, deviceName, emulador, fileName, continueFlow);
    }

    public static void setUp(OS os, String udId, String deviceName, String fileName) {
        driverManager.resolveDriver(os, udId, deviceName, fileName);
    }

    public static AppiumDriver getDriver() {
        return driverManager.getDriver();
    }

    public static void quitDriver() {
        driverManager.getDriver().quit();
    }

    public static void setDriverTimeout(Integer tiempo) {
        driverManager.getDriver().manage().timeouts().implicitlyWait(tiempo, TimeUnit.SECONDS);
    }

    public static void setDriverDefaultTimeout() {
        setDriverTimeout(Constants.DRIVER_DEFAULT_TIMEOUT);
    }

    public static Dimension getSreenSize() {
        return driverManager.getScreenSize();
    }

    public static final String getAndroidPackageId() {
        return ((AndroidDriver) driverManager.getDriver()).getCurrentPackage();
    }
}
