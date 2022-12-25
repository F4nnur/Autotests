package com.example.UntitledTestSuite.Helpers;

import com.example.UntitledTestSuite.AppManager;


public class NavHelper extends HelperBase {
    private String baseUrl;

    public NavHelper(AppManager appManager, String baseUrl) {
        super(appManager);
        this.baseUrl = baseUrl;
    }

    public void GetMainPage() {
        driver.get("https://app.simplenote.com/");
    }

    public void GetLoginPage() {
        driver.get("https://app.simplenote.com/login/");
    }
}
