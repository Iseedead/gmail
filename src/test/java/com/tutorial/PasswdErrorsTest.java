package com.tutorial;

import Util.TestCheck.TestCheck;
import org.testng.annotations.Test;

public class PasswdErrorsTest extends AbstractTest {
    @Test(dataProvider = "errorPasswdInput", dataProviderClass = Util.DataProviderWrongInput.class)
    public void passwdErrorsTest(String wrongInput, String expectedError) throws InterruptedException {
        MailCreatorPage mailCreatorPage = new MailCreatorPage();
        mailCreatorPage.passwdErrors(wrongInput);
        TestCheck.assertEquals(mailCreatorPage.PASSWD_ERROR.getText(), expectedError);
        TestCheck.assertEquals(mailCreatorPage.PASSWD_AGAIN_ERROR.getText(), mailCreatorPage.PASSWD_MATCH_ERROR_EXP);
    }
}
