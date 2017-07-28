package com.tutorial;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static Util.DriverWrapper.getDriver;
import static Util.DriverWrapper.nullDriver;

public abstract class AbstractTest {

    @BeforeMethod
    public void preCondition() {
        //path to the gmail registration page
        getDriver().get("https://www.google.com");
        GoogleMainPage googleMainPage = new GoogleMainPage();
        googleMainPage.googleIt("gmail");
        GoToRegistrationPage goToRegistrationPage = new GoToRegistrationPage();
        goToRegistrationPage.createMailButton();
    }

    @AfterMethod
    public void postCondition() {
        System.out.println("After Test");
        nullDriver();
    }
}
