package com.tutorial;

import Util.TestCheck.TestCheck;
import org.testng.annotations.Test;

public class BirthErrorsTest extends AbstractTest {
    @Test
    public void birthErrorsTest() throws InterruptedException {
        MailCreatorPage mailCreatorPage = new MailCreatorPage();
        mailCreatorPage.birthDayError();
        TestCheck.assertEquals(mailCreatorPage.BIRTH_DAY_ERROR.getText(), mailCreatorPage.BIRTH_DAY_ERROR_EXP);
        mailCreatorPage.birthYearError();
        TestCheck.assertEquals(mailCreatorPage.BIRTH_YEAR_ERROR.getText(), mailCreatorPage.BIRTH_YEAR_ERROR_EXP);
    }
}
