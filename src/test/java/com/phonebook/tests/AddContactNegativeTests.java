package com.phonebook.tests;

import com.phonebook.core.TestBase;
import com.phonebook.data.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactNegativeTests extends TestBase {

    @BeforeMethod
    public void precondition(){
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new com.phonebook.models.User()
                .setEmail(com.phonebook.data.UserData.email)
                .setPassword(com.phonebook.data.UserData.password));
        app.getUser().clickOnLoginButton();

    }
    @Test
    public void addContactWithInvalidPhoneTest(){
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new com.phonebook.models.Contact()
                .setName(ContactData.name)
                .setLastName(ContactData.lastName)
                .setPhone("234567890")
                .setEmail(ContactData.email)
                .setAddress(ContactData.address)
                .setDescription(ContactData.description));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isAlertPresent());

    }
}
//data-driven
