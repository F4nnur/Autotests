package com.example.UntitledTestSuite.Tests;

import com.example.UntitledTestSuite.AppManager;
import com.example.UntitledTestSuite.Config.Config;
import com.example.UntitledTestSuite.Entities.AccountData;
import com.example.UntitledTestSuite.Entities.NewNoteData;
import com.example.UntitledTestSuite.Entities.NoteData;

import org.jetbrains.annotations.NotNull;
import org.junit.Before;
import org.openqa.selenium.*;

public class TestBase {

    protected AppManager appManager;


    @Before
    public void setUp() throws InterruptedException {
        appManager = AppManager.getInstance();
    }
     NewNoteData new_data = new NewNoteData("edited");

    public static String getRandomString(int minWord, int maxWord, int minLength, int maxLength) {
        String alphabet = "qwertyuiopasdfghjklzxcvbnmйцукенгшщзхъфывапролджэячсмитьбюё";
        alphabet = alphabet + alphabet.toUpperCase();
        char[] chars = alphabet.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < Math.round(Math.random() * (maxWord - minWord)) + minWord; i++) {
            for (int j = 0; j < Math.round(Math.random() * (maxLength - minLength)) + minLength; j++) {
                stringBuilder.append(chars[(int) Math.round(Math.random() * (chars.length - 1))]);
            }
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();
    }
}



