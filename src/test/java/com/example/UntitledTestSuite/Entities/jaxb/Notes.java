package com.example.UntitledTestSuite.Entities.jaxb;

import com.example.UntitledTestSuite.Entities.NoteData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "notes")
@XmlAccessorType(XmlAccessType.FIELD)
public class Notes {

    @XmlElement(name = "note")
    private List<NoteData> notes;

    public List<NoteData> getNotes() {
        return notes;
    }

    public void setNotes(List<NoteData> notes) {
        this.notes = notes;
    }
}
