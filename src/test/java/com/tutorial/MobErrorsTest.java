package com.tutorial;

import Util.TestCheck.TestCheck;
import org.testng.annotations.Test;

public class MobErrorsTest extends AbstractTest {
    @Test
    public void mobErrorTest() {
        MailCreatorPage mailCreatorPage = new MailCreatorPage();
        mailCreatorPage.mobError();
        TestCheck.assertEquals(mailCreatorPage.REC_PHONE_ERROR.getText(), mailCreatorPage.MOB_ERROR_EXP);
    }
}
