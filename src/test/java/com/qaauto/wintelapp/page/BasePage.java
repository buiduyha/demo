package com.qaauto.wintelapp.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class BasePage {
    protected static AndroidDriver driver;

    public static void waitSecond(double second) {
        try {
            synchronized (driver) {
                driver.wait((int) (second * 1000));
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static boolean waitForElementDisplay(AndroidDriver driver, By by, int waitInSecond) {
        for (int i = 0; i < waitInSecond / 2 + 1; i++) {
            try {
                if (driver.findElement(by).isDisplayed()) {
                    return true;
                }
            } catch (Exception e) {
                System.out.println("waiting element for display...");
            }
        }
        return false;
    }

    public static void clickElementByBy(By by) {
        try {
            WebElement webElement = driver.findElement(by);
            if (webElement != null) {
                webElement.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void enterText(By by, String string) {
        try {
            WebElement webElement = driver.findElement(by);
            if (webElement != null) {
                webElement.clear();
                webElement.sendKeys(string);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void scrollAndClick(String visibleText) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + visibleText + "\").instance(0))")).click();
    }

    public static void scrollToBottom() {
        int x = driver.manage().window().getSize().width / 2;
        int start_y = (int) (driver.manage().window().getSize().height * 0.3);
        int end_y = (int) (driver.manage().window().getSize().height * 0.7);
        TouchAction scroller = new TouchAction(driver)
                .press(PointOption.point(x, end_y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(x, start_y))
                .release();
        scroller.perform();
    }

    public static void scrollToBottom_1() {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollToEnd(10)"));
    }

    public boolean check_title(By by, String title) {
        return driver.findElement(by).getText().equals(title);
    }

    public static void press_back() {
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        waitSecond(2);
    }

}