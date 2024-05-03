//package com.qaauto.wintelapp.testcase;
//
//import com.qaauto.wintelapp.utils.HomePage;
//import com.qaauto.wintelapp.page.LoginPage;
//import com.qaauto.wintelapp.page.TopUpPage;
//import com.qaauto.wintelapp.utils.WelcomePage;
//import com.qaauto.wintelapp.testcase.BasePageTest;
//import com.qaauto.wintelapp.utils.Constants;
//import org.testng.Assert;
//import org.testng.annotations.*;
//
//public class HomePageTest extends BasePageTest {
//    WelcomePage welcomePage;
//    LoginPage loginPage;
//    HomePage homePage;
//
//    @BeforeClass
//    public void open_app_and_login() {
//        welcomePage = new WelcomePage(driver);
//        welcomePage.login();
//        loginPage = new LoginPage(driver);
//        loginPage.login(Constants.PHONE_NUMBER, Constants.PASSWORD);
//    }
//
//    @BeforeMethod
//    public void setUp() {
//        homePage = new HomePage(driver);
//        homePage.click_home_icon();
//    }
//
//    @Test(dependsOnMethods = "login")
//    public void click_top_up() {
//        homePage.click_top_up();
//        Assert.assertTrue(TopUpPage.isLoaded());
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        homePage.press_back();
//        homePage.click_home_icon();
//    }
//
//    @AfterClass
//    public void abc() {
//    }
//}
