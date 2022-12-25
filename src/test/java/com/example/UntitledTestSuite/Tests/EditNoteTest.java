package com.example.UntitledTestSuite.Tests;

import com.example.UntitledTestSuite.Entities.NewNoteData;
import org.junit.Assert;
import org.junit.Test;

public class EditNoteTest extends AuthTestBase {

    @Test
    public void editNoteTest() throws Exception {
        appManager.getNew_data().EditData(new_data);
//        Assert.assertTrue(appManager.getNew_data().isNoteModified());
    }

}
