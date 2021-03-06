package com.tutorial;

import Util.TestCheck.TestCheck;
import org.testng.annotations.Test;

public class RecoveryMailErrorsTest extends AbstractTest {
    @Test(dataProvider = "errorRecoveryMailInput", dataProviderClass = Util.DataProviderWrongInput.class)
    public void recoveryMailErrorsTest(String wrongInput, String expectedError) {
        MailCreatorPage mailCreatorPage = new MailCreatorPage();
        mailCreatorPage.recoveryMail(wrongInput);
        TestCheck.assertEquals(mailCreatorPage.REC_MAIL_ERROR.getText(), expectedError);
    }
}
