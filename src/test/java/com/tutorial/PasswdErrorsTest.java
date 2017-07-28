package com.tutorial;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PasswdErrorsTest extends AbstractTest {
    @Test(dataProvider = "errorPasswdInput", dataProviderClass = Util.DataProviderWrongInput.class)
    public void passwdErrorsTest(String wrongInput, String expectedError) throws InterruptedException {
        MailCreatorPage mailCreatorPage = new MailCreatorPage();
        mailCreatorPage.passwdErrors(wrongInput);
        Assert.assertEquals(mailCreatorPage.PASSWD_ERROR.getText(), expectedError);
        Assert.assertEquals(mailCreatorPage.PASSWD_AGAIN_ERROR.getText(), mailCreatorPage.PASSWD_MATCH_ERROR_EXP);
    }
}
