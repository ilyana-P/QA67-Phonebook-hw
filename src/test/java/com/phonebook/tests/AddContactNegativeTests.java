package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactNegativeTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        app.clickOnLoginLink();
        app.fillLoginRegisterForm(new User()
                .setEmail(UserData.email)
                .setPassword(UserData.password));
        app.clickOnLoginButton();

    }
    @Test
    public void addContactWithInvalidPhoneTest(){
        app.clickOnAddLink();
        app.fillContactForm(new Contact()
                .setName(ContactData.name)
                .setLastName(ContactData.lastName)
                .setPhone("234567890")
                .setEmail(ContactData.email)
                .setAddress(ContactData.address)
                .setDescription(ContactData.description));
        app.clickOnSaveButton();
        Assert.assertTrue(app.isAlertPresent());

    }
}
