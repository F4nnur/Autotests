package com.example.UntitledTestSuite.Tests;

import com.example.UntitledTestSuite.Config.Config;
import com.example.UntitledTestSuite.Entities.AccountData;
import org.junit.Before;

public class AuthTestBase extends TestBase {

    protected static final AccountData nUser = new AccountData(
            Config.getLogin(),
            Config.getPassword(),
            Config.getPath()
    );

    @Before
    public void setup() throws InterruptedException {
        super.setUp();
        appManager.getNavigation().GetLoginPage();
        appManager.getLogin().login(nUser);
        appManager.getNavigation().GetMainPage();
    }
}
