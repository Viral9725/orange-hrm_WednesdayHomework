package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.basetest.BaseTest;
import com.orangehrmlive.demo.pages.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Test
    public void verifyUserShouldLoginSuccessFully(){
        loginPage.setUsernameOption("Admin");
        loginPage.passwordOption("admin123");
        loginPage.clickLoginButton();
        String expectedMessage = "Dashboard";
        Assert.assertEquals(dashboardPage.getTextDashboard(),expectedMessage, "Dashboard");
    }
    @Test
    public void VerifyThatTheLogoDisplayOnLoginPage() {
        //   Launch the application
        loginPage.clickOnElement(By.xpath("//button[@type='submit']"));
        //    Verify Logo is Displayed
        loginPage.clickOnElement(By.xpath("//img[@alt='company-branding']"));
        //verify message logo display
     //   Assert.assertEquals(loginPage.getPopUpMessage(), "Customer added successfully with customer id :8", "Message not found");
    }
    @Test
    public void VerifyUserShouldLogOutSuccessFully() {
        // Login To The application
        //   Click on User Profile logo
        loginPage.clickLoginButton();
      //  loginPage.clickOnElement(By.xpath("//img[@class='oxd-userdropdown-img']"));
        //  Mouse hover on "Logout" and click
        dashboardPage.mouseHoverToElement(By.xpath(""));
   //     dashboardPage.clickOnElement();
        //   Verify the text "Login Panel" is displayed
       // Assert.assertEquals(loginPage.getPopUpMessage(), "Login", "Message not found");
    }
}
