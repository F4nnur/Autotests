package com.example.UntitledTestSuite.Helpers;

import com.example.UntitledTestSuite.AppManager;
import com.example.UntitledTestSuite.Entities.AccountData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.io.Console;
import java.util.Objects;

public class LoginHelper extends HelperBase {

    public LoginHelper(AppManager appManager) {
        super(appManager);
    }

    public void SubmitData() {
        driver.findElement(By.xpath("//input[@value='Log in']")).click();
    }

    public void login(AccountData user) throws InterruptedException{
        if (isAuthorized()) {
            if (isAuthorized(user.getPath())) {
                return;
            }
            logout();
        }
        System.out.println("зашел");
        driver.findElement(By.id("email")).click();
        System.out.println("вышел");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(user.getUsername());

        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(user.getPassword());

        SubmitData();



    }


    public void logout(){
        driver.findElement(By.xpath("//*[@id='root']/div/div/div/div/aside/div[1]/button[1]")).click();
        driver.findElement(By.xpath("//*[@id='root']/div/div/div/div[1]/div[1]/div[3]/button")).click();
        driver.findElement(By.cssSelector("#react-tabs-1 > div > div > ul > li:nth-child(3) > button")).click();
    }

    public boolean isAuthorized() {
        return isElementPresent(By.cssSelector("#root > div > div > div > div > aside > div.menu-bar > button:nth-child(3)"));
    }

    public boolean isAuthorized(String path){
        return Objects.equals(path, getAuthorizedUserSettingsPath());
    }


    public String getAuthorizedUserSettingsPath() {
        if (!isAuthorized()) return null;
        String path = driver.findElement(By.cssSelector("#root > div > div > div > div > aside > div.menu-bar > button:nth-child(3)")).getAttribute("class");
        path = path.substring(path.lastIndexOf('i'));
        System.out.println(path+"kek");
        return path;
    }

    public boolean isNotAuthorized() {
        try {
            WebElement webElement = driver.findElement(By.xpath(
                    "//*[@id='page']/div"
            ));
            return Objects.equals(webElement.getText(), "Неверный пароль");
        } catch (NoSuchElementException exception) {
            return false;
        }
    }
}
