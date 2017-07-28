package com.tutorial;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RecoveryMailErrorsTest extends AbstractTest {
    @Test(dataProvider = "errorRecoveryMailInput", dataProviderClass = Util.DataProviderWrongInput.class)
    public void recoveryMailErrorsTest(String wrongInput, String expectedError) {
        MailCreatorPage mailCreatorPage = new MailCreatorPage();
        mailCreatorPage.recoveryMail(wrongInput);
        Assert.assertEquals(mailCreatorPage.recoveryMailError.getText(), expectedError);
    }
}
