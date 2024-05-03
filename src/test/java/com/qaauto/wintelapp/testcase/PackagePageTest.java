package com.qaauto.wintelapp.testcase;

import com.qaauto.wintelapp.page.LoginPage;
import com.qaauto.wintelapp.page.PackagePage;
import com.qaauto.wintelapp.utils.HomePage;
import com.qaauto.wintelapp.utils.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PackagePageTest extends BasePageTest {
    WelcomePage welcomePage;
    LoginPage loginPage;
    HomePage homePage;
    PackagePage packagePage;

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
        packagePage = new PackagePage(driver);
        homePage.click_home_icon();
    }

    @Test(dependsOnMethods = {"buyPhoneNumberAfterLogin"}, groups = {"buyPackage"})
    public void buyPackage() {
        System.out.println("Test buy package ...");
        homePage.click_package_icon();
        Assert.assertTrue(packagePage.isLoaded());
        packagePage.buyPackage();
    }

    @AfterMethod
    public void back_to_home_page() {
//        packagePage = new PackagePage(driver);
        packagePage.press_back();
        packagePage.press_back();
//        while (!homePage.isLoaded()) {
//            packagePage.press_back();
//        }
        homePage.click_home_icon();
    }
}
