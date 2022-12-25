package com.example.UntitledTestSuite.Helpers;

import com.example.UntitledTestSuite.AppManager;
import com.example.UntitledTestSuite.Entities.NoteData;
import org.openqa.selenium.By;


public class DataHelper extends HelperBase{
    public DataHelper(AppManager appManager){
        super(appManager);
    }

    public void EnterDataNote(NoteData note) throws InterruptedException {
        driver.findElement(By.cssSelector("svg.icon-new-note > path")).click();
        driver.findElement(By.xpath("//div[@id='root']/div/div/div/div/main/div[2]/div/div/div[2]/div/div/textarea")).clear();
        driver.findElement(By.xpath("//div[@id='root']/div/div/div/div/main/div[2]/div/div/div[2]/div/div/textarea")).sendKeys(note.getTitle());
        Thread.sleep(3000);
    }

    public NoteData GetCreatedNote(){
        String title = driver.findElement(By.xpath("//*[@id='root']/div/div/div/div/aside/div[3]/div/div[1]/div/div/div[1]/div/button/div/span")).getText();
        return new NoteData(title);

    }

}

