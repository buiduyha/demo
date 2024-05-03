package com.qaauto.wintelapp.utils;

import com.qaauto.wintelapp.page.BasePage;
import com.qaauto.wintelapp.page.PackagePage;
import com.qaauto.wintelapp.page.PhoneNumberSelectionPage;
import com.qaauto.wintelapp.page.TopUpPage;
import com.qaauto.wintelapp.utils.ChangeSIMCardPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {
    private static By byTopUp = AppiumBy.accessibilityId("recharge_icon");

    private By byPhoneNumberWarehouse = AppiumBy.accessibilityId("service1");
    private WebElement btnPhoneNumberWarehouse;

    private By byChangeSIMCard = AppiumBy.accessibilityId("service2");
    private WebElement btnChangeSIMCard;

    private By byCallBarring = AppiumBy.accessibilityId("service3");
    private WebElement btnCallBarring;

    private By byBlackList = AppiumBy.accessibilityId("service4");
    private WebElement btnBlackList;

    private By byWhiteList = AppiumBy.accessibilityId("service5");
    private WebElement btnWhiteList;

    private By byMCA = AppiumBy.accessibilityId("service6");
    private WebElement btnMCA;

    private static By voucher = AppiumBy.accessibilityId("service7");
    public static By bottomNavigation = AppiumBy.id("com.reddi.dev:id/bottom_navigation_item_icon");

    public HomePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public static boolean isLoaded() {
        return waitForElementDisplay(driver, bottomNavigation, 3);
    }

    public static void click_top_up() {
        WebElement btnTopUp = driver.findElement(byTopUp);
        btnTopUp.click();
        waitForElementDisplay(driver, TopUpPage.byTitle, 3);
    }

    public PhoneNumberSelectionPage click_number_warehouse() {
        scrollToBottom();
        WebElement btnPhoneNumberWarehouse = driver.findElement(byPhoneNumberWarehouse);
        btnPhoneNumberWarehouse.click();
        return new PhoneNumberSelectionPage(driver);
    }

    public ChangeSIMCardPage click_change_SIMCard() {
        scrollToBottom();
        WebElement btnChangeSIMCard = driver.findElement(byChangeSIMCard);
        btnChangeSIMCard.click();
        return new ChangeSIMCardPage(driver);
    }

    public static void click_voucher() {
        scrollToBottom_1();
        WebElement btnVoucher = driver.findElement(voucher);
        btnVoucher.click();
    }

    public static void click_home_icon() {
        List<WebElement> btnBottomNavigation = driver.findElements(bottomNavigation);
        btnBottomNavigation.get(0).click();
        waitForElementDisplay(driver, byTopUp, 3);
    }

    public static void click_package_icon() {
        List<WebElement> btnBottomNavigation = driver.findElements(bottomNavigation);
        btnBottomNavigation.get(1).click();
        waitForElementDisplay(driver, PackagePage.byTitle, 3);
    }
}
