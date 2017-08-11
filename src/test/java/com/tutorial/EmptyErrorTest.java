package com.tutorial;

import Util.TestCheck.TestCheck;
import org.testng.annotations.Test;


public class EmptyErrorTest extends AbstractTest {
    @Test
    public void emptySubFieldsTest() {
        MailCreatorPage mailCreatorPage = new MailCreatorPage();
        mailCreatorPage.subFieldsFill("LastName", "FirstName");
        TestCheck.assertEquals(mailCreatorPage.FIRST_NAME_ERROR.getText(), mailCreatorPage.EMPTY_ERROR_EXP);
        mailCreatorPage.subFieldsFill("BirthYear", "BirthDay");
        TestCheck.assertEquals(mailCreatorPage.BIRTH_DAY_ERROR.getText(), mailCreatorPage.EMPTY_ERROR_EXP);
        mailCreatorPage.subFieldsFill("BirthDay", "BirthMonth");
        TestCheck.assertEquals(mailCreatorPage.BIRTH_MONTH_ERROR.getText(), mailCreatorPage.EMPTY_ERROR_EXP);
    }

    @Test
    private void emptyErrorsTest() throws InterruptedException {
        MailCreatorPage mailCreatorPage = new MailCreatorPage();
        mailCreatorPage.submitButton();
        //EmptyErrors
        TestCheck.assertEquals(mailCreatorPage.LAST_NAME_ERROR.getText(), mailCreatorPage.EMPTY_ERROR_EXP);
        TestCheck.assertEquals(mailCreatorPage.GMAIL_ERROR.getText(), mailCreatorPage.EMPTY_ERROR_EXP);
        TestCheck.assertEquals(mailCreatorPage.PASSWD_ERROR.getText(), mailCreatorPage.EMPTY_ERROR_EXP);
        TestCheck.assertEquals(mailCreatorPage.PASSWD_AGAIN_ERROR.getText(), mailCreatorPage.EMPTY_ERROR_EXP);
        TestCheck.assertEquals(mailCreatorPage.BIRTH_YEAR_ERROR.getText(), mailCreatorPage.EMPTY_ERROR_EXP);
        TestCheck.assertEquals(mailCreatorPage.GENDER_ERROR.getText(), mailCreatorPage.EMPTY_ERROR_EXP);
    }
}
