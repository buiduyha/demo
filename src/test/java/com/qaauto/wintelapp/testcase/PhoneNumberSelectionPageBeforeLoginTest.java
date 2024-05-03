package com.qaauto.wintelapp.testcase;

import com.qaauto.wintelapp.page.*;
import com.qaauto.wintelapp.utils.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PhoneNumberSelectionPageBeforeLoginTest extends BasePageTest {
    String TITLE = "Chọn số";
    WelcomePage welcomePage;
    PhoneNumberSelectionPage phoneNumberSelectionPage;

    @BeforeClass
    public void open_app() {
        welcomePage = new WelcomePage(driver);
        phoneNumberSelectionPage = new PhoneNumberSelectionPage(driver);
    }

    @BeforeMethod
    public void open_buy_phone_number_screen() {
        welcomePage.click_buy_sim();
    }

    @Test(groups = {"buyPhoneNumberBeforeLogin"})
    public void buyPhoneNumberBeforeLogin() {
        System.out.println("Test buy phone number before login ...");
        Assert.assertTrue(phoneNumberSelectionPage.isLoaded());
        phoneNumberSelectionPage.buyPhoneNumber();
    }

    @AfterMethod
    public void back_welcome_page() {
        phoneNumberSelectionPage.close();
    }
}
