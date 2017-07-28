package com.tutorial;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BirthErrorsTest extends AbstractTest {
    @Test
    public void birthErrorsTest() throws InterruptedException {
        MailCreatorPage mailCreatorPage = new MailCreatorPage();
        mailCreatorPage.birthDayError();
        Assert.assertEquals(mailCreatorPage.birthDayError.getText(), mailCreatorPage.birthDayErrorExpected);
        mailCreatorPage.birthYearError();
        Assert.assertEquals(mailCreatorPage.birthYearError.getText(), mailCreatorPage.birthYearErrorExpected);
    }
}
