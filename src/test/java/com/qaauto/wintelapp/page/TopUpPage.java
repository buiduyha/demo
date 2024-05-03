package com.qaauto.wintelapp.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopUpPage extends BasePage {
    public static By byTitle = AppiumBy.accessibilityId("title");

    private By byPhoneNumber = AppiumBy.accessibilityId("enter_phone_input");

    private By byAmountOfMoney = AppiumBy.accessibilityId("enter_price_input");

    private By byPaymentMethod = AppiumBy.accessibilityId("select_pay");
//    private WebElement btnPaymentMethod = driver.findElement(paymentMethod);

    private By byPaymentMethodList;

    private By byPaymentAmount = AppiumBy.accessibilityId("total_amount");

    private static By byTopUp = AppiumBy.accessibilityId("recharge_btn");

    public TopUpPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public static boolean isLoaded() {
        return waitForElementDisplay(driver, byTitle, 3);
    }

    public WebElement getEdtPhoneNumber() {
        WebElement edtPhoneNumber = driver.findElement(byPhoneNumber);
        return edtPhoneNumber;
    }

    public WebElement getEdtAmountOfMoney() {
        WebElement edtAmountOfMoney = driver.findElement(byAmountOfMoney);
        return edtAmountOfMoney;
    }

    public WebElement getLbPaymentAmount() {
        WebElement lbPaymentAmount = driver.findElement(byPaymentAmount);
        return lbPaymentAmount;
    }

    public static void top_up() {
        clickElementByBy(byTopUp);
    }
}
