package com.qaauto.wintelapp.testcase;

import com.qaauto.wintelapp.utils.HomePage;
import com.qaauto.wintelapp.page.LoginPage;
import com.qaauto.wintelapp.page.PhoneNumberSelectionPage;
import com.qaauto.wintelapp.utils.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PhoneNumberSelectionPageAfterLoginTest extends BasePageTest {
    String TITLE = "Chọn số";
    WelcomePage welcomePage;
    LoginPage loginPage;
    HomePage homePage;
    PhoneNumberSelectionPage phoneNumberSelectionPage;

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
        phoneNumberSelectionPage = new PhoneNumberSelectionPage(driver);
        homePage.click_home_icon();
    }

    @Test(dependsOnMethods = {"login"},groups={"buyPhoneNumberAfterLogin"})
    public void buyPhoneNumberAfterLogin() {
        System.out.println("Test buy phone number after login ...");
        homePage.click_number_warehouse();
        Assert.assertTrue(phoneNumberSelectionPage.isLoaded());
        Assert.assertTrue(phoneNumberSelectionPage.check_title(phoneNumberSelectionPage.byTitle, TITLE));
        phoneNumberSelectionPage.buyPhoneNumber();
    }

    @AfterMethod
    public void back_to_home_page() {
        phoneNumberSelectionPage.back_to_home_page();
    }
}
