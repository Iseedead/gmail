package com.tutorial;

import org.testng.Assert;
import org.testng.annotations.Test;


public class EmptyErrorTest extends AbstractTest {
    @Test
    public void emptySubFieldsTest() {
        MailCreatorPage mailCreatorPage = new MailCreatorPage();
        mailCreatorPage.subFieldsFill("LastName", "FirstName");
        Assert.assertEquals(mailCreatorPage.FIRST_NAME_ERROR.getText(), mailCreatorPage.EMPTY_ERROR_EXP);
        mailCreatorPage.subFieldsFill("BirthYear", "BirthDay");
        Assert.assertEquals(mailCreatorPage.BIRTH_DAY_ERROR.getText(), mailCreatorPage.EMPTY_ERROR_EXP);
        mailCreatorPage.subFieldsFill("BirthDay", "BirthMonth");
        Assert.assertEquals(mailCreatorPage.BIRTH_MONTH_ERROR.getText(), mailCreatorPage.EMPTY_ERROR_EXP);
    }

    @Test
    private void emptyErrorsTest() throws InterruptedException {
        MailCreatorPage mailCreatorPage = new MailCreatorPage();
        mailCreatorPage.submitButton();
        //EmptyErrors
        Assert.assertEquals(mailCreatorPage.LAST_NAME_ERROR.getText(), mailCreatorPage.EMPTY_ERROR_EXP);
        Assert.assertEquals(mailCreatorPage.GMAIL_ERROR.getText(), mailCreatorPage.EMPTY_ERROR_EXP);
        Assert.assertEquals(mailCreatorPage.PASSWD_ERROR.getText(), mailCreatorPage.EMPTY_ERROR_EXP);
        Assert.assertEquals(mailCreatorPage.PASSWD_AGAIN_ERROR.getText(), mailCreatorPage.EMPTY_ERROR_EXP);
        Assert.assertEquals(mailCreatorPage.BIRTH_YEAR_ERROR.getText(), mailCreatorPage.EMPTY_ERROR_EXP);
        Assert.assertEquals(mailCreatorPage.GENDER_ERROR.getText(), mailCreatorPage.EMPTY_ERROR_EXP);
    }
}
