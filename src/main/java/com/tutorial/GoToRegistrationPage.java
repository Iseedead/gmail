package com.tutorial;

import Util.BaseStuff;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class GoToRegistrationPage extends BaseStuff {
    @CacheLookup @FindBy(css = "a[ng-click*=\"desktop\"]") private WebElement desktopButton;
    @CacheLookup @FindBy(css = "a[ng-click*=\"mobile\"]") private WebElement mobileButton;

    void createMailButton() {
        try {
            desktopButton.click();                  //if window size > 1360px (desktop mod  e)
        } catch (ElementNotVisibleException e) {
            mobileButton.click();                   //if window size < 1360px (mobile mode)
        }
        tabs();
    }
}