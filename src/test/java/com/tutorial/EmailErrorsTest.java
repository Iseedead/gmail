package com.tutorial;

import Util.TestCheck.TestCheck;
import org.testng.annotations.Test;

public class EmailErrorsTest extends AbstractTest {
    @Test(dataProvider = "errorEmailInput", dataProviderClass = Util.DataProviderWrongInput.class)
    private void emailErrorsTest(String wrongInput, String expectedError) throws InterruptedException {
        MailCreatorPage mailCreatorPage = new MailCreatorPage();
        mailCreatorPage.emailErrors(wrongInput);
        TestCheck.assertEquals(mailCreatorPage.GMAIL_ERROR.getText(), expectedError);
    }
}
