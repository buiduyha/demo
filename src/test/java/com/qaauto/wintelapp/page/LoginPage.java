package com.qaauto.wintelapp.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private static By byPhoneNumber = AppiumBy.accessibilityId("signInScreen_username_input");

    private static By byPassword = AppiumBy.accessibilityId("signInScreen_password_input");

    private static By byLogin = AppiumBy.accessibilityId("signInScreen_sign_in");

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public static boolean isLoaded() {
        return waitForElementDisplay(driver, byPhoneNumber, 3);
    }

    private static void enterPhoneNumber(String phoneNumber) {
        enterText(byPhoneNumber, phoneNumber);
    }

    private static void enterPassword(String password) {
        enterText(byPassword, password);
    }

    private static void click_login() {
        press_back();
        clickElementByBy(byLogin);
    }

    public static void login(String phoneNumber, String password) {
        enterPassword(phoneNumber);
        enterPhoneNumber(password);
        click_login();
    }
}
