package com.qaauto.wintelapp.page;

import com.qaauto.wintelapp.utils.HomePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class VoucherPage extends BasePage {
    public static By byTitle = AppiumBy.accessibilityId("title");

    private static By byVoucher_50 = AppiumBy.accessibilityId("voucher0");

    private static By byVoucher_20 = AppiumBy.accessibilityId("voucher1");

    private static By byBuy = AppiumBy.accessibilityId("detailVoucher_buynow");

    private static By byPayment = AppiumBy.accessibilityId("confimOrderVoucher_pay");

    private static By byClose = AppiumBy.id("android:id/button1");

    public VoucherPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public boolean isLoaded() {
        return waitForElementDisplay(driver, byTitle, 3);
    }

    public static void click_voucher_20() {
        clickElementByBy(byVoucher_20);
        waitForElementDisplay(driver, byBuy, 3);
    }

    public static void click_voucher_50() {
        clickElementByBy(byVoucher_50);
        waitForElementDisplay(driver, byBuy, 3);
    }

    public static void click_buy_now() {
        clickElementByBy(byBuy);
        waitForElementDisplay(driver, byPayment, 3);
    }

    public static void click_payment() {
        WebElement btnPayment = driver.findElement(byPayment);
        if (btnPayment.isEnabled()) {
            btnPayment.click();
            waitSecond(2);
        }
    }

    public static void cancel_order() {
        press_back();
        waitForElementDisplay(driver, byClose, 3);
        clickElementByBy(byClose);
        waitForElementDisplay(driver, HomePage.bottomNavigation, 10);
    }
}
