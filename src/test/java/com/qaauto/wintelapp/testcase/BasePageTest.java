package com.qaauto.wintelapp.testcase;

import com.qaauto.wintelapp.utils.Devices;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.time.Duration;

public class BasePageTest {
    protected static AndroidDriver driver;

    @BeforeTest
    public void createDriver() throws MalformedURLException {
        driver = new Devices().getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterTest
    public void quit() {
        driver.quit();
    }
}