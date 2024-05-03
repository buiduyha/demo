//package com.qaauto.wintelapp.testcase;
//
//import com.qaauto.wintelapp.page.LoginPage;
//import com.qaauto.wintelapp.utils.WelcomePage;
//import com.qaauto.wintelapp.testcase.BasePageTest;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//public class WelcomePageTest extends BasePageTest {
//    WelcomePage welcomePage;
//
//    @BeforeClass
//    public void open_app() {
//        welcomePage = new WelcomePage(driver);
//    }
//
//    @Test(groups = {"login_first"})
//    public void login_first() {
//        System.out.println("Test login first ...");
//        welcomePage.login();
//        Assert.assertTrue(LoginPage.isLoaded());
//    }
//
//    @AfterClass
//    public void back_to_welcome_page() {
//        welcomePage.press_back();
//        welcomePage.press_back();
//    }
//}
