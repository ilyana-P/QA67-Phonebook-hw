package com.phonebook.tests;

import com.phonebook.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.phonebook.core.ApplicationManager.softAssert;

public class CreateAccountTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }
    @Test(enabled = false)
    public void newUserRegisterPositiveTest() {

        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new com.phonebook.models.User()
                .setEmail(com.phonebook.data.UserData.email)
                .setPassword(com.phonebook.data.UserData.password));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isSignButtonPresent());


    }

    @Test
    public void existedUserRegisterNegativeTest() {

        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new com.phonebook.models.User()
                .setEmail(com.phonebook.data.UserData.email)
                .setPassword(com.phonebook.data.UserData.password));
        app.getUser().clickOnRegistrationButton();
        //Assert.assertTrue(app.getUser().isAlertPresent());
        softAssert.assertTrue(app.getUser().isAlertPresent());
        softAssert.assertTrue(app.getUser().isErrorMessagePresent());
        softAssert.assertAll();
    }

}




