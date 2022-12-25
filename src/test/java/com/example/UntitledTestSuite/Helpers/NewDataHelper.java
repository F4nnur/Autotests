package com.example.UntitledTestSuite.Helpers;

import com.example.UntitledTestSuite.AppManager;
import com.example.UntitledTestSuite.Entities.NewNoteData;
import org.openqa.selenium.By;

public class NewDataHelper extends HelperBase {

    public NewDataHelper(AppManager appManager){
        super(appManager);
    }
    public void EditData(NewNoteData new_data) throws InterruptedException {
        driver.findElement(By.xpath("//div[@id='root']/div/div/div/div/aside/div[3]/div/div/div/div/div/div/button/div")).click();
        driver.findElement(By.xpath("//div[@id='root']/div/div/div/div/main/div[2]/div/div/div[2]/div/div/div[2]/div/div[4]/div")).click();
        driver.findElement(By.xpath("//div[@id='root']/div/div/div/div/main/div[2]/div/div/div[2]/div/div/textarea")).clear();
        driver.findElement(By.xpath("//div[@id='root']/div/div/div/div/main/div[2]/div/div/div[2]/div/div/textarea")).sendKeys(new_data.getTittle());
        Thread.sleep(5000);
    }

    public NewNoteData getMewNote(){
        String newTitile = driver.findElement(By.xpath("//*[@id='root']/div/div/div/div/aside/div[3]/div/div[1]/div/div/div[1]/div/button/div/span")).getText();
        return new NewNoteData(newTitile);
    }

    public boolean isNoteModified(){
        if(!getMewNote().equals(getMewNote().new_title.substring(0,15))){
            return true;
        }
        return false;
    }
}
