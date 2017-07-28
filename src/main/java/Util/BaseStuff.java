package Util;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

import static Util.DriverWrapper.getDriver;

public abstract class BaseStuff {
    protected BaseStuff() {
        PageFactory.initElements(getDriver(), this);
    }
    protected void waitUntil(By selector) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }
    protected void tabs() {
        //switch to new, just opened, tab and close old tab
        ArrayList<String> handles = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().close();
        try {
            getDriver().switchTo().window(handles.get(handles.size() - 1));
        } catch (NoSuchWindowException e) {
            getDriver().switchTo().window(handles.get(1));
        }
        waitUntil(By.tagName("body")); //createaccount
    }
}
