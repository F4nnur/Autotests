package com.example.UntitledTestSuite;

import Utils.Destructor;
import com.example.UntitledTestSuite.Config.Config;
import com.example.UntitledTestSuite.Helpers.DataHelper;
import com.example.UntitledTestSuite.Helpers.LoginHelper;
import com.example.UntitledTestSuite.Helpers.NavHelper;
import com.example.UntitledTestSuite.Helpers.NewDataHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AppManager {
    private final String baseUrl = Config.getBaseUrl();
    protected WebDriver driver;

    public StringBuffer getVerificationErrors() {
        return verificationErrors;
    }

    protected StringBuffer verificationErrors;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void setNavigation(NavHelper navigation) {
        this.navigation = navigation;
    }

    public void setLogin(LoginHelper login) {
        this.login = login;
    }

    public void setData(DataHelper data) {
        this.data = data;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public NavHelper getNavigation() {
        return navigation;
    }

    public LoginHelper getLogin() {
        return login;
    }

    public DataHelper getData() {
        return data;
    }

    public void stop() {
        driver.quit();
    }

    protected NavHelper navigation;
    protected LoginHelper login;
    protected DataHelper data;
    protected NewDataHelper new_data;

    public void setNew_data(NewDataHelper new_data) {
        this.new_data = new_data;
    }

    public NewDataHelper getNew_data() {
        return new_data;
    }

    private static final ThreadLocal<AppManager> appMLT = new ThreadLocal<>();

    public JavascriptExecutor getJs() {
        return js;
    }

    private final JavascriptExecutor js;

    public static AppManager getInstance() {
        if (appMLT.get() == null) {
            AppManager newInstance = new AppManager();
            appMLT.set(newInstance);
        }
        return appMLT.get();
    }

    private AppManager() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Fannur/Desktop/chromedriver.exe");
        driver = new ChromeDriver();
//        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        verificationErrors = new StringBuffer();
        js = (JavascriptExecutor) driver;
        navigation = new NavHelper(this, baseUrl);
        login = new LoginHelper(this);
        data = new DataHelper(this);
        new_data = new NewDataHelper(this);
        Thread destructor = Destructor.addManagerDestructor(this);

    }


}