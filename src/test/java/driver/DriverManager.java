package driver;

import constants.Constants;
import constants.OS;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;


class DriverManager {
    private DesiredCapabilities capabilities = new DesiredCapabilities();
    private AppiumDriver driver;
    private File root = new File("apps");

    protected void resolveDriver(OS os, String udId, String puerto, String fileName, Boolean rootMac) {
        resolveDriver(os, udId, "", false, "http://10.252.152.193:" + puerto + "/wd/hub", fileName, false, rootMac, "");
    }

    protected void resolveDriver(OS os, String udId, String deviceName, Boolean emulador, String fileName) {
        resolveDriver(os, udId, deviceName, emulador, "http://127.0.0.1:4723/wd/hub", fileName, false, false, "");
    }

    protected void resolveDriver(OS os, String udId, String deviceName, Boolean emulador, String fileName, String versionDispositivo) {
        resolveDriver(os, udId, deviceName, emulador, "http://127.0.0.1:4723/wd/hub", fileName, false, false, versionDispositivo);
    }

    protected void resolveDriver(OS os, String udId, String deviceName, Boolean emulador, String fileName, Boolean continueFlow) {
        resolveDriver(os, udId, deviceName, emulador, "http://127.0.0.1:4723/wd/hub", fileName, continueFlow, false, "");
    }

    protected void resolveDriver(OS os, String udId, String deviceName, String fileName) {
        resolveDriver(os, udId, deviceName, false, "http://172.16.98.145:5355/wd/hub", fileName, false, false, "");
    }

    protected void resolveDriver(OS os, String udId, String deviceName, Boolean emulador, String urlAppiumServer, String nameFile, Boolean continueFlow, Boolean rootMac, String versionDispositivo) {
        URL server = null;
        try {
            server = new URL(urlAppiumServer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        File app;
        if (os == OS.ANDROID) {
            if (rootMac) {
                eliminarAPK();
                deviceName = "Device Android";
                this.capabilities.setCapability("fullReset", true);
                app = new File(root, nameFile + ".apk");
            } else {
                app = new File(root, nameFile + ".apk");
            }
            capabilities.setCapability("deviceName", deviceName);
            if (!emulador) {
                capabilities.setCapability(MobileCapabilityType.UDID, udId);
            }

            if (continueFlow) {
                this.capabilities.setCapability("noReset", true);
            } else {
                this.capabilities.setCapability("noReset", false);
            }

            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 400000);
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
            driver = new AndroidDriver(server, capabilities);
            driver.manage().timeouts().implicitlyWait(Constants.DRIVER_DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        } else {

            if (!emulador) {
                if (rootMac) {
                    deviceName = "Device iOS";
                    this.capabilities.setCapability("fullReset", true);
                }
                capabilities.setCapability(MobileCapabilityType.UDID, udId);
            } else {
                app = new File(root, nameFile + ".app");
                capabilities.setCapability("platformVersion", "14.4");
                capabilities.setCapability("bundleId", " Calculadora  com.apple.calculator");
            }

            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.IOS);
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 400000);

            if (!versionDispositivo.equals("")) {
                capabilities.setCapability("platformVersion", versionDispositivo);
            }

            capabilities.setCapability(IOSMobileCapabilityType.ALLOW_TOUCHID_ENROLL, true);
            driver = new IOSDriver(server, capabilities);
            driver.manage().timeouts().implicitlyWait(Constants.DRIVER_DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        }

    }

    protected AppiumDriver getDriver() {
        return driver;
    }

    private void eliminarAPK() {
        try {
            String[] cmds = {
                    "/bin/sh", "-c", "adb shell pm uninstall " + Constants.APP_PACKAGE_ID};
            Process p = Runtime.getRuntime().exec(cmds);
            p.waitFor();
            System.out.println("Aplicación eliminada");
        } catch (Exception e) {
            System.out.println("Err: " + e.getMessage());

        }
    }


}
