package com.tutorial;

import Util.BaseStuff;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class GoogleMainPage extends BaseStuff {
    @CacheLookup @FindBy(id = "lst-ib") private WebElement searchField;
    @CacheLookup @FindBy(css = "#rso:first-child .r > a") private WebElement firstLink;

    void googleIt(String search) {
        searchField.sendKeys(search, Keys.ENTER);
        firstLink.click();
    }
}
