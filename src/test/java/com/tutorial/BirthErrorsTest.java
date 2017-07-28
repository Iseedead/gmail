package com.tutorial;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BirthErrorsTest extends AbstractTest {
    @Test
    public void birthErrorsTest() throws InterruptedException {
        MailCreatorPage mailCreatorPage = new MailCreatorPage();
        mailCreatorPage.birthDayError();
        Assert.assertEquals(mailCreatorPage.BIRTH_DAY_ERROR.getText(), mailCreatorPage.BIRTH_DAY_ERROR_EXP);
        mailCreatorPage.birthYearError();
        Assert.assertEquals(mailCreatorPage.BIRTH_YEAR_ERROR.getText(), mailCreatorPage.BIRTH_YEAR_ERROR_EXP);
    }
}
