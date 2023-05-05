package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.basetest.BaseTest;
import com.orangehrmlive.demo.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UsersTest extends BaseTest {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    ViewSystemUsersPage viewSystemUserPage = new ViewSystemUsersPage();
    AddUserPage addUserPage = new AddUserPage();
    AdminPage adminPage = new AdminPage();
    HomePage homePage = new HomePage();
    @Test
    public void adminShouldAddUserSuccessFully() throws InterruptedException {
        loginPage.setUsernameOption("Admin");
        loginPage.passwordOption("admin123");
        loginPage.clickLoginButton();
        String expectedMessage = "Dashboard";
        Assert.assertEquals(dashboardPage.getTextDashboard(), expectedMessage, "Dashboard");
        dashboardPage.clickOnAdminTab();
        String expectedMessage1 = "System Users";
        Assert.assertEquals(addUserPage.verifySystemUsersText(), expectedMessage1, "System User text not displayed");
        addUserPage.clickOnAddButton();
        String expectedMessage2 = "Add User";
        Assert.assertEquals(addUserPage.verifyAddUserText(), expectedMessage2, "Add user text not displayed");
        Thread.sleep(2000);
        addUserPage.selectTheUserRoleDropdown();
        addUserPage.selectTheAdminOptionInUserRoleDropdown();
        addUserPage.enterEmployeeName("Martin King");
        addUserPage.enterUserName("MartinKing");
        addUserPage.selectStatus("Disabled");
        addUserPage.enterPasswordInPasswordField("MartinKing");
        addUserPage.enterConfirmPasswordInPasswordField("MartinKing");
        addUserPage.clickOnSaveButton();
        String expectedMessage3 = "Successfully Saved";
        Assert.assertEquals(addUserPage.verifySuccessfullySavedText(), expectedMessage3, "Successfully Saved text not displayed");

    }

    @Test
    public void searchTheUserCreatedAndVerifyIt() {
        viewSystemUserPage.setUsernameOption("Admin");
        viewSystemUserPage.passwordOption("admin123");
        viewSystemUserPage.clickLoginButton();
        String expectedMessage = "System Users";
        Assert.assertEquals(viewSystemUserPage.verifySystemUsersText(), expectedMessage, "System User text not displayed");
        viewSystemUserPage.enterUserName("John Smith1.");
        viewSystemUserPage.selectTheUserRoleDropdown();
        viewSystemUserPage.selectTheAdminOptionInUserRoleDropdown();
        viewSystemUserPage.enterEmployeeName("Martin King");
        viewSystemUserPage.selectStatus("Disabled");
        viewSystemUserPage.clickOnSearchButton();
        String expectedMessage1 = "Martin King";
        Assert.assertEquals(viewSystemUserPage.verifyUserInSearchResult(), expectedMessage1, "User Martin King 1 not found");
    }

    @Test
    public void verifyThatAdminShouldDeleteTheUserSuccessFully() {
        adminPage.setUsernameOption("Admin");
        adminPage.passwordOption("admin123");
        adminPage.clickLoginButton();
        String expectedMessage = "System Users";
        Assert.assertEquals(adminPage.verifySystemUsersText(), expectedMessage, "System User text not displayed");
        adminPage.enterUserName("Martin King");
        adminPage.selectTheUserRoleDropdown();
        adminPage.selectTheAdminOptionInUserRoleDropdown();
        adminPage.enterEmployeeName("Martin King");
        adminPage.selectStatus("Disabled");
        adminPage.clickOnSearchButton();
        String expectedMessage1 = "Martin King";
        Assert.assertEquals(adminPage.verifyUserInSearchResult(), expectedMessage1, "User John Smith 1 not found");
        adminPage.clickOnCheckBoxButton();
        adminPage.clickOnDeleteButton();
        adminPage.clickOnYesDeleteButton();
        String expectedMessage2 = "Successfully Deleted";
        Assert.assertEquals(adminPage.verifyUserInSearchResult(), expectedMessage2, "User not Deleted");
    }

    @Test
    public void searchTheDeletedUserAndVerifyTheMessageNoRecordFound() {
        homePage.setUsernameOption("Admin");
        homePage.passwordOption("admin123");
        homePage.clickLoginButton();
        String expectedMessage = "System Users";
        Assert.assertEquals(homePage.verifySystemUsersText(), expectedMessage, "System User text not displayed");
        homePage.enterUserName("Martin King.");
        homePage.selectTheUserRoleDropdown();
        homePage.selectTheUserRoleDropdown();
        homePage.clickOnSearchButton();
        homePage.verifyUserNotFoundText();


    }
}
