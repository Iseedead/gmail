package com.tutorial;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EmailErrorsTest extends AbstractTest {
    @Test(dataProvider = "errorEmailInput", dataProviderClass = Util.DataProviderWrongInput.class)
    private void emailErrorsTest(String wrongInput, String expectedError) throws InterruptedException {
        MailCreatorPage mailCreatorPage = new MailCreatorPage();
        mailCreatorPage.emailErrors(wrongInput);
        Assert.assertEquals(mailCreatorPage.gmailError.getText(), expectedError);
    }
}
