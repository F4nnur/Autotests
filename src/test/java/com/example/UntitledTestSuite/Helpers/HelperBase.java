package com.example.UntitledTestSuite.Helpers;

import com.example.UntitledTestSuite.AppManager;
import org.openqa.selenium.*;

public class HelperBase {
    protected boolean acceptNextAlert = true;
    protected WebDriver driver;
    protected AppManager appManager;
    protected JavascriptExecutor js;

    public HelperBase(AppManager appManager) {
        this.appManager = appManager;
        this.driver = appManager.getDriver();
        this.js = appManager.getJs();
    }


    boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
