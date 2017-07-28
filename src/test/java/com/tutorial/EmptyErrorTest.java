package com.tutorial;

import org.testng.Assert;
import org.testng.annotations.Test;


public class EmptyErrorTest extends AbstractTest {
    @Test
    public void emptySubFieldsTest() {
        MailCreatorPage mailCreatorPage = new MailCreatorPage();
        mailCreatorPage.subFieldsFill("LastName", "FirstName");
        Assert.assertEquals(mailCreatorPage.firstNameError.getText(), mailCreatorPage.emptyErrorExpected);
        mailCreatorPage.subFieldsFill("BirthYear", "BirthDay");
        Assert.assertEquals(mailCreatorPage.birthDayError.getText(), mailCreatorPage.emptyErrorExpected);
        mailCreatorPage.subFieldsFill("BirthDay", "BirthMonth");
        Assert.assertEquals(mailCreatorPage.birthMonthError.getText(), mailCreatorPage.emptyErrorExpected);
    }

    @Test
    private void emptyErrorsTest() throws InterruptedException {
        MailCreatorPage mailCreatorPage = new MailCreatorPage();
        mailCreatorPage.submitButton();
        //EmptyErrors
        Assert.assertEquals(mailCreatorPage.lastNameError.getText(), mailCreatorPage.emptyErrorExpected);
        Assert.assertEquals(mailCreatorPage.gmailError.getText(), mailCreatorPage.emptyErrorExpected);
        Assert.assertEquals(mailCreatorPage.passwdError.getText(), mailCreatorPage.emptyErrorExpected);
        Assert.assertEquals(mailCreatorPage.passwdAgainError.getText(), mailCreatorPage.emptyErrorExpected);
        Assert.assertEquals(mailCreatorPage.birthYearError.getText(), mailCreatorPage.emptyErrorExpected);
        Assert.assertEquals(mailCreatorPage.genderError.getText(), mailCreatorPage.emptyErrorExpected);
    }
}
