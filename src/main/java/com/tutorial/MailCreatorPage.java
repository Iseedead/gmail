package com.tutorial;

import Util.BaseStuff;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import static Util.DriverWrapper.getDriver;
public class MailCreatorPage extends BaseStuff {
    //Elements
    @FindBy(id = "submitbutton")
    private WebElement submitButton;
    @FindBy(id = "GmailAddress")
    private WebElement gmailAddress;
    @FindBy(id = "Passwd")
    private WebElement pwd;
    @FindBy(id = "PasswdAgain")
    private WebElement pwd2;
    @FindBy(id = "BirthMonth")
    private WebElement birthMon;
    @FindBy(id = "BirthDay")
    private WebElement birthDa;
    @FindBy(id = "BirthYear")
    private WebElement birthYea;
    @FindBy(id = "RecoveryPhoneNumber")
    private WebElement mobile;
    @FindBy(id = "RecoveryEmailAddress")
    private WebElement recMail;

    private final By firstNameErrorSelector = By.id("errormsg_0_FirstName");
    private final By lastNameErrorSelector = By.id("errormsg_0_LastName");
    private final By gmailErrorSelector = By.id("errormsg_0_GmailAddress");
    private final By passwdErrorSelector = By.id("errormsg_0_Passwd");
    private final By passwdAgainErrorSelector = By.id("errormsg_0_PasswdAgain");
    private final By birthMonthErrorSelector = By.id("errormsg_0_BirthMonth");
    private final By birthDayErrorSelector = By.id("errormsg_0_BirthDay");
    private final By birthYearErrorSelector = By.id("errormsg_0_BirthYear");
    private final By genderErrorSelector = By.id("errormsg_0_Gender");
    private final By mobErrorSelector = By.id("errormsg_0_RecoveryPhoneNumber");
    private final By recoveryMailErrorSelector = By.id("errormsg_0_RecoveryEmailAddress");

    final String emptyErrorExpected = "You can't leave this empty.";
    final String passwdMatchErrorExpected = "These passwords don't match. Try again?";
    final String birthDayErrorExpected = "Hmm, the day doesn't look right. " +
            "Be sure to use a 2-digit number that is a day of the month.";
    final String birthYearErrorExpected = "Hmm, the date doesn't look right. " +
            "Be sure to use your actual date of birth.";
    final String mobErrorExpected = "This phone number format is not recognized. " +
            "Please check the country and number.";

    final WebElement firstNameError = getDriver().findElement(firstNameErrorSelector);
    final WebElement lastNameError = getDriver().findElement(lastNameErrorSelector);
    final WebElement gmailError = getDriver().findElement(gmailErrorSelector);
    final WebElement passwdError = getDriver().findElement(passwdErrorSelector);
    final WebElement passwdAgainError = getDriver().findElement(passwdAgainErrorSelector);
    final WebElement birthMonthError = getDriver().findElement(birthMonthErrorSelector);
    final WebElement birthDayError = getDriver().findElement(birthDayErrorSelector);
    final WebElement birthYearError = getDriver().findElement(birthYearErrorSelector);
    final WebElement genderError = getDriver().findElement(genderErrorSelector);
    final WebElement mobError = getDriver().findElement(mobErrorSelector);
    final WebElement recoveryMailError = getDriver().findElement(recoveryMailErrorSelector);


    void submitButton() {
        submitButton.submit();
    }

    void emailErrors(String error) {
        gmailAddress.sendKeys(error, Keys.ENTER);
        waitUntil(gmailErrorSelector);
    }

    void passwdErrors(String error) {
        pwd2.submit();
        pwd.sendKeys(error, Keys.ENTER);
        waitUntil(passwdErrorSelector);
        waitUntil(passwdAgainErrorSelector);
    }

    void birthDayError() {
        birthMon.click();
        getDriver().findElement(By.id(":5")).click();
        birthDa.sendKeys("99");
        birthYea.sendKeys("99", Keys.ENTER);
        waitUntil(birthDayErrorSelector);
    }

    void birthYearError() {
        birthDa.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, "15");
        birthYea.sendKeys("99", Keys.ENTER);
        waitUntil(birthYearErrorSelector);
    }

    void mobError() {
        mobile.sendKeys(" grebi, rab", Keys.ENTER);
        waitUntil(mobErrorSelector);
    }

    void recoveryMail(String error) {
        recMail.sendKeys(error, Keys.ENTER);
        waitUntil(recoveryMailErrorSelector);
    }

    public void subFieldsFill(String id, String errorIn) {
        getDriver().findElement(By.id(id)).sendKeys("15");
        submitButton();
        waitUntil(By.id("errormsg_0_" + errorIn));
    }
}
