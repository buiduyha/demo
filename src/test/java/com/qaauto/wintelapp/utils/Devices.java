package com.qaauto.wintelapp.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Devices {
    public static AndroidDriver driver;

    public Devices() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "13");
        capabilities.setCapability("deviceName", "RFCRC05M0HJ"); // M52
//        capabilities.setCapability("deviceName", "R5CRC0MFA5R"); // S21 FE
//        capabilities.setCapability("deviceName", "R5CT138NK7K"); // A52
//        capabilities.setCapability("platformVersion", "11");
//        capabilities.setCapability("deviceName", "BDE00027859"); // Aris
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "com.reddi.dev");
        capabilities.setCapability("appActivity", "com.reddi.MainActivity");

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        capabilities.setCapability("clearDeviceLogsOnStart", true);
    }

    public static AndroidDriver getDriver() {
        return driver;
    }
}