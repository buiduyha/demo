package com.qaauto.wintelapp.testcase;

import com.qaauto.wintelapp.page.LoginPage;
import com.qaauto.wintelapp.page.TopUpPage;
import com.qaauto.wintelapp.utils.Constants;
import com.qaauto.wintelapp.utils.HomePage;
import com.qaauto.wintelapp.utils.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TopUpPageTest extends BasePageTest {
    String TITLE = "Nạp tiền";
    WelcomePage welcomePage;
    LoginPage loginPage;
    HomePage homePage;
    TopUpPage topUpPage;

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
        topUpPage = new TopUpPage(driver);
        homePage.click_home_icon();
    }

    @Test(dependsOnMethods = {"buyPackage"}, groups = {"top_up"})
    public void top_up() {
        System.out.println("Test top up ...");
        homePage.click_top_up();
        Assert.assertTrue(topUpPage.isLoaded());
        Assert.assertTrue(topUpPage.check_title(topUpPage.byTitle, TITLE));

        // check default
        Assert.assertEquals(topUpPage.getEdtPhoneNumber().getText(), Constants.PHONE_NUMBER);
        Assert.assertEquals(topUpPage.getEdtAmountOfMoney().getText(), "100.000");
        Assert.assertEquals(topUpPage.getLbPaymentAmount().getText(), "100.000đ");

        topUpPage.top_up();
    }

    @AfterMethod
    public void back_to_home_page() {
        topUpPage.press_back();
        topUpPage.press_back();
    }
}
