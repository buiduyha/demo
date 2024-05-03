package com.qaauto.wintelapp.page;

import com.qaauto.wintelapp.utils.Constants;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class PhoneNumberSelectionPage extends BasePage {
    public static By byTitle = AppiumBy.accessibilityId("title");
    private static By byChoose_number_phone = AppiumBy.accessibilityId("choose_number_phone");
    private static By byChoose_package = AppiumBy.accessibilityId("select_package0");
    private static By byChoose_physical_sim = AppiumBy.accessibilityId("choose_physical_sim");
    private static By byChoose_Esim = AppiumBy.accessibilityId("choose_Esim");
    private static By byBtn_order_continue = AppiumBy.accessibilityId("order_continue");
    private static By byName = AppiumBy.accessibilityId("deliveryInfomation_name");
    private static By byPhone = AppiumBy.accessibilityId("deliveryInfomation_phone");
    private static By byEmail = AppiumBy.accessibilityId("deliveryInfomation_email");
    private static By byCity = AppiumBy.accessibilityId("cityId");
    private static By byCity0 = AppiumBy.accessibilityId("cityID0");
    private static By byDistrict = AppiumBy.accessibilityId("districtId");
    private static By byDistrict0 = AppiumBy.accessibilityId("deliveryID0");
    private static By byVillage = AppiumBy.accessibilityId("villageId");
    private static By byVillage0 = AppiumBy.accessibilityId("villageID0");
    private static By byAddress = AppiumBy.accessibilityId("addr_detail");
    private static By byPayment = AppiumBy.accessibilityId("deliveryInfomation_pay");
    private static By byPay_COD = AppiumBy.accessibilityId("deliveryInfomationPay_COD");
    private static By byBtn_delivery_continue = AppiumBy.accessibilityId("deliveryInfomation_continue");
    private static By byBtn_confirm = AppiumBy.accessibilityId("confirmOrder_confirm");
    private static By byShipping = AppiumBy.accessibilityId("select_transport0");
    private static By bySuccess = By.xpath("//android.widget.TextView[@text=\"Đặt hàng thành công\"]");
    private static By byBackToHome = AppiumBy.accessibilityId("resultScreen_right_btn");
    private static By byClose = AppiumBy.accessibilityId("resultScreen_left_btn");

    public PhoneNumberSelectionPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public boolean isLoaded() {
        return waitForElementDisplay(driver, byTitle, 3);
    }

    public static void buyPhoneNumber() {
        // 1.Chọn số, Chọn gói cước
        clickElementByBy(byChoose_number_phone);
        clickElementByBy(byChoose_package);

        //2. Chọn loại sim
//        Assert.assertEquals(driver.findElement(title).getText(), "Chọn loại hình SIM");
        clickElementByBy(byChoose_physical_sim);
        clickElementByBy(byBtn_order_continue);

        //3. Nhập thông tin nhận hàng
        //  Assert.assertEquals(driver.findElement(title).getText(), "Thông tin nhận hàng");
        enterText(byName, Constants.RECEIVER_NAME);
        enterText(byPhone, Constants.RECEIVER_NUMBER);
        enterText(byEmail, Constants.RECEIVER_EMAIL);

        clickElementByBy(byCity);
        clickElementByBy(byCity0);
        clickElementByBy(byDistrict0);
        clickElementByBy(byVillage0);
        enterText(byAddress,Constants.RECEIVER_ADDRESS);

        scrollToBottom_1();
        scrollToBottom();
        scrollAndClick("Hình thức thanh toán");

        clickElementByBy(byPay_COD);
        clickElementByBy(byShipping);
        clickElementByBy(byBtn_delivery_continue);

        //4.Xác nhận
        //   Assert.assertEquals(driver.findElement(title).getText(), "Xác nhận đơn hàng");
        clickElementByBy(byBtn_confirm);

        //5.Thành công
        waitForElementDisplay(driver, bySuccess, 3);
        Assert.assertEquals(driver.findElement(bySuccess).getText(), "Đặt hàng thành công");
    }

    public static void close() {
        clickElementByBy(byClose);
    }

    public static void back_to_home_page() {
        clickElementByBy(byBackToHome);
    }
}
