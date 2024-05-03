package com.qaauto.wintelapp.utils;

import com.qaauto.wintelapp.page.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WelcomePage extends BasePage {
    private static By byLogin = AppiumBy.accessibilityId("intro_sign_in");

    private static By byBuySim = AppiumBy.accessibilityId("intro_buySIM");

    public WelcomePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public static void login() {
        WebElement btnLogin = driver.findElement(byLogin);
        btnLogin.click();
    }

    public static void click_buy_sim() {
        WebElement btnBuySim = driver.findElement(byBuySim);
        btnBuySim.click();
    }
}
