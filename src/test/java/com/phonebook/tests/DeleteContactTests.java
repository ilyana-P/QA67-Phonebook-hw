package com.phonebook.tests;

import com.phonebook.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase {

    @BeforeMethod
    public void precondition(){
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new com.phonebook.models.User()
                .setEmail("il.potnyaeva+test2@gmail.com")
                .setPassword("Test1234!"));
        app.getUser().clickOnLoginButton();

        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new com.phonebook.models.Contact()
                .setName("Oliver")
                .setLastName("Koen")
                .setPhone("1234567890")
                .setEmail("test@gmail.com")
                .setAddress("TelAviv")
                .setDescription("QA"));
        app.getContact().clickOnSaveButton();
    }
    @Test
    public void deleteContactTest(){
        int sizeBefore = app.getContact().sizeOfContacts();

        app.getContact().removeContact();
        app.getUser().pause(1000);
        int sizeAfter = app.getContact().sizeOfContacts();
        Assert.assertEquals(sizeAfter,sizeBefore-1);

    }


}
