package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

    @BeforeMethod
    public void precondition(){
        app.clickOnLoginLink();
        app.fillLoginRegisterForm(new User()
                .setEmail(UserData.email)
                .setPassword(UserData.password));
        app.clickOnLoginButton();
    }
    @Test
    public void addContactPositiveTest(){
          
        app.clickOnAddLink();
        app.fillContactForm(new Contact()
                .setName(ContactData.name)
                .setLastName(ContactData.lastName)
                .setPhone(ContactData.phone)
                .setEmail(ContactData.email)
                .setAddress(ContactData.address)
                .setDescription(ContactData.description));
        app.clickOnSaveButton();
        Assert.assertTrue(app.isContactCreatedByText(ContactData.name));

    }

    @AfterMethod
    public void postConditions(){
        app.removeContact();
    }

}
