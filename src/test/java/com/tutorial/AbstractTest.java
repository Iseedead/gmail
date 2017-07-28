package com.tutorial;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import static Util.DriverWrapper.getDriver;

public abstract class AbstractTest {

    @BeforeMethod
    public void preCondition() {
        //path to the email registration page
        getDriver().get("https://www.google.com");
        GoogleMainPage googleMainPage = new GoogleMainPage();
        googleMainPage.googleIt("gmail");
        GoToRegistrationPage goToRegistrationPage = new GoToRegistrationPage();
        goToRegistrationPage.createMailButton();
    }

    @AfterTest
    public void postCondition() {
        getDriver().quit();
    }
}
