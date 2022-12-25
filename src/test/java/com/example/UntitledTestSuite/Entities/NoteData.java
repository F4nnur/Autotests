package com.example.UntitledTestSuite.Entities;

import com.google.common.base.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "note")
@XmlAccessorType(XmlAccessType.FIELD)
public class NoteData {
    @XmlElement(name = "title", required = true)
    private String title;

    public NoteData() {

    }

    public NoteData(String title ) {
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String title() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NoteData noteData)) return false;
        return Objects.equal(title, noteData.title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }

    @Override
    public String toString() {
        return "NoteData{" +
                "title='" + title +
                '}';
    }
}
