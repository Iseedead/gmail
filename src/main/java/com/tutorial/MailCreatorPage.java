package com.tutorial;

import Util.BaseStuff;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


import static Util.DriverWrapper.getDriver;
public class MailCreatorPage extends BaseStuff {
    //Elements
    @CacheLookup @FindBy(id = "submitbutton") private WebElement submitButton;
    @CacheLookup @FindBy(id = "GmailAddress") private WebElement gmailAddress;
    @CacheLookup @FindBy(id = "Passwd") private WebElement pwd;
    @CacheLookup @FindBy(id = "PasswdAgain") private WebElement pwd2;
    @CacheLookup @FindBy(id = "BirthMonth") private WebElement birthMon;    //vot tak namano
    @CacheLookup @FindBy(id = "BirthDay") private WebElement birthDa;
    @CacheLookup @FindBy(id = "BirthYear") private WebElement birthYea;
    @CacheLookup @FindBy(id = "RecoveryPhoneNumber") private WebElement mobile;
    @CacheLookup @FindBy(id = "RecoveryEmailAddress") private WebElement recMail;
    //Errors

    private final By FIRST_NAME_ERROR_SELECTOR = By.id("errormsg_0_FirstName");
    private final By LAST_NAME_ERROR_SELECTOR = By.id("errormsg_0_LastName");
    private final By GMAIL_ERROR_SELECTOR = By.id("errormsg_0_GmailAddress");
    private final By PASSWD_ERROR_SELECTOR = By.id("errormsg_0_Passwd");
    private final By PASSWD_AGAIN_ERROR_SELECTOR = By.id("errormsg_0_PasswdAgain");
    private final By BIRTH_MONTH_ERROR_SELECTOR = By.id("errormsg_0_BirthMonth");
    private final By BIRTH_DAY_ERROR_SELECTOR = By.id("errormsg_0_BirthDay");
    private final By BIRTH_YEAR_ERROR_SELECTOR = By.id("errormsg_0_BirthYear");
    private final By GENDER_ERROR_SELECTOR = By.id("errormsg_0_Gender");
    private final By MOB_ERROR_SELECTOR = By.id("errormsg_0_RecoveryPhoneNumber");
    private final By REC_MAIL_ERROR_SELECTOR = By.id("errormsg_0_RecoveryEmailAddress");

    final String EMPTY_ERROR_EXP = "You can't leave this empty.";
    final String PASSWD_MATCH_ERROR_EXP = "These passwords don't match. Try again?";
    final String BIRTH_DAY_ERROR_EXP = "Hmm, the day doesn't look right. " +
            "Be sure to use a 2-digit number that is a day of the month.";
    final String BIRTH_YEAR_ERROR_EXP = "Hmm, the date doesn't look right. " +
            "Be sure to use your actual date of birth.";
    final String MOB_ERROR_EXP = "This phone number format is not recognized. " +
            "Please check the country and number.";

    @CacheLookup @FindBy(id = "errormsg_0_FirstName") WebElement FIRST_NAME_ERROR;
    @CacheLookup @FindBy(id = "errormsg_0_LastName") WebElement LAST_NAME_ERROR;
    @CacheLookup @FindBy(id = "errormsg_0_GmailAddress") WebElement GMAIL_ERROR;
    @CacheLookup @FindBy(id = "errormsg_0_Passwd") WebElement PASSWD_ERROR;
    @CacheLookup @FindBy(id = "errormsg_0_PasswdAgain") WebElement PASSWD_AGAIN_ERROR;
    @CacheLookup @FindBy(id = "errormsg_0_BirthMonth") WebElement BIRTH_MONTH_ERROR;
    @CacheLookup @FindBy(id = "errormsg_0_BirthDay") WebElement BIRTH_DAY_ERROR;
    @CacheLookup @FindBy(id = "errormsg_0_BirthYear") WebElement BIRTH_YEAR_ERROR;
    @CacheLookup @FindBy(id = "errormsg_0_Gender") WebElement GENDER_ERROR;
    @CacheLookup @FindBy(id = "errormsg_0_RecoveryPhoneNumber") WebElement REC_PHONE_ERROR;
    @CacheLookup @FindBy(id = "errormsg_0_RecoveryEmailAddress") WebElement REC_MAIL_ERROR;




    void submitButton() {
        submitButton.submit();
    }

    void emailErrors(String error) {
        gmailAddress.sendKeys(error, Keys.ENTER);
        waitUntil(GMAIL_ERROR_SELECTOR);
    }

    void passwdErrors(String error) {
        pwd2.submit();
        pwd.sendKeys(error, Keys.ENTER);
        waitUntil(PASSWD_ERROR_SELECTOR);
        waitUntil(PASSWD_AGAIN_ERROR_SELECTOR);
    }

    void birthDayError() {
        birthMon.click();
        getDriver().findElement(By.id(":5")).click();
        birthDa.sendKeys("99");
        birthYea.sendKeys("99", Keys.ENTER);
        waitUntil(BIRTH_DAY_ERROR_SELECTOR);
    }

    void birthYearError() {
        birthDa.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, "15");
        birthYea.sendKeys("99", Keys.ENTER);
        waitUntil(BIRTH_YEAR_ERROR_SELECTOR);
    }

    void mobError() {
        mobile.sendKeys(" grebi, rab", Keys.ENTER);
        waitUntil(MOB_ERROR_SELECTOR);
    }

    void recoveryMail(String error) {
        recMail.sendKeys(error, Keys.ENTER);
        waitUntil(REC_MAIL_ERROR_SELECTOR);
    }

    public void subFieldsFill(String id, String errorIn) {
        getDriver().findElement(By.id(id)).sendKeys("15");
        submitButton();
        waitUntil(By.id("errormsg_0_" + errorIn));
    }
}
