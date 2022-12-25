package com.example.UntitledTestSuite.Tests;

import com.example.UntitledTestSuite.Entities.NoteData;
import com.example.UntitledTestSuite.Entities.jaxb.Notes;
import com.example.UntitledTestSuite.Generator.Generator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

@RunWith(Theories.class)
public class CreateNoteTest extends AuthTestBase{

    @DataPoints
    public static List<NoteData> notesFromXmlFile() {
        try {
            JAXBContext context = JAXBContext.newInstance(Notes.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Notes notes = (Notes) unmarshaller.unmarshal(new File(Generator.dir + "/notes.xml"));
            return notes.getNotes();
        } catch (JAXBException exception) {
            throw new RuntimeException(exception);
        }

    }

    @Test
    @Theory
    public void createNote(NoteData note) throws Exception {
//        appManager.getNavigation().GetMainPage();
        appManager.getData().EnterDataNote(note);
        //NoteData createdNote = appManager.getData().GetCreatedNote();
        //Assert.assertEquals(note.title(), createdNote.title());
    }
}
