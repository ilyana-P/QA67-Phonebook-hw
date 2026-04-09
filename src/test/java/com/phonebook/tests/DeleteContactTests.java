package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        app.clickOnLoginLink();
        app.fillLoginRegisterForm(new User()
                .setEmail("kristitomash001@gmail.com")
                .setPassword("Aa12345!"));
        app.clickOnLoginButton();

        app.clickOnAddLink();
        app.fillContactForm(new Contact()
                .setName("Oliver")
                .setLastName("Koen")
                .setPhone("1234567890")
                .setEmail("test@gmail.com")
                .setAddress("TelAviv")
                .setDescription("QA"));
        app.clickOnSaveButton();
    }
    @Test
    public void deleteContactTest(){
        int sizeBefore = app.sizeOfContacts();

        app.removeContact();
        app.pause(1000);
        int sizeAfter = app.sizeOfContacts();
        Assert.assertEquals(sizeAfter,sizeBefore-1);

    }


}
