package com.qaauto.wintelapp.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class PackagePage extends BasePage {
    public static By byTitle = AppiumBy.accessibilityId("TITLE");

    private static By bySelectPackage = AppiumBy.accessibilityId("package0");

    private static By byRegister = AppiumBy.accessibilityId("detailPackage_registration");

    private static By byAgree = AppiumBy.accessibilityId("detailPackage_yes_modal");

    private By title_HTTT = By.xpath("//android.widget.TextView[@text=\"Hình thức thanh toán\"]");

    private static By ATM_noiDia = AppiumBy.accessibilityId("DC");

    private static By byConfirm = AppiumBy.accessibilityId("detailPackage_confim_pay");

    private static By vnpt_epay_page = By.xpath("//android.widget.Image[@text=\"Vnpt epay\"]");

    public PackagePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public static boolean isLoaded() {
        return waitForElementDisplay(driver, byTitle, 3);
    }

    public static boolean isAlert() {
        return waitForElementDisplay(driver, byAgree, 3);
    }

    private static void click_select_package() {
        clickElementByBy(bySelectPackage);
    }

    private static void click_register_package() {
        clickElementByBy(byRegister);
    }

    private static void click_agree() {
        clickElementByBy(byAgree);
    }

    private static void click_ATM() {
        clickElementByBy(ATM_noiDia);
    }

    private static void click_confirm() {
        clickElementByBy(byConfirm);
    }

    public static void buyPackage() {
        click_select_package();
        click_register_package();

        //Kiem tra thong bao thay the goi cuoc cu
        if (isAlert()) {
            click_agree();
        }

        click_ATM();
        click_confirm();

        //  waitForElementDisplay(driver, vnpt_epay_page, 10);
        Assert.assertEquals(driver.findElement(vnpt_epay_page).getText(), "Vnpt epay", "Trang thanh toán");
    }
}
