package com.phonebook.tests;

import com.phonebook.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test
    public void loginPositiveTest(){
       
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new com.phonebook.models.User()
                .setEmail(com.phonebook.details.UserDetails.EMAIL)
                .setPassword(com.phonebook.details.UserDetails.PASSWORD));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isSignButtonPresent());

        }
        @Test
    public void loginNegativeWithoutEmailTest(){

        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new com.phonebook.models.User()
                .setPassword(com.phonebook.details.UserDetails.PASSWORD));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertPresent());

        }

}

