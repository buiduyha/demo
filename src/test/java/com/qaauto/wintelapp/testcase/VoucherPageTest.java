package com.qaauto.wintelapp.testcase;

import com.qaauto.wintelapp.page.*;
import com.qaauto.wintelapp.utils.HomePage;
import com.qaauto.wintelapp.utils.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VoucherPageTest extends BasePageTest {
    String TITLE = "Voucher";
    String SUB_TITLE = "Xác nhận đơn hàng";

    WelcomePage welcomePage;
    LoginPage loginPage;
    HomePage homePage;
    VoucherPage voucherPage;

//    @BeforeClass
//    public void open_app_and_login() {
//        welcomePage = new WelcomePage(driver);
//        welcomePage.login();
//        loginPage = new LoginPage(driver);
//        loginPage.login(Constants.PHONE_NUMBER, Constants.PASSWORD);
//    }

    @BeforeMethod
    public void open_home_page() {
        homePage = new HomePage(driver);
        voucherPage = new VoucherPage(driver);
        homePage.click_home_icon();
    }

    @Test(dependsOnMethods = {"top_up"}, groups = {"buyVoucher"})
    public void buy_voucher_20() {
        System.out.println("Test buy voucher 20k ...");
        homePage.click_voucher();
        Assert.assertTrue(voucherPage.isLoaded());
        Assert.assertTrue(voucherPage.check_title(voucherPage.byTitle, TITLE));

        voucherPage.click_voucher_20();
        voucherPage.click_buy_now();
        Assert.assertTrue(voucherPage.check_title(voucherPage.byTitle, SUB_TITLE));

        voucherPage.click_payment();
    }

    @Test(dependsOnMethods = {"top_up"}, groups = {"buyVoucher"})
    public void buy_voucher_50() {
        System.out.println("Test buy voucher 50k ...");
        homePage.click_voucher();
        Assert.assertTrue(voucherPage.isLoaded());
        Assert.assertTrue(voucherPage.check_title(voucherPage.byTitle, TITLE));

        voucherPage.click_voucher_50();
        voucherPage.click_buy_now();
        Assert.assertTrue(voucherPage.check_title(voucherPage.byTitle, SUB_TITLE));

        voucherPage.click_payment();
    }

    @AfterMethod
    public void back_to_home_page() {
        voucherPage.cancel_order();
    }
}
