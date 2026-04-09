package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginPositiveTest(){
       
        app.clickOnLoginLink();
        app.fillLoginRegisterForm(new User()
                .setEmail(UserData.email)
                .setPassword(UserData.password));
        app.clickOnLoginButton();
        Assert.assertTrue(app.isSignButtonPresent());

        }
        @Test
    public void loginNegativeWithoutEmailTest(){

        app.clickOnLoginLink();
        app.fillLoginRegisterForm(new User()
                .setPassword(UserData.password));
        app.clickOnLoginButton();
        Assert.assertTrue(app.isAlertPresent());

        }

}

