package com.qaauto.wintelapp.testcase;

import com.qaauto.wintelapp.utils.HomePage;
import com.qaauto.wintelapp.page.LoginPage;
import com.qaauto.wintelapp.utils.WelcomePage;
import com.qaauto.wintelapp.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BasePageTest {
    WelcomePage welcomePage;
    LoginPage loginPage;

    @BeforeClass
    public void open_app() {
        welcomePage = new WelcomePage(driver);
    }

    @BeforeMethod
    public void setUp() {
        welcomePage.login();
        loginPage = new LoginPage(driver);
    }

    @Test(dependsOnMethods = {"buyPhoneNumberBeforeLogin"}, groups = {"login"})
    public void login() {
        System.out.println("Test login ...");
        loginPage.login(Constants.PHONE_NUMBER, Constants.PASSWORD);
        Assert.assertTrue(HomePage.isLoaded());
    }

    @AfterMethod
    public void tearDown() {
    }
}
